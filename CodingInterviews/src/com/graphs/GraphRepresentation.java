package com.graphs;

/**
 * Demonstrates adjacency list representation of graphs.
 */
public class GraphRepresentation {

  public static void main(String args[]) {
    /*
     
      0 --------- 1
      |         / |  \
      |       /   |    \ 
      |     /     |      2
      |   /       |    /
      | /         |  /
      4 --------- 3   
    
    */   
    int V = 5;
    Graph graph = new Graph(V);
    graph.addEdgeUnDirected(0, 1);
    graph.addEdgeUnDirected(0, 4);
    graph.addEdgeUnDirected(1, 2);
    graph.addEdgeUnDirected(1, 3);
    graph.addEdgeUnDirected(1, 4);
    graph.addEdgeUnDirected(2, 3);
    graph.addEdgeUnDirected(3, 4);
    
    graph.printGraph(graph);
  }
}
