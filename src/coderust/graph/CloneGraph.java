package coderust.graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public GraphNode cloneGraph(GraphNode root) {
        Map<GraphNode, GraphNode> completed = new HashMap<GraphNode, GraphNode>();
        return cloneRec(root, completed);
    }

    private static GraphNode cloneRec(GraphNode root, Map<GraphNode, GraphNode> completed) {
        if (root == null) {
            return null;
        }
        GraphNode nodeCopy = new GraphNode(root.data);
        completed.put(root, nodeCopy);
        for (GraphNode node : root.neighbors) {
            if (completed.containsKey(node)) {
                nodeCopy.neighbors.add(completed.get(node));
            } else {
                // if the completed doesn't contains the node, recursively call the clone.
                nodeCopy.neighbors.add(cloneRec(node, completed));
            }
        }
        return nodeCopy;
    }
}

