package com.asusoftware.CoronaVirusTracker.model;

import lombok.Getter;
import lombok.Setter;

/**
 * CoronaVirusTracker Created by Antonio on 2/17/2021
 */
@Getter
@Setter
public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;
}
