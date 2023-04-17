package com.jta.abialgorithms.graph.search;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;
import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.datastructures.linear.Stack;

/**
 * An implementation of the iterative depth-first search algorithm.
 */
public class IterativeDepthFirstSearch implements GraphSearchAlgorithm {
    @Override
    public Vertex search(final Graph graph, final Vertex vertex) {
        Vertex startingVertex = FirstVertexRetriever.getFirstVertex(graph);
        if (startingVertex == null) {
            return null;
        }
        graph.setAllEdgeMarks(false);
        Stack<Vertex> stack = new Stack<>();
        stack.push(startingVertex);
        while (!stack.isEmpty()) {
            Vertex current = stack.top();
            if (current.getID().equals(vertex.getID())) {
                return current;
            }
            stack.pop();
            current.setMark(true);
            List<Vertex> neighbors = graph.getNeighbours(current);
            neighbors.toFirst();
            while (neighbors.hasAccess()) {
                Vertex neighbor = neighbors.getContent();
                if (!neighbor.isMarked()) {
                    stack.push(neighbor);
                }
                neighbors.next();
            }
        }
        return null;
    }
}
