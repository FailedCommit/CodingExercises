package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
  int numOfVertices;
  // List of Linked Lists
  List<List<Integer>> adjList;

  public Graph(int numOfVertices) {
    this.numOfVertices = numOfVertices;

    // define the size of ArrayList as
    // number of vertices
    adjList = new ArrayList<>(numOfVertices);

    // Create a new LinkedList for each vertex
    // such that adjacent nodes can be stored
    for (int i = 0; i < numOfVertices; i++) {
      adjList.add(new LinkedList<>());
    }
  }

  // For Directed Graphs
  public void addEdgeDirected(int source, int dest) {
    adjList.get(source).add(dest);
  }

  // For Un-Directed Graphs
  public void addEdgeUnDirected(int source, int dest) {
    adjList.get(source).add(dest);
    adjList.get(dest).add(source);
  }

  public void printGraph(Graph graph) {
    for (int v = 0; v < graph.numOfVertices; v++) {
      System.out.println("Adjacency list of vertex " + v);
      System.out.print("head");
      for (Integer adjacency : graph.adjList.get(v)) {
        System.out.print(" -> " + adjacency);
      }
      System.out.println("\n");
    }
  }
}
