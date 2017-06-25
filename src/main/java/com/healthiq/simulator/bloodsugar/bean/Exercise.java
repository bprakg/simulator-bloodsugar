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
	private String exerciseIndex;

}
