package com.kulhade.programming.simple;

import com.kulhade.programming.entity.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vn05f93 on 7/29/17.
 */
public class SimpleProgramsTest {

    private static SimplePrograms simplePrograms=null;

    @BeforeAll
    public static void setUp(){
        simplePrograms = new SimplePrograms();
    }

    @Test
    public void testWordCount(){
        String testStr ="a   ab abc ";
        long actual=simplePrograms.wordCount(testStr);
        Assertions.assertEquals(3,actual);
    }

    @Test
    public void testGetCharacterCount(){
        String testStr="aaaa bb";
        long actual=simplePrograms.getCharacterCount(testStr,'b');
        Assertions.assertEquals(2,actual);
    }

    @Test
    public void testSortMap(){
        Map<String, String> codenames = new HashMap<String, String>();
            codenames.put("JDK 1.1.4", "Sparkler");
            codenames.put("J2SE 1.2", "Playground");
            codenames.put("J2SE 1.3", "Kestrel");
            codenames.put("J2SE 1.4", "Merlin");
            codenames.put("J2SE 5.0", "Tiger");
            codenames.put("Java SE 6", "Mustang");
            codenames.put("Java SE 7", "Dolphin");
        List<Map.Entry<String,String>> entries = simplePrograms.sortMap(codenames);
        String[] expected = {"Dolphin","Kestrel","Merlin","Mustang","Playground","Sparkler","Tiger"};
        List<String> lastNames = new ArrayList<String>();
        for(Map.Entry<String,String> entry:entries){
            lastNames.add(entry.getValue());
        }
        Assertions.assertArrayEquals(expected,lastNames.toArray());
    }

    @Test
    public void testSortWithLastNameAppearance() throws IOException{
        File inputFile = new File("src/test/resources/name.txt");
        Map<String,Integer> countMap = simplePrograms.sortWithLastNameAppearance(inputFile);
        Assertions.assertEquals(2,countMap.get("Mayer").longValue());


    }

    @Test
    public void testMergeList(){
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(1,3));
        intervals.add(new Interval<>(2,6));
        intervals.add(new Interval<>(8,10));
        intervals.add(new Interval<>(13,15));
        simplePrograms.mergeIntervalList(intervals);
        Interval expectedChange = new Interval(1,6);
        Interval actual = (Interval)intervals.toArray()[0];
        Assertions.assertEquals(expectedChange.getEnd(),actual.getEnd());
    }

    @Test
    public void testMergeList_1(){
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(1,3));
        intervals.add(new Interval<>(2,6));
        intervals.add(new Interval<>(8,10));
        intervals.add(new Interval<>(13,15));
        intervals.add(new Interval<>(1,11));
        simplePrograms.mergeIntervalList(intervals);
        Interval expectedChange = new Interval(1,11);
        Interval actual = (Interval)intervals.toArray()[0];
        Assertions.assertEquals(expectedChange.getEnd(),actual.getEnd());
    }

    @Test
    public void testMergeList_2(){
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(1,4));
        intervals.add(new Interval<>(0,2));
        intervals.add(new Interval<>(3,5));
        simplePrograms.mergeIntervalList(intervals);
        Interval expectedChange = new Interval(0,5);
        Interval actual = (Interval)intervals.toArray()[0];
        Assertions.assertEquals(expectedChange.getEnd(),actual.getEnd());
    }
    //Need to manually verify the values
    @Test
    public void testInsertInterval_1(){
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(1,3));
        intervals.add(new Interval<>(6,9));
        Interval newInterval = new Interval(2,5);
        simplePrograms.insertInterval(intervals,newInterval);
        List<Interval<Integer>> expectedIntervals = new ArrayList<>();
        expectedIntervals.add(new Interval<>(1,5));
        expectedIntervals.add(new Interval<>(6,9));
        Assertions.assertEquals(expectedIntervals.size(),intervals.size());
    }

    //Need to manually verify the values
    @Test
    public void testInsertInterval_2(){
        List<Interval<Integer>> intervals = new ArrayList<>();
        intervals.add(new Interval<>(1,2));
        intervals.add(new Interval<>(3,5));
        intervals.add(new Interval<>(6,7));
        intervals.add(new Interval<>(8,10));
        intervals.add(new Interval<>(12,16));
        Interval newInterval = new Interval(4,9);
        simplePrograms.insertInterval(intervals,newInterval);
        List<Interval<Integer>> expectedIntervals = new ArrayList<>();
        expectedIntervals.add(new Interval<>(1,2));
        expectedIntervals.add(new Interval<>(3,10));
        expectedIntervals.add(new Interval<>(12,16));
        Assertions.assertEquals(expectedIntervals.size(),intervals.size());
    }


}
