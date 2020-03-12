package com.kulhade.datastructure.graph;

import org.junit.jupiter.api.*;

import java.util.Map;
import java.util.Set;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
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
    public void testC_AddNode(){
        fb.addNode("Someone-Disconnected");
        Assertions.assertEquals(4,fb.size());
    }

    @Test
    public void testC_dfs(){
        Set<String> d = fb.dfs("Advik");
        Assertions.assertEquals(4,d.size());
        Assertions.assertEquals("[Advik, Vijendra, Tanvi, Someone-Disconnected]",d.toString());
    }

    @Test
    public void testD_AddEdgeToSameVertex(){
        fb.addEdge("Vijendra","Mummy");
        fb.addEdge("Mummy","A");
        fb.addEdge("Mummy","G");
        Assertions.assertEquals(7,fb.size());
        Assertions.assertEquals(3,fb.fetchNeighbour("Vijendra").size());
    }

    @Test
    public void testE_bfs(){
        Set<String> d = fb.bfs("Vijendra");
        Assertions.assertEquals(7,d.size());
        Assertions.assertEquals("[Vijendra, Tanvi, Advik, Mummy, A, G, Someone-Disconnected]",d.toString());
    }

    @Test
    public void test_findInDegree(){
        Map<String,Integer> r = fb.findInDegree();
        System.out.println(r);
    }
}
