package me.triip.springboot.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HealthCheckApiTest {

    @Test
    public void testHealthCheck() throws Exception {
        // setup
        HealthCheckApi healthCheckApi = new HealthCheckApi();

        // when
        HealthCheckApi.HealthCheck healthCheck = healthCheckApi.healthCheck();

        // then
        assertEquals(200, healthCheck.getStatus(), "Health check should return Object with status 200");
    }
}