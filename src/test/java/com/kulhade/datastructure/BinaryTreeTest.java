package com.kulhade.datastructure;


import org.junit.jupiter.api.*;

import java.util.List;

public class BinaryTreeTest {

    BinaryTree<Integer> binaryTree;
    @BeforeEach
    public  void setUp(){
        binaryTree = new BinaryTree<Integer>();
    }

    @AfterAll
    public static void tearDown() throws Exception {
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
        Assertions.assertArrayEquals(expected,actual.toArray());
    }

    @Test
    public void testIsBalanced(){
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        Assertions.assertTrue(binaryTree.isBalanced());
    }

    @Test
    public void testBalancedHeight(){
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(8);
        Assertions.assertEquals(3,binaryTree.balancedHeight());
    }

    @Test
    public void testSerialize(){
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(1);
        Assertions.assertEquals("2,1,3",binaryTree.serialize());
    }

    @Test
    public void testDeserialize(){
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(1);
        BinaryTree.BTNode root = binaryTree.getRoot();
        BinaryTree.BTNode btNode = binaryTree.deserialize(binaryTree.serialize());
        Assertions.assertNotNull(btNode);
    }
}
