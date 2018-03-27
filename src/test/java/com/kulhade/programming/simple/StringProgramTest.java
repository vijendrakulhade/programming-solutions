package com.kulhade.programming.simple;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void testWordLadderCount(){
        String start = "hit";String end = "cog";
        Set<String> dic = new HashSet<>();
        dic.add("hot");dic.add("dot");dic.add("dog");dic.add("lot");dic.add("log");
        int actual = stringPrograms.wordLadderCount(start,end,dic);
        Assert.assertEquals(5,actual);
    }

    @Test
    public void testWordLadderCount_2(){
        String start = "TOON";String end = "PLEA";
        Set<String> dic = new HashSet<>();
        dic.add("POON");dic.add("PLEE");dic.add("SAME");dic.add("POIE");dic.add("PLEA");dic.add("PLIE");dic.add("POIN");
        int actual = stringPrograms.wordLadderCount(start,end,dic);
        Assert.assertEquals(7,actual);
    }
    @Test
    public void testFormSenetence(){
        String words = "catsanddog";
        Set<String> dic = new HashSet<>();
        dic.add("cat");dic.add("cats");dic.add("and");dic.add("sand");dic.add("dog");
        List<String> sentences  = stringPrograms.formSentence(words,dic);
        List<String> expected = new ArrayList<>();
        expected.add("cats and dog");expected.add("cat sand dog");
        Assert.assertEquals(expected.size(),sentences.size());
        Assert.assertEquals(expected,sentences);
    }

    @Test
    public void testIsWordBreakable(){
        String word = "mynameis";
        Set<String> dict = new HashSet<>();
        dict.add("my");dict.add("name");dict.add("is");
        Assert.assertTrue(stringPrograms.isWordBreakable(word,dict));
    }

    @Test
    public void testIsWordBreakableNeg(){
        String word = "mynameisking";
        Set<String> dict = new HashSet<>();
        dict.add("my");dict.add("name");dict.add("is");
        Assert.assertFalse(stringPrograms.isWordBreakable(word,dict));
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
