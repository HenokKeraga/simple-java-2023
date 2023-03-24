package graph.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
   private List<GraphNode> nodeList ;
    private int[][] adjacencyMatrix;

    public Graph(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        this.adjacencyMatrix[i][j] = 1;
        this.adjacencyMatrix[j][i] = 1;
    }

    @Override
    public String toString() {
         StringBuilder sb =new StringBuilder();

        for (int i = 0; i < nodeList.size(); i++) {
            sb.append("  "+nodeList.get(i).name()) ;
        }
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append("\n"+nodeList.get(i).name());

            for (int j = 0; j < nodeList.size(); j++) {
                sb.append("  "+adjacencyMatrix[i][j]);
            }

        }



        return sb.toString();
    }
}
