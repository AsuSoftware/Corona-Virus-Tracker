package com.asusoftware.CoronaVirusTracker.controller;

import com.asusoftware.CoronaVirusTracker.model.LocationStats;
import com.asusoftware.CoronaVirusTracker.service.CoronaVirusDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;
import java.util.List;

/**
 * CoronaVirusTracker Created by Antonio on 2/17/2021
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CoronaVirusDataService coronaVirusDataService;

    @GetMapping(path = "/")
    public String home(Model model) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        int totalNewCases = allStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", decimalFormat.format(totalReportedCases));
        model.addAttribute("totalNewCases", decimalFormat.format(totalNewCases));
        return "home";
    }
}
