package Generator;

public class Maze {
    public static void main(String[] args){
        MazeGenerator generator = new MazeGenerator(); // initialize and generate the maze using recursive backtracking
        DijkstraSolve solver = new DijkstraSolve(generator.maze);
        MazePanel.BuildGUI(solver.maze); // build the gui for displaying
    }
}
