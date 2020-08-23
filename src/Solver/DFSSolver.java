package Solver;

import Generator.*;
import ADTs.Stack;
import ADTs.List;

import java.util.Random;

public class DFSSolver {
    public Cell[][] maze; // generated maze to pass into the solver
    Stack<Cell> cellStack; // stack used for DFS solution.
    
    public DFSSolver(Cell[][] maze) throws Exception { // constructor
        this.maze = maze;
        cellStack = new Stack<>();
        solve();
    }
    
    public void solve() throws Exception {
        Cell current = maze[0][0], next; // current cell is the starting cell, next cell used for finding cell to move to
        current.setVisitedSolution(true); // mark the first cell as visited and part of the solution
        current.setSolution(true);
        do {
            next = getNeighbor(current); // get a random neighbour to move to
            if (next != null) { // if a neighbor exists, push the current cell to a stack, make the current cell the enxt cell, and mark it as visited and part of the solution
                cellStack.push(current);
                current = next;
                current.setSolution(true);
                current.setVisitedSolution(true);
            } else { // if the next neighbor is false, then we have reached a dead-end, so we set the solution as false and pop from the stack
                current.setSolution(false);
                current = cellStack.pop();
            }
        } while(!cellStack.isEmpty() && current != maze[maze.length - 1][maze.length - 1]); // loop runs while the stack isnt empty and we arent at the end of the maze
    }
    
    private Cell getNeighbor(Cell cell) throws Exception { // this method looks at all of the available neighbours of a current cell and returns a random one
        List<Cell> list = new List<>(); // list used to store neighbors

        if(!cell.getWalls()[0] && cell.getRow() > 0 && !maze[cell.getCol()][cell.getRow()-1].isVisitedSolution()) // north neighbour
            list.add(maze[cell.getCol()][cell.getRow()-1]);
        if(!cell.getWalls()[1] && cell.getCol() < maze.length- 1 && !maze[cell.getCol()+1][cell.getRow()].isVisitedSolution()) // east neighbour
            list.add(maze[cell.getCol()+1][cell.getRow()]);
        if(!cell.getWalls()[2] && cell.getRow() < maze.length - 1 && !maze[cell.getCol()][cell.getRow()+1].isVisitedSolution()) // south neighbour
            list.add(maze[cell.getCol()][cell.getRow()+1]);
        if(!cell.getWalls()[3] && cell.getCol() > 0 && !maze[cell.getCol() - 1][cell.getRow()].isVisitedSolution()) // west neighbour
            list.add(maze[cell.getCol() - 1][cell.getRow()]);
        
        if(list.size > 0) // if there are available neighbours, then return a random one
            return list.get(new Random().nextInt(list.size));
        else
            return null;
    }
}
