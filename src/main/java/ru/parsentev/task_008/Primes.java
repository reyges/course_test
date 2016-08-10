package ru.parsentev.task_008;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Primes {
    private static final Logger log = getLogger(Primes.class);

    private final int limit;

    public Primes(final int limit) {
        this.limit = limit;
    }

    public List<Integer> calc() {
        List<Integer> primesList = new ArrayList<Integer>();
        primesList.add(2);
        for (int i = 3; i < limit+1; i++) {
            for (int j = 0; j < primesList.size(); j++) {
                if (i % primesList.get(j) == 0) {
                    break;
                } else if (j == primesList.size() - 1) {
                    primesList.add(i);
                }
            }
        }

        return primesList;
    }
}
