package ru.parsentev.task_005;

import org.slf4j.Logger;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_003.Triangle;

import java.util.Arrays;

import static java.lang.Math.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class RightTriangle extends Triangle {
    private static final Logger log = getLogger(RightTriangle.class);

    public RightTriangle(Point first, Point second, Point third) {
        super(first, second, third);
    }

    @Override
    public boolean exists() {
        double[] arr = {a, b, c};
        Arrays.sort(arr);
        return super.exists() && (round(pow(arr[0], 2)) + round(pow(arr[1], 2))) == round(pow(arr[2], 2));
    }
}
