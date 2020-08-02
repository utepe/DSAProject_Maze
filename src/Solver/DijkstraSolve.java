package Solver;

import Generator.*;

public class DijkstraSolve{
    public Cell[][] maze;

    public DijkstraSolve(Cell[][] maze) {
        this.maze = maze;
        solve();
    }

    public void solve(){
        Cell current = maze[maze.length - 1][maze.length - 1], next;

        current.setSolution(true);

        while(current != maze[0][0]){
            next = getNeighbor(current);
            if(next != null){
                current = next;
                current.setSolution(true);
            }
            else
                System.out.println("Null cell!");
        }
    }

    private Cell getNeighbor(Cell cell){
        if(!cell.getWalls()[0] && cell.getRow() > 0 && maze[cell.getCol()][cell.getRow()- 1].getDistance() == cell.getDistance() - 1 )
            return maze[cell.getCol()][cell.getRow() - 1];
        if(!cell.getWalls()[1] && cell.getCol() < maze.length - 1 && maze[cell.getCol() + 1][cell.getRow()].getDistance() == cell.getDistance() - 1)
            return maze[cell.getCol() + 1][cell.getRow()];
        if(!cell.getWalls()[2] && cell.getRow() < maze.length - 1 && maze[cell.getCol()][cell.getRow() + 1].getDistance() == cell.getDistance() - 1 )
            return maze[cell.getCol()][cell.getRow() + 1];
        if(!cell.getWalls()[3] && cell.getCol() > 0  && maze[cell.getCol() - 1][cell.getRow()].getDistance() == cell.getDistance() - 1)
            return maze[cell.getCol() - 1][cell.getRow()];

        return null;
    }

}
