package com.algo.maze;

import lombok.extern.java.Log;
import java.util.*;

/**
 * MazeSolver.java: The service class for solving Maze puzzles.
 *
 */
@Log
public class MazeSolver {
  private final Maze maze;
  private final Deque<MazeNode> mazeNodes = new LinkedList<>();

  public MazeSolver(final Maze maze) {
    this.maze = maze;
  }

  /**
   * Solve the Maze puzzle using DFS algorithm
   * @return true if solved; false if not solvable
   */
  public boolean solve() {
    MazeNode start = maze.getEntry();
    this.mazeNodes.push(start);

    while (!this.mazeNodes.isEmpty()) {
      MazeNode node = this.mazeNodes.peek();
      if (node.isVisited()) {
        this.mazeNodes.pop();
        continue;
      }
      if (!node.isVisited()) {
        if (explore(node)) {
          log.info(String.format("Exit node found: %s", node));
          return true;
        } else {
          List<MazeNode> list = this.getNavigableNodes(node);
          addMazeNodesForExploring(node, list);
          log.info(String.format("Size of Nodes for exploring: %d", this.mazeNodes.size()));
        }
      }
    }
    return false;
  }

  public List<MazeNode> getNavigableNodes(Point current) {
    MazeNode node = this.maze.getMazeNode(current);
    return this.getNavigableNodes(node);
  }

  private List<MazeNode> getNavigableNodes(MazeNode current) {
    List<MazeNode> list = new ArrayList<>();
    for (Direction d : Direction.values()) {
      Optional<MazeNode> optional = this.maze.move(current, d);
      if (optional.isPresent()) {
        log.info(String.format("Can move to node: %s", optional.get()));
        list.add(optional.get());
      }
    }
    log.info(String.format("Found %d navigable nodes from node location: %s", list.size(), current.getCord()));
    return list;
  }

  private void addMazeNodesForExploring(MazeNode node, List<MazeNode> list) {
    if (list.isEmpty()) {
      maze.updateMazeNode(node);
      this.mazeNodes.pop();
    } else {
      for (MazeNode mp : list) {
        this.mazeNodes.push(mp);
      }
    }
  }

  private boolean explore(MazeNode node) {
    log.info(String.format("Exploring node location: %s...", node.getCord()));
    if (node.isExit()) {
      return true;
    }
    node.setVisited(true);
    return false;
  }
}
