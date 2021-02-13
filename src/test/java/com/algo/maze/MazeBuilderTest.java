package com.algo.maze;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MazeBuilderTest {
    final static String[] LINES = {
            "0 1 0 0 0 0 0 0 0 0",
            "0 1 1 1 1 1 1 0 0 0",
            "0 1 0 0 0 1 1 0 1 0",
            "0 1 0 1 1 1 1 0 1 0",
            "0 1 0 1 1 0 1 0 1 0",
            "0 0 0 0 0 0 0 0 0 0"
    };

    final static Point START = new Point(0,0);
    final static Point END = new Point(5,4);

    @Test
    public void mazzBuildOk() {
        Maze maze = MazeBuilder.buildMaze(START, END, LINES);
        assertNotNull(maze);
    }

    @Test(expected = NullPointerException.class)
    public void mazeBuildFailWithNullStartPoint() {
        Maze maze = MazeBuilder.buildMaze(null, END, LINES);
        assertNotNull(maze);
    }

    @Test(expected = NullPointerException.class)
    public void mazeBuildFailWithNullEndPoint() {
        Maze maze = MazeBuilder.buildMaze(START, null, LINES);
        assertNotNull(maze);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mazeBuildFailWithNullLines() {
        Maze maze = MazeBuilder.buildMaze(START, END, null);
        assertNotNull(maze);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mazeBuildFailWithEmptyLines() {
        String[] lines = {};
        Maze maze = MazeBuilder.buildMaze(START, END, lines);
        assertNotNull(maze);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mazeBuildFailWithInvalidStartPoint() {
        String[] lines = {};
        Maze maze = MazeBuilder.buildMaze(new Point(-1,0), END, lines);
        assertNotNull(maze);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mazeBuildFailWithInvalidEndPoint() {
        String[] lines = {};
        Maze maze = MazeBuilder.buildMaze(new Point(8,8), END, lines);
        assertNotNull(maze);
    }

}
