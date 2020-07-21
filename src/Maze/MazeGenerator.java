package Maze;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeGenerator {
    Cell[][] maze;
    JFrame frame;
    public static final int MAZE_SIZE = 50;

    public static void main(String[] args){
        MazeGenerator generator = new MazeGenerator();
        generator.run();
    }

    public MazeGenerator(){
        maze = new Cell[MAZE_SIZE][MAZE_SIZE];
        initializeCells();
        RecursiveBacktrackGenerate();
    }

    private void initializeCells(){ // initialize the x and y coords of each cell relative to their position in the 2d array
        for(int i = 0; i < MAZE_SIZE; i++){
            for(int j = 0; j < MAZE_SIZE; j++){
                maze[i][j] = new Cell(i, j);
            }
        }
    }

    private void RecursiveBacktrackGenerate(){
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
            } else {
                current = cellStack.pop();
            }
        } while(!cellStack.empty());
    }

    private Cell getNeighbor(Cell cell){ // find all unvisited neighbors next to cell and return a random one
        ArrayList<Cell> a = new ArrayList<>();
        if(cell.getX() > 0 && !maze[cell.getX() - 1][cell.getY()].isVisited())
            a.add(maze[cell.getX() - 1][cell.getY()]);
        if(cell.getY() > 0 && !maze[cell.getX()][cell.getY()-1].isVisited())
            a.add(maze[cell.getX()][cell.getY()-1]);
        if(cell.getX() < MAZE_SIZE- 1 && !maze[cell.getX()+1][cell.getY()].isVisited())
            a.add(maze[cell.getX()+1][cell.getY()]);
        if(cell.getY() < MAZE_SIZE- 1 && !maze[cell.getX()][cell.getY()+1].isVisited())
            a.add(maze[cell.getX()][cell.getY()+1]);

        if(a.size() > 0)
            return a.get(new Random().nextInt(a.size()));
        else
            return null;
    }

    private void run(){
        frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GPanel panel = new GPanel();
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(MAZE_SIZE * Cell.CELL_DIMS, MAZE_SIZE * Cell.CELL_DIMS + 30);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setResizable(true);
    }

    class GPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            for(int i = 0; i < MAZE_SIZE; i++){
                for(int j = 0; j < MAZE_SIZE; j++){
                    maze[i][j].drawCell(g);
                }
            }
            maze[0][0].setCellColor(g, Color.GREEN);
            maze[MAZE_SIZE -1][MAZE_SIZE - 1].setCellColor(g, Color.RED);
        }
    }
}
