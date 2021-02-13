package com.algo.maze;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.extern.java.Log;
import static com.algo.maze.MazeNode.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Maze.java: Modelling the Maze with Move/Navigation functionalities etc.
 *
 */

@Data
@Log
public class Maze {

  @Getter(AccessLevel.NONE)
  private final Map<Point, MazeNode> map = new HashMap<>();

  private final int width;
  private final int height;
  private final Point start;
  private final Point end;

  /**
   * Constructing the Maze based on passed String[] for Maze node properties
   * @param start The point to start the maze probe
   * @param end The exit point of the Maze
   * @param lines The String Array capturing the nodes information
   */
  public Maze(Point start, Point end, String[] lines) {
    this.start = start;
    this.end = end;
    this.height = lines.length;
    int j = 0;
    for (int i = 0; i < this.height; i++) {
      String[] values = lines[i].split(" ");
      for (j = 0; j < values.length; j++) {
        Point p = new Point(i, j);
        MazeNode mp = MazeNode.builder().cord(p).value(Integer.parseInt(values[j])).build();
        map.put(p, mp);
      }
    }
    this.width = j;
    this.setMazeNodeValue(start, ENTRY);
    this.setMazeNodeValue(end, EXIT);
  }

  public boolean isValid(MazeNode mp) {
    return mp == null ? false : isValid(mp.getCord());
  }

  public Optional<MazeNode> move(MazeNode mp, Direction d) {
    Point p = mp.getCord();
    Point next = null;
    switch (d) {
      case North:
        next = new Point(p.getX() - 1, p.getY());
        break;
      case South:
        next = new Point(p.getX() + 1, p.getY());
        break;
      case East:
        next = new Point(p.getX(), p.getY() + 1);
        break;
      case West:
        next = new Point(p.getX(), p.getY() - 1);
        break;
    }
    MazeNode res = map.get(next);
    return canNavigate(res) ? Optional.of(res) : Optional.empty();
  }

  public boolean canNavigate(MazeNode mazeNode) {
    return isValid(mazeNode) && (mazeNode.isPath() || mazeNode.isExit());
  }

  public MazeNode getEntry() {
    return this.map.get(this.start);
  }

  public void updateMazeNode(MazeNode mazeNode) {
    map.computeIfPresent(mazeNode.getCord(), (k, v) -> mazeNode);
  }

  public MazeNode getMazeNode(Point p) {
    return this.map.get(p);
  }

  private void setMazeNodeValue(Point p, int value) {
    MazeNode node = this.map.get(p);
    node.setValue(value);
  }

  private boolean isValid(Point p) {
    if (p == null) {
      return false;
    }
    int x = p.getX();
    int y = p.getY();
    return (x >= 0 && x < this.height)
      && (y >= 0 && y < this.width);
  }

}
