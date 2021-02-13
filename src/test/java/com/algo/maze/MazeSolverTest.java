package com.algo.maze;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MazeSolverTest {
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
    public void mazeSolve() {
        Maze maze = MazeBuilder.buildMaze(START, END, LINES);
        MazeSolver solver = new MazeSolver(maze);
        assertNotNull(solver);
        boolean found = solver.solve();
        assertTrue(found);
    }

    @Test
    public void getMovablePointsShouldWork() {
        Maze maze = MazeBuilder.buildMaze(START, END, LINES);
        MazeSolver solver = new MazeSolver(maze);
        List<MazeNode> list = solver.getNavigableNodes(new Point(0,1));
        assertEquals(list.size(), 1);

        list = solver.getNavigableNodes(new Point(1,2));
        assertEquals(list.size(), 2);

        list = solver.getNavigableNodes(new Point(1,1));
        assertEquals(list.size(), 3);

        list = solver.getNavigableNodes(new Point(4,5));
        assertEquals(list.size(), 3);

        list = solver.getNavigableNodes(new Point(5,5));
        assertEquals(list.size(), 1);
    }

}
