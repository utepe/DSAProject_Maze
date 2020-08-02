package Solver;

import Generator.*;
import ADTs.*;

public class recursiveSolve {
    public Cell[][] maze;
    public static final int MAZE_SIZE = MazeGenerator.MAZE_SIZE;
    int cols = MAZE_SIZE;
    int rows = MAZE_SIZE;

    public recursiveSolve(Cell[][] maze){
        this.maze = maze;
    }

    public void solveMaze(){
        Stack<Cell> cellStack = new Stack<>();
    }
}