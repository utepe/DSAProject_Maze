package Generator;

import java.awt.*;

public class Cell {
    public static final int CELL_DIMS = 5;
    private int col, row; // col, row position of the cell.
    private boolean visited = false; // has this cell already  been visited?
    private boolean solution = false; // is this cell part of the most optimal path?

    private double distance;

    private boolean[] walls = {true, true, true, true}; // N E S W walls. true = a wall is present

    public Cell(int col, int row){ // constructor
        this.col = col;
        this.row = row;
    }

    public void drawCell(Graphics g) { // color the cell appropriately and draw the walls if there are any
        if (isVisited()) { // visited cells are white
            setCellColor(g, Color.WHITE);
        }
        if (isSolution()) { // cells that are part of the most optimal solution are yellow
            setCellColor(g, Color.YELLOW);
        }

        // draw the walls if there are any
        int col2 = col * CELL_DIMS;
        int row2 = row * CELL_DIMS;

        g.setColor(Color.BLACK); // walls are black
        if (walls[0]) // north wall
            g.drawLine(col2, row2, col2 + CELL_DIMS, row2);
        if (walls[1]) // east wall
            g.drawLine(col2 + CELL_DIMS, row2, col2 + CELL_DIMS, row2 + CELL_DIMS);
        if (walls[2]) // south wall
            g.drawLine(col2 + CELL_DIMS, row2 + CELL_DIMS, col2, row2 + CELL_DIMS);
        if (walls[3]) // west wall
            g.drawLine(col2, row2 + CELL_DIMS, col2, row2);
    }

    public void setCellColor(Graphics g, Color color){
        int col2 = col * CELL_DIMS;
        int row2 = row * CELL_DIMS;
        g.setColor(color);
        g.fillRect(col2, row2, CELL_DIMS, CELL_DIMS);
    }

    public void removeWalls(Cell neighbor){ // remove between current cell and a neighboring cell
        int col2 = col - neighbor.col;
        if(col2 == 1){ // neighbor is to the left of current cell
            walls[3] = false;
            neighbor.walls[1] = false;
        } else if(col2 == -1){ // neighbor is to the right of current cell
            walls[1] = false;
            neighbor.walls[3] = false;
        }

        int row2 = row - neighbor.row;
        if(row2 == 1) { // neighbor is above current cell
            walls[0] = false;
            neighbor.walls[2] = false;
        } else if (row2 == -1){ // neighbor is below current cell
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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
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

    public void setSolution(boolean solution) {
        this.solution = solution;
    }

    public void setPath(boolean solution) {
        this.solution = solution;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
