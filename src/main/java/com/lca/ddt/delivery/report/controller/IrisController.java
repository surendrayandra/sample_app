package com.lca.ddt.delivery.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lca.ddt.delivery.report.input.IrisResultsMessage;
import com.lca.ddt.delivery.report.inspire.model.Inspire;
import com.lca.ddt.delivery.report.service.InspireRequestGenerator;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.xml.bind.JAXBException;


@RestController
public class IrisController {
	
	@Autowired
	InspireRequestGenerator inspireRequestGenerator;
	
	
	@PostMapping(value = "/iris", consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
    public Inspire createPerson(@RequestBody IrisResultsMessage inputMessage) throws JAXBException {
        System.out.println("Received iris: " + inputMessage.getEvent());
        return inspireRequestGenerator.getInspire();
    }
	
	@GetMapping(value = "/iris",
			produces = MediaType.APPLICATION_XML_VALUE)
    public Inspire createPerson() throws JAXBException {
        return inspireRequestGenerator.getInspire();
    }
	
	
}
