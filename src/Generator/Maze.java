package Generator;

import Solver.*;
import java.util.Scanner;

public class Maze {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime(); 
        MazeGenerator generated = new MazeGenerator(); // initialize and generate the maze using recursive backtracking
        long endTime = System.nanoTime();
        System.out.println("Generating maze took: " + (endTime - startTime) / 1000000 + " ms"); // print the time it takes to generate a maze in ms
        Scanner sc = new Scanner(System.in);
        System.out.println("Maze Generator & Solver Menu");
        System.out.println("-----------------------------");
        boolean flag = true;
        while(flag){
                System.out.println("[1] Display Generated Maze");
                System.out.println("[2] Solve Maze using Modified Dijkstra's Algorithm");
                System.out.println("[3] Solve Maze using a Recursive Solver");
                System.out.println("[4] Solve Maze using Breadth First Search");
                System.out.println("[5] Solve Maze using Depth-First Search");
                System.out.println("[6] Exit");
                int key = sc.nextInt();
                switch (key) {
                    case 1 -> {
                        MazePanel.BuildGUI(generated.maze); // build the gui for displaying genereated maze
                    }
                    case 2 -> {
                        startTime = System.nanoTime();
                        DijkstraSolve solver1 = new DijkstraSolve(generated.maze); // solve using djikstras algorithm
                        endTime = System.nanoTime();
                        System.out.println("Solving maze using Dijkstra's Algorithm took: " + (endTime - startTime) / 1000000 + " ms"); // time to generate solution
                        MazePanel.BuildGUI(solver1.maze); // build the gui for displaying
                    }
                    case 3 -> {
                        startTime = System.nanoTime();
                        RecursiveSolver solver2 = new RecursiveSolver(generated.maze); // solve using the recursive solver
                        endTime = System.nanoTime();
                        System.out.println("Solving maze using a recursive algorithm took: " + (endTime - startTime) / 1000000 + " ms"); // time to generate solution
                        MazePanel.BuildGUI(solver2.maze);
                    }
                    case 4 -> {
                        startTime = System.nanoTime();
                        BFSSolver solver3 = new BFSSolver(generated.maze); // solve using bfs
                        endTime = System.nanoTime();
                        System.out.println("Solving maze using breadth-first search took: " + (endTime - startTime) / 1000000 + " ms"); // time to generate solution
                        MazePanel.BuildGUI(solver3.maze);

                    }
                    case 5 -> {
                        startTime = System.nanoTime();
                        DFSSolver solver4 = new DFSSolver(generated.maze); // solve using dfs
                        endTime = System.nanoTime();
                        System.out.println("Solving maze using depth-first search took: " + (endTime - startTime) / 1000000 + " ms"); // time to generate solution
                        MazePanel.BuildGUI(solver4.maze);
                    }
                    default -> flag = false;
                }
        }
        sc.close();
    }
}
