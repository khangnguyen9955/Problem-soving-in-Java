package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindHamiltonPath {
    List<List<Integer>> graph = new ArrayList<>();

    boolean findHamiltonPath(int numVertices, int vertice, int[] path) {
        if (numVertices == count) { // num of recursive == num of vertices
            // got a hamilton cycle
            return true;
        }
        for (int i : graph.get(vertice)) {
            if (i != 1) {
                i = 1;
                if (findHamiltonPath(numVertices + 1, i, path)) {
                    return true;
                }
                i = 2;
            }
        }
        return false;
    }

}
