package com.kulhade.oops.impl;

import com.kulhade.datastructure.BinaryTree;
import com.kulhade.oops.ApiWrapper;

public abstract class ApiWrapperImpl implements ApiWrapper{

    public void wrap(BinaryTree b) {
        System.out.println("I am in ApiWrapperImpl !! " +b);
        System.out.println("B from  ApiWrapper !! " +ApiWrapper.super.defaultWrap());
    }
}
