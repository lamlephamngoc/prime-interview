package me.triip.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilsIsPrimeTest {

    class Case {
        public long input;
        public boolean isPrime;
        public String message;

        public Case(long input, boolean isPrime, String message) {
            this.input = input;
            this.isPrime = isPrime;
            this.message = message;
        }
    }

    @Test
    void testIsPrime() {
        // setup data-driven
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(53l, Boolean.TRUE, "53 is prime"));
        cases.add(new Case(55l, Boolean.FALSE, "55 is not prime"));
        cases.add(new Case(100l, Boolean.FALSE, "100 is not prime"));
        cases.add(new Case(97l, Boolean.TRUE, "97 is prime"));
        cases.add(new Case(2l, Boolean.TRUE, "2 is prime"));
        cases.add(new Case(1l, Boolean.FALSE, "1 is not prime"));
        cases.add(new Case(0l, Boolean.FALSE, "0 is not prime"));

        for(Case c: cases) {
            boolean actual = Utils.isPrime(c.input);

            assertEquals(c.isPrime, actual, c.message);
        }
    }
}