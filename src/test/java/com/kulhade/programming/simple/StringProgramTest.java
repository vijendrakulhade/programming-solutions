package com.kulhade.programming.simple;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by vn05f93 on 3/11/18.
 */
@RunWith(JUnit4.class)
public class StringProgramTest {

    static StringPrograms stringPrograms;
    @BeforeClass
    public static void setUp(){
        stringPrograms = new StringPrograms();
    }

    @Test
    public void testLongestPalindrome(){
        String str = "ababcba";
        String palindrome = stringPrograms.longestPalindrome(str);
        Assert.assertEquals("abcba",palindrome);
    }
    @Test
    public void testLongestPalindrome_2(){
        String str = "ababcbaabcdcba";
        String palindrome = stringPrograms.longestPalindrome(str);
        Assert.assertEquals("abcdcba",palindrome);
    }
}
