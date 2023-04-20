package com.jta.abialgorithms.graph.search;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;

/**
 * A utility class for retrieving the first vertex of a graph.
 */
public final class FirstVertexRetriever {
  private FirstVertexRetriever() {
  }

  /**
   * Gets the first vertex of a given graph.
   *
   * @param graph the graph to get the first vertex from
   * @return the first vertex of the graph
   */
  public static Vertex getFirstVertex(final Graph graph) {
    List<Vertex> vertices = graph.getVertices();
    vertices.toFirst();
    return vertices.getContent();
  }
}
