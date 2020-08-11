package Solver;

import Generator.*;
import ADTs.Stack;
import ADTs.List;

import java.util.Random;

public class DFSSolver {
    public Cell[][] maze;
    Stack<Cell> cellStack;
    
    public DFSSolver(Cell[][] maze) throws Exception {
        this.maze = maze;
        cellStack = new Stack<>();
        solve();
    }
    
    public void solve() throws Exception {
        Cell current = maze[0][0], next;
        current.setVisitedSolution(true);
        current.setSolution(true);
        do {
            next = getNeighbor(current);
            if (next != null) {
                current.removeWalls(next);
                cellStack.push(current);
                current = next;
                current.setSolution(true);
                current.setVisitedSolution(true);
            } else {
                current.setSolution(false);
                current = cellStack.pop();
            }
        } while(!cellStack.isEmpty() && current != maze[maze.length - 1][maze.length - 1]);
    }
    
    private Cell getNeighbor(Cell cell) throws Exception {
        List<Cell> list = new List<>();

        if(!cell.getWalls()[0] && cell.getRow() > 0 && !maze[cell.getCol()][cell.getRow()-1].isVisitedSolution())
            list.add(maze[cell.getCol()][cell.getRow()-1]);
        if(!cell.getWalls()[1] && cell.getCol() < maze.length- 1 && !maze[cell.getCol()+1][cell.getRow()].isVisitedSolution())
            list.add(maze[cell.getCol()+1][cell.getRow()]);
        if(!cell.getWalls()[2] && cell.getRow() < maze.length - 1 && !maze[cell.getCol()][cell.getRow()+1].isVisitedSolution())
            list.add(maze[cell.getCol()][cell.getRow()+1]);
        if(!cell.getWalls()[3] && cell.getCol() > 0 && !maze[cell.getCol() - 1][cell.getRow()].isVisitedSolution())
            list.add(maze[cell.getCol() - 1][cell.getRow()]);
        
        if(list.size > 0)
            return list.get(new Random().nextInt(list.size));
        else
            return null;
    }
}
