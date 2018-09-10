package com.demo.settlement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.demo.settlement.entities.CycleConfig;
import com.demo.settlement.repository.CycleConfigRepository;

@RestController
@CrossOrigin(origins = "*")
public class CycleConfigController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, Object> response = new HashMap<String, Object>();
    private final String DATA = "data";
    private final String STATUS = "status";

    @Autowired
    CycleConfigRepository cycleConfigRepository;

    @RequestMapping(value = "/cycleConfig", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        logger.info("Getting all cycle configs");
        List<CycleConfig> cycleConfigList = cycleConfigRepository.findAll();
        logger.info("Cycle config list : " + cycleConfigList);
        response.put(DATA, cycleConfigList);
        response.put(STATUS, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/cycleConfig", method = RequestMethod.POST)
    public Map<String, Object> create(@RequestBody Map<String, String> data) {
        logger.info("Creating cycle config");
        CycleConfig cycleConfig = new CycleConfig();
        cycleConfig.setCycleType(data.get("cycleType"));
        cycleConfig.setOpenTime(data.get("openTime"));
        cycleConfig.setCloseTime(data.get("closeTime"));
        cycleConfig.setCycleCondition(data.get("cycleCondition"));

        cycleConfig = cycleConfigRepository.save(cycleConfig);
        logger.info("Saved success : " + cycleConfig.getId());
        response.put(DATA, cycleConfig.getId());
        response.put(STATUS, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/cycleConfig", method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Map<String, String> data) {
        logger.info("Creating cycle config");
        CycleConfig cycleConfig = cycleConfigRepository.getOne(Long.parseLong(data.get("id")));
        cycleConfig.setCycleType(data.get("cycleType"));
        cycleConfig.setOpenTime(data.get("openTime"));
        cycleConfig.setCloseTime(data.get("closeTime"));
        cycleConfig.setCycleCondition(data.get("condition"));

        cycleConfig = cycleConfigRepository.save(cycleConfig);
        logger.info("Saved success : " + cycleConfig.getId());
        logger.info("Saved success : " + cycleConfig.getId());
        response.put(DATA, cycleConfig.getId());
        response.put(STATUS, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/cycleConfig/{id}", method = RequestMethod.GET)
    public Map<String, Object> getById(@PathVariable Long id) {
        Optional<CycleConfig> optional = cycleConfigRepository.findById(id);

        if (optional.isPresent()) {
            response.put(DATA, optional.get());
            response.put(STATUS, HttpStatus.OK);
        } else {
            response.put(DATA, null);
            response.put(STATUS, HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(value = "/cycleConfig/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteById(@PathVariable Long id) {
        cycleConfigRepository.deleteById(id);
        response.put(DATA, null);
        response.put(STATUS, HttpStatus.OK);
        return response;
    }
}
