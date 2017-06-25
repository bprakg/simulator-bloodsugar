/**
 * 
 */
package com.healthiq.simulator.bloodsugar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Official
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
