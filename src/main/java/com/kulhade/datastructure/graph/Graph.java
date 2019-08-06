package com.kulhade.datastructure.graph;

import java.util.*;

public class Graph<T>{

    final class Vertex<T>{
        private T vertex;
        public Vertex(T t){
            this.vertex = t;
        }

        public int hashCode(){
            return this.vertex.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex<?> vertex1 = (Vertex<?>) o;
            return Objects.equals(vertex, vertex1.vertex);
        }

    }

    private Map<Vertex<T>, List<Vertex<T>>> adj;
    public Graph(){
        adj = new HashMap<>();
    }

    public void addEdge(T v1,T v2){
        if(v1==null || v2== null){
            throw new IllegalArgumentException("Vertexes can not be null to be added to the graph");
        }
        Vertex<T> u = new Vertex<>(v1);
        Vertex<T> v = new Vertex<>(v2);
        adj.computeIfAbsent(u,tVertex -> new ArrayList<>());
        adj.computeIfAbsent(v,tVertex -> new ArrayList<>());
        adj.computeIfPresent(u,(tVertex, vertices) -> {
            vertices.add(v);
            return vertices;
        });
        adj.computeIfPresent(v,(tVertex, vertices) -> {
            vertices.add(u);
            return vertices;
        });

    }

    public List<Vertex<T>> fetchNeighbour(T t){
        return adj.get(new Vertex<>(t));
    }

    public int size(){
        return adj.size();
    }
}
