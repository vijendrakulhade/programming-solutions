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
     * Longest Increasing Subsequence length O(n^2)
     */
    public int lisOn(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[] lis = new int[arr.length];
        lis[0]=1;
        for(int i=1;i<arr.length;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            res = Math.max(res,lis[i]);
        }
        return res;
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
     * Length of Longest BiTonic subsequence
     * Eg {1,11,2,10,4,5,2,1}
     * increasing 1,2,10
     * decreasing 10,4,2,1 or 10,5,2,1
     * length = 3+4-1=6
     */
    public int longestBiTonicSubSeq(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[] lis = new int[arr.length];
        int[] lds = new int[arr.length];
        int lis_i=0;//1 2 3 4
        // lis = {1,2,4,1,0,0,0}
        lis[lis_i++]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<lis[lis_i-1]){
                int pos = getPosition(arr,arr[i],0,i);//0,
                lis[pos]=arr[i];
            }else{
                lis[lis_i++] = arr[i];
            }
        }
        int lds_i=arr.length-1;//3 4 5
        //lds = {1,2,4,10,2} {0,11,2,1,4,2,1}
        lds[lds_i--] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]<arr[lds_i-1]){
                int pos = getPosition(arr,arr[i],i,arr.length-1);
                lds[pos] = arr[i];
            }else{
                lds[lds_i--] = arr[i];
            }
        }
        // Lis and lds should be same length
        int count=0;
        for(int i=0;i<lis.length;i++){
            if(lis[i]!=0) count++;
            if(lds[i]!=0) count++;
        }
        return count-1;
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

    /**
     * Min Coins required to make a sum
     * Eg {25,10,5} Sum 30
     * o/p 2 as required coins are {25,5}
     */
    public int minCoins(int[] coins,int sum){
        if(coins==null || coins.length==0)
            return 0;
        // Base case
        if(sum==0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=sum){
                int sub_res = minCoins(coins,sum-coins[i]);
                if(sub_res!=Integer.MAX_VALUE){
                    res = Math.min(res,1+sub_res);
                }
            }
        }
        return res;
    }

    private int minCoins(int[] coins,int sum,int[] memo){
        if(sum==0){
            memo[sum]=0;
            return memo[sum];
        }
        if(memo[sum]!=Integer.MAX_VALUE)
            return memo[sum];
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=sum){
                memo[sum-coins[i]] = Integer.MAX_VALUE;
                int sub_res = minCoins(coins,sum-coins[i],memo);
                if(sub_res!=Integer.MAX_VALUE){
                    memo[sum] = Math.min(memo[sum],1+sub_res);
                }
            }
        }
        return memo[sum];
    }

    public int minCoinsMemo(int[] coins,int sum){
        if(coins==null || coins.length==0)
                return 0;
        int[] memo = new int[sum+1];
        memo[sum]=Integer.MAX_VALUE;
        return minCoins(coins,sum,memo);
    }

    public int minCoinsTabulation(int[] coins,int sum){
        if(coins== null || coins.length==0){
            return 0;
        }
        int[] memo = new int[sum+1];
        for(int i=0;i<sum+1;i++){
            if(i==0){
                memo[i]=0;
                continue;
            }
            memo[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    memo[i] = Math.min(memo[i],1+memo[i-coins[j]]);
                }
            }
        }
        return memo[sum];
    }

    /**
     * Minimum Jump required to reach to the end
     * Eg {3,4,2,1,2,1} o/p 2 (3 to 4 to last ie 1)
     */
    public int minJump(int[] arr,int idx){
        if(arr==null || arr.length==0) return 0;
        if(idx== arr.length-1) return 0;
        int jump = Integer.MAX_VALUE;
        int allowedLastIdx = idx+arr[idx];
        for(int i=idx+1;i<=allowedLastIdx;i++){
            if(i>arr.length-1) continue;
            int temp = minJump(arr,i);
            if(temp!=Integer.MAX_VALUE) //Check for MAX_VALUE because +1 will make it -ve and it will count as min than
                jump = Math.min(jump,temp+1);
        }
        return jump;
    }

    public int minJumpMemo(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[] memo = new int[arr.length+1];
        for(int i=0;i<arr.length;i++) memo[i]=Integer.MAX_VALUE;
        return minJump(arr,0,memo);
    }

    private int minJump(int[] arr,int idx,int[] memo){
        if(arr==null || arr.length==0) return 0;
        if(idx== arr.length-1) {
            memo[idx] = 0;
            return memo[idx];
        }
        if(memo[idx]!=Integer.MAX_VALUE) return memo[idx];
        int allowedLastIdx = idx+arr[idx];
        for(int i=idx+1;i<=allowedLastIdx;i++){
            if(i>arr.length-1) continue;
            int temp = minJump(arr,i,memo);
            if(temp!=Integer.MAX_VALUE) {//Check for MAX_VALUE because +1 will make it -ve and it will count as min than
                memo[idx] = Math.min(memo[idx], temp + 1);
            }
        }
        return memo[idx];
    }

    public int minJumpTabulation(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[] dp = new int[arr.length+1];
        dp[arr.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i+arr[i];j>i;j--){
                if(j>arr.length-1) continue;
                if(dp[j]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i],dp[j]+1);
            }
        }
        return dp[0];

    }

    /**
     * 0-1 KnapSack
     * Get Max Value for given weight
     * Eg V={1,2,10,12,4} W={1,1,12,4,8} GW=15
     * Ans 19
     */
    public int knapsackRec(int[] v,int[] w,int gw,int n){
        if(v==null || w==null || v.length==0 || w.length==0) return 0;
        if(v.length!=w.length) throw new IllegalArgumentException("Value and Weight arrays length should be same");
        if(n==0) return 0;
        if(gw==0) return 0;
        if(gw<0) return Integer.MIN_VALUE;
        if(w[n-1]>gw){
            return knapsackRec(v,w,gw,n-1);
        }else{
            return Math.max(knapsackRec(v,w,gw,n-1),v[n-1]+knapsackRec(v,w,gw-w[n-1],n-1));
        }
    }
    public int knapsackMemo(int[] v,int[] w,int gw,int n){
        if(v==null || w==null || v.length==0 || w.length==0) return 0;
        if(v.length!=w.length) throw new IllegalArgumentException("Value and Weight arrays length should be same");
        int[][] memo = new int[n+1][gw+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<gw+1;j++){
                memo[i][j]=Integer.MIN_VALUE;
            }
        }
        return knapsack(v,w,gw,n,memo);
    }

    private int knapsack(int[] v,int[] w,int gw,int n,int[][] memo){

        if(n==0) return memo[n][gw]=0;
        if(gw==0) return memo[n][gw]=0;

        if(gw<0) return Integer.MIN_VALUE;
        if(memo[n][gw]!=Integer.MIN_VALUE){
            return memo[n][gw];
        }
        if(w[n-1]>gw){
            memo[n][gw] = knapsack(v,w,gw,n-1,memo);
        }else{
            memo[n][gw] = Math.max(knapsack(v,w,gw,n-1,memo),v[n-1]+knapsack(v,w,gw-w[n-1],n-1,memo));
        }
        return memo[n][gw];
    }

    public int knapsackTabulation(int[] v,int[] w,int gw,int n){
        if(v==null || w==null || v.length==0 || w.length==0) return 0;
        if(n==0 || gw==0) return 0;
        int[][] memo = new int[n+1][gw+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<gw+1;j++){
                if(i==0 || j==0){
                    memo[i][j] = 0;
                    continue;
                }
                if(w[i-1]>j){
                    memo[i][j] = memo[i-1][j];
                }else{
                    memo[i][j] = Math.max( memo[i-1][j],v[i-1]+memo[i-1][j-w[i-1]]);
                }
            }
        }
        return memo[n][gw];
    }

    /**
     * Optimal strategy for a game
     * Pick max point to win the game
     * Eg {25,5,4,6} o/p 30
     * @param arr
     * @return
     */
    public int pickPointRec(int[] arr,int start,int end){
        if(start+1==end){
            return Math.max(arr[start],arr[end]);
        }
        int totalPointIfPickStart = arr[start]+Math.min(pickPointRec(arr,start+2,end),pickPointRec(arr,start+1,end-1));
        int totalPointIfPickEnd = arr[end]+Math.min(pickPointRec(arr,start,end-2),pickPointRec(arr,start+1,end-1));
        return Math.max(totalPointIfPickStart,totalPointIfPickEnd);
    }
    public int pickPointMemo(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[][] memo = new int[arr.length][arr.length];
        pickPoint(arr,0,arr.length-1,memo);
        return memo[0][arr.length-1];
    }
    private int pickPoint(int[] arr,int start, int end,int[][] memo){
        if(start+1==end){
            return memo[start][end] = Math.max(arr[start],arr[end]);
        }
        if(memo[start][end]!=0) return memo[start][end];
        memo[start][end] = arr[start]+Math.min(pickPoint(arr,start+2,end,memo),pickPoint(arr, start+1, end-1, memo));
        memo[start][end] = Math.max(memo[start][end],arr[end]+Math.min(pickPoint(arr,start,end-2,memo),pickPoint(arr,start+1,end-1,memo)));
        return memo[start][end];
    }

    public int pickPointTabulation(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[][] memo = new int[arr.length][arr.length];

        for(int gap=1;gap<arr.length;gap=gap+2){
            for(int i=0;i+gap<arr.length;i++){
                int j=i+gap;
                if(i+1==j){
                    memo[i][j] = Math.max(arr[i],arr[j]);
                    continue;
                }
                memo[i][j] = Math.max(arr[i]+Math.min(memo[i+2][j],memo[i+1][j-1]),
                        arr[j]+Math.min(memo[i][j-2],memo[i+1][j-1]));
            }
        }
        return memo[0][arr.length-1];
    }

    /**
     * Egg Dropping Problem
     * Given n floors and k eggs
     * Find minimum number of tries to find the floor from which eggs will not break
     */
    public int eggDropRec(int floors,int eggs){
        //No floors or egg no trials
        if(floors==0 || eggs==0){
            return 0;
        }
        // If only one floor or 1 egg number of trials are number of floors
        if(floors==1 || eggs ==1){
            return floors;
        }
        int tries = Integer.MAX_VALUE;
        for(int i=1;i<=floors;i++){
            tries = Math.min(1+ Math.max(eggDropRec(i-1,eggs-1),eggDropRec(floors-i,eggs)),tries);
        }
        return tries;
    }

    public int eggDropTabulation(int floors,int eggs){
        int[][] memo = new int[floors+1][eggs+1];
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                if(i==0 || j==0){
                    memo[i][j]=0;
                    continue;
                }
                if(i==1 || j==1){
                    memo[i][j]=i;
                    continue;
                }
                memo[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<i;x++)
                    memo[i][j] = Math.min(memo[i][j],Math.max(memo[x-1][j-1],memo[i-x][j])+1);
            }
        }
        return memo[floors][eggs];
    }

    /**
     * Maximum Sum with no 2 consecutive elements of arr
     * @return
     */
    public int maxSum(int[] arr, int n){
        if(arr==null || arr.length==0) return 0;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        return Math.max(maxSum(arr,n-1),maxSum(arr,n-2)+arr[n-1]);
    }

    public int maxSumTabulation(int[] arr){
        if(arr==null || arr.length==0) return 0;
        int[] memo = new int[arr.length+1];
        memo[0] = 0;
        memo[1] = arr[0]; //n==1 // space can be optimized by just taking var sum_1
        memo[2] = Math.max(arr[0],arr[1]);//n==2 //space can be optimized by just taking var sum_2
        for(int i=3;i<=arr.length;i++){
            memo[i] = Math.max(memo[i-1],memo[i-2]+arr[i-1]); //res = Math.max(sum_2,sum_1+arr[i-1])
            // sum_1 = sum_2
            // sum_2 = res
        }
        return memo[arr.length]; //res
    }

    public int subsetWithSum(int[] arr, int sum,int idx){
        if(arr==null || arr.length==0) return 0;
        if(idx==0) {
            return sum == 0? 1:0;
        }
        int countWithIdx = subsetWithSum(arr,sum,idx-1);
        int countWithoutIdx = subsetWithSum(arr,sum-arr[idx-1],idx-1);
        return countWithIdx+countWithoutIdx;
    }

    public int subsetWithSumTab(int[] arr,int sum){
        if(arr==null || arr.length==0) return 0;
        if(sum==0) return 1;
        int[][] memo = new int[sum+1][arr.length+1];
        for(int i=0;i<=arr.length;i++) memo[0][i]=1;
        for(int i=1;i<memo.length;i++){
            for(int j=1;j<memo[0].length;j++){
                if(i-arr[j-1]>=0){
                    memo[i][j] = memo[i][j-1]+memo[i-arr[j-1]][j-1];
                }else{
                    memo[i][j] = memo[i][j-1];
                }
            }
        }
        return memo[sum][arr.length];
    }

}

