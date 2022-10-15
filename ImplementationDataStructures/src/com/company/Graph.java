package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
        private LinkedList<Integer> adjList[];
        private boolean visited[];


        Graph(int vertices){
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<Integer>(); // store neighbors element
            }
        }


        void addEdge(int src,int dest){
            adjList[src].add(dest);
        }

        void DFS (int vertex){
            visited[vertex] = true;
            System.out.println(vertex + " ");

            Iterator<Integer> iterator = adjList[vertex].listIterator();
            while(iterator.hasNext()){
                int neighbor = iterator.next();

                if(visited[neighbor] != true){
                    DFS(neighbor);
                }
            }

        }

    public  static  boolean canFinish(int numCourses, int[][] prerequisites) {
        // [0,1] => [v,u]
        // 1 -> 0
        // u -> v
        int [] taken = new int [numCourses];
        // new graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0 ; i < numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }

        // add edge to graph
        for(int [] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(dfs(graph,taken, i)){
                return false;
            }
        }
        return true;
    }

    public static boolean dfs (List<List<Integer>> graph, int taken[],int vertice){
        if(taken[vertice] == 1) return true;
        if(taken[vertice] == 2) return false;
        taken[vertice] = 1;
        for(int adj : graph.get(vertice)){
            if(dfs(graph,taken,adj)) return true;
        }
        taken[vertice] = 2;
        return false;
    }



    public static void main(String[] args) {
            int[][] prerequisites = {{0,1},{1,0}};
            canFinish(2,prerequisites);
    }
}
