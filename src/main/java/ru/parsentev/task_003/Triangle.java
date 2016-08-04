package ru.parsentev.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {
    private static final Logger log = getLogger(Triangle.class);

    protected final Point first;
    protected final Point second;
    protected final Point third;

    protected double a;
    protected double b;
    protected double c;

    public Triangle(final Point first, final Point second, final Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
        a = first.distanceTo(second);
        b = second.distanceTo(third);
        c = third.distanceTo(first);
    }

    public boolean exists() {
        return ((b+c-a)>0) && ((a+c-b)>0) && ((a+b-c)>0);
    }

    public double area() {
        if (!this.exists()) throw new IllegalStateException();
        BigDecimal bd = new BigDecimal(0.25*(Math.sqrt((a+b+c)*(b+c-a)*(a+c-b)*(a+b-c))));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
