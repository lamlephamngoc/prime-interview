package me.triip.springboot.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.triip.springboot.service.HighestPrimeFinderServiceDefault;

@RestController
public class PrimeApi {

    private final HighestPrimeFinderServiceDefault highestPrimeFinderService;

    public PrimeApi(HighestPrimeFinderServiceDefault highestPrimeFinderService) {
        this.highestPrimeFinderService = highestPrimeFinderService;
    }

    @PostMapping(path = "/api/highestPrime", consumes = "application/json")
    public long getHighestPrimeLowerThanInput(@RequestBody InputNumber formNumber) {
        if (formNumber == null) return -1;
        return highestPrimeFinderService.find(formNumber.getInput());
    }

    public static class InputNumber {
        private long input;

        public InputNumber(long input) {
            this.input = input;
        }

        public InputNumber() {
        }

        public long getInput() {
            return input;
        }

        public void setInput(long input) {
            this.input = input;
        }
    }

}
