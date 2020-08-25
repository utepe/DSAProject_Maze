package Generator;

import javax.swing.*;

import ADTs.List;
import ADTs.Stack;

import java.util.Random;

public class MazeGenerator {
    Cell[][] maze;
    JFrame frame;
    public static int MAZE_SIZE; // maze dimensions
    int cols = MAZE_SIZE;
    int rows = MAZE_SIZE;


    public MazeGenerator() throws Exception {
        maze = new Cell[cols][rows];
        initializeCells();
        RecursiveBacktrackGenerate();
    }

    private void initializeCells(){ // initialize the x and y coords of each cell relative to their position in the 2d array
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                maze[i][j] = new Cell(i, j);
            }
        }
    }

    private void RecursiveBacktrackGenerate() throws Exception { // this is also called DFS generation
        Stack<Cell> cellStack = new Stack<>(); // stack used for generation
        Cell current = maze[0][0], next; // set current cell as the starting cell, next cell used to mark neighbor
        current.setVisited(true); // set the starting cell as visited
        do {
            next = getNeighbor(current); // get a neighbor of the current cell
            if (next != null) { // if a neighbor exists, remove the walls between the current cell and its neighbor, push the current to a stack, and set the current cell as the neighbor
                current.removeWalls(next); 
                cellStack.push(current);
                current = next;
                current.setVisited(true);
                current.setDistance(cellStack.Size()); // used for djikstra
            } else { // if there are no valid neighbors, then we have looped in on ourselves and have genereated a dead-end. If this is the case, pop from the stack 
                current = cellStack.pop();
            }
        } while(!cellStack.isEmpty()); // loop until we have accessed every cell in the maze
    }

    private Cell getNeighbor(Cell cell) throws Exception { // find all unvisited neighbors next to cell and return a random one
        List<Cell> a = new List<>(); // list used to return a random neighbor
        if(cell.getCol() > 0 && !maze[cell.getCol() - 1][cell.getRow()].isVisited()) // east neighbor
            a.add(maze[cell.getCol() - 1][cell.getRow()]);
        if(cell.getRow() > 0 && !maze[cell.getCol()][cell.getRow()-1].isVisited()) // north neighbor
            a.add(maze[cell.getCol()][cell.getRow()-1]);
        if(cell.getCol() < cols- 1 && !maze[cell.getCol()+1][cell.getRow()].isVisited()) // west neighbor
            a.add(maze[cell.getCol()+1][cell.getRow()]);
        if(cell.getRow() < rows - 1 && !maze[cell.getCol()][cell.getRow()+1].isVisited()) // south neighbor
            a.add(maze[cell.getCol()][cell.getRow()+1]);

        if(a.size() > 0) // if there are available neighbors, return a random one
            return a.get(new Random().nextInt(a.size()));
        else
            return null;
    }
}
