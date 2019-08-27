package com.kulhade.datastructure.graph;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GuavaGraphTest {

    private static MutableGraph<String> graph;


    @BeforeAll
    public static void setBuilder(){
        graph = GraphBuilder.undirected().build();
    }

    @Test
    public void testGraphAdd(){

        graph.putEdge("Vijendra","Advik");
        System.out.println(graph.toString());
    }
}
