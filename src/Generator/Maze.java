package Generator;

import Solver.*;
import java.util.Scanner;

public class Maze {
<<<<<<< HEAD
    public static void main(String[] args) throws Exception {
=======
    public static void main(String[] args) throws Exception{
>>>>>>> 4583c02806c23d2f7d5c57921651315dbd7518a1
        MazeGenerator generated = new MazeGenerator(); // initialize and generate the maze using recursive backtracking
        Scanner sc = new Scanner(System.in);
        System.out.println("Maze Generator & Solver Menu");
        System.out.println("-----------------------------");
        boolean flag = true;
        while(flag){
                System.out.println("[1] Display Generated Maze");
                System.out.println("[2] Solve Maze using Modified Dijkstra's Algorithm");
                System.out.println("[3] Solve Maze using a Recursive Solver");
                System.out.println("[4] Solve Maze using Breath First Search");
                System.out.println("[5] Exit");
                int key = sc.nextInt();
                switch (key) {
                        case 1:
                                MazePanel.BuildGUI(generated.maze); // build the gui for displaying
                                break;
                        case 2:
                                DijkstraSolve solver1 = new DijkstraSolve(generated.maze);
                                MazePanel.BuildGUI(solver1.maze); // build the gui for displaying
                                break;
                        case 3: 
                                RecursiveSolver solver2 = new RecursiveSolver(generated.maze);
                                MazePanel.BuildGUI(solver2.maze);
                                break;
                        case 4:
                                // BFSSolver solver3 = new BFSSolver(generated.maze);
                                // MazePanel.BuildGUI(solver3.maze);
                                // break;
                        default:
                                flag = false;
                                break;
                }
        }
        sc.close();
    }
}
