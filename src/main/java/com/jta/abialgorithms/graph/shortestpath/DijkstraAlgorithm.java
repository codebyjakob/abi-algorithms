package com.jta.abialgorithms.graph.shortestpath;

import com.jta.abialgorithms.datastructures.graph.Graph;
import com.jta.abialgorithms.datastructures.graph.Vertex;
import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.graph.search.FirstVertexRetriever;

/**
 * An implementation of the Dijkstra algorithm.
 */
public final class DijkstraAlgorithm implements GraphShortestPathAlgorithm {
  @Override
  public List<Vertex> getShortestPath(
      final Graph graph, final Vertex source, final Vertex target) {
    graph.setAllVertexMarks(false);
    Vertex startVertex = FirstVertexRetriever.getFirstVertex(graph);
    if (startVertex == null) {
      return null;
    }
    int numberOfVertices = getNumberOfVertices(graph);
    double[] distances = new double[numberOfVertices];
    Vertex[] predecessors = new Vertex[numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      distances[i] = Integer.MAX_VALUE;
      predecessors[i] = null;
    }
    distances[getIndexOfVertex(graph.getVertices(), source)] = 0;
    while (!graph.allVerticesMarked()) {
      Vertex currentVertex = getVertexWithSmallestDistance(graph, distances);
      if (currentVertex == null) {
        return null;
      }
      currentVertex.setMark(true);
      List<Vertex> neighbors = graph.getNeighbours(currentVertex);
      neighbors.toFirst();
      while (neighbors.hasAccess()) {
        int currentVertexIndex = getIndexOfVertex(
            graph.getVertices(), currentVertex);
        Vertex neighbor = neighbors.getContent();
        if (!neighbor.isMarked()) {
          int neighborIndex = getIndexOfVertex(graph.getVertices(), neighbor);
          double distance = distances[currentVertexIndex]
              + graph.getEdge(currentVertex, neighbor).getWeight();
          if (distance < distances[neighborIndex]) {
            distances[neighborIndex] = distance;
            predecessors[neighborIndex] = currentVertex;
          }
        }
        neighbors.next();
      }
    }
    return getShortestPath(predecessors, target);
  }

  private List<Vertex> getShortestPath(
      final Vertex[] predecessors, final Vertex target) {
    List<Vertex> reversedShortestPath = new List<>();
    Vertex currentVertex = target;
    while (currentVertex != null) {
      reversedShortestPath.insert(currentVertex);
      currentVertex = predecessors[getIndexOfVertex(
          reversedShortestPath, currentVertex)];
    }
    List<Vertex> shortestPath = new List<>();
    reversedShortestPath.toLast();
    while (reversedShortestPath.hasAccess()) {
      shortestPath.append(reversedShortestPath.getContent());
      reversedShortestPath.remove();
      reversedShortestPath.toLast();
    }
    return shortestPath;
  }

  private int getNumberOfVertices(final Graph graph) {
    List<Vertex> vertices = graph.getVertices();
    vertices.toFirst();
    int numberOfVertices = 0;
    while (vertices.hasAccess()) {
      numberOfVertices++;
      vertices.next();
    }
    return numberOfVertices;
  }

  private int getIndexOfVertex(
      final List<Vertex> vertices, final Vertex vertex) {
    vertices.toFirst();
    int index = 0;
    while (vertices.hasAccess()) {
      if (vertices.getContent().getID().equals(vertex.getID())) {
        return index;
      }
      index++;
      vertices.next();
    }
    return -1;
  }

  private Vertex getVertexWithSmallestDistance(
      final Graph graph, final double[] distances) {
    List<Vertex> vertices = graph.getVertices();
    vertices.toFirst();
    Vertex vertexWithSmallestDistance = null;
    double smallestDistance = Double.MAX_VALUE;
    while (vertices.hasAccess()) {
      Vertex currentVertex = vertices.getContent();
      if (!currentVertex.isMarked()) {
        double distance = distances[getIndexOfVertex(
            graph.getVertices(), currentVertex)];
        if (distance < smallestDistance) {
          smallestDistance = distance;
          vertexWithSmallestDistance = currentVertex;
        }
      }
      vertices.next();
    }
    return vertexWithSmallestDistance;
  }
}
