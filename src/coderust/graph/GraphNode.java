package coderust.graph;

import java.util.List;

public class GraphNode {
    public int data;
    public List<GraphNode> neighbors;
    public GraphNode(int d) {
        data = d;
    }
}
