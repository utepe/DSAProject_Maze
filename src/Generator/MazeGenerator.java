package Generator;

import javax.swing.*;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
    Cell[][] maze;
    JFrame frame;
    public static final int MAZE_SIZE = 100;
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

    private void RecursiveBacktrackGenerate() throws Exception {
        Stack<Cell> cellStack = new Stack<>();
        Cell current = maze[0][0], next;
        current.setVisited(true);
        do {
            next = getNeighbor(current);
            if (next != null) {
                current.removeWalls(next);
                cellStack.push(current);
                current = next;
                current.setVisited(true);
                current.setDistance(cellStack.size());
            } else {
                current = cellStack.pop();
            }
        } while(!cellStack.empty());
    }

    private Cell getNeighbor(Cell cell) throws Exception { // find all unvisited neighbors next to cell and return a random one
        List<Cell> a = new List<>();
        if(cell.getCol() > 0 && !maze[cell.getCol() - 1][cell.getRow()].isVisited())
            a.add(maze[cell.getCol() - 1][cell.getRow()]);
        if(cell.getRow() > 0 && !maze[cell.getCol()][cell.getRow()-1].isVisited())
            a.add(maze[cell.getCol()][cell.getRow()-1]);
        if(cell.getCol() < cols- 1 && !maze[cell.getCol()+1][cell.getRow()].isVisited())
            a.add(maze[cell.getCol()+1][cell.getRow()]);
        if(cell.getRow() < rows - 1 && !maze[cell.getCol()][cell.getRow()+1].isVisited())
            a.add(maze[cell.getCol()][cell.getRow()+1]);

        if(a.size() > 0)
            return a.get(new Random().nextInt(a.size()));
        else
            return null;
    }
}
