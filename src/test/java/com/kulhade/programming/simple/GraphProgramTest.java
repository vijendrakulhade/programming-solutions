package com.kulhade.programming.simple;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.LinkedHashMap;

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
}
