package com.jta.abialgorithms.graph.search;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;
import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An implementation of the recursive depth-first search algorithm.
 */
public final class RecursiveDepthFirstSearch implements GraphSearchAlgorithm {
  @Override
  public Vertex search(final Graph graph, final Vertex vertex) {
    graph.setAllVertexMarks(false);
    Vertex startVertex = FirstVertexRetriever.getFirstVertex(graph);
    if (startVertex == null) {
      return null;
    }
    return search(graph, startVertex, vertex);
  }

  private Vertex search(
      final Graph graph, final Vertex currentVertex, final Vertex vertex) {
    currentVertex.setMark(true);
    if (currentVertex.getID().equals(vertex.getID())) {
      return currentVertex;
    }
    List<Vertex> neighbors = graph.getNeighbours(currentVertex);
    neighbors.toFirst();
    while (neighbors.hasAccess()) {
      Vertex neighbor = neighbors.getContent();
      if (!neighbor.isMarked()) {
        Vertex result = search(graph, neighbor, vertex);
        if (result != null) {
          return result;
        }
      }
      neighbors.next();
    }
    return null;
  }
}
