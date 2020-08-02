package Solver;

import Generator.*;

public class RecursiveSolve {
    public Cell[][] maze;
    public Cell[][] wasHere;
    public Cell[][] solutionPath;
    public static final int MAZE_SIZE = MazeGenerator.MAZE_SIZE;
    int cols = MAZE_SIZE, rows = MAZE_SIZE;
    int startX = 0, startY = 0;
    int endX = cols-1, endY = rows-1;


    public RecursiveSolve(Cell[][] maze){
        this.maze = maze;
        wasHere = maze;
        solutionPath = maze;
        for(int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++) {
                wasHere[i][j].setVisited(false);
                solutionPath[i][j].setVisited(false);

            }
        }
        solveMaze(startX, startY);
        this.maze = solutionPath;
    }

    public boolean solveMaze(int x, int y) {
        if(x == endX && y == endY) return true;
        if(wasHere[x][y].isVisited()) return false; //checks if it was already visited
        wasHere[x][y].setVisited(true); //setting visited to true for next recursice call
        if(x < 0){
            if(solveMaze(x-1, y)) { //recurivsely calls the left part
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        if(x != cols-1){
            if(solveMaze(x+1, y)) {   //recurivsely calls the right part
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        if(y < 0){
            if(solveMaze(x, y-1)) { //recurivsely calls the top part
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        if(y != rows-1){
            if(solveMaze(x, y+1)) {   //recurivsely calls the bottom part
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        return false;
    }
}