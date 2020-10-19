package me.triip.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckApi {

    @RequestMapping("/api/health")
    public HealthCheck healthCheck() {
        return new HealthCheck(200);
    }

    public static class HealthCheck {
        private int status;

        public HealthCheck(int status) {
            this.status = status;
        }

        public HealthCheck() {
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

}
