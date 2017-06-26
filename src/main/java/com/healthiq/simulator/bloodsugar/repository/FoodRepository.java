/**
 * 
 */
package com.healthiq.simulator.bloodsugar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.healthiq.simulator.bloodsugar.bean.Food;

/**
 * @author Official
 *
 */
public interface FoodRepository extends CrudRepository<Food, Long> {

	List<Food> findFirst10ByFiNameIgnoreCaseContaining(String name);

}
