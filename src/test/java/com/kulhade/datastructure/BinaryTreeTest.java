package com.kulhade.datastructure;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class BinaryTreeTest {

    BinaryTree<Integer> binaryTree;
    @Before
    public  void setUp(){
        binaryTree = new BinaryTree<Integer>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        System.out.println(binaryTree.toString());
    }

    @Test
    public void testPreOrder(){
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        Integer[] expected = {1,5,8,2,3};
        List<Integer> actual = (List<Integer>)binaryTree.preOrder();
        Assert.assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void testIsBalanced(){
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        Assert.assertTrue(binaryTree.isBalanced());
    }

    @Test
    public void testBalancedHeight(){
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        Assert.assertEquals(3,binaryTree.balancedHeight());
    }
}
