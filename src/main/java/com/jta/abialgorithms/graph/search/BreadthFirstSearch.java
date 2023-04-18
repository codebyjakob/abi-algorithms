package com.jta.abialgorithms.graph.search;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;
import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.datastructures.linear.Queue;

/**
 * An implementation of the breadth-first search algorithm.
 */
public final class BreadthFirstSearch implements GraphSearchAlgorithm {
  @Override
  public Vertex search(final Graph graph, final Vertex vertex) {
    graph.setAllVertexMarks(false);
    Vertex startVertex = FirstVertexRetriever.getFirstVertex(graph);
    if (startVertex == null) {
      return null;
    }
    Queue<Vertex> verticesToVisit = new Queue<>();
    startVertex.setMark(true);
    verticesToVisit.enqueue(startVertex);
    while (!verticesToVisit.isEmpty()) {
      Vertex currentVertex = verticesToVisit.front();
      verticesToVisit.dequeue();
      if (currentVertex.getID().equals(vertex.getID())) {
        return currentVertex;
      }
      List<Vertex> neighbors = graph.getNeighbours(currentVertex);
      neighbors.toFirst();
      while (neighbors.hasAccess()) {
        Vertex neighbor = neighbors.getContent();
        if (!neighbor.isMarked()) {
          neighbor.setMark(true);
          verticesToVisit.enqueue(neighbor);
        }
        neighbors.next();
      }
    }
    return null;
  }
}
