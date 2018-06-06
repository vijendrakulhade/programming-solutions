package com.kulhade.oops;

import com.kulhade.datastructure.BinaryTree;

public interface ApiWrapper {

    default BinaryTree defaultWrap(){
        BinaryTree b = new BinaryTree();
        System.out.println("default wrap "+b);
        return b;
    }

    void wrap(BinaryTree binaryTree);
}
