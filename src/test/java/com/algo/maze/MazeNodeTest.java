package com.algo.maze;

import org.junit.Test;

import static com.algo.maze.MazeNode.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MazeNodeTest {
  @Test
  public void isValid() {
    MazeNode p = MazeNode.builder().cord(new Point(0, 1)).value(2).build();
    assertTrue(p.isValid());
  }

  @Test(expected = IllegalArgumentException.class)
  public void notValidWitnNegativeCord() {
    MazeNode p = MazeNode.builder().cord(new Point(-1, 1)).value(2).build();
    assertFalse(p.isValid());
  }

  @Test
  public void notValidWitnNullCord() {
    MazeNode p = MazeNode.builder().cord(null).value(2).build();
    assertFalse(p.isValid());
  }

  @Test
  public void notValidWitnNegativeValue() {
    MazeNode p = MazeNode.builder().cord(new Point(0, 1)).value(-2).build();
    assertFalse(p.isValid());
  }

  @Test
  public void mazeNodeIsEntry() {
    MazeNode p = MazeNode.builder().cord(new Point(0, 1)).value(ENTRY).build();
    assertTrue(p.isEntry());
    p = MazeNode.builder().cord(new Point(0, 1)).value(PATH).build();
    assertFalse(p.isEntry());
  }

  @Test
  public void mazeNodeIsExit() {
    MazeNode p = MazeNode.builder().cord(new Point(0, 1)).value(EXIT).build();
    assertTrue(p.isExit());
    p = MazeNode.builder().cord(new Point(0, 1)).value(PATH).build();
    assertFalse(p.isExit());
  }

  @Test
  public void mazeNodeIsPath() {
    MazeNode p = MazeNode.builder().cord(new Point(0, 1)).value(PATH).build();
    assertTrue(p.isPath());
    p = MazeNode.builder().cord(new Point(0, 1)).value(EXIT).build();
    assertFalse(p.isPath());
  }

  @Test
  public void mazeNodeIsWall() {
    MazeNode p = MazeNode.builder().cord(new Point(0, 1)).value(WALL).build();
    assertTrue(p.isWall());
    p = MazeNode.builder().cord(new Point(0, 1)).value(EXIT).build();
    assertFalse(p.isWall());
  }

}
