package com.jta.abialgorithms.graph.search;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;

/**
 * An interface for graph search algorithms.
 */
public interface GraphSearchAlgorithm {
  /**
   * Searches for a vertex in a given graph.
   *
   * @param graph  the graph to search in
   * @param vertex the vertex to search for
   * @return the vertex if found, null otherwise
   */
  Vertex search(Graph graph, Vertex vertex);
}
