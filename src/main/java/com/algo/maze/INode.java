package com.algo.maze;

/**
 * Node.java: The interface for Maze Node
 *
 */
public interface INode {
    boolean isPath();

    boolean isWall();

    boolean isEntry();

    boolean isExit();

    boolean isValid();
}
