package me.triip.springboot.service;

import org.springframework.stereotype.Service;

import me.triip.springboot.Utils;

@Service
public class HighestPrimeFinderServiceDefault {

    public long find(long input) {
        long highestPrime = -1;
        for (long i = input - 1; i > 0; i--) {
            if (Utils.isPrime(i)) {
                highestPrime = i;
                break;
            }
        }
        return highestPrime;
    }
}
