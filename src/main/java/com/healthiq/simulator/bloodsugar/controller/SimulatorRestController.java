package com.healthiq.simulator.bloodsugar.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static Logger LOGGER = LoggerFactory
			.getLogger("com.healthiq.simulator.bloodsugar.controller.SimulatorRestController");

	@RequestMapping(method = RequestMethod.GET, value = "/{name}")
	public List<GIOrEiIndex> getRelatedGIFromLookup(@PathVariable String name) {
		LOGGER.info("getRelatedGIFromLookup");
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
	public Collection<SimulatedBloodSugarAndGlycation> getSimulatedBloodSugarAndGlycation(
			@RequestBody Collection<Activity> list) {

		LOGGER.info("getSimulatedBloodSugarAndGlycation");
		LocalDateTime ds = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
				LocalDateTime.now().getDayOfMonth(), 7, 0);
		TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map = new TreeMap<>();

		list.stream().forEach(e -> {
			e.setEventTime(LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
					LocalDateTime.now().getDayOfMonth(), e.getHour(), e.getMinute()));

		});

		list.stream().forEach(e -> {
			bloodSugarBeforeAnyAlteringEvent(map, ds, e);

			BloodSugarBetweenEvents(map, e);

			bloodSugarAfterAnAlteringEvent(map, e);
		});

		map.values().stream().forEach(e -> {
			LOGGER.info("simulation time - " + e.getSimulationTime().toString() + " BloodSugar " + e.getBloodSugar()
					+ " Glycation " + e.getGlycation());
		});

		return map.values();
	}

	private void bloodSugarBeforeAnyAlteringEvent(TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map,
			LocalDateTime dayStart, Activity e) {
		LOGGER.info("bloodSugarBeforeAnyAlteringEvent");
		if (map.isEmpty()) {
			while (dayStart.isBefore(e.getEventTime())) {
				LOGGER.info("dayStart - " + dayStart.toString() + " e.getEventTime() - " + e.getEventTime().toString());
				SimulatedBloodSugarAndGlycation s = new SimulatedBloodSugarAndGlycation(dayStart, 80, 0);
				map.put(dayStart, s);
				dayStart = dayStart.plusMinutes(1);
			}
		}
	}

	private void BloodSugarBetweenEvents(TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map, Activity e) {
		LOGGER.info("BloodSugarBetweenEvents");
		LocalDateTime ldt = map.get(map.lastKey()).getSimulationTime().plusMinutes(1);
		float sugarlevel = map.get(map.lastKey()).getBloodSugar();
		int glycation = map.get(map.lastKey()).getGlycation();

		while (ldt.isBefore(e.getEventTime())) {
			LOGGER.info("ldt - " + ldt.toString() + " e.getEventTime() - " + e.getEventTime());
			if (sugarlevel > 80)
				sugarlevel--;
			else if (sugarlevel < 80)
				sugarlevel++;
			if (sugarlevel > 150)
				glycation++;
			SimulatedBloodSugarAndGlycation s = new SimulatedBloodSugarAndGlycation(ldt, sugarlevel, glycation);
			map.put(ldt, s);
			ldt = ldt.plusMinutes(1);
		}
	}

	private void bloodSugarAfterAnAlteringEvent(TreeMap<LocalDateTime, SimulatedBloodSugarAndGlycation> map,
			Activity e) {

		LOGGER.info("bloodSugarAfterAnAlteringEvent");
		int rateChangeDuration = (e.getAlteringEvent().equalsIgnoreCase("FOOD")) ? 2 : 1;
		int rateChangeFactor = (e.getAlteringEvent().equalsIgnoreCase("FOOD")) ? 1 : -1;
		LocalDateTime startTime = e.getEventTime();
		LocalDateTime endTime = startTime.plusHours(rateChangeDuration);
		float rateOfChange = ((float) e.getIndexValue() / (rateChangeDuration * 60)) * rateChangeFactor;

		LOGGER.info("e.getIndexValue() - " + e.getIndexValue() + " rateChangeDuration - " + rateChangeDuration
				+ " rateChangeFactor - " + rateChangeFactor + " rateOfChange - " + rateOfChange);
		while (startTime.isBefore(endTime)) {
			LOGGER.info("startTime = " + startTime.toString() + " endTime - " + endTime);
			SimulatedBloodSugarAndGlycation s = null;
			float currentBloodSugar = 0;
			int currentGlycation = 0;

			if (map.containsKey(startTime)) {
				s = map.get(startTime);
				currentBloodSugar = s.getBloodSugar();
				currentGlycation = s.getGlycation();
			} else {
				s = new SimulatedBloodSugarAndGlycation();
				SimulatedBloodSugarAndGlycation sprime = map.get(startTime.minusMinutes(1));
				currentBloodSugar = sprime.getBloodSugar();
				currentGlycation = sprime.getGlycation();
			}

			s.setBloodSugar(currentBloodSugar + rateOfChange);
			s.setSimulationTime(startTime);
			s.setGlycation((s.getBloodSugar() > 150) ? currentGlycation + 1 : currentGlycation);
			map.put(startTime, s);
			startTime = startTime.plusMinutes(1);
		}
	}
}
