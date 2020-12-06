package com.santosh.practise.dp;

public class MaxPathMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,9}, {5,3,8}, {4,6,7}};
        int[][] visited = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(visited[i][j] == 0) {
                    visited[i][j] = 1;
                    findMaxPathInMatrix(matrix, visited, i, j, 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, visited[i][j]);
            }
        }

        System.out.println("max path is" + max);
    }

    private static void findMaxPathInMatrix(int[][] matrix, int[][] visited, int i, int j, int pathLength) {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length)
            return;

        int currentNumber = matrix[i][j];
        int requiredNumber = ++currentNumber;

        visited[i][j] = pathLength;
        // check if exists in the left side of it.
        if(j-1 >=0 && matrix[i][j-1] == requiredNumber) {
                findMaxPathInMatrix(matrix, visited, i, j-1, pathLength+1);
        }
        // check if exists in the right side of it.
        if(j+1 < matrix[0].length && matrix[i][j+1] == requiredNumber) {
                findMaxPathInMatrix(matrix, visited, i, j+1, pathLength+1);

        }
        // check if it is on the top
        if(i-1 >= 0 && matrix[i-1][j] == requiredNumber) {
                findMaxPathInMatrix(matrix, visited, i-1, j, pathLength+1);
        }
        // check if it is on the bottom
        if(i+1 < matrix.length && matrix[i+1][j] == requiredNumber) {
                findMaxPathInMatrix(matrix, visited, i+1, j, pathLength+1);
        }
    }
}
