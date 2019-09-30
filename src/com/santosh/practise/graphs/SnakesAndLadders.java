package com.santosh.practise.graphs;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLadders {
    public static void main(String[] args) {
        System.out.println("Enter number of vertices");
        Scanner s = new Scanner(System.in);
        int numVertices = s.nextInt();

        LinkedList<Integer>[] adjacencyList = new LinkedList[numVertices+1];

        // populate defaults to adjacency lists, with next possible six moves

        for(int i = 1; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
            for(int j = i+1 ; j <=i+6 && j<=100; j++) {
                adjacencyList[i].add(j);
            }
        }

        System.out.println("Enter number of ladders");
        int numLadders = s.nextInt();

        for(int i = 1; i <= numLadders ; i++) {
            System.out.println("Enter source vertex");
            int source = s.nextInt();
            System.out.println("Enter destination vertex");
            int destination = s.nextInt();
            replaceNodesWithLaddersInGraph(adjacencyList, source, destination);
        }

        System.out.println("Enter number of snakes");
        int numSnakes = s.nextInt();

        for(int i = 1; i <= numSnakes ; i++) {
            System.out.println("Enter source vertex");
            int source = s.nextInt();
            System.out.println("Enter destination vertex");
            int destination = s.nextInt();
            replaceNodesWithSnakesInGraph(adjacencyList, source, destination);
        }

        System.out.println("Adjacency List");
        printAdjacencyList(adjacencyList);
        int[] parents = new int[++numVertices];
        int[] levels = new int[++numLadders];
        for(int i = 0; i<=numVertices; i++) {
            parents[i] = -1;
            levels[i] = -1;
        }
        bfs(adjacencyList, parents, levels, 1);

        System.out.println("Minimum steps required::" + levels[100]);
    }

    private static void bfs(LinkedList<Integer>[] adjacencyList, int[] parents, int[] levels, int starting) {
        levels[starting] = 0; // stating with level 0
        Queue<Integer> queue = new LinkedList<>();
        queue.add(starting);

        while (! queue.isEmpty()) {
            // get the next vertex in queue
            int currentNode = queue.peek();

            LinkedList<Integer> adjacentNodes = adjacencyList[currentNode];
            for(int i = 0; i < adjacentNodes.size(); i++) {
                if(levels[adjacentNodes.get(i)] == -1) {
                    levels[adjacentNodes.get(i)] = levels[currentNode+1]; // setting the level of adjacent vertex
                    parents[adjacentNodes.get(i)] = currentNode;
                    queue.add(adjacentNodes.get(i));
                }
            }
            queue.poll();
        }
    }

    private static void printAdjacencyList(LinkedList<Integer>[] adjacencyList) {
        for(int i = 1; i < adjacencyList.length; i++) {

            LinkedList<Integer> list = adjacencyList[i];
            System.out.print(i);
            for(int j = 0; j < list.size(); j++) {
                System.out.print("->>");
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }

    private static void replaceNodesWithLaddersInGraph(LinkedList<Integer>[] adjacencyList, int source, int destination) {
        for(int i = 1; i < adjacencyList.length; i++) {
            LinkedList<Integer> list = adjacencyList[i];
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == source) {
                    list.set(j, destination);
                }
            }
        }
    }
    private static void replaceNodesWithSnakesInGraph(LinkedList<Integer>[] adjacencyList, int source, int destination) {
        for(int i = 1; i < adjacencyList.length; i++) {
            LinkedList<Integer> list = adjacencyList[i];
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == source) {
                    list.set(j, destination);
                }
            }
        }
    }
}
