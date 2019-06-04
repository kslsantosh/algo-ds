package com.santosh.practise.dp;


/*Given a matrix with each cell containing each number of candies, and a constraint that you can move only right or down,
        from the top left corner to the bottom right corner, find the path that gets you maximum candies.*/

/*
example:

1 1 2 30
1 1 1 70
2 1 1 90
40 80 1 1

*/

import java.util.Scanner;

public class CostGridMaxSumFirstToLast {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        int numRows = s.nextInt();
//        int numCols = s.nextInt();
        /*int[][] grid = new int[numRows][numCols];
        for(int i = 0; i< numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                grid[i][j] = s.nextInt();
            }
        }*/
        int[][] grid = {
                { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 }
        };
        int numRows = 4;
        int numCols = 6;
        int[][] maxCostMatrix = computeCostMatrix(numRows, numCols, grid);
        printCostMatrix(numRows, numCols,maxCostMatrix);
        printMaxCostAndItsPath(numRows, numCols, maxCostMatrix);

    }

    private static void printCostMatrix(int numRows, int numCols, int[][] maxCostMatrix) {
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols ; j++) {
                System.out.print(maxCostMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printMaxCostAndItsPath(int numRows, int numCols, int[][] maxCostMatrix) {
        // start from the bottom right corner of the matrix, that is where the max value is present.
        // for every move check whether, max(its top and left value) make a move which ever is higher
        //termination when: you reached [0][0]
        int currentRow = numRows-1;
        int currentColumn = numCols-1;
        System.out.println("Max Cost:" + maxCostMatrix[currentRow][currentColumn]);
        while(! isNotTheFirstElementOfGrid(currentRow, currentColumn)) {
            int leftValue = getLeftValue(currentRow, currentColumn, maxCostMatrix);
            int topValue = getTopValue(currentRow, currentColumn, maxCostMatrix);
            if(leftValue > topValue) {
                //move to the left by one column
                currentColumn--;
            } else {
                // move one row top
                currentRow--;
            }
            System.out.println("Path::" + maxCostMatrix[currentRow][currentColumn]);
        }
    }

    private static boolean isNotTheFirstElementOfGrid(int currentRow, int currentColumn) {
        return currentRow == 0 && currentColumn == 0;
    }

    private static int[][] computeCostMatrix(int numRows, int numCols, int[][] grid) {
        // possible moves: one right and one bottom
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols ; j++) {
                int currentValue = grid[i][j];
                int topValue = getTopValue(i,j, grid);
                int leftValue = getLeftValue(i,j,grid);
                grid[i][j] = max(currentValue+topValue, currentValue+leftValue);
            }
        }
        return grid;
    }

    private static int getTopValue(int rowNum, int colNum, int[][] grid) {
        if(rowNum-1 < 0 ) return 0;
        else return grid[rowNum-1][colNum];
    }

    private static int getLeftValue(int rowNum, int colNum, int[][] grid) {
        if(colNum-1 < 0 ) return 0;
        else return grid[rowNum][colNum-1];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
