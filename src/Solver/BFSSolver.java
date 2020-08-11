package Solver;

import ADTs.List;
import ADTs.Queue;
import Generator.Cell;

public class BFSSolver {
    Queue<Cell> queue; // queue used for BFS
    public Cell[][] maze; // maze that we will pass into the solver

    public BFSSolver(Cell[][] maze) throws Exception { // constructor throws exception for list implementation
        this.maze = maze;
        queue = new Queue<>();
        solve();
    }

    private void solve() throws Exception {
        Cell current, next; // current and next cells used as temporary variables
        maze[0][0].setVisitedSolution(true);  // mark the start of the cell as visited and queue it in the queue
        queue.enqueue(maze[0][0]);
        boolean flag = false; // flag variable used to halt once solution ends

        while(!queue.isEmpty() && !flag){ // run while the queue is not empty and we are not done
            current = queue.dequeue(); // set current as the front cell in the queue and remove it

            if(current == maze[maze.length - 1][maze.length - 1]) { // if current is the end of the maze, backtrack using parents and set as solution along the way
                while(current != maze[0][0]){
                    current.setSolution(true);
                    current = current.parent;
                }
                flag = true; // set flag to true to exit
            }

            if(!flag) {
                for (int i = 0; i < getNeighbors(current).size; i++) { // loop through each available neighbor of the current cell
                    next = getNeighbors(current).get(i);
                    if (!next.isVisitedSolution()) { // if we haven't visited the next cell, set it as visited, set its parent as current. and enqueue it
                        next.setVisitedSolution(true);
                        next.parent = current;
                        queue.enqueue(next);
                    }
                }
            }
        }
    }

    private List<Cell> getNeighbors(Cell cell){ // method returns the available cells of a specified cell as a list
        List<Cell> list = new List<>(); // initialize a list to be returned

        if(!cell.getWalls()[0] && cell.getRow() > 0)  // neighbor is north
            list.add(maze[cell.getCol()][cell.getRow()-1]);
        if(!cell.getWalls()[1] && cell.getCol() < maze.length - 1) // neighbor is east
            list.add(maze[cell.getCol() + 1][cell.getRow()]);
        if(!cell.getWalls()[2] && cell.getRow() < maze.length - 1) // neighbor is south
            list.add(maze[cell.getCol()][cell.getRow() + 1]);
        if(!cell.getWalls()[3] && cell.getCol() > 0 )
            list.add(maze[cell.getCol() - 1][cell.getRow()]); // neighbor is west

        return list;
    }
}
