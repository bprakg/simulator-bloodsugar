package com.healthiq.simulator.bloodsugar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Food {

	private @Id @GeneratedValue long id;
	private String fiName;
	private int glycemicIndex;

	/**
	 * 
	 */
	public Food() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param glycemicIndex
	 */
	public Food(String fiName, int glycemicIndex) {
		this.fiName = fiName;
		this.glycemicIndex = glycemicIndex;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fiName
	 */
	public String getFiName() {
		return fiName;
	}

	/**
	 * @param fiName
	 *            the fiName to set
	 */
	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	/**
	 * @return the glycemicIndex
	 */
	public int getGlycemicIndex() {
		return glycemicIndex;
	}

	/**
	 * @param glycemicIndex
	 *            the glycemicIndex to set
	 */
	public void setGlycemicIndex(int glycemicIndex) {
		this.glycemicIndex = glycemicIndex;
	}

}
