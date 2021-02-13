package com.algo.maze;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * MazeNode.java: Model of Maze node entity
 */
@Data
@Builder
@AllArgsConstructor
public class MazeNode implements INode {

  // Encode Maze Nodes
  public final static int WALL = 0;
  public final static int PATH = 1;
  public final static int ENTRY = 2;
  public final static int EXIT = 3;

  private final Point cord;
  private int value;
  private boolean visited;

  @Override
  public boolean isPath() {
    return PATH == this.value;
  }

  @Override
  public boolean isWall() {
    return WALL == this.value;
  }

  @Override
  public boolean isEntry() {
    return ENTRY == this.value;
  }

  @Override
  public boolean isExit() {
    return EXIT == this.value;
  }

  public boolean isValid() {
    return this.cord != null && this.cord.isValid() && this.value >= 0;
  }

}
