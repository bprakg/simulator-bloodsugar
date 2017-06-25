package com.healthiq.simulator.bloodsugar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Food {

	private @Id @GeneratedValue long id;
	private String name;
	private String glycemicIndex;
	/**
	 * 
	 */
	public Food() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param glycemicIndex
	 */
	public Food(long id, String name, String glycemicIndex) {
		this.id = id;
		this.name = name;
		this.glycemicIndex = glycemicIndex;
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
	 * @return the glycemicIndex
	 */
	public String getGlycemicIndex() {
		return glycemicIndex;
	}
	/**
	 * @param glycemicIndex the glycemicIndex to set
	 */
	public void setGlycemicIndex(String glycemicIndex) {
		this.glycemicIndex = glycemicIndex;
	}
	
	
}
