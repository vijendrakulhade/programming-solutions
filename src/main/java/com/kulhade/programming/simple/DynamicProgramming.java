package com.kulhade.programming.simple;

import java.util.*;

/**
 * Created by vn05f93 on 10/7/17.
 */
public class DynamicProgramming {


    public boolean isPatternMatch(String s,String p){
        //base case
        if(p.length()==0) return s.length()==0;
        //case 0 if pattern is only one char '.' or '*'
        if(p.length()==1){
            if(s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.'){
                return false;
            }else{
                return isPatternMatch(s.substring(1),p.substring(1));
            }
        }
        //case 1 if pattern second char is not '*'
        if(p.charAt(1)!='*'){
            if(s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.'){
                return false;
            }else{
                return isPatternMatch(s.substring(1),p.substring(1));
            }
        }else{// 2 if pattern second char is *
            //case 2.1: a char & '*' can stand for 0 element OR
            if(isPatternMatch(s,p.substring(2))){
                return true;
            }
            //case 2.2: a char & '*' can stand for 1 or more preceding element
                int i=0;
            while(i<s.length() && s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
                  if(isPatternMatch(s.substring(i+1),p.substring(2))){
                      return true;
                  }
                  i++;
            }
            return false;
        }

    }
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

    /**
     * Taking first index from Array
     *
     */
    private int makeChange(int[] coins,int money,int index,Map<String,Integer> memo){
        if(money == 0){
            return 1;
        }
        if(index >= coins.length){
            return 0;
        }
        int amountWithCoins = 0; int ways=0;
        String key = money+"_"+index;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        while (amountWithCoins <= money) {
            int remaining = money - amountWithCoins;
            ways += makeChange(coins, remaining, index + 1,memo);
            amountWithCoins += coins[index];
        }
        memo.put(key,ways);
        return memo.get(key);
    }

    /**
     * coins = {2,3,5,6} & Sum=10
     * @param coins
     * @param i length of coins array taking last index
     * @param sum
     * @return
     */
    private int makeChange(int[] coins, int i,int sum){
        if(sum==0) return 1;
        if(i==0) return 0;
        int ways = makeChange(coins,i-1,sum);
        if(coins[i-1]<=sum){
            ways+=makeChange(coins,i,sum-coins[i-1]);
        }
        return ways;
    }

