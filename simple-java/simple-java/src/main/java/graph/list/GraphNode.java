package graph.list;

import java.util.List;

public class GraphNode {
    private String name;
    private int index;
    private List<GraphNode> neighbor;

    public GraphNode(String name, int index, List<GraphNode> neighbor) {
        this.name = name;
        this.index = index;
        this.neighbor = neighbor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<GraphNode> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(List<GraphNode> neighbor) {
        this.neighbor = neighbor;
    }
}
