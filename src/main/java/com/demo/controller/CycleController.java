package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.db1.Cycle;
import com.demo.repository.db1.CycleRepository;

@RestController
public class CycleController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, Object> response = new HashMap<String, Object>();
    private final String DATA = "data";
    private final String STATUS = "status";

    @Autowired
    CycleRepository cycleRepository;

    @RequestMapping(value = "/cycles", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        logger.info("Getting all cycle configs");
        List<Cycle> cycleList = cycleRepository.findAll();
        response.put(DATA, cycleList);
        response.put(STATUS, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/cycles", method = RequestMethod.POST)
    public Map<String, Object> create(@RequestBody Cycle cycle) {
        logger.info("Creating cycle config");

        cycle = cycleRepository.save(cycle);
        logger.info("Saved success : " + cycle.getId());
        response.put(DATA, cycle.getId());
        response.put(STATUS, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/cycles", method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Cycle cycle) {
        logger.info("Creating cycle config");
        cycle = cycleRepository.save(cycle);
        logger.info("Saved success : " + cycle.getId());
        response.put(DATA, cycle.getId());
        response.put(STATUS, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/cycles/{id}", method = RequestMethod.GET)
    public Map<String, Object> getById(@PathVariable Long id) {
        Optional<Cycle> optional = cycleRepository.findById(id);

        if (optional.isPresent()) {
            response.put(DATA, optional.get());
            response.put(STATUS, HttpStatus.OK);
        } else {
            response.put(DATA, null);
            response.put(STATUS, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(value = "/cycles/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteById(@PathVariable Long id) {
        cycleRepository.deleteById(id);
        response.put(DATA, null);
        response.put(STATUS, HttpStatus.OK);
        return response;
    }
    
    @RequestMapping(value = "/cycles/{id}/stateChangeEvent", method = RequestMethod.POST)
    public Map<String, Object> stateChangeEvent(@PathVariable Long id,@RequestBody Map<String, String> data ) {
    	Optional<Cycle> cycle = cycleRepository.findById(id);
    	
    	if(cycle.isPresent()) {
    		Cycle actualCycle = cycle.get();
    		actualCycle.setState(data.get("event"));
    		cycleRepository.save(actualCycle);
    		response.put(DATA, null);
            response.put(STATUS, HttpStatus.OK);
    	}else {
    		response.put(DATA, "Provided id not found.");
            response.put(STATUS, HttpStatus.OK);
    	}
        
        return response;
    }
    
}
