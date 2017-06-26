package com.healthiq.simulator.bloodsugar.model;

public class GIOrEiIndex {

	private String indexName;
	private int indexValue;
	private String alteringEvent;

	/**
	 * @return the indexName
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * @param indexName
	 *            the indexName to set
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName;
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

}
