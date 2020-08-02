package Generator;

import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel {

    Cell[][] maze;
    JFrame frame;

    public MazePanel(Cell[][] maze){
        this.maze = maze;
    }

    @Override
    public void paintComponent(Graphics g){
        for (Cell[] cells : maze) {
            for (Cell cell : cells) {
                cell.drawCell(g);
            }
        }
        maze[0][0].setCellColor(g, Color.GREEN);
        maze[maze.length -1][maze.length - 1].setCellColor(g, Color.RED);
    }

    public static void BuildGUI(Cell[][] maze){
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MazePanel panel = new MazePanel(maze);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        frame.setSize(maze.length * Cell.CELL_DIMS + 50, maze.length * Cell.CELL_DIMS + 50);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setResizable(true);
    }
}