package com.santosh.practise.graphs;

import com.santosh.practise.nodes.Graph;

public class DFS {
    DFS(Graph graph, int n) {
        // initialize empty visited array
        boolean visited[] = new boolean[graph.v];
        dfsUtil(n, graph, visited);
    }

    private void dfsUtil(int n, Graph g, boolean[] visited) {
        // mark this node as visited
        visited[n] = true;
        System.out.println("Visited" + n);

        // now get all its adjacent nodes and iterate
        g.adjacentNodes[n].forEach(adjacentNode -> {
            if(! visited[adjacentNode]) {
                dfsUtil(adjacentNode, g, visited);
            }
        });
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        DFS dfs = new DFS(g, 2);
    }
}
