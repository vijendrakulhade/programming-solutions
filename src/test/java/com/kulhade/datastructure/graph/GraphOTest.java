package com.kulhade.datastructure.graph;

import org.junit.jupiter.api.*;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class GraphOTest {

    private static GraphO<String> fb;
    @BeforeAll
    public static void setFb(){
        fb = new GraphO();
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

    @Test
    public void testIsCyclic(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdge(0,1);
        graphO.addEdge(0,2);
        graphO.addEdge(0,3);
        graphO.addEdge(1,0);
        graphO.addEdge(1,2);
        graphO.addEdge(3,0);
        graphO.addEdge(3,4);
        Assertions.assertTrue(graphO.isCyclic());
    }

    @Test
    public void testIsCyclic_0(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdge(0,1);
        graphO.addEdge(1,0);
        Assertions.assertFalse(graphO.isCyclic());
    }

    @Test
    public void testIsCyclic_1(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdge(0,1);
        graphO.addEdge(0,3);
        graphO.addEdge(3,4);
        Assertions.assertFalse(graphO.isCyclic());
    }

    @Test
    public void testIsCyclic_Directed(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
//        graphO.addEdge(2,3);
        Assertions.assertFalse(graphO.isCyclicDirected());
    }

    @Test
    public void testIsCyclic_Directed_0(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
        graphO.addEdgeDirected(5,1); //0-->1<--2-->3-->4-->5
        Assertions.assertFalse(graphO.isCyclicDirected());
    }

    @Test
    //0-->1<--2-->3-->4-->5
    //         ^          |
    //          \________/
    public void testIsCyclic_Directed_1(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
        graphO.addEdgeDirected(5,2);
        Assertions.assertTrue(graphO.isCyclicDirected());
    }
    @Test
    public void testFindInDegree(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
        Map<Integer,Integer> inDegree = graphO.findInDegree();
        System.out.println(inDegree.values());
        Integer[] expected = {0, 2, 0, 1, 1, 1};
        Integer[] actual = (Integer[])inDegree.values().toArray();
        Assertions.assertArrayEquals(expected,actual);
        Assertions.assertArrayEquals(graphO.getVertices().toArray(),inDegree.keySet().toArray());
    }
    @Test
    //0-->1<--2-->3-->4-->5
    public void testTopologicalSort_0(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
//        graphO.addEdgeDirected(5,2);
        Set<Integer> expected = new LinkedHashSet<>();
        expected.add(0);
        expected.add(2);
        expected.add(1);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        Set<Integer> actual = graphO.topologicalSort();
        Assertions.assertEquals(expected.size(),actual.size());
        System.out.print(actual);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testTopologicalSortCycleDetection(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
        Assertions.assertFalse(graphO.topologicalSortCycleDetection(),"No Cycle");
    }
    @Test
    public void testTopologicalSortCycleDetection_0(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
        graphO.addEdgeDirected(5,3);
        Assertions.assertTrue(graphO.topologicalSortCycleDetection(),"Cycle Present");
    }

    @Test
    public void testDfsTopologicalSort(){
        GraphO<Integer> graphO = new GraphO<>();
        graphO.addEdgeDirected(0,1);
        graphO.addEdgeDirected(2,1);
        graphO.addEdgeDirected(2,3);
        graphO.addEdgeDirected(3,4);
        graphO.addEdgeDirected(4,5);
        Set<Integer> expected = new LinkedHashSet<>();
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(0);
        expected.add(1);
        Set<Integer> actual = graphO.dfsTopologicalSort();
        Assertions.assertEquals(expected.size(),actual.size());
        System.out.print(actual);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

}
