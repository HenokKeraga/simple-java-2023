package graph.traversal;

import java.util.*;

class Graph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited, List<Integer> result) {
        visited[source] = true;
        result.add(source);
        var neighbors = adj.get(source);

        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                DFSRec(adj, neighbor, visited, result);
            }
        }

    }

    static List<Integer> DFS(ArrayList<ArrayList<Integer>> adj, int V, int source) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        DFSRec(adj, source, visited, result);

        return result;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 3, 4);


        System.out.println("Following is Depth First Traversal: ");
        var dfs = DFS(adj, V, 0);

        System.out.println(dfs);

    }
}
