package com.company;

import java.util.*;

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


    public static int[] findOrder(int numCourses, int [][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        int[] totalPreCoursesOfEachCourse = new int[numCourses];
        // build graph
        for (int i = 0; i < numCourses ; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //  add edge to the graph
        //
        // different with the course schedule problem
        // this problem we will build the graph with index is the course and value is other available courses can take from this course
        // and we also count the total prerequisite courses of a course
        // we can take
        for(int [] course : prerequisites){
            totalPreCoursesOfEachCourse[course[0]]++;
            graph.get(course[1]).add(course[0]);
        }
        // with example 2
        // Course | Available
        //  0     | [1,2]
        //  1     | [3]
        //  2     | [3]
        return BFS(graph,totalPreCoursesOfEachCourse);
    }
    public static int [] BFS (List<List<Integer>> graph,int []totalPreCoursesOfEachCourse){
        Queue<Integer> queue = new LinkedList<>();
        int numCourse = totalPreCoursesOfEachCourse.length;
        int [] order = new int[numCourse];
        for (int i = 0; i < numCourse ; i++) {
            if (totalPreCoursesOfEachCourse[i] == 0 ){
                queue.offer(i);
                // we will add all the courses that do not
                // need us to take any prequisite courses to the queue
            }
        }
        int visited = 0; // for counting
        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            // from this current course
            order[visited++] = currentCourse;
            for (int availableCourse: graph.get(currentCourse)) {
                // get all the course we can take
                // from the current course
                totalPreCoursesOfEachCourse[availableCourse]--;
                // we will decrease the total prerequisite course of this current course
                // by 1, because we will offer it into the queue now and BFS it
                if (totalPreCoursesOfEachCourse[availableCourse] == 0){
                    // if this total pre... course of this current course
                    // now become 0, it means that we have to take
                    // this available course after the current course
                    // for example course 0 -> course 1
                    queue.offer(availableCourse);
                    // now we will add this available course to the queue to BFS
                }
                // if the total... of available course
                // not equal 0, so this available course can be taken after
                // another course, so we just continue loop
                // and this available course will be taken after
                // the last course (in graph)
            }
        }
        return visited == numCourse ? order : new int[0];
    }



    public static void main(String[] args) {
            int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//            canFinish(2,prerequisites);
        findOrder(4,prerequisites);

    }
}
