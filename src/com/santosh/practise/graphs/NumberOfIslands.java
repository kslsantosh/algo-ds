package com.santosh.practise.graphs;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * LeetCode Problem 200
 */
public class NumberOfIslands {
    public static void main(String[] args) {
//        int[][] matrix = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
//        int[][] matrix = {{1}};
//        char[][] matrix = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] matrix = {};
        int numberOfIslands = findNumberOfIslands(matrix);
        System.out.println("Number Of Islands" + numberOfIslands);

    }

    private static int findNumberOfIslands(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1' && visited[i][j] == 0) {
                    System.out.println("Found New Island @ " + i + "_" +  j);
                    numberOfIslands++;
                    dfs(i ,j, matrix, visited);
                }
            }
        }

        return numberOfIslands;
    }

    private static void dfs(int i, int j, char[][] matrix, int[][] visited) {
        if(isSafe(i, j, matrix.length, matrix[0].length) && matrix[i][j] == '1' && visited[i][j] == 0) {
            System.out.println("Visited "  + i + "_" +  j);
            visited[i][j] = 1; // mark current node as visited
            dfs(i-1, j, matrix, visited); // recur adjacent left
            dfs(i+1, j, matrix, visited); // recur adjacent right
            dfs(i, j-1, matrix, visited); // recur top
            dfs(i, j+1, matrix, visited); // recur bottom
        }
    }

    private static boolean isSafe(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}
