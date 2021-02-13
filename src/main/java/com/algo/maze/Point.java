package com.algo.maze;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Point.java: Model Node location (Coordinates)
 *
 */
@Data
@AllArgsConstructor
public class Point {
    private final int x;
    private final int y;

    public boolean isValid() {
        boolean valid = (this.x >= 0 && this.y >= 0);
        if(!valid) {
            throw new IllegalArgumentException(String.format("Location (%s) is not valid", this));
        }
        return valid;
    }
}
