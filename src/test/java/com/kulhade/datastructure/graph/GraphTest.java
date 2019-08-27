package com.kulhade.datastructure.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;


public class GraphTest {

    private static Graph<String> fb;
    @BeforeAll
    public static void setFb(){
        fb =  new Graph<>();
    }

    @Test
    public void testA_AddEdge(){
        fb.addEdge("Vijendra","Tanvi");
        Assertions.assertEquals(2,fb.size());
    }

    @Test
    public void testB_AddEdgeToSameVertex(){
        fb.addEdge("Vijendra","Advik");
        Assertions.assertEquals(3,fb.size());
        Assertions.assertEquals(2,fb.fetchNeighbour("Vijendra").size());
    }

    @Test
    public void testC_dfs(){
        Set<String> d = fb.dfs("Advik");
        Assertions.assertEquals(3,d.size());
        Assertions.assertEquals("[Advik, Vijendra, Tanvi]",d.toString());
    }

    @Test
    public void testD_AddEdgeToSameVertex(){
        fb.addEdge("Vijendra","Mummy");
        fb.addEdge("Mummy","A");
        fb.addEdge("Mummy","G");
        Assertions.assertEquals(6,fb.size());
        Assertions.assertEquals(3,fb.fetchNeighbour("Vijendra").size());
    }

    @Test
    public void testE_bfs(){
        Set<String> d = fb.bfs("Vijendra");
        Assertions.assertEquals(6,d.size());
        Assertions.assertEquals("[Vijendra, Tanvi, Advik, Mummy, A, G]",d.toString());
    }
}
