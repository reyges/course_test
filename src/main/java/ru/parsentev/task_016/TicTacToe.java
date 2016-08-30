package ru.parsentev.task_016;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class TicTacToe {
    private static final Logger log = getLogger(TicTacToe.class);

    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        boolean result = false;
        final int length = values.length;
        int countVertical = 0;
        int countHorizont = 0;
        int countDiagonal = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                countHorizont += values[i][j];
                countVertical += values[j][i];
                countDiagonal += values[j][j];
            }
            if (countHorizont == length) {
                result = true;
            } else countHorizont = 0;
            if (countVertical == length) {
                result = true;
            } else countVertical = 0;
            if (countDiagonal == length) {
                result = true;
            }
        }
        return result;
    }
}
