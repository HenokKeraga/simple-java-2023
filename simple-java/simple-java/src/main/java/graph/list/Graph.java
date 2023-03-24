package graph.list;

import java.util.List;

public class Graph {
    List<GraphNode> nodeList;

    public Graph(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedNeighborNode(int i,int j){
        var main = nodeList.get(i);
        var neighbor = nodeList.get(j);

        main.getNeighbor().add(neighbor);
        neighbor.getNeighbor().add(main);

    }

    @Override
    public String toString() {

        var sb = new StringBuilder();

        for (int i = 0; i < nodeList.size(); i++) {

            sb.append("\n"+nodeList.get(i).getName()+" -> ");
            for (int j = 0; j < nodeList.get(i).getNeighbor().size(); j++) {

                sb.append(nodeList.get(i).getNeighbor().get(j).getName()+" ");

            }

        }
        return sb.toString();
    }
}
