package Solver;

import java.util.Random;
import ADTs.LinkedList;

public class MazeSolver{
	/*MAZE GENERATION MANUAL
	With a INT array
	*/
	
	static int [][] maze = {
			{1, 0, 0, 1, 1, 1, 0},
			{1, 0, 0, 1, 0, 1, 0},
			{1, 1, 0, 0, 0, 1, 0},
			{1, 0, 0, 1, 0, 1, 0},
			{1, 0, 0, 1, 0, 1, 0},
			{1, 0, 0, 1, 0, 1, 0},
			{1, 1, 1, 2, 0, 1, 0},
	};
	/* 0 = wall
		1 = path
		2 = final spot */
	//CREATE YOUR OWN LINKED LIST
	static LinkedList<POS> path  = new LinkedList<POS>();
	
	
	public static void main(String[] args) {
		displayMaze(maze);
		solveMaze(new POS(0,0),maze);
		
		
	}
	
	//When you try a path and it doesnt work YOU Will update the ALready tried path TO A WALL WHICh is ZERO
	// so you would switch a 1 to a 0 a path to a wall.
	private static void solveMaze(POS pos,int [][] maze) {
		path.push(pos);
		//just x and y because there all ready initialized up there
		while(true) {
			int y = path.peek().y;
			int x = path.peek().x;
			maze[y][x] = 0;
			//down
			
			if(isValidPath(y+1,x)) {
				if (maze[y+1][x] == 2){
					System.out.println("Moved down, EXIT FOUND !");
					return;
				}else if(maze[y+1][x] == 1) {//movement so add to stack
					System.out.println("Moved down");
					path.push(new POS(y+1,x));
					continue;
				}
			}
			//left
			if(isValidPath(y,x-1)) {
				if (maze[y][x-1] == 2){
					System.out.println("Moved left, EXIT FOUND !");
					return;
				}else if(maze[y][x-1] == 1) {//movement so add to stack
					System.out.println("Moved left");
					path.push(new POS(y,x-1));
					continue;
				}
			}
			//UP
			if(isValidPath(y-1,x)) {
				if (maze[y-1][x] == 2){
					System.out.println("Moved up, EXIT FOUND !");
					return;
				}else if(maze[y-1][x] == 1) {//movement so add to stack
					System.out.println("Moved up");
					path.push(new POS(y-1,x));
					continue;
				}
			}
			
			//right
			if(isValidPath(y,x+1)) {
				if (maze[y][x+1] == 2){
					System.out.println("Moved right,  EXIT FOUND !");
					return;
				}else if(maze[y][x+1] == 1) {//movement so add to stack
					System.out.println("Moved right");
					path.push(new POS(y,x+1));
					continue;
				}
			}
			System.out.println("Moved back 1 postion");
			path.pop();
			
			if(path.size()<=0) {
				System.out.println("No path to exit");
				return;
			}
		}
		
	}
	public static boolean isValidPath(int y, int x) {
		if(y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
			return false;
		}
		else{
			return true;
		}
	}
	public static int[][] randomMaze() {
		int n = 4;
		int[][] maze= new int[n][n];
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		        maze[i][j] = rand.nextInt(2);
		    }
		}
		return maze;
	}
	//prints out a matrix
	public static void displayMaze(int [][] maze){
		int width = maze.length;
		String str = " ";
		//creating random thingy to maze i think
		/*
		Random randx = new Random();
		Random randy = new Random();
		//setting random x and y and settign that POS to 2
		int x = randx.nextInt(maze.length);
		int y = randy.nextInt(maze[0].length);
		*/
		//maze[x][y] = 2 ;
		
		for (int i = 0; i < width; i++) {
		    for (int j = 0; j < maze[0].length; j++) {
		    	if(maze[i][j] == 2) {
		    		maze[i][j] = 2;
		    	}
		    	str += maze[i][j] + " ";
		    		
		    }
		    System.out.println(str);
		    str = " ";
		}
		
		
	}
	
}