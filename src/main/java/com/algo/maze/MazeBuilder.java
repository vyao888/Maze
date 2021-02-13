package com.algo.maze;

import java.util.Objects;

/**
 * MazeBuilder.java: The help class for building Maze with required validation
 *
 */
public final class MazeBuilder {

    private MazeBuilder() {
    }

    public static Maze buildMaze(final Point start, final Point end, final String[] lines) {
        Objects.requireNonNull(start, "Start point must be specified.");
        Objects.requireNonNull(end, "Exit point must be specified.");
        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException("Lines must be valid.");
        }
        Maze maze = null;
        if (start.isValid() && end.isValid()) {
            maze = new Maze(start, end, lines);
        }
        if (maze == null) {
            throw new IllegalArgumentException(String.format(
                    "Failed to build Maze object with Start: %s, End: %s and Lines: %s ", start, end, lines));
        }
        return maze;
    }

}
