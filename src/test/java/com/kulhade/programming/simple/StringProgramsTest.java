package com.kulhade.programming.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vn05f93 on 3/11/18.
 */
public class StringProgramsTest {

    static StringPrograms stringPrograms;
    @BeforeAll
    public static void setUp(){
        stringPrograms = new StringPrograms();
    }

    @Test
    public void testWordLadderCount(){
        String start = "hit";String end = "cog";
        Set<String> dic = new HashSet<>();
        dic.add("hot");dic.add("dot");dic.add("dog");dic.add("lot");dic.add("log");
        int actual = stringPrograms.wordLadderCount(start,end,dic);
        Assertions.assertEquals(5,actual);
    }

    @Test
    public void testWordLadderCount_2(){
        String start = "TOON";String end = "PLEA";
        Set<String> dic = new HashSet<>();
        dic.add("POON");dic.add("PLEE");dic.add("SAME");dic.add("POIE");dic.add("PLEA");dic.add("PLIE");dic.add("POIN");
        int actual = stringPrograms.wordLadderCount(start,end,dic);
        Assertions.assertEquals(7,actual);
    }
    @Test
    public void testFormSenetence(){
        String words = "catsanddog";
        Set<String> dic = new HashSet<>();
        dic.add("cat");dic.add("cats");dic.add("and");dic.add("sand");dic.add("dog");
        List<String> sentences  = stringPrograms.formSentence(words,dic);
        List<String> expected = new ArrayList<>();
        expected.add("cats and dog");expected.add("cat sand dog");
        Assertions.assertEquals(expected.size(),sentences.size());
        Assertions.assertEquals(expected,sentences);
    }

    @Test
    public void testIsWordBreakable(){
        String word = "mynameis";
        Set<String> dict = new HashSet<>();
        dict.add("my");dict.add("name");dict.add("is");
        Assertions.assertTrue(stringPrograms.isWordBreakable(word,dict));
    }

    @Test
    public void testIsWordBreakableNeg(){
        String word = "mynameisking";
        Set<String> dict = new HashSet<>();
        dict.add("my");dict.add("name");dict.add("is");
        Assertions.assertFalse(stringPrograms.isWordBreakable(word,dict));
    }

    @Test
    public void testLongestPalindrome(){
        String str = "ababcba";
        String palindrome = stringPrograms.longestPalindrome(str);
        Assertions.assertEquals("abcba",palindrome);
    }
    @Test
    public void testLongestPalindrome_2(){
        String str = "ababcbaabcdcba";
        String palindrome = stringPrograms.longestPalindrome(str);
        Assertions.assertEquals("abcdcba",palindrome);
    }

    @Test
    public void testReverseWithSpace(){
        char[] arr = {' ',' '};
        char[] actual = stringPrograms.reverseWithSpace(arr);
        char[] expected = {' ',' '};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testReverseWithSpace_1(){
        char[] arr = {'p','e','r','f','a','c','t',' ','m','a','k','e','s',' ','p','r','a','c','t','i','c','e'};
        char[] actual = stringPrograms.reverseWithSpace(arr);
        char[] expected = {'p','r','a','c','t','i','c','e',' ','m','a','k','e','s',' ','p','e','r','f','a','c','t'};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testReverseWithSpace_2(){
        char[] arr = {'h','e','l','l','o'};
        char[] actual = stringPrograms.reverseWithSpace(arr);
        char[] expected = {'h','e','l','l','o'};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void testLongestUniqueCharSubstring(){
        String s = "abcba";
        int actual = stringPrograms.longestUniqueCharSubstring(s);
        Assertions.assertEquals(3,actual);
    }

    @Test
    public void testLongestUniqueCharSubstring_1(){
        String s = "obamacare";
        int actual = stringPrograms.longestUniqueCharSubstring(s);
        Assertions.assertEquals(4,actual);
    }

    @Test
    public void testLongestCommonPrefix(){
        String[] strs = {"aaa","ab","abc"};
        String actual = stringPrograms.longestCommonPrefix(strs);
        Assertions.assertEquals("a",actual);
    }

    @Test
    public void testBasic(){
        String s = "some";
        Assertions.assertEquals("ome",s.substring(1).intern());
        String s1 = "something";
        Assertions.assertEquals("somethin",s1.substring(0,s1.length()-1).intern());
    }

    @Test
    public void testPalindromePartitions(){
        String aab = "aab";
        List<String> cur = new ArrayList<>();
        cur.add("a");cur.add("a");cur.add("b");
        List<List<String>> expected = new ArrayList<>();
        expected.add(cur);
        cur = new ArrayList<>();
        cur.add("aa");cur.add("b");
        expected.add(cur);
        List<List<String>> actual = stringPrograms.palindromePartitions(aab);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testPalindromePartitions_1(){
        String aab = "aab";
        List<String> cur = new ArrayList<>();
        cur.add("a");cur.add("a");cur.add("b");
        List<List<String>> expected = new ArrayList<>();
        expected.add(cur);
        cur = new ArrayList<>();
        cur.add("aa");cur.add("b");
        expected.add(cur);
        List<List<String>> actual = stringPrograms.palindromePartitions(aab);
        Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testIsMatch(){
        String s="aab", p="c*a*b";
        Assertions.assertTrue(stringPrograms.isMatch(s,p));
    }

    @Test
    public void testStringMethods(){
        String s = "A man, a plan, a canal: Panama";
        s = s.replaceAll("[^a-zA-Z0-9]+","").toLowerCase();
        System.out.print(s);
    }

    @Test
    public void testStringSub(){
        String s = "abcdebdde";
        System.out.println(s.substring(1,5));
    }

    @Test
    public void testBackspaceCompare(){
        String S = "ab#c", T = "ad#c";
        Assertions.assertTrue(stringPrograms.backspaceCompare(S,T));
    }

    @Test
    public void testBackspaceCompare_1(){
        String S = "ab#c", T = "#d#c";
        Assertions.assertFalse(stringPrograms.backspaceCompare(S,T));
    }

    @Test
    public void testFindFirstNonRepeatingCharIndex(){
        String s="geeksforgeeks";
        Assertions.assertEquals(5,stringPrograms.findFirstNonRepeatingCharIndex(s));
    }

    @Test
    public void testFindFirstRepeatingCharIndex(){
        String s="geeksforgeeks";
        Assertions.assertEquals(0,stringPrograms.findFirstRepeatingCharIndex(s));
    }

    @Test
    public void testLexicographicalRank(){
        String s = "BAC";
        Assertions.assertEquals(3,stringPrograms.lexicographicalRank(s));
    }

    @Test
    public void testLexicographicalRank_1(){
        String s = "STRING";
        Assertions.assertEquals(598,stringPrograms.lexicographicalRank(s));
    }

    @Test
    public void testIsPalindromicPattern(){
        String s = "geeksforgeeks";
        String p = "egeks";
        Assertions.assertTrue(stringPrograms.isPalindromicPattern(s,p)) ;
    }

}
