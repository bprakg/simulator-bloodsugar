/**
 * 
 */
package com.healthiq.simulator.bloodsugar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Exercise {

	private @Id @GeneratedValue long id;
	private String name;
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
	public Exercise(String name, int exerciseIndex) {
		this.name = name;
		this.exerciseIndex = exerciseIndex;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the exerciseIndex
	 */
	public int getExerciseIndex() {
		return exerciseIndex;
	}
	/**
	 * @param exerciseIndex the exerciseIndex to set
	 */
	public void setExerciseIndex(int exerciseIndex) {
		this.exerciseIndex = exerciseIndex;
	}
	
	
}