    public List<List<Integer>> findAllPossibleChangeForMoney(int[] coins,int money){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        wayToChangesMoney(coins,money,0,current,result);
        return result;
    }
    private void wayToChangesMoney(int[] coins,int money,int index,List<Integer> curr,List<List<Integer>> result){
        if(money == 0){
            List<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }
        for(int i=index;i<coins.length;i++){
            if(coins[i]>money){
                return;
            }
            curr.add(coins[i]);
            wayToChangesMoney(coins,money-coins[i],i,curr,result);
            curr.remove(curr.size()-1);
        }

    }
    public List<List<Integer>> showMoneyChangeCombinations(int[] coins,int money){
        List<List<Integer>> result = new ArrayList<>();
        if(coins==null || coins.length==0) return result;
        Map<String,List> memo = new HashMap<>();
        makeChangeCombinations(coins,money,0,new ArrayList<>(),result,memo);
        return result;
    }
    private void makeChangeCombinations(int[] coins,int money,int index,List<Integer> current,List<List<Integer>> result,Map<String,List> memo){
        if(money == 0){
            result.add(current);
            return;
        }
        if(index >= coins.length){
            return;
        }
        int amountWithCoins = 0; int ways=0;
        String key = money+"_"+index;
        if(memo.containsKey(key)) {
            result.add(memo.get(key));
        }
        while (amountWithCoins <= money) {
            int remaining = money - amountWithCoins;
            makeChangeCombinations(coins, remaining, index + 1,current,result,memo);
            amountWithCoins += coins[index];

        }
        memo.put(key,current);
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


    /**
     * Longest Common sub-sequence iterative
     * Method will return the length of longest common sub-sequence from 2 strings
     * Eg. str1="ADBFGT" , str2="GBFCHX" Answer GBF
     * Recursion
     */
    public int longestCommonSubsequenceIterative(String str1,String str2){
        if(str1.length()==0 || str2.length()==0){
            return 0;
        }
        int[][] memo = new int[str1.length()+1][str2.length()+1];
        for(int j=0;j<memo[0].length;j++){
            memo[0][j]=1;
        }
        for (int i=1;i<memo.length;i++){
            for(int j=1;j<memo[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    memo[i][j] = Math.max(memo[i][j-1],memo[i-1][j-1]);
                }else{
                    memo[i][j] = memo[i-1][j-1];
                }
            }
        }
        return memo[str1.length()][str2.length()];
    }

    public int distinctCommonSubSequence(String str1,String str2){
        if(str2.length() == 0) return 0;
        if(str1.length() == 0) return 0;
        if(str1.charAt(0)!=str2.charAt(0)){
            return distinctCommonSubSequence(str1.substring(1),str2.substring(1));
        }else{
            return distinctCommonSubSequence(str1.substring(1),str2)+distinctCommonSubSequence(str1.substring(1),str2.substring(1));
        }

    }

    public int distinctCommonSubSequenceIterative(String str1,String str2){
        if(str2.length() == 0) return 0;
        if(str1.length() == 0) return 0;
        int[][] arr = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<arr.length;i++)
            arr[i][0]=1;

        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }else{
                    arr[i][j]=arr[i-1][j];
                }
            }
        }

        printTwoDimArr(arr);

        return arr[str1.length()][str2.length()];
    }

    public List<String> subStringsKDist(String inputStr, int num)
    {
        if(inputStr == null) { return null; }
        char[] chars = inputStr.toCharArray();
        Map<Character,Integer> memo = new HashMap();
        List<String> subStringsKDist = new ArrayList();

        if(num > 0){
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
     * Method will print the min operations required to make str1 to str2
     * Iterative
     *
     */
    public int minEditDistanceIterative(String str1,String str2){
        if(str1.length()==0){
            return str2.length();
        }
        if(str2.length()==0){
            return str1.length();
        }
        if(str1.equalsIgnoreCase(str2)){
            return 0;
        }
        int[][] memo = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<memo.length;i++){
            memo[i][0]=i;
        }
        for(int j=0;j<memo[0].length;j++){
            memo[0][j]=j;
        }
        for(int i=1;i<memo.length;i++){
            for (int j=1;j<memo[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    memo[i][j]=memo[i-1][j-1];
                }else{
                    memo[i][j]=1+Math.min(Math.min(memo[i-1][j],memo[i][j-1]),memo[i-1][j-1]);
                }
            }
        }
        return memo[str1.length()][str2.length()];

    }

    /**
     * Method will remove consecutive duplicates from String
     */
    public String super_reduced_string(String s){
        if(s ==null) throw new IllegalArgumentException("Null String");
        if(s.length()<=1) return s;
        Set<Character> characters = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(Character c:s.toCharArray()){
            if(characters.contains(c)){
                continue;
            }
            characters.add(c);
            sb.append(c);
        }
        return sb.toString();
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

    private void printTwoDimArr(int[][] arr){
        if(arr==null) return;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Longest Increasing Subsequence length
     * {3,4,2,8,10,5,1} --> {3,4,8,10} -- 4
     */
    public int lis(int[] arr){
        if(arr==null || arr.length==0) return 0;
        List<Integer> lis = new ArrayList<>();
        int n = arr.length;
        lis.add(arr[0]);
        for(int i=1,lis_i=0;i<n;i++){
            if(arr[i]>lis.get(lis_i)){
                lis.add(arr[i]);
            }else{
                int pos  = getPosition(arr,arr[i],0,i);
                lis.set(pos,arr[i]);
            }
            lis_i = lis.size()-1;
        }
        return lis.size();
    }

    private int getPosition(int[] arr,int x, int l, int r){
        if(l>r) return 0;
        while(r>l){
            int m = l+(r-l)/2;
            if(arr[m]>=x){
                 r=m;
            }else{
                l=m+1;
            }
        }
        return r;
    }

    /**
     * Get Max cut of a Rod
     * Given Rod of size m and probable cuts a,b,c.
     * Find out the max cut we can get.
     */
    public int makeCut(int m,int a,int b,int c){
        if(m<0) return -1;
        if(m==0) return 0;
        int res = Math.max(Math.max(makeCut(m-a,a,b,c),makeCut(m-b,a,b,c)),makeCut(m-c,a,b,c));
        if(res!=-1)
            return 1+res;
        return res;
    }

    /**
     * Make Max cur memoization
     */
    public int makeCutMemo(int m,int a,int b,int c){
        int[] memo = new int[m+1];
        if(m<0) return -1;
        if(m==0){
            memo[m] = 0;
            return memo[m];
        }
        return makeCutMemo(m,a,b,c,memo);
    }
    private int makeCutMemo(int m,int a,int b,int c,int[] memo){
        if(m<0) return -1;
        if(m==0) {
            memo[m]=0;
            return memo[m];
        }
        memo[m] = Math.max(Math.max(makeCutMemo(m-a,a,b,c,memo),makeCutMemo(m-b,a,b,c,memo)),makeCutMemo(m-c,a,b,c,memo));
        if(memo[m]!=-1) {
            memo[m] = 1+memo[m];
        }
        return memo[m];
    }

    /**
     * Make max cut tabulation
     */
    public int makeCutTabulation(int m, int a,int b,int c){
        int[] memo = new int[m+1];
        if(m<0) return -1;
        memo[0] = 0;
        for(int i=1;i<=m;i++){
            memo[i]=-1;
            if(i-a>=0){
                memo[i] = Math.max(memo[i],memo[i-a]);
            }
            if(i-b>=0){
                memo[i] = Math.max(memo[i],memo[i-b]);
            }
            if(i-c>=0){
                memo[i] = Math.max(memo[i],memo[i-c]);
            }
            if(memo[i]!=-1){
                memo[i]++;
            }
        }
        return memo[m];
    }
}

