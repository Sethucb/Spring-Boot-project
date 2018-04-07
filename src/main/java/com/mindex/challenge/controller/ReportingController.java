package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingService;

@RestController		
public class ReportingController {
	private static final Logger LOG = LoggerFactory.getLogger(ReportingController.class);
	
	@Autowired
    private ReportingService reportService;
	
    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure read(@PathVariable String id) {
        LOG.debug("Received report read request for id [{}] ", id);
        return reportService.getReport(id);        
    }
}
