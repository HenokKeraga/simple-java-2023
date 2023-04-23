package graph.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<GraphNode> nodeList = List.of(
                new GraphNode("A", 0, new ArrayList<>()),
                new GraphNode("B", 1, new ArrayList<>()),
                new GraphNode("C", 2, new ArrayList<>()),
                new GraphNode("D", 3, new ArrayList<>()),
                new GraphNode("E", 4, new ArrayList<>())
        );

        Graph graph = new Graph(nodeList)  ;

        graph.addUndirectedEdge(0,1);
        graph.addUndirectedEdge(0,2);
        graph.addUndirectedEdge(0,3);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(3,4);

        System.out.println(graph.toString());
        System.out.println(graph.bfs(graph.nodeList.get(0),graph.nodeList.size()));

        System.out.println(graph.dfs(graph.nodeList.get(0),graph.nodeList.size()));

    }
}
