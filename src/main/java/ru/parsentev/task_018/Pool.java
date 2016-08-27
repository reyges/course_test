package ru.parsentev.task_018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Pool {
    private static final Logger log = getLogger(Pool.class);

    private final int[][] values;

    private int maxSumm = 0;
    private int curSumm = 0;


    public Pool(final int[][] values) {
        this.values = values;
    }

    public int maxUnion() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                curSumm = 0;
                findSumm(i, j);
                if (curSumm > maxSumm) {
                    maxSumm = curSumm;
                }
            }
        }

        return maxSumm;
    }

    private void findSumm(int i, int j) {
        if (values[i][j] == 1) {
            curSumm++;
            values[i][j]  = 0;
            //up
            if ((i > 0)) {
                findSumm(i - 1, j);
            }
            //down
            if (i < (values.length - 1)) {
                findSumm(i + 1, j);
            }
            //left
            if ((j > 0)) {
                findSumm(i, j - 1);
            }
            //right
            if ((j < values.length - 1)) {
                findSumm(i, j + 1);
            }
        }
    }
}
