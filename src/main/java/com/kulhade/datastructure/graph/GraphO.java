package com.kulhade.datastructure.graph;

import com.kulhade.programming.simple.ArrayPrograms;

import java.util.*;

public class GraphO<T>{

    private Map<T, Set<T>> graph;
    public GraphO(){
        graph = new LinkedHashMap<>();
    }

    public Set<T> getVertices(){
        return graph.keySet();
    }
    public void addNode(T t){

        if(graph.containsKey(t)){
            return;
        }
        graph.put(t,new LinkedHashSet<>());
    }

    public void addEdge(T v1,T v2){
        if(v1==null || v2== null){
            throw new IllegalArgumentException("Vertexes can not be null to be added to the graph");
        }

        graph.computeIfAbsent(v1,tVertex -> new LinkedHashSet<>());
        graph.computeIfAbsent(v2,tVertex -> new LinkedHashSet<>());
        graph.computeIfPresent(v1,(tVertex, vertices) -> {
            vertices.add(v2);
            return vertices;
        });
        graph.computeIfPresent(v2,(tVertex, vertices) -> {
            vertices.add(v1);
            return vertices;
        });

    }

    public void addEdgeDirected(T v1,T v2){
        if(v1==null || v2== null){
            throw new IllegalArgumentException("Vertexes can not be null to be added to the graph");
        }

        graph.computeIfAbsent(v1,tVertex -> new LinkedHashSet<>());
        graph.computeIfPresent(v1,(tVertex, vertices) -> {
            vertices.add(v2);
            return vertices;
        });
        graph.computeIfAbsent(v2,tVertex -> new LinkedHashSet<>());
    }

    public Set<T> dfs(T start){
        if(!graph.containsKey(start)){
            throw new IllegalArgumentException("Element doesn't belong to the graph");
        }
        Set<T> visited = new LinkedHashSet<>();
        dfsStack(start,visited);
        for(T a:graph.keySet()) {
            if(visited.contains(a)) continue;
            dfsStack(a,visited);
        }
        return visited;
    }

