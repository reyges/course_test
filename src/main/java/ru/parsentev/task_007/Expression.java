package ru.parsentev.task_007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static java.lang.Math.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {

        String operators[] = expr.split("[0-9]+");
        String operands[] = expr.split("[^0-9]+");

        if (operands.length < 2) throw new IllegalStateException();

        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("+")) {
                return Double.parseDouble(operands[i - 1]) + Double.parseDouble(operands[i]);
            }
            if (operators[i].equals("-")) {
                return Double.parseDouble(operands[i - 1]) - Double.parseDouble(operands[i]);
            }
            if (operators[i].equals("exp")) {
                return exp(Double.parseDouble(operands[i+1]));
            }
        }
        return 0.0d;
    }
}
