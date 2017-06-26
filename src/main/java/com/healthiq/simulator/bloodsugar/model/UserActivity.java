package com.healthiq.simulator.bloodsugar.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserActivity {

	private LocalDateTime dayStart;

	private List<Activity> list = new ArrayList<>();

	/**
	 * @param dayStart
	 * @param list
	 */
	public UserActivity(LocalDateTime dayStart, List<Activity> list) {
		this.dayStart = dayStart;
		this.list = list;
	}

	/**
	 * @return the dayStart
	 */
	public LocalDateTime getDayStart() {
		return dayStart;
	}

	/**
	 * @param dayStart
	 *            the dayStart to set
	 */
	public void setDayStart(LocalDateTime dayStart) {
		this.dayStart = dayStart;
	}

	/**
	 * @return the list
	 */
	public List<Activity> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Activity> list) {
		this.list = list;
	}

}
