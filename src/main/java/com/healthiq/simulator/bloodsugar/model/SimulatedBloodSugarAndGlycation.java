package com.healthiq.simulator.bloodsugar.model;

import java.time.LocalDateTime;

public class SimulatedBloodSugarAndGlycation {

	private LocalDateTime simulationTime;
	private int bloodSugar;
	private int glycation;

	/**
	 * @param ldt
	 * @param bloodSugar
	 * @param glycation
	 */
	public SimulatedBloodSugarAndGlycation(LocalDateTime ldt, int bloodSugar, int glycation) {
		this.simulationTime = ldt;
		this.bloodSugar = bloodSugar;
		this.glycation = glycation;
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
	public int getBloodSugar() {
		return bloodSugar;
	}

	/**
	 * @param bloodSugar
	 *            the bloodSugar to set
	 */
	public void setBloodSugar(int bloodSugar) {
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
