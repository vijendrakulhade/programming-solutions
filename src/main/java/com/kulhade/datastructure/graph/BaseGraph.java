package com.kulhade.datastructure.graph;


import java.util.Set;

public interface BaseGraph<N>{

     Set<N> nodes();
     Set<Edge<N>> edges();
     void addNode(N n);
     void addEdge(N u,N v, long w);
    Set<Edge<N>> fetchNeighbour(N t);
     boolean isDirected();

     class Edge<N>{
        private final N end;
        private long weight;
        public Edge(N v,long w){
            this.end = v;
            this.weight = w;
        }
        public N adjacentNode(){
            return this.end;
        }
    }


}