    private void dfsStack(T start,Set<T> visited){
        Stack<T> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            T s = stack.pop();
            if (!visited.contains((T)s)) {
                visited.add((T) s);
                for (T a : this.fetchNeighbour((T) s)) {
                    stack.push(a);
                }
            }
        }
    }

    public boolean isCyclic(){
        Set<T> visited = new LinkedHashSet<>();
        T p = (T)new Object();
        for(T a:graph.keySet()){
            if(visited.contains(a))
                continue;
             if(dfsCycleRec(a,visited,p)) return true;
        }
        return false;
    }

    public boolean isCyclicDirected(){
        Set<T> visited = new LinkedHashSet<>();
        Set<T> parents = new LinkedHashSet<>();
        for(T a:graph.keySet()){
            if(visited.contains(a))
                continue;
            if(dfsCycleDirected(a,visited,parents)) return true;
        }
        return false;
    }

    private boolean dfsCycleDirected(T u,Set<T> visited,Set<T> p){
        Deque<T> s = new LinkedList<>();
        s.push(u);
        while(!s.isEmpty()){
            T  n = s.pop();
            visited.add(n);p.add(n);
            for(T a:fetchNeighbour(n)){
                if(visited.contains(a) && p.contains(a)) return true;
                else if(visited.contains(a)) continue;
                else s.push(a);
            }
        }
        p.clear();
        return false;
    }
    private boolean dfsCycle(T start,Set<T> visited,T p){
        Deque<ArrayPrograms.Pair<T,T>> s = new LinkedList<>();
        s.push(new ArrayPrograms.Pair<>(start,p));
        while(!s.isEmpty()){
            ArrayPrograms.Pair pair = s.pop();
            T n = (T)pair.getA();
            p = (T)pair.getB();
            visited.add(n);
            for (T a: fetchNeighbour(n)){
                if(!visited.contains(a)){
                    s.push(new ArrayPrograms.Pair<>(a,n));
                    continue;
                }
                if(!a.equals(p)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsCycleRec(T start,Set<T> visited, T p){
        visited.add(start);
        for(T a:fetchNeighbour(start)){
            if(!visited.contains(a)){
                if(dfsCycleRec(a,visited,start)){
                    return true;
                }
            }else if(!a.equals(p)){
                return true;
            }
        }
        return false;
    }

    public Set<T> bfs(T t){

        Set<T> visited = new LinkedHashSet<>();
        bfs(t,visited);
        for(T a:graph.keySet()){
            if(visited.contains(a)) continue;
            bfs(a, visited);
        }
        return visited;
    }

    private void bfs(T start,Set<T> visited){
        if(!graph.containsKey(start)){
            throw new IllegalArgumentException("Element doesn't belong to the graph");
        }
        Queue<T> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()){
            T v = q.poll();
            for (T u:this.fetchNeighbour((T)v)){
                if(!visited.contains(u)){
                    visited.add((T)u);
                    q.add(u);
                }
            }
        }
    }

    public Set<T> fetchNeighbour(T t){
        return graph.getOrDefault(t,new LinkedHashSet<>());
    }

    public Set<T> topologicalSort(){
        Set<T> visited = new LinkedHashSet<>();
        Map<T,Integer> degree = findInDegree();
        Queue<T> q = new LinkedList<>();
        for(T a:degree.keySet()){
            if(degree.get(a)==0){
                q.add(a);
                visited.add(a);
            }
        }
        while(!q.isEmpty()){
            T n = q.poll();
            for(T adj:fetchNeighbour(n)){
                if(visited.contains(adj)) continue;
                degree.put(adj,degree.get(adj)-1);
                if(degree.get(adj)==0){
                    q.add(adj);
                    visited.add(adj);
                }
            }
        }
        return visited;
    }

    public boolean topologicalSortCycleDetection(){
        Set<T> visited = new LinkedHashSet<>();
        Queue<T> q = new LinkedList<>();
        Map<T,Integer> inDegree = findInDegree();
        for(T a:inDegree.keySet()){
            if(inDegree.get(a)==0){
                q.add(a);
                visited.add(a);
            }
        }
        int counter = 0;
        while(!q.isEmpty()){
            T n = q.poll();
            counter++;
            for(T adj:fetchNeighbour(n)){
                if(visited.contains(adj)) continue;
                inDegree.put(adj,inDegree.get(adj)-1);
                if(inDegree.get(adj)==0) {
                    q.add(adj);
                    visited.add(adj);
                }
            }
        }
        return counter!=graph.size();
    }

    public int size(){
        return graph.size();
    }

    public Map<T,Integer> findInDegree(){
        Comparator<Map.Entry<T,Integer>> valueComparator = (Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2)-> {
                if(o1.getValue()>o2.getValue())
                    return 1;
                else if(o1.getValue()<o2.getValue())
                    return -1;
                else
                    return 0;
            };
        Map<T,Integer> result = new LinkedHashMap<>();
        for(T a:graph.keySet()){
            int d = result.getOrDefault(a,-1)+1;
            result.put(a,d);
            for(T adj:graph.get(a)){
                result.put(adj,result.getOrDefault(adj,-1)+1);
            }
        }
//        List<Map.Entry<T, Integer>> entries  = new LinkedList<>(result.entrySet());
//        Collections.sort(entries,valueComparator);
//        result.clear();
//        entries.forEach(tIntegerEntry -> result.put(tIntegerEntry.getKey(),tIntegerEntry.getValue()));
        return result;
    }

    public Set<T> dfsTopologicalSort(){
        Set<T> visited = new LinkedHashSet<>();
        Deque<T> stack = new LinkedList<>();
        for(T a:graph.keySet()){
            if(visited.contains(a)) continue;
            dfsRec(a,visited,stack);
        }
        return stackToSet(stack);
    }

    public void dfsRec(T n,Set<T> v,Deque<T> st){
        v.add(n);
        for(T adj:fetchNeighbour(n)){
            if(v.contains(adj)) continue;
            dfsRec(adj,v,st);
        }
        st.push(n);
    }

    private Set<T> stackToSet(Deque<T> st){
        Set<T> result  = new LinkedHashSet<>();
        do{
            result.add(st.pop());
        }while(!st.isEmpty());
        return result;
    }
}
