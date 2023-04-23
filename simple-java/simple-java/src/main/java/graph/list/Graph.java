package graph.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    List<GraphNode> nodeList;

    public Graph(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        var main = nodeList.get(i);
        var neighbor = nodeList.get(j);

        main.getNeighbor().add(neighbor);
        neighbor.getNeighbor().add(main);

    }

    @Override
    public String toString() {

        var sb = new StringBuilder();

        for (int i = 0; i < nodeList.size(); i++) {

            sb.append("\n" + nodeList.get(i).getName() + " -> ");
            for (int j = 0; j < nodeList.get(i).getNeighbor().size(); j++) {

                sb.append(nodeList.get(i).getNeighbor().get(j).getName() + " ");

            }

        }
        return sb.toString();
    }

    public List<String> bfs(GraphNode sourceNode, int size) {

        boolean[] visited = new boolean[size];
        List<String> bfs = new ArrayList<>();
        LinkedList<GraphNode> queue = new LinkedList<>();


        visited[sourceNode.getIndex()] = true;
        queue.add(sourceNode);

        while (queue.size() != 0) {
            var node = queue.poll();
            bfs.add(node.getName());
            for (int i = 0; i < node.getNeighbor().size(); i++) {
                var graphNode = node.getNeighbor().get(i);
                var index = graphNode.getIndex();
                if (!visited[index]) {
                    visited[index] = true;
                    queue.add(graphNode);
                }
            }

        }


        return bfs;
    }

    public List<String> dfs(GraphNode source, int size) {
        boolean[] visited = new boolean[size];
        List<String> result = new ArrayList<>(size);
        dfsUtil(source, size, result, visited);

        return result;

    }

    public void dfsUtil(GraphNode source, int size, List<String> result, boolean[] visited) {
        visited[source.getIndex()] = true;
        result.add(source.getName());
        var neighbors = source.getNeighbor();

        for (int i = 0; i < neighbors.size(); i++) {
            var neighbor = neighbors.get(i);
            if (!visited[neighbor.getIndex()]) {
                dfsUtil(neighbor, size, result, visited);
            }
        }
    }
}
