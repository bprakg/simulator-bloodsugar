package com.healthiq.simulator.bloodsugar.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.healthiq.simulator.bloodsugar.model.Activity;
import com.healthiq.simulator.bloodsugar.model.GIOrEiIndex;
import com.healthiq.simulator.bloodsugar.model.SimulatedBloodSugarAndGlycation;
import com.healthiq.simulator.bloodsugar.repository.ExerciseRepository;
import com.healthiq.simulator.bloodsugar.repository.FoodRepository;

@RestController
@RequestMapping("/simulator")
public class SimulatorRestController {

	@Autowired
	private FoodRepository fr;
	@Autowired
	private ExerciseRepository er;

	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public List<GIOrEiIndex> getRelatedGIFromLookup(@PathVariable String name) {
		List<GIOrEiIndex> list = new ArrayList<>();
		fr.findFirst10ByFiNameIgnoreCaseContaining(name).stream().forEach(e -> {
			GIOrEiIndex cgei = new GIOrEiIndex();
			cgei.setIndexName(e.getFiName());
			cgei.setIndexValue(e.getGlycemicIndex());
			cgei.setAlteringEvent("FOOD");
			list.add(cgei);
		});
		if (list.isEmpty() || list.size() < 10) {
			er.findFirst10ByEiNameIgnoreCaseContaining(name).stream().forEach(e -> {
				GIOrEiIndex cgei = new GIOrEiIndex();
				cgei.setIndexName(e.getEiName());
				cgei.setIndexValue(e.getExerciseIndex());
				cgei.setAlteringEvent("EXERCISE");
				list.add(cgei);
			});
		}
		return list;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Map<LocalDateTime, SimulatedBloodSugarAndGlycation> getSimulatedBloodSugarAndGlycation(
			@RequestBody Collection<Activity> list) {
		System.out.println("getSimulatedBloodSugarAndGlycation");
		LocalDateTime ds = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
				LocalDateTime.now().getDayOfMonth(), 7, 0);
		TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map = new TreeMap<>();
		list.stream().forEach(e -> {
			bloodSugarBeforeAnyAlteringEvent(map, ds, e);

			BloodSugarBetweenEvents(map, e);

			bloodSugarAfterAnAlteringEvent(map, e);
		});
		return map;
	}

	private void bloodSugarBeforeAnyAlteringEvent(TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map,
			LocalDateTime dayStart, Activity e) {
		if (map.isEmpty()) {
			LocalDateTime now = LocalDateTime.now();
			e.setEventTime(
					LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), e.getHour(), e.getMinute()));

			while (dayStart.isBefore(e.getEventTime())) {
				SimulatedBloodSugarAndGlycation s = new SimulatedBloodSugarAndGlycation(dayStart, 80, 0);
				map.put(dayStart, s);
				dayStart.plusMinutes(1);
			}
		}
	}

	private void BloodSugarBetweenEvents(TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map, Activity e) {
		LocalDateTime ldt = map.get(map.lastKey()).getSimulationTime();
		int sugarlevel = map.get(map.lastKey()).getBloodSugar();
		int glycation = map.get(map.lastKey()).getGlycation();

		while (ldt.isBefore(e.getEventTime())) {
			if (sugarlevel > 80)
				sugarlevel--;
			else if (sugarlevel < 80)
				sugarlevel++;
			if (sugarlevel > 150)
				glycation++;
			ldt.plusMinutes(1);
			SimulatedBloodSugarAndGlycation s = new SimulatedBloodSugarAndGlycation(ldt, sugarlevel, glycation);
			map.put(ldt, s);
		}
	}

	private void bloodSugarAfterAnAlteringEvent(TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map,
			Activity e) {
		int rateChangeDuration = (e.getAlteringEvent().equalsIgnoreCase("FOOD")) ? 2 : 1;
		int rateChangeFactor = (e.getAlteringEvent().equalsIgnoreCase("FOOD")) ? 1 : -1;
		LocalDateTime targetLDT = e.getEventTime().plusHours(rateChangeDuration);
		int rateOfChange = (e.getIndexValue() / (rateChangeDuration * 60)) * rateChangeFactor;

		while (e.getEventTime().isBefore(targetLDT)) {
			SimulatedBloodSugarAndGlycation s = null;
			if (map.containsKey(e.getEventTime())) {
				s = map.get(e.getEventTime());

			} else {
				s = map.get(map.lastKey());
			}
			int currentBloodSugar = s.getBloodSugar();
			int currentGlycation = s.getGlycation();
			s.setBloodSugar(currentBloodSugar + rateOfChange);
			s.setSimulationTime(e.getEventTime());
			s.setGlycation((s.getBloodSugar() > 150) ? currentGlycation + 1 : currentGlycation);
			map.put(e.getEventTime(), s);
			e.getEventTime().plusMinutes(1);
		}
	}
}
