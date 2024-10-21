package com.kulhade.programming.simple;


import java.util.*;

public class GraphPrograms {

    public String alienDictionary(String[] words){
        if(words==null || words.length==0) return "";
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree = new HashMap<>();
        buildGraph(graph,inDegree,words);
        String order = topologicalSort(graph,inDegree);
        return order.length()==graph.size()?order:"";
    }

    private void buildGraph(Map<Character,Set<Character>> graph,
                            Map<Character,Integer> inDegree,
                            String[] words) {
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.put(c, new HashSet<>());
                inDegree.put(c,0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String sec = words[i];
            int len = Math.min(first.length(), sec.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != sec.charAt(j)) {
                    if (!graph.get(first.charAt(j)).contains(sec.charAt(j))) {
                        graph.get(first.charAt(j)).add(sec.charAt(j));
                        int d = inDegree.get(sec.charAt(j)) + 1;
                        inDegree.put(sec.charAt(j), d);
                    }
                    break;
                }
            }
        }
    }

    private String topologicalSort(Map<Character,Set<Character>> graph,Map<Character,Integer> inDegree){
        Queue<Character> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(char c:inDegree.keySet()){
            if(inDegree.get(c)==0){
                q.add(c);
                sb.append(c);
            }
        }
        while(!q.isEmpty()){
            char c= q.poll();
            for(char adj:graph.get(c)){
                if(sb.indexOf(adj+"")==-1){
                    int d = inDegree.get(adj);
                    inDegree.put(adj,d-1);
                    if(inDegree.get(adj)==0){
                        q.add(adj);
                        sb.append(adj);
                    }
                }
            }
        }
        return sb.toString();
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms==null){
            return false;
        }
        Map<Integer,List<Integer>> graph = new HashMap<>(rooms.size());
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<rooms.size();i++){
            graph.put(i,rooms.get(i));
        }
        List<Integer> toBeVisited= new LinkedList<>();
        visited.add(0);
        toBeVisited.addAll(graph.get(0));
        while(!toBeVisited.isEmpty()){
            Integer room = toBeVisited.remove(0);
            if(visited.contains(room)){
             continue;
            }else {
                visited.add(room);
            }
            toBeVisited.addAll(graph.get(room));
        }
        return visited.size()==rooms.size();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] edge:prerequisites){
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1],new ArrayList<>());
                graph.put(edge[0],new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited  =  new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()){
            int node = q.remove();
            for(int neigh:graph.get(node)){
                if(visited.contains(neigh)) continue;
                else{
                    visited.add(neigh);
                    q.add(neigh);
                }
            }

        }
        return visited.size()==numCourses;
    }
}
