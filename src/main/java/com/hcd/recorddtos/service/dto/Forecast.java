package com.hcd.recorddtos.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Forecast(Props properties) {

    public record Props(List<Period> periods) {}

    public record Period(String name,
                         String startTime, String endTime,
                         int temperature, @JsonProperty("temperatureUnit") String unit,
                         String windSpeed, String windDirection,
                         String shortForecast,
                         String detailedForecast) {}
}
