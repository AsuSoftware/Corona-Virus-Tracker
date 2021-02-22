package com.asusoftware.CoronaVirusTracker.service;

import com.asusoftware.CoronaVirusTracker.model.LocationStats;
import com.asusoftware.CoronaVirusTracker.model.LocationStatsDto;
import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * CoronaVirusTracker Created by Antonio on 2/17/2021
 */
@Service
@Getter
public class CoronaVirusDataService {

    private final static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocationStatsDto> allStats = new ArrayList<>();

    @PostConstruct // Execute that function when the application starts
    //           second minute hour day month year
    @Scheduled(cron = "* * 1 * * *") // Execute this function every time that in set inside ()
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStatsDto> newStats = new ArrayList<>();
        // Make an http call to the url to get the data
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            int latestCases = Integer.parseInt(record.get(record.size()-1));
            int prevDayCases = Integer.parseInt(record.get(record.size()-2));
            locationStat.setLatestTotalCases(latestCases);
            locationStat.setDiffFromPrevDay(latestCases - prevDayCases);
            newStats.add(LocationStatsDto.toDto(locationStat));
        }
        this.allStats = newStats;
    }
}
