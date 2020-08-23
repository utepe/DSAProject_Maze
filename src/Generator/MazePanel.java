package Generator;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

class MazePanel extends JPanel {

    Cell[][] maze; // maze to pass in

    public MazePanel(Cell[][] maze){ // constructor
        this.maze = maze;
    }

    @Override // draw all cells
    public void paintComponent(Graphics g){
        for (Cell[] cells : maze) {
            for (Cell cell : cells) {
                cell.drawCell(g); // draw each cell including walls
            }
        }
        maze[0][0].setCellColor(g, Color.GREEN); // starting cell is green
        maze[maze.length -1][maze.length - 1].setCellColor(g, Color.RED); // end cell is red
    }

    public static void BuildGUI(Cell[][] maze){ // this method will make a new window/gui to print the maze/solution
        JFrame frame = new JFrame("Maze"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel panel = new MazePanel(maze);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(maze.length * Cell.CELL_DIMS + 50, maze.length * Cell.CELL_DIMS + 50); // + 50 on the frame size used for padding
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);

        Scanner in = new Scanner(System.in); // User can enter "e" to close the window without stopping the program
        System.out.println("Press e to exit window: ");
        if(in.nextLine().equalsIgnoreCase("e"))
            frame.dispose();
    }
}