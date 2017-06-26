package com.healthiq.simulator.bloodsugar.model;

import java.time.LocalDateTime;

public class Activity {
	private String alteringEvent;
	private int indexValue;
	private int hour;
	private int minute;
	private LocalDateTime eventTime;

	/**
	 * @param alteringEvent
	 * @param indexValue
	 * @param eventTime
	 */
	public Activity(String alteringEvent, int indexValue, LocalDateTime eventTime) {
		this.alteringEvent = alteringEvent;
		this.indexValue = indexValue;
		this.eventTime = eventTime;
	}

	/**
	 * @return the alteringEvent
	 */
	public String getAlteringEvent() {
		return alteringEvent;
	}

	/**
	 * @param alteringEvent
	 *            the alteringEvent to set
	 */
	public void setAlteringEvent(String alteringEvent) {
		this.alteringEvent = alteringEvent;
	}

	/**
	 * @return the indexValue
	 */
	public int getIndexValue() {
		return indexValue;
	}

	/**
	 * @param indexValue
	 *            the indexValue to set
	 */
	public void setIndexValue(int indexValue) {
		this.indexValue = indexValue;
	}

	/**
	 * @return the eventTime
	 */
	public LocalDateTime getEventTime() {
		return eventTime;
	}

	/**
	 * @param eventTime
	 *            the eventTime to set
	 */
	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}

}
