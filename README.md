# Introduction

This Java project (with MAVEN support) is about how to solve the Maze puzzle

You can run the application via the maven command line:
``````
  mvn exec:java -Dexec.mainClass="com.algo.maze.MazeApplication"


  Victors-MacBook-Pro:Maze victoryao$  mvn exec:java -Dexec.mainClass="com.algo.maze.MazeApplication"
  [INFO] Scanning for projects...
  [INFO] 
  [INFO] -------------------------< com.algo.maze:Maze >-------------------------
  [INFO] Building Maze 1.0-SNAPSHOT
  [INFO] --------------------------------[ jar ]---------------------------------
  [INFO] 
  [INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ Maze ---
  Feb 11, 2021 7:28:54 PM com.algo.maze.MazeSolver explore
  INFO: Exploring Point(x=0, y=0)...
  
  Feb 11, 2021 7:28:54 PM com.algo.maze.MazeSolver solve
  INFO: Exit point found: MazePoint(cord=Point(x=5, y=4), value=3, visited=false)
  Feb 11, 2021 7:28:54 PM com.algo.maze.MazeApplication main
  INFO: Maze has been solved successfully
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time: 1.289 s

````````
Unit tests can be invoked via maven command line as well:


``````
  mvn test


  -------------------------------------------------------
   T E S T S
  -------------------------------------------------------
  Running com.algo.maze.PointTest
  Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.092 sec
  Running com.algo.maze.MazeNodeTest
  Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 sec
  Running com.algo.maze.MazeBuilderTest
  Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.148 sec
  Running com.algo.maze.MazeSolverTest
  Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.321 sec
  Running com.algo.maze.MazeTest
  Tests run: 12, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.023 sec
  
  Results :
  
  Tests run: 31, Failures: 0, Errors: 0, Skipped: 0

``````

# Technologies

- lombok for avoiding the boiler type code
- Junit for unit tests
- Following TDD and Clean Code Best Practices
- Intellij IDE

# Overview of the Implementation Classes

- com.algo.maze.Point: The domain class capturing the x, y cordinates for positioning maze nodes

- com.algo.maze.MazeNode: The INode implementation class. Modeling the real Maze Nodes with position info

- com.algo.maze.INode: The interface for Maze Node

- com.algo.maze.Maze: This is the main class providing Maze operations including navigation logic.
  The Maze constructor takes three parameters: start pozition (Point type), end Pozition (Point type) and lines (String[]) for node details.

- com.algo.maze.MazeSolver: This is a service class for solving the Maze problem using DFS algorithm.

- com.algo.maze.MazeBuilder: This is the help class for building Maze instance object with required validations

- com.algo.maze.MazeApplication: The driver class running the Maze solutions


# NOTE
INFO level log is for the debugging purpose and should be turned off in Production
