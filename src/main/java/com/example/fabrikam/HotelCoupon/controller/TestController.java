package com.example.fabrikam.HotelCoupon.controller;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.telemetry.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    TelemetryClient telemetryClient;

    @GetMapping("/hello")
    public String hello() {

        // track a custom event
        telemetryClient.trackEvent("Sending a custom event...");

        // trace a custom trace
        telemetryClient.trackTrace("Sending a custom trace....");

        // track a custom metric
        telemetryClient.trackMetric("custom metric", 1.0);

        // track a custom dependency
        telemetryClient.trackDependency("SQL", "Insert", new Duration(0, 0, 1, 1, 1), true);

        return "hello";
    }
}