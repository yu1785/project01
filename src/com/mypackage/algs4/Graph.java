package com.mypackage.algs4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {

    private int V;    //顶点数目
    private int E;          //边的数目
    private Bag<Integer>[] adj;  //邻接表

    public Graph(int V){
        this.V = V;
        this.E = E;
        adj = (Bag<Integer>[]) new Bag[V];   //创建邻接表
        for (int v = 0;v < V;v ++)           //初始化所有链表为空
            adj[v] = new Bag<Integer>();
    }

    public Graph(In in){
        this(in.readInt());  //读取V并将图初始化
        int E = in.readInt(); //读取E
        for (int i = 0;i < E;i ++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public int V(){
        return V;
    }

    private int E() {
        return E;
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E ++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    /*
          一些常用方法
     */
    public static int degree(Graph G,int v){
        int degree = 0;
        for (int w:G.adj(v))
            degree ++;
        return degree;
    }


    public static int maxDegree(Graph G){
        int max = 0;
        for (int v = 0;v < G.V();v ++)
            if (degree(G,v) > max)
                max = degree(G,v);
        return max;
    }


    public static double avgDegree(Graph G){
        return 2 * G.E() / G.V();
    }


    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0;v < G.V();v ++)
            for (int w : G.adj(v))
                if (v == w)
                    count ++;
        return count/2;
    }



}
