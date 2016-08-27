package ru.parsentev.task_020;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Combine {
    private static final Logger log = getLogger(Combine.class);

    private final int[] values;
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public Combine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> generate() {
        combine(values, 0);
        return result;
    }


    private void combine(int[] array, int i) {
        if (i == array.length - 1) {
            List<Integer> list = new ArrayList<Integer>();
            for (int number: array){
                list.add(number);
            }
            this.result.add(list);
        } else {
            for (int j = i; j < array.length; j++) {
                swap(array, i, j);
                combine(array, i + 1);
                swap(array, i, j);
            }
        }
    }

    private void swap(int[] pa, int i, int j) {
        int k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }



}
