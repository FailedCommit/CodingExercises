package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1].
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * https://leetcode.com/problems/course-schedule/description/
 */
public class CourseSchedule {
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Graph graph = new Graph(numCourses);
    for(int i = 0; i < prerequisites.length; i++) {
      graph.addDirectedEdge(prerequisites[i][0], prerequisites[i][1]);
    }
    return !graph.hasCycle();
  }

  public static void main(String[] args) {
    CourseSchedule cs = new CourseSchedule();
    System.out.println("Can Finish {{1, 0}, {0, 1}} : " + cs.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
    System.out.println("Can Finish {{1, 0}} : " + cs.canFinish(2, new int[][] {{1, 0}}));
  }
}

class Graph {
  int numVertices;
  List<List<Integer>> adjList;
  
  Graph(int numVertices) {
    this.numVertices = numVertices;
    this.adjList = new ArrayList<>(numVertices);
    
    for(int i = 0; i < numVertices; i++) {
      adjList.add(new LinkedList<>());
    }
  }
  
  public boolean hasCycle() {
    boolean[] isBeingVisited = new boolean[numVertices];
    boolean[] isVisited = new boolean[numVertices];
    
    for(int i = 0; i < numVertices; i++) {
      if(isCyclic(i, isBeingVisited, isVisited)) return true;
    }
    return false;
  }

  private boolean isCyclic(int i, boolean[] isBeingVisited, boolean[] isVisited) {
    if(isBeingVisited[i]) return true;
    if(isVisited[i]) return false;
    
    isVisited[i] = true;
    isBeingVisited[i] = true;
    
    List<Integer> adjacencies = adjList.get(i);
    for(Integer adjcency : adjacencies) {
      if(isCyclic(adjcency, isBeingVisited, isVisited)) return true;
    }
    
    isBeingVisited[i] = false;
    return false;
  }

  public void addDirectedEdge(int source, int destination) {
    adjList.get(source).add(destination);
  }
}
