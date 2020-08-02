package Generator;

import Solver.*;

public class Maze {
    public static void main(String[] args){
        MazeGenerator generator = new MazeGenerator(); // initialize and generate the maze using recursive backtracking
        DijkstraSolve solver = new DijkstraSolve(generator.maze);
        MazePanel.BuildGUI(solver.maze); // build the gui for displaying
        // MazePanel.BuildGUI(generator.maze); // build the gui for displaying

        RecursiveSolver solved = new RecursiveSolver(generator.maze);
        MazePanel.BuildGUI(solved.maze);
    }
}
