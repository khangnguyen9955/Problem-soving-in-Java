package com.company;

public class WeightedQuickUnion{
    private int [] id;
    private int [] sz;

    public WeightedQuickUnion(int n){
        id = new int [n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
            id[i] = i;
        }
    }

    public int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]]; // keep the tree flatten
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(sz[i] < sz[j]){ // root with number of nodes smaller will be point to root that has larger number of nodes
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }


}
