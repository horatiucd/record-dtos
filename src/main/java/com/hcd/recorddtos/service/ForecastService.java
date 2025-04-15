package com.hcd.recorddtos.service;

import com.hcd.recorddtos.service.dto.Forecast;
import com.hcd.recorddtos.service.dto.PointMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ForecastService {

    private final RestClient restClient;

    public ForecastService() {
        restClient = RestClient.builder()
                .baseUrl("https://api.weather.gov")
                .defaultHeader("User-Agent", "MyApp - horatiucd@gmail.com")
                .defaultHeader("Accept", "application/geo+json")
                .build();
    }

    public Forecast forecast(double latitude, double longitude) {
        PointMetadata point = restClient.get()
                .uri("/points/{latitude},{longitude}", latitude, longitude)
                .retrieve()
                .body(PointMetadata.class);

        if (point == null || point.properties() == null) {
            throw new RuntimeException("Unable to retrieve forecast point meta-data");
        }

        return restClient.get()
                .uri(point.properties().forecast())
                .retrieve()
                .body(Forecast.class);
    }
}
