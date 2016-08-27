package ru.parsentev.task_015;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CycleShift {
    private static final Logger log = getLogger(CycleShift.class);

    private final int[] values;

    public CycleShift(final int[] values) {
        this.values = values;
    }

    public int[] shift(int position) {
        int length = values.length;
        if (position >= length) {
            return values;
        }
        int[] result = new int[length];
        int n = 0;
        for (int i = position + 1; i < length; i++) {
            result[n] = values[i];
            n++;
        }
        for (int i = 0; i < position + 1; i++) {
            result[n] = values[i];
            n++;
        }
        return result;

    }

    public static void main(String[] args) {
        CycleShift cycle = new CycleShift(new int[]{1, 2, 3, 4, 5});
        int[] result = cycle.shift(2);
        System.out.println(Arrays.toString(result));
    }
}
