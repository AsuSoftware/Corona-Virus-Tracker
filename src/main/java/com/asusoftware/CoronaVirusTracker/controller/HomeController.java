package com.asusoftware.CoronaVirusTracker.controller;

import com.asusoftware.CoronaVirusTracker.model.LocationStatsDto;
import com.asusoftware.CoronaVirusTracker.service.CoronaVirusDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CoronaVirusTracker Created by Antonio on 2/17/2021
 */
@RestController
@RequestMapping(path = "/api/v1/cases")
@RequiredArgsConstructor
public class HomeController {

    private final CoronaVirusDataService coronaVirusDataService;

    @GetMapping
    public List<LocationStatsDto> getAllData() {
      return coronaVirusDataService.getAllStats();
    }
}
