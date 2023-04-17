package com.jta.abialgorithms.graph.search;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;
import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.datastructures.linear.Stack;

/**
 * An implementation of the iterative depth-first search algorithm.
 */
public final class IterativeDepthFirstSearch implements GraphSearchAlgorithm {
  @Override
  public Vertex search(final Graph graph, final Vertex vertex) {
    graph.setAllEdgeMarks(false);
    Vertex startVertex = FirstVertexRetriever.getFirstVertex(graph);
    if (startVertex == null) {
      return null;
    }
    Stack<Vertex> verticesToVisit = new Stack<>();
    startVertex.setMark(true);
    verticesToVisit.push(startVertex);
    while (!verticesToVisit.isEmpty()) {
      Vertex current = verticesToVisit.top();
      verticesToVisit.pop();
      if (current.getID().equals(vertex.getID())) {
        return current;
      }
      List<Vertex> neighbors = graph.getNeighbours(current);
      neighbors.toFirst();
      while (neighbors.hasAccess()) {
        Vertex neighbor = neighbors.getContent();
        if (!neighbor.isMarked()) {
          neighbor.setMark(true);
          verticesToVisit.push(neighbor);
        }
        neighbors.next();
      }
    }
    return null;
  }
}
