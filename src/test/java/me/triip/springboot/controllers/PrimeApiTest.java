package me.triip.springboot.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.triip.springboot.service.HighestPrimeFinderServiceDefault;

class PrimeApiTest {

    @Mock
    private HighestPrimeFinderServiceDefault highestPrimeFinderService;

    private PrimeApi primeApi;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        primeApi = new PrimeApi(highestPrimeFinderService);
    }

    class Case {
        public long input;
        public long expected;
        public long actual;
        public String message;

        public Case(long input, long expected, long actual, String message) {
            this.input = input;
            this.expected = expected;
            this.actual = actual;
            this.message = message;
        }
    }

    @Test
    void getHighestPrimeLowerThanInput() {
        // setup data-driven test cases
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(0l, -1l, -1l, "There is no prime number lower than 0"));
        cases.add(new Case(55l, 53l, 53l, "Highest prime lower than 55 is 53"));
        cases.add(new Case(70l, 67l, 67l, "Highest prime lower than 70 is 67"));
        cases.add(new Case(100l, 97l, 97l, "Highest prime lower than 55 is 53"));
        cases.add(new Case(1000000l, 999983l, 999983l, "Highest prime lower than 1_000_000 is 999_983"));

        for(Case c : cases) {
            // setup
            when(highestPrimeFinderService.find(c.input)).thenReturn(c.actual);
            PrimeApi.InputNumber input = new PrimeApi.InputNumber();
            input.setInput(c.input);

            // when
            long highestPrimeLowerThanInput = primeApi.getHighestPrimeLowerThanInput(input);

            // then
            assertEquals(c.expected, highestPrimeLowerThanInput);
        }
    }
}