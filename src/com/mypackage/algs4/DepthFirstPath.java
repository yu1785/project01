package com.mypackage.algs4;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPath {
    private boolean[] marked;
    private int[]  edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点
    private int s;

    public DepthFirstPath(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        for (int w:G.adj(v))
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
    }

    public boolean hadPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hadPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v;x != s;x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
