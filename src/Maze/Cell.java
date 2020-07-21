package Maze; 

import java.awt.*;

public class Cell {
    public static final int CELL_DIMS = 10;
    private int x, y; // x, y position of the cell.
    private boolean visited = false; // has this cell already been visited?
    private boolean solution = false; // is this cell part of the most optimal path?
    private boolean deadEnd = false;

    private boolean[] walls = {true, true, true, true}; // N E S W walls. true = a wall is present

    public Cell(int x, int y){ // constructor
        this.x = x;
        this.y = y;
    }

    public void drawCell(Graphics g) { // color the cell appropriately and draw the walls if there are any
        if (isVisited()) { // visited cells are white
            setCellColor(g, Color.WHITE);
        }
        if (isSolution()) { // cells that are part of the most optimal solution are yellow
            setCellColor(g, Color.YELLOW);
        } else if (isDeadEnd()) { // cells that lead to a dead end are red
            setCellColor(g, Color.RED);
        }

        // draw the walls if there are any
        int x2 = x * CELL_DIMS;
        int y2 = y * CELL_DIMS;

        g.setColor(Color.BLACK); // walls are black
        if (walls[0]) // north wall
            g.drawLine(x2 + CELL_DIMS, y2 + CELL_DIMS, x2, y2 + CELL_DIMS);
        if (walls[1]) // east wall
            g.drawLine(x2 + CELL_DIMS, y2, x2 + CELL_DIMS, y2 + CELL_DIMS);
        if (walls[2]) // south wall
            g.drawLine(x2, y2, x2 + CELL_DIMS, y2);
        if (walls[3]) // west wall
            g.drawLine(x2, y2 + CELL_DIMS, x2, y2);
    }

    public void setCellColor(Graphics g, Color color){
        int x2 = x * CELL_DIMS;
        int y2 = x * CELL_DIMS;
        g.setColor(color);
        g.fillRect(x2, y2, CELL_DIMS, CELL_DIMS);
    }

    public void removeWalls(Cell neighbor){ // remove between current cell and a neighboring cell
        int x2 = x - neighbor.x;
        if(x2 == 1){ // neighbor is to the left of current cell
            walls[3] = false;
            neighbor.walls[1] = false;
        } else if(x2 == -1){ // neighbor is to the right of current cell
            walls[1] = false;
            neighbor.walls[3] = false;
        }

        int y2 = y - neighbor.y;
        if(y2 == 1) { // neighbor is above current cell
            walls[0] = false;
            neighbor.walls[2] = false;
        } else if (y2 == -1){ // neighbor is below current cell
            walls[2] = false;
            neighbor.walls[0] = false;
        }
    }


    // getters and setters

    public boolean[] getWalls() {
        return walls;
    }

    public void setWalls(boolean[] walls) {
        this.walls = walls;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isSolution() {
        return solution;
    }

    public void setPath(boolean solution) {
        this.solution = solution;
    }

    public boolean isDeadEnd() {
        return deadEnd;
    }

    public void setDeadEnd(boolean deadEnd) {
        this.deadEnd = deadEnd;
    }
}
