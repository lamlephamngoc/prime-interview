package me.triip.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HighestPrimeFinderServiceDefaultTest {

    private HighestPrimeFinderServiceDefault highestPrimeFinder = new HighestPrimeFinderServiceDefault();

    class Case {
        public long input;
        public long expected;
        public String message;

        public Case(long input, long expected, String message) {
            this.input = input;
            this.expected = expected;
            this.message = message;
        }
    }

    @Test
    void testFindHighestPrimeLowerThanInput() {
        // setup data-driven
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(0, -1, "There is no prime number lower than 0"));
        cases.add(new Case(3, 2, "Highest prime number lower than 3 is 2"));
        cases.add(new Case(53, 47, "Highest prime number lower than 53 is 47"));
        cases.add(new Case(55, 53, "Highest prime number lower than 55 is 53"));
        cases.add(new Case(80, 79, "Highest prime number lower than 80 is 79"));
        cases.add(new Case(100, 97, "Highest prime number lower than 100 is 97"));
        cases.add(new Case(1000000, 999983, "Highest prime number lower than 1000000 is 999983"));

        for (Case c : cases) {
            // when
            long actual = highestPrimeFinder.find(c.input);

            // then
            assertEquals(c.expected, actual, c.message);
        }
    }
}