package com.kulhade.programming.simple;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GraphProgramTest {

    GraphPrograms graphPrograms = new GraphPrograms();
    @Test
    public void testAlienDictionary(){
        String[]  words  = {"wrt","wrf","er","ett","rftt"};
        Assertions.assertEquals("wertf",graphPrograms.alienDictionary(words));
    }

    @Test
    public void testAlienDictionary_1(){
        String[] words = {"eff", "fg"};
        Assertions.assertEquals("efg",graphPrograms.alienDictionary(words));
    }

    @Test
    public void testCanVisitAllRooms(){
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3),Arrays.asList());
        Assertions.assertTrue(graphPrograms.canVisitAllRooms(rooms));
    }

    @Test
    public void testCanVisitAllRooms_1(){
//        [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1,3),Arrays.asList(3,0,1),Arrays.asList(2),Arrays.asList(0));
        Assertions.assertFalse(graphPrograms.canVisitAllRooms(rooms));
    }

    @Test
    public void testCanFinish(){
        int[][] prerequisites = new int[1][2];
        prerequisites[0]= new int[]{1,0};
        Assertions.assertTrue(graphPrograms.canFinish(2,prerequisites));
    }

    @Test
    public void testCanFinish_1(){
        int[][] prerequisites = new int[2][2];
        prerequisites[0]= new int[]{1,0};
        prerequisites[1]= new int[]{0,1};
        Assertions.assertTrue(graphPrograms.canFinish(2,prerequisites));
    }
}
