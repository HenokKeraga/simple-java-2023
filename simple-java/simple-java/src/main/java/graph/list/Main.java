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

        graph.addUndirectedNeighborNode(0,1);
        graph.addUndirectedNeighborNode(0,2);
        graph.addUndirectedNeighborNode(0,3);
        graph.addUndirectedNeighborNode(1,4);
        graph.addUndirectedNeighborNode(2,3);
        graph.addUndirectedNeighborNode(3,4);

        System.out.println(graph.toString());

    }
}
