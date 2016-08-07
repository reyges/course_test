package ru.parsentev.task_006;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Square {
    private static final Logger log = getLogger(Square.class);

    private final Point first;
    private final Point second;
    private final Point third;
    private final Point fourth;
    protected double a;
    protected double b;
    protected double c;
    protected double d;

    public Square(final Point first, final Point second, final Point third, final Point fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        a = first.distanceTo(second);
        b = second.distanceTo(third);
        c = third.distanceTo(fourth);
        d = fourth.distanceTo(first);
    }

    public boolean exists() {
        return (a == b) && (b == c) && (c == d) && (d == a);
    }
}
