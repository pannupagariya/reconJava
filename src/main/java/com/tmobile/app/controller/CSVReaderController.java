package com.tmobile.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVReaderController {
	
	@RequestMapping("/read")
	public String readCsv() {
		return "Hello from restController";
	}

}
