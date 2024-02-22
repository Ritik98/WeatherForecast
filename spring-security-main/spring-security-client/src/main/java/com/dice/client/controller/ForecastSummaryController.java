package com.dice.client.controller;

import ch.qos.logback.classic.Logger;
import com.dice.client.utility.JavaApiCaller;
import com.dice.client.utility.LoggerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastSummaryController {
    @Value("${forecast.summary.location.url}")
    private String forecastSummaryApiUrl;
    private final Logger logger = LoggerClass.getLogger(this.getClass().getName());

    @Autowired
    JavaApiCaller javaApiCaller;

    @GetMapping("/forecast/summary/{location}")
    public ResponseEntity<Object> getForecastSummaryByLocationName(@PathVariable String location) {
        logger.info("Calling getForecastSummaryByLocationName method ");
        String url = forecastSummaryApiUrl + location + "/summary/";
        ResponseEntity<Object> response = javaApiCaller.callAPI(url);
        logger.info("Completed getForecastSummaryByLocationName method ");
        return response;
    }

    @GetMapping("/forecast/summary/hourly/{location}")
    public ResponseEntity<Object> getForecastSummaryHourlyByLocationName (@PathVariable String location){
        logger.debug("Calling getForecastSummaryByLocationName method ");
        String url = forecastSummaryApiUrl + location + "/hourly/";
        ResponseEntity<Object> response = javaApiCaller.callAPI(url);
        logger.debug("Completed getForecastSummaryByLocationName method ");
        return response;

    }
}
