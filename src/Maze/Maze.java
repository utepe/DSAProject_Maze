public class Maze {
    public static void main(String[] args){
        MazeGenerator generator = new MazeGenerator(); // initialize and generate the maze using recursive backtracking
        MazePanel.BuildGUI(generator.maze); // build the gui for displaying
    }
}
