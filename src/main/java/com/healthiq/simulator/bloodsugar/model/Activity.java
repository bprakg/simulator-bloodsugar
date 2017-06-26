package com.healthiq.simulator.bloodsugar.model;

import java.time.LocalDateTime;

public class Activity {
	private String alteringEvent;
	private int indexValue;
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
	 * @param alteringEvent the alteringEvent to set
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
	 * @param indexValue the indexValue to set
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
	 * @param eventTime the eventTime to set
	 */
	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}
	
	
}
