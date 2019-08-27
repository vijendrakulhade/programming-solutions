package com.kulhade.oops;

import com.kulhade.datastructure.BinaryTree;
import com.kulhade.oops.impl.ApiWrapperImplSec;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApiWrapperImplSecTest {

    static ApiWrapper apiWrapper;

    @BeforeAll
    public static void setUp(){
        apiWrapper = new ApiWrapperImplSec();
    }

    @Test
    public void testWrapper(){
        apiWrapper.wrap(new BinaryTree());

    }

    @Test
    public void testDefaultInterface(){
        ApiWrapper apiWrapper1 = ((b) -> {
            System.out.println("This Obj "+this.hashCode());
        });
        ApiWrapper apiWrapper2 = ((b) -> {
            System.out.println("This Obj "+this.hashCode());
        });
        apiWrapper1.defaultWrap();
        apiWrapper2.defaultWrap();
    }
}
