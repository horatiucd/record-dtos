package com.hcd.recorddtos.service;

import com.hcd.recorddtos.service.dto.Forecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ForecastServiceTest {

    private ForecastService forecastService;

    @BeforeEach
    void setUp() {
        forecastService = new ForecastService();
    }

    @Test
    void forecast() {
        final double latitude = 33.7179;
        final double longitude = -116.3431;

        Forecast forecast = forecastService.forecast(latitude, longitude);
        Assertions.assertNotNull(forecast);

        forecast.properties().periods().forEach(period ->
                System.out.println(period.name() + ", " + period.startTime() + " - " + period.endTime() +
                        ": " + period.detailedForecast()));
    }
}
