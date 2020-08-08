package Generator;

import Solver.*;
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) throws Exception{
        MazeGenerator generated = new MazeGenerator(); // initialize and generate the maze using recursive backtracking
        Scanner sc = new Scanner(System.in);
        System.out.println("Maze Generator & Solver Menu");
        System.out.println("-----------------------------");
        boolean flag = true;
        while(flag){
                System.out.println("[1] Display Generated Maze");
                System.out.println("[2] Solve Maze using Modified Dijkstra's Algorithm");
                System.out.println("[3] Solve Maze using a Recursive Solver");
                System.out.println("[4] Solve Maze using Breadth-First Search");
                System.out.println("[5] Exit");
                int key = sc.nextInt();
                switch (key) {
                        case 1:
                                MazePanel.BuildGUI(generated.maze); // build the gui for displaying
                                break;
                        case 2:
                                DijkstraSolve solver = new DijkstraSolve(generated.maze);
                                MazePanel.BuildGUI(solver.maze); // build the gui for displaying
                                break;
                        case 3: 
                                RecursiveSolver solved = new RecursiveSolver(generated.maze);
                                MazePanel.BuildGUI(solved.maze);
                                break;
                        case 4:
                                BFSSolver solver = new BFSSolver(generated.maze);
                                MazePanel.BuildGUI(solver.maze);
                                break;
                        default:
                                flag = false;
                                break;
                }
        }
        sc.close();
    }
}
