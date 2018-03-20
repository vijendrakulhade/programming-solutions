package com.kulhade.programming.simple;

import java.util.*;

/**
 * Created by vn05f93 on 10/7/17.
 */
public class DynamicProgramming {

    /**
     * Method will print fibonacci Series with recursion
     * @param n
     * @return
     */
    public int[] fibonacciSeries(int n){
        int[] memo = new int[n];
        int[] series = new int[n];
        for(int i=0;i<n;i++){
            series[i] = fibonacci(i,memo);
        }
        return series;
    }

    /**
     * Method will find ways to make change for money
     * from given array of coins with recursion
     * @param coins
     * @param money
     * @return
     */
    public int findWaysToMakeChange(int[] coins,int money){
        Map<String,Integer> memo = new HashMap<String, Integer>();
        return makeChange(coins,money,0,memo);
    }

    /**
     * Method will find ways to make change for money
     * from given array of coins with out recursion
     * @param coins
     * @param money
     * @return
     */
    public int findWaysToMakeChangeNoRecursion(int[] coins,int money){
        return makeChangeNoRecursion(money,coins);
    }

    /**
     * Method will evaluate the number based on below conditions
     *
     * There is a 4 digits number in increasing order.
     * The tens digit is the sum of the hundreds digit and the thousand digit
     * The unit (one) digit is the sum of the other three.
     * The sum of all 4 digits is 16. What is the number
     *
     */
    public int evaluateNumber(){
        return 0;
    }

    private int makeChange(int[] coins,int money,int index,Map<String,Integer> memo){
        if(money == 0){
            return 1;
        }
        if(index >= coins.length){
            return 0;
        }
        int amountWithCoins = 0; int ways=0;
        String key = money+"_"+index;
        if(!memo.containsKey(key)) {
            while (amountWithCoins <= money) {
                int remaining = money - amountWithCoins;
                ways += makeChange(coins, remaining, index + 1,memo);
                amountWithCoins += coins[index];
            }
            memo.put(key,ways);
        }
        return memo.get(key);
    }

    private int makeChangeNoRecursion(int amount,int[] coins){
        int[] combinations = new int[amount+1];
        combinations[0]=0;
        for(int coin:coins){
            for(int i=1;i<=amount;i++){
                if(i>=coin){
                    combinations[i] = combinations[i]+combinations[i-coin];
                }
            }
        }
        return combinations[amount];

    }

    private int fibonacci(int n,int[] memo){
        if(n==0 || n==1){ return n;}
        else if(memo[n]==0){
            memo[n] = fibonacci(n-1,memo)+fibonacci(n-2,memo);
        }
        return memo[n];
    }

    /**
     * Longest Common sub-sequence
     * Method will return the length of longest common sub-sequence from 2 strings
     * Eg. str1="ADBFGT" , str2="GBFCHX" Answer GBF
     * Recursion
     */
    public int longestCommonSubsequence(String str1,String str2){
        if(str1.length()==0 || str2.length()==0){
            return 0;
        }else if(str1.charAt(str1.length()-1)==str2.charAt(str2.length()-1)){
                return 1+longestCommonSubsequence(str1.substring(0,str1.length()-1),str2.substring(0,str2.length()-1));
        }else{
            return Math.max(longestCommonSubsequence(str1,str2.substring(0,str2.length()-1)),longestCommonSubsequence(str1.substring(0,str1.length()-1),str2));
        }
    }

    public List<String> subStringsKDist(String inputStr, int num)
    {
        if(inputStr == null) { return null; }
        char[] chars = inputStr.toCharArray();
        Map<Character,Integer> memo = new HashMap();
        List<String> subStringsKDist = new ArrayList();

        if(num > 0){
            for( Character c:inputStr.toCharArray()){

            }
            for(int i=0,j=0;i<inputStr.length();i++){
                /*if(memo.containsKey(chars[i])){
                    j = Math.max(memo.get(chars[i]),j);
                }
                window = Math.max(window,i-j+1);*/
                memo.put(chars[i],1);
                /*if(window==num){
                    StringBuilder sb = new StringBuilder(num);
                    for(Map.Entry<Character,Integer> entry:memo.entrySet()){
                        sb.append(entry.getKey());
                    }
                    subStringsKDist.add(sb.toString());
                    window--;
                }*//*else if(window > num){
                    int diff  = window- num;
                    StringBuilder sb = new StringBuilder(num);
                    int k = 1;
                    for(Map.Entry<Character,Integer> entry:memo.entrySet()){
                        if(diff >= k){
                            k++;
                            continue;
                        }
                        sb.append(entry.getKey());
                    }
                    subStringsKDist.add(sb.toString());
                }*/

            }
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Character,Integer> entry:memo.entrySet()){
                sb.append(entry.getKey());
            }
            return makeSubstrings(sb.toString());

        }
        return null;
    }

    int countkDist(String str, int k)
    {
        // Initialize result
        int res = 0;

        int n = str.length();

        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            int dist_count = 0;

            // Initializing count array with 0
            Arrays.fill(cnt, 0);

            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;

                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;

                // If distinct character count becomes k,
                // then increment result.
                if (dist_count == k) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * Method will print the min operations required to make str1 to str2
     *
     */
    public int minEditDistance(String str1,String str2){
        if(str1.length()==0){
            return str2.length();
        }
        if(str2.length()==0){
            return str1.length();
        }
        if(str1.equalsIgnoreCase(str2)){
            return 0;
        }if(str1.charAt(0)==str2.charAt(0)){
            return minEditDistance(str1.substring(1,str1.length()),str2.substring(1,str2.length())); //replace
        }else{
            return Math.min(Math.min(minEditDistance(str1.substring(1,str1.length()),str2),//remove
                    minEditDistance(str1,str2.substring(1,str2.length()))),//Insert
                    minEditDistance(str1.substring(1,str1.length()),str2.substring(1,str2.length())))+1; //replace
        }

    }

    /**
     * Method will remove consecutive duplicates from String
     */
    public String super_reduced_string(String s,int index){
        if("".equalsIgnoreCase(s)){
            return "Empty String";
        }else if(s.charAt(index)==s.charAt(index+1)){
            return s.substring(index+1)+super_reduced_string(s.substring(index+2,s.length()),index+1);
        }else{
            return super_reduced_string(s,index+1);
        }

    }

    /**
     * Method will form permutations of a given string
     * @param str
     * @return
     */
    private List<String> makeSubstrings(String str){
        List<String> perm = new ArrayList<String>();
        if(str ==null){
            return null;
        }
        if( str.length()==0){
            perm.add("");
            return perm;
        }
        char first  =  str.charAt(0);
        String remainder = str.substring(1);
        List<String> words = makeSubstrings(remainder);
        for(String word:words){
            for(int j=0;j<=word.length();j++){
                String s = insertCharAt(word,first,j);
                perm.add(s);
            }
        }
        return perm;
    }

    private String insertCharAt(String word, char c, int i){
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start+c+end;
    }
}

