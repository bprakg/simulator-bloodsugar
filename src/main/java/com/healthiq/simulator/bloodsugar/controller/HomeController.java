/**
 * 
 */
package com.healthiq.simulator.bloodsugar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Official
 *
 */
@RestController
public class HomeController {

	@RequestMapping(value = "/echo")
	public String echo(@RequestParam(value="request", defaultValue = "Hello") String request ) {
		return request;
	}
}
