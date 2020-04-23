package com.kulhade.datastructure.graph;

import java.util.*;

public class GraphE<N> implements BaseGraph<N> {
    private final Map<N, Set<Edge<N>>> g;
    private boolean isDirected;

    /**
     * Constructor to create undirected graph
     */
    public GraphE(){
        this.g = new LinkedHashMap<>();
        this.isDirected=false;
    }

    /**
     * Constructor to create directed graph
     */
    public GraphE(boolean isDirected){
        this.g = new LinkedHashMap<>();
        this.isDirected=isDirected;
    }

    @Override
    public Set nodes() {
        return this.g.keySet();
    }

    @Override
    public Set<Edge<N>> edges() {
        Set<Edge<N>> allEdges = new LinkedHashSet<>();
        for(Set<Edge<N>> edges: this.g.values())
            allEdges.addAll(edges);
        return allEdges;
    }

    @Override
    public void addNode(N o) {
        if(this.g.containsKey(o)){
            throw new IllegalArgumentException("Node already exist in the graph ");
        }else{
            this.g.put(o,new LinkedHashSet<>());
        }
    }

    public void addEdge(N u, N v){
        if(u==v) {
            this.addEdge(u, v, 0);
            return;
        }
        this.addEdge(u,v,1);
    }

    @Override
    public void addEdge(N u, N v,long w) {
        connect(u,v,1);
        if(!isDirected)
            connect(v,u,1);
    }
    private void connect(N u,N v,long w){
        Edge<N> e = new Edge(v,w);
        if(g.containsKey(u))
            this.g.get(u).add(e);
        else {
            Set<Edge<N>> adj = new LinkedHashSet<>();
            adj.add(e);
            this.g.put(u,adj);
        }
    }
    @Override
    public boolean isDirected() {
        return isDirected;
    }

    public int size(){
        return g.size();
    }
    @Override
    public Set<Edge<N>> fetchNeighbour(N a){
        return g.getOrDefault(a,new LinkedHashSet<>());
    }

    public Map<N,Integer> findInDegree(){
        Map<N,Integer> result = new LinkedHashMap<>();
        for(N a:g.keySet()){
            int d = result.getOrDefault(a,-1)+1;
            result.put(a,d);
            for(Edge<N> adj:g.get(a)){
                result.put(adj.adjacentNode(),result.getOrDefault(adj,-1)+1);
            }
        }
        return result;
    }

    public Set<N> dfs(N n){
        Set<N> visited = new LinkedHashSet<>();
        dfs(n,visited);
        for(N a:g.keySet()){
            if(visited.contains(a)) continue;
            dfs(a,visited);
        }
        return visited;
    }

    private void dfs(N a,Set<N> v){
        if(!g.containsKey(a)) throw new IllegalArgumentException("Node doesn't exist in the gaph");
        Deque<N> st = new LinkedList<>();
        st.push(a);
        v.add(a);
        while(!st.isEmpty()){
            N n = st.pop();
            for (Edge adj:fetchNeighbour(n)){
                if(v.contains(adj.adjacentNode())) continue;
                st.push((N)adj.adjacentNode());
                v.add((N)adj.adjacentNode());
            }
        }
    }

    public Set<N> bfs(N n){
        if(!g.containsKey(n)) throw new IllegalArgumentException("Node doesn't exist in graph");
        Set<N> visited = new LinkedHashSet<>();
        bfs(n,visited);
        for(N a:g.keySet()){
            if(visited.contains(a)) continue;
            bfs(a,visited);
        }
        return visited;
    }

    private void bfs(N a,Set<N> v){
        Queue<N> q  = new LinkedList<>();
        q.add(a);
        v.add(a);
        while(!q.isEmpty()){
            N p = q.poll();
            for(Edge adj:fetchNeighbour(p)){
                if(v.contains(adj.adjacentNode())) continue;
                N adjN = (N)adj.adjacentNode();
                q.add(adjN);
                v.add(adjN);
            }
        }
    }

    public boolean isCyclic(){
        Set<N> visited = new LinkedHashSet<>();
        N p = (N)new Object();
        for(N a: g.keySet()){
            if(visited.contains(a)) continue;
            if(dfsCycle(a,visited,p)) return true;
        }
        return false;
    }

    private boolean dfsCycle(N a,Set<N> v,N p){
        v.add(a);
        for(Edge adj:fetchNeighbour(a)){
            N b = (N)adj.adjacentNode();
            if(v.contains(b) && !p.equals(b))
                return true;
            else if(v.contains(b))
                continue;
            else if(dfsCycle(b,v,a))
                return true;
        }
        return false;
    }
}
