/**
 * 
 */
package com.healthiq.simulator.bloodsugar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.healthiq.simulator.bloodsugar.bean.Exercise;

/**
 * @author Official
 *
 */
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

	List<Exercise> findFirst10ByEiNameIgnoreCaseContaining(String name);

}
