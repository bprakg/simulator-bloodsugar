/**
 * 
 */
package com.healthiq.simulator.bloodsugar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Exercise {

	private @Id @GeneratedValue long id;
	private String eiName;
	private int exerciseIndex;

	/**
	 * 
	 */
	public Exercise() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param exerciseIndex
	 */
	public Exercise(String eiName, int exerciseIndex) {
		this.eiName = eiName;
		this.exerciseIndex = exerciseIndex;
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
	 * @return the eiName
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * @param eiName
	 *            the eiName to set
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * @return the exerciseIndex
	 */
	public int getExerciseIndex() {
		return exerciseIndex;
	}

	/**
	 * @param exerciseIndex
	 *            the exerciseIndex to set
	 */
	public void setExerciseIndex(int exerciseIndex) {
		this.exerciseIndex = exerciseIndex;
	}

}
