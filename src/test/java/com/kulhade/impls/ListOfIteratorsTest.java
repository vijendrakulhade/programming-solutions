package com.kulhade.impls;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vn05f93 on 10/8/17.
 */
public class ListOfIteratorsTest {

    private ListOfIterators listOfIterators=null;

    @Test
    public void testMultipleToOneIterator(){
        Iterator<Integer> a = Arrays.asList(1,2,3,4,5).iterator();
        Iterator<Integer> b = Arrays.asList(6,7,8,9,10).iterator();
        List<Iterator<Integer>> listOfIterator = new ArrayList<Iterator<Integer>>();
        listOfIterator.add(a);listOfIterator.add(b);
        listOfIterators = new ListOfIterators(listOfIterator.iterator());
        while(listOfIterators.hasNext()){
            System.out.println(listOfIterators.next());
        }
    }


}
