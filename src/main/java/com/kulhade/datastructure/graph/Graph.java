package com.kulhade.datastructure.graph;


import java.util.*;

public class Graph<T>{

    private final class Vertex<T>{
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

    private Map<Vertex<T>, Set<Vertex<T>>> adj;
    public Graph(){
        adj = new HashMap<>();
    }
    public void addNode(T t){
        Vertex<T> v = new Vertex<>(t);
        if(adj.containsKey(v)){
            return;
        }
        adj.put(v,new LinkedHashSet<>());
    }

    public void addEdge(T v1,T v2){
        if(v1==null || v2== null){
            throw new IllegalArgumentException("Vertexes can not be null to be added to the graph");
        }
        Vertex<T> u = new Vertex<>(v1);
        Vertex<T> v = new Vertex<>(v2);
        adj.computeIfAbsent(u,tVertex -> new LinkedHashSet<>());
        adj.computeIfAbsent(v,tVertex -> new LinkedHashSet<>());
        adj.computeIfPresent(u,(tVertex, vertices) -> {
            vertices.add(v);
            return vertices;
        });
        adj.computeIfPresent(v,(tVertex, vertices) -> {
            vertices.add(u);
            return vertices;
        });

    }

    public Set<T> dfs(T t){
        Vertex<T> start = new Vertex<>(t);
        if(!adj.containsKey(start)){
            throw new IllegalArgumentException("Element doesn't belong to the graph");
        }
        Set<T> visited = new LinkedHashSet<>();
        dfsStack(start,visited);
        for(Vertex a:adj.keySet()) {
            if(visited.contains(a)) continue;
            dfsStack(a,visited);
        }
        return visited;
    }

    private void dfsStack(Vertex<T> start,Set<T> visited){
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex s = stack.pop();
            if (!visited.contains((T) s.vertex)) {
                visited.add((T) s.vertex);
                for (Vertex a : this.fetchNeighbour((T) s.vertex)) {
                    stack.push(a);
                }
            }
        }
    }

    public Set<T> bfs(T t){

        Set<T> visited = new LinkedHashSet<>();
        bfs(t,visited);
        for(Vertex<T> a:adj.keySet()){
            if(visited.contains(a.vertex)) continue;
            bfs(a.vertex, visited);
        }
        return visited;
    }

    private void bfs(T t,Set<T> visited){
        Vertex<T> start = new Vertex<>(t);
        if(!adj.containsKey(start)){
            throw new IllegalArgumentException("Element doesn't belong to the graph");
        }
        Queue<Vertex<T>> q = new LinkedList<>();
        q.add(start);
        visited.add(t);
        while(!q.isEmpty()){
            Vertex v = q.poll();
            for (Vertex u:this.fetchNeighbour((T)v.vertex)){
                if(!visited.contains(u.vertex)){
                    visited.add((T)u.vertex);
                    q.add(u);
                }
            }
        }
    }

    public Set<Vertex<T>> fetchNeighbour(T t){
        return adj.get(new Vertex<>(t));
    }

    public int size(){
        return adj.size();
    }

    public Map<T,Integer> findInDegree(){
        Comparator<Map.Entry<T,Integer>> valueComparator = (o1,o2)->{
            if(o1.getValue()>o2.getValue())
                return 1;
            else if(o1.getValue()<o2.getValue())
                return -1;
            else
                return 0;
        };
        Map<T,Integer> result = new TreeMap(valueComparator);
        for(Set<Vertex<T>> adLst:adj.values()){
            for(Vertex<T> a:adLst){
                int d = result.getOrDefault(a.vertex,-1)+1;
                T e = (T)a.vertex;
                result.put(e,d);
            }
        }
        return result;
    }
}
