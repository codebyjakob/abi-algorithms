package com.jta.abialgorithms.graph.shortestpath;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;
import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An interface for algorithms that search for the shortest path between two
 * vertices in a graph.
 */
public interface GraphShortestPathAlgorithm {
  /**
   * Searches for the shortest path between two vertices in a given graph.
   *
   * @param graph  the graph to search in
   * @param source the source vertex
   * @param target the target vertex
   * @return the shortest path between the source and target vertices
   */
  List<Vertex> getShortestPath(Graph graph, Vertex source, Vertex target);
}
