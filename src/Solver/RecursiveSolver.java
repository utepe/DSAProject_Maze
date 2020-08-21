package Solver;

import Generator.*;

public class RecursiveSolver {
    public Cell[][] maze;
    public Cell[][] wasHere;
    public Cell[][] solutionPath;
    public static final int MAZE_SIZE = MazeGenerator.MAZE_SIZE;
    int cols = MAZE_SIZE, rows = MAZE_SIZE;
    int startX = 0, startY = 0;
    int endX = cols-1, endY = rows-1;


    public RecursiveSolver(Cell[][] maze){
        this.maze = maze;
        solutionPath = maze;
        for(int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++) {
                solutionPath[i][j].setVisited(false);

            }
        }
        solveMaze(startX, startY);
        this.maze = solutionPath;
    }

    public boolean solveMaze(int x, int y) {
        if(x == endX && y == endY) return true;
        if(solutionPath[x][y].isVisited()) return false; //checks if it was already visited
        solutionPath[x][y].setVisited(true); //setting visited to true for next recursice call
        if(x != 0 && !hasWestWall(this.maze[x][y])){
            if(solveMaze(x-1, y)) { //recurivsely calls the left of current pos
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        if(x != cols-1 && !hasEastWall(this.maze[x][y])){
            if(solveMaze(x+1, y)) {   //recurivsely calls the right of current pos
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        if(y != 0 && !hasNorthWall(this.maze[x][y])){
            if(solveMaze(x, y-1)) { //recurivsely calls the north of current pos
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        if(y != rows-1 && !hasSouthWall(this.maze[x][y])){
            if(solveMaze(x, y+1)) {   //recurivsely calls the bottom part
                solutionPath[x][y].setPath(true); //set path to true
                return true;
            }
        }
        return false;
    }

    private boolean hasWestWall(Cell cell){
        return cell.getWalls()[3];  //if the cell has a wall to the left of it then return true
    }

    private boolean hasNorthWall(Cell cell){
        return cell.getWalls()[0];  //if the cell has a wall to the north of it then return true
    }

    private boolean hasEastWall(Cell cell){
        return cell.getWalls()[1]; //if the cell has a wall to the right of it then return true
    }

    private boolean hasSouthWall(Cell cell){
        return cell.getWalls()[2]; //if the cell has a wall to the south of it then return true

    }
}