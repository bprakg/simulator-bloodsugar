package com.healthiq.simulator.bloodsugar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Food {

	private @Id @GeneratedValue Long id;
	private String name;
	private String glycemicIndex;
}
