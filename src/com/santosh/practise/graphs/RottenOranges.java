package com.santosh.practise.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 994
 */
class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Cell> q = new LinkedList<Cell>();

        int numRows = grid.length;
        if(numRows == 0) return -1;

        int numCols = grid[0].length;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    Cell c = new Cell();
                    c.row = i;
                    c.col = j;
                    q.add(c);
                }
            }
        }
        int units = 0;

        while(! q.isEmpty()) {

            List<Cell> items = new ArrayList<>();
            while(! q.isEmpty()) {
                items.add(q.poll());
            }
            int counter = 0;


            for(Cell c : items) {
                int topr = c.row-1;
                int topc = c.col;

                if(isValid(topr, topc, numRows, numCols) && grid[topr][topc] == 1) {
                    grid[topr][topc] = 2;
                    Cell c1 = new Cell();
                    c1.row = topr;
                    c1.col = topc;
                    q.add(c1);
                    counter++;
                }

                int bottomr = c.row+1;
                int bottomc = c.col;

                if(isValid(bottomr, bottomc, numRows, numCols) && grid[bottomr][bottomc] == 1) {
                    grid[bottomr][bottomc] = 2;
                    Cell c2 = new Cell();
                    c2.row = bottomr;
                    c2.col = bottomc;
                    q.add(c2);
                    counter++;
                }

                int leftr = c.row;
                int leftc = c.col-1;

                if(isValid(leftr, leftc, numRows, numCols) && grid[leftr][leftc] == 1) {
                    grid[leftr][leftc] = 2;
                    Cell c3 = new Cell();
                    c3.row = leftr;
                    c3.col = leftc;
                    q.add(c3);
                    counter++;
                }

                int rightr = c.row;
                int rightc = c.col+1;

                if(isValid(rightr, rightc, numRows, numCols) && grid[rightr][rightc] == 1) {
                    grid[rightr][rightc] = 2;
                    Cell c4 = new Cell();
                    c4.row = rightr;
                    c4.col = rightc;
                    q.add(c4);
                    counter++;
                }
            }

            if(counter > 0) {
                units++;
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    System.out.println(i + " " + j);
                    return -1;
                }
            }
        }

        return units;
    }
    public boolean isValid(int row, int col, int m, int n) {
        if(row >= 0 && row < m && col >=0 && col < n) return true;
        return false;
    }
}

class Cell {
    int row;
    int col;
}
