package com.healthiq.simulator.bloodsugar.model;

import java.time.LocalDateTime;

public class SimulatedBloodSugarAndGlycation {

	private LocalDateTime simulationTime;
	private float bloodSugar;
	private int glycation;

	/**
	 * @param ldt
	 * @param bloodSugar
	 * @param glycation
	 */
	public SimulatedBloodSugarAndGlycation(LocalDateTime ldt, float bloodSugar, int glycation) {
		this.simulationTime = ldt;
		this.bloodSugar = bloodSugar;
		this.glycation = glycation;
	}

	public SimulatedBloodSugarAndGlycation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the simulationTime
	 */
	public LocalDateTime getSimulationTime() {
		return simulationTime;
	}

	/**
	 * @param simulationTime
	 *            the simulationTime to set
	 */
	public void setSimulationTime(LocalDateTime simulationTime) {
		this.simulationTime = simulationTime;
	}

	/**
	 * @return the bloodSugar
	 */
	public float getBloodSugar() {
		return bloodSugar;
	}

	/**
	 * @param bloodSugar
	 *            the bloodSugar to set
	 */
	public void setBloodSugar(float bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	/**
	 * @return the glycation
	 */
	public int getGlycation() {
		return glycation;
	}

	/**
	 * @param glycation
	 *            the glycation to set
	 */
	public void setGlycation(int glycation) {
		this.glycation = glycation;
	}

}
