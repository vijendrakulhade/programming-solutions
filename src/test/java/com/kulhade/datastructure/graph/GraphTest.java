package com.kulhade.datastructure.graph;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;


@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphTest {

    private static Graph<String> fb;
    @BeforeClass
    public static void setFb(){
        fb =  new Graph<>();
    }

    @Test
    public void testA_AddEdge(){
        fb.addEdge("Vijendra","Tanvi");
        Assert.assertEquals(2,fb.size());
    }

    @Test
    public void testB_AddEdgeToSameVertex(){
        fb.addEdge("Vijendra","Advik");
        Assert.assertEquals(3,fb.size());
        Assert.assertEquals(2,fb.fetchNeighbour("Vijendra").size());
    }
}
