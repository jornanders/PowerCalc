package no.jascorp.powercalc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/demo.html", method = RequestMethod.GET)
	public String demo() {
		System.out.println("HAAAAAAAAAAAAAAAA!!!");
		return "demo";
	}
}
