package com.hcd.recorddtos.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PointMetadata(Properties properties) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Properties(String forecast) {}
}

