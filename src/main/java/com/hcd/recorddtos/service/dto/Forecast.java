package com.hcd.recorddtos.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Forecast(Props properties) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Props(List<Period> periods) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Period(String name,
                         String startTime, String endTime,
                         int temperature, @JsonProperty("temperatureUnit") String unit,
                         String windSpeed, String windDirection,
                         String shortForecast,
                         String detailedForecast) {}
}
