package com.asusoftware.CoronaVirusTracker.model;

import lombok.Getter;
import lombok.Setter;

/**
 * CoronaVirusTracker Created by Antonio on 2/22/2021
 */
@Getter
@Setter
public class LocationStatsDto {
    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;

    public static LocationStatsDto toDto(LocationStats locationStats) {
        LocationStatsDto locationStatsDto = new LocationStatsDto();
        locationStatsDto.setState(locationStats.getState());
        locationStatsDto.setCountry(locationStats.getCountry());
        locationStatsDto.setLatestTotalCases(locationStats.getLatestTotalCases());
        locationStatsDto.setDiffFromPrevDay(locationStats.getDiffFromPrevDay());
        return locationStatsDto;
    }
}
