package com.hcd.recorddtos.service.dto;

public record PointMetadata(Properties properties) {

    public record Properties(String forecast) {}
}

