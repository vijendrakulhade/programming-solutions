package com.kulhade.oops.programming.patterns;

import com.kulhade.programming.patterns.SlidingWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlidingWindowTest {

    static SlidingWindow slidingWindow = new SlidingWindow();

    @Test
    public void testSmallestSubArrSizeSum(){
        int[] arr= {2,1,5,2,3,2};
        int sum=7;
        Assertions.assertEquals(2,slidingWindow.smallestSubArrSizeSum(arr,sum));
    }
    @Test
    public void testSmallestSubArrSizeSum_1(){
        int[] arr= {2,1,5,2,8};
        int sum=1;
        Assertions.assertEquals(1 ,slidingWindow.smallestSubArrSizeSum(arr,sum));
    }

    @Test
    public void testSmallestSubArrSizeSum_2(){
        int[] arr= {3, 4, 1, 1, 6};
        int sum=8;
        Assertions.assertEquals(3 ,slidingWindow.smallestSubArrSizeSum(arr,sum));
    }
    @Test
    public void testLongestSubKDistChar(){
        String s = "araaci";
        int k=2;
        Assertions.assertEquals(4,slidingWindow.longestSubKDistChar(s,k));
    }

    @Test
    public void testSlidingWindowAvg(){
        int[] arr={1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k=5;
        float[] result = slidingWindow.slidingWindowAvg(arr,k);
        float[] expected = {2.2F, 2.8F, 2.4F, 3.6F, 2.8F};
        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void testLongestSubKDistChar_1(){
        String s = "araaci";
        int k=1;
        Assertions.assertEquals(2,slidingWindow.longestSubKDistChar(s,k));
    }

    @Test
    public void testLongestSubKDistChar_2(){
        String s = "cbbebi";
        int k=3;
        Assertions.assertEquals(5,slidingWindow.longestSubKDistChar(s,k));
    }

    @Test
    public void testFruitsInBasket(){
        int[] arr = {'A', 'B', 'C', 'A', 'C'};
        Assertions.assertEquals(3,slidingWindow.fruitsInBasket(arr));
    }

    @Test
    public void testLongestSubAtMost2DistChar(){
        String s = "ccaabbb";
        Assertions.assertEquals(5,slidingWindow.longestSubAtMost2DistChar(s));
    }

    @Test
    public void testLongestSubNoRepeat(){
        String s = "abcabcbb";
        Assertions.assertEquals(3,slidingWindow.longestSubNoRepeat(s));
    }

    @Test
    public void testLongestSubNoRepeat_1(){
        String s = "abbbb";
        Assertions.assertEquals(2,slidingWindow.longestSubNoRepeat(s));
    }
    @Test
    public void testMaxRepeated(){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        Assertions.assertEquals(6,slidingWindow.longestOnes(nums,k));
    }
    @Test
    public void testMaxRepeated_1(){
        int[] nums = {0,0,0,0};
        int k=2;
        Assertions.assertEquals(2,slidingWindow.longestOnes(nums,k));
    }

    @Test
    public void testCheckIfPermutationAvailable(){
        String s1="dc"; String s2="odicf";
        Assertions.assertFalse(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_1(){
        String s1="dc"; String s2="odcf";
        Assertions.assertTrue(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_2(){
        String s1="abc"; String s2="oidbcaf";
        Assertions.assertTrue(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_3(){
        String s1="aab"; String s2="oidabaf";
        Assertions.assertTrue(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_4(){
        String s1 = "ab", s2 = "eidboaoo";
        Assertions.assertFalse(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_5(){
        String s1 = "adc", s2 = "dcda";
        Assertions.assertTrue(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_6(){
        String s1 = "abc", s2 = "aaacb";
        Assertions.assertTrue(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }
    @Test
    public void testCheckIfPermutationAvailable_7(){
        String s1 = "bcdxabcdy", s2 = "bcdxabcdy";
        Assertions.assertTrue(slidingWindow.checkIfPermutationAvailable(s1,s2));
    }

}
