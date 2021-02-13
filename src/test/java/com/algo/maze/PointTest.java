package com.algo.maze;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointTest {
    @Test
    public void isValid() {
        Point p = new Point(0, 1);
        assertTrue(p.isValid());
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValid() {
        Point p = new Point(-1, 1);
        assertFalse(p.isValid());
    }
}
