package com.algo.maze;


import lombok.extern.java.Log;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

@Log
public class MazeTest {
    private final static String[] lines = {
            "1 1 1 1 1 1 1 1 1 1",
            "1 0 0 0 0 0 0 0 0 1",
            "1 0 1 0 1 1 1 1 1 1",
            "1 0 1 0 0 0 0 0 0 1",
            "1 0 1 1 0 1 0 1 1 1",
            "1 0 1 0 0 1 0 1 0 1",
            "1 0 1 0 0 0 0 0 0 1",
            "1 0 1 1 1 0 1 1 1 1",
            "1 0 1 0 0 0 0 0 0 1",
            "1 1 1 1 1 1 1 1 1 1"
    };
    private final static Point START = new Point(1, 1);
    private final static Point END = new Point(8, 8);
    private final static int WIDTH = 10;
    private final static int HEIGHT = 10;


    @Test
    public void constructMazeWithValidWidthAndHeight() {
        Maze maze = createMaze();
        assertEquals(HEIGHT, maze.getHeight());
        assertEquals(WIDTH, maze.getWidth());
    }

    @Test
    public void isValid() {
        Maze maze = createMaze();
        Point p = new Point(2,2);
        assertTrue(maze.isValid(maze.getMazeNode(p)));
    }

    @Test
    public void isNotValid() {
        Maze maze = createMaze();
        Point p = new Point(10,10);
        assertFalse(maze.isValid(maze.getMazeNode(p)));
    }

    @Test
    public void canMoveNorth() {
        Maze maze = createMaze();;
        Point p = new Point(3,2);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.North);
        assertTrue(optional.isPresent());
    }

    @Test
    public void cannotMoveNorth() {
        Maze maze = createMaze();
        Point p = new Point(2,2);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.North);
        assertFalse(optional.isPresent());
        p = new Point(0,2);
        optional = maze.move(maze.getMazeNode(p), Direction.North);
        assertFalse(optional.isPresent());
    }

    @Test
    public void canMoveSouth() {
        Maze maze = createMaze();
        Point p = new Point(3,2);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.South);
        assertTrue(optional.isPresent());
    }

    @Test
    public void cannotMoveSouth() {
        Maze maze = createMaze();
        Point p = new Point(0,2);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.South);
        assertFalse(optional.isPresent());
        p = new Point(9,2);
        optional = maze.move(maze.getMazeNode(p), Direction.South);
        assertFalse(optional.isPresent());
    }

    @Test
    public void canMoveEast() {
        Maze maze = createMaze();
        Point p = new Point(7,2);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.East);
        assertTrue(optional.isPresent());
    }

    @Test
    public void cannotMoveEast() {
        Maze maze = createMaze();
        Point p = new Point(3,2);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.East);
        assertFalse(optional.isPresent());
        p = new Point(2,9);
        optional = maze.move(maze.getMazeNode(p), Direction.East);
        assertFalse(optional.isPresent());
    }

    @Test
    public void canMoveWest() {
        Maze maze = createMaze();
        Point p = new Point(4,9);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.West);
        assertTrue(optional.isPresent());
    }

    @Test
    public void cannotMoveWest() {
        Maze maze = createMaze();
        Point p = new Point(3,9);
        Optional<MazeNode> optional = maze.move(maze.getMazeNode(p), Direction.West);
        assertFalse(optional.isPresent());
        p = new Point(9,0);
        optional = maze.move(maze.getMazeNode(p), Direction.West);
        assertFalse(optional.isPresent());
    }

    @Test
    public void getMazePointShouldWOrk() {
        Maze maze = createMaze();
        Point p = new Point(2,0);
        MazeNode mp =  maze.getMazeNode(p);
        assertEquals(p, mp.getCord());
    }

    private Maze createMaze() {
        return new Maze(START, END, lines);
    }
}
