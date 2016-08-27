package ru.parsentev.task_002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Class Point defines a point in coodrional system (x, y).
 *
 * @author parsentev
 * @since 19.07.2016
 */
public class Point {
    private static final Logger log = getLogger(Point.class);

    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        Point point = (Point) obj;
        return (x == point.x) && (y == point.y);
    }

    public double distanceTo(final Point point) {
        BigDecimal bd = new BigDecimal(sqrt(pow(abs(this.x - point.x), 2) + pow(abs(this.y - point.y), 2)));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
