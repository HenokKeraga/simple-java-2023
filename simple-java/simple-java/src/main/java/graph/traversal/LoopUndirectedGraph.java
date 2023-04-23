package graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoopUndirectedGraph {
    //is loop there or not

    public static void main(String[] args) {

        int V = 5;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addAdjacencyList(adjacencyList, 0, 1);
        addAdjacencyList(adjacencyList, 0, 2);
        addAdjacencyList(adjacencyList, 1, 4);
        addAdjacencyList(adjacencyList, 1, 3);
        addAdjacencyList(adjacencyList, 2, 3);
        addAdjacencyList(adjacencyList, 3, 4);


        System.out.println(bfs(adjacencyList, V));
        System.out.println(bfsIsCycle(adjacencyList, V));

    }

    public static void addAdjacencyList(List<List<Integer>> adjList, int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public static List<Integer> bfs(List<List<Integer>> adjList, int size) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            var poll = queue.poll();
            result.add(poll);
            var neighbors = adjList.get(poll);

            for (Integer neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }

    public static boolean bfsIsCycle(List<List<Integer>> adjList, int size) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];
        int[] parent = new int[size];
        queue.add(0);
        visited[0] = true;
        parent[0] = -1;
        while (!queue.isEmpty()) {
            var poll = queue.poll();
            result.add(poll);
            var neighbors = adjList.get(poll);

            for (Integer neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor]=poll;
                    queue.add(neighbor);
                } else {

                    if (parent[poll]!=neighbor){
                        System.out.println("poll  " + poll + " neighbor " + neighbor + "  parent "+ parent[poll]);
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
