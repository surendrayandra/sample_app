package com.lca.ddt.delivery.report.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lca.ddt.delivery.report.input.IrisResultsMessage;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class IrisController {
	
	@PostMapping(value = "/iris", consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
    public String createPerson(@RequestBody IrisResultsMessage inputMessage) {
        System.out.println("Received iris: " + inputMessage.getEvent());
        return "OK";
    }
	
	
}
