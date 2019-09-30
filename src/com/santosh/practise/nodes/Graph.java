package com.santosh.practise.nodes;

import java.util.LinkedList;

public class Graph {
    public int v; // number of vertices
    public LinkedList<Integer> adjacentNodes[]; // array of linked lists for maintaining adjacency list
    int arr[] = new int[10];

    public Graph(int v) {
        this.v = v;
        // initialize adjacency list with default values
        adjacentNodes = new LinkedList[v];
        for(int i = 0; i < v ; i++) {
            adjacentNodes[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        // edge from v to w. so add w to v's adjacency list
        adjacentNodes[v].add(w);
    }
}
