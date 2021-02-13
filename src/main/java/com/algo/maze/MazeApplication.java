package com.algo.maze;

import lombok.extern.java.Log;

/**
 * MazeApplication.java: The Maze Driver with the input hard coded. Should not be used in Production.
 * The node information can be passed as argument via a file, for example.
 * Same for the start and end points of the Maze
 */
@Log
public class MazeApplication {

  public static void main(String[] args) {
    String[] lines = {
      "0 1 0 0 0 0 0 0 0 0",
      "0 1 1 1 1 1 1 0 0 0",
      "0 1 0 0 0 1 1 0 1 0",
      "0 1 0 1 1 1 1 0 1 0",
      "0 1 0 1 1 0 1 0 1 0",
      "0 0 0 0 0 0 0 0 0 0"
    };

    Maze maze = MazeBuilder.buildMaze(new Point(0, 0), new Point(5, 4), lines);
    MazeSolver solver = new MazeSolver(maze);
    boolean solved = solver.solve();
    log.info(solved ? "Maze has been solved successfully" : "Maze not been solved.");
  }

}
