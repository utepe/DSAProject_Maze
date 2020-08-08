package Solver;

import ADTs.PriorityQueue;
import Generator.*;

public class DijkstraSolve{
    public Cell[][] maze; // maze that we will pass into the solver
    PriorityQueue<Cell> queue; // queue used to solve

    public DijkstraSolve(Cell[][] maze) { // constructor for this
        this.queue = new PriorityQueue<>(maze.length * maze.length); // initialize the queue to be of size of the total number of cells
        this.maze = maze; // pass in the already generated maze
        solve(); // call the solve method to solve the maze
    }

    public void solve(){
        Cell current = maze[maze.length - 1][maze.length - 1], next; // current cell is set as the end of the maze

        queue.enqueue(current, (int) current.getDistance()); // enqueue the last cell of the maze with a priority = to its distance

        while(queue.peek() != maze[0][0]){ // loop until the front of the queue = the start of the maze
            next = getNeighbor(current); // call the getNeighbor method to find the next cell
                if(next != null){ // check to make sure that we aren't moving to null cells
                    current = next; // set current to the neighbor we found and add it to the key with priority = to its distance
                    queue.enqueue(current, (int) current.getDistance());
                }
                else // if next is null; this is just an error-check and should never run
                    System.out.println("Null cell!");
        }


        while(queue.getSize() != 0){ // now our queue contains the solution in order from start to finish
            current = queue.dequeue(); // dequeue until the queue is empty and set the solution
            current.setSolution(true);
        }
    }

    private Cell getNeighbor(Cell cell){ // method gets the neighbor to choose when solving the maze
        if(!cell.getWalls()[0] && cell.getRow() > 0 && maze[cell.getCol()][cell.getRow()- 1].getDistance() == cell.getDistance() - 1 ) // neighbor is north
            return maze[cell.getCol()][cell.getRow() - 1];
        if(!cell.getWalls()[1] && cell.getCol() < maze.length - 1 && maze[cell.getCol() + 1][cell.getRow()].getDistance() == cell.getDistance() - 1) // neighbor is east
            return maze[cell.getCol() + 1][cell.getRow()];
        if(!cell.getWalls()[2] && cell.getRow() < maze.length - 1 && maze[cell.getCol()][cell.getRow() + 1].getDistance() == cell.getDistance() - 1 ) // neighbor is south
            return maze[cell.getCol()][cell.getRow() + 1];
        if(!cell.getWalls()[3] && cell.getCol() > 0  && maze[cell.getCol() - 1][cell.getRow()].getDistance() == cell.getDistance() - 1) // neighbor is west
            return maze[cell.getCol() - 1][cell.getRow()];

        return null;
    }

}
