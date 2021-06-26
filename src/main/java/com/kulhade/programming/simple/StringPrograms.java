package com.kulhade.programming.simple;

import java.util.*;


/**
 * Created by vn05f93 on 3/11/18.
 * Some of the String problems are solved by Dynamic Programming
 */
public class StringPrograms {

    public int wordLadderCount(String start,String end,Set<String> dict){
        if(dict.size()==0) return 0;
        dict.add(end);
        Deque<String> wordStack = new LinkedList<>();
        Deque<Integer> distance = new LinkedList<>();
        wordStack.add(start);
        distance.add(1);
        int result = Integer.MAX_VALUE;
        while(!wordStack.isEmpty()) {
            String currentWord = wordStack.pop();
            int currentDis = distance.pop();
            if (currentWord.equalsIgnoreCase(end)) {
                result = Math.min(currentDis, result);
            } else {
                for (int i = 0; i < currentWord.length(); i++) {
                    char[] currCharArr = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        currCharArr[i] = c;
                        String newWord = new String(currCharArr);
                        if (compareDictionary(dict,newWord)) {
                            wordStack.add(newWord);
                            distance.add(currentDis + 1);
                            dict.remove(newWord);
                        }
                    }
                }
            }
        }
        if(result<Integer.MAX_VALUE) return result;
        else return 0;
    }

    private boolean compareDictionary(Set<String> dict,String word){
        boolean same = false;
        Iterator<String> iterator = dict.iterator();
        while(iterator.hasNext()){
            String s= iterator.next();
            if(s.equalsIgnoreCase(word)){
                dict.remove(s);
                return true;
            }
        }
        return same;
    }
    /**
     * Method will form a sentence from given words based on dictionary
     * Eg "catsanddog" dic=["cat","cats","and","sand","dog"]
     * Output ["cats and dog","cat sand dog"]
     * @param words
     * @param dic
     * @return
     */
    public List<String> formSentence(String words,Set<String> dic){
        if(words.length()==0){
            throw new IllegalArgumentException("Illegal argument");
        }
        Map<String,List<String>> memory = new HashMap<>();
        return breakTheWord(words,dic,memory);
    }

    private List<String> breakTheWord(String str,Set<String> dic,Map<String,List<String>> m){
        if(m.containsKey(str)) return m.get(str);
        List<String> result = new ArrayList<>();
        if(str.length()==0){
            result.add("");
            return result;
        }
        for(int i=str.length();i>=0;i--){
            String temp = str.substring(i);
            if(dic.contains(temp)){
                List<String> tempList = breakTheWord(str.substring(0,i),dic,m);
                for(String s:tempList){
                    if(s.equals("")) result.add(temp);
                    else result.add(s+" "+temp);
                }
            }
        }
        m.put(str,result);
        return result;
    }

    /**
     * Method will check if  word is breakable with a specific dictionary
     * @param word
     * @param dic
     * @return
     */
    public boolean isWordBreakable(String word,Set<String> dic){
        if(word == null || dic ==null) throw new IllegalArgumentException("Illegal Input");
        boolean[] t = new boolean[word.length()+1];
        t[0]=true;
        for(int i=0;i<word.length();i++){
            if(!t[i]) continue;
            for(String a: dic){
                int len = a.length();
                int end = len+i;
                if(end>word.length()) continue;
                if(t[end]) continue;
                if(word.substring(i,end).equals(a)){
                    t[end]=true;
                }
            }
        }
        return t[word.length()];
    }

    /**
     * Method reverse the String with space
     * @param arr
     * @return
     */
    public char[] reverseWithSpace(char[] arr){
        if(arr==null || arr.length==0) return arr;
        reverse(arr,0,arr.length-1);
        for(int i=0,j=0;j<arr.length;j++){
            if(arr[j]!=' ' && j!=arr.length-1){
                continue;
            }else if(j==arr.length-1){
                reverse(arr,i,j);
            }else{
                reverse(arr,i,j-1);
            }
            i=j+1;
        }
        return arr;
    }
    public void reverse(char[] nums,int left,int right){
        if(nums==null || nums.length==0){
            return;
        }
        if(right<left){
            return;
        }
        while(left<right){
            char temp = nums[left];
            nums[left]= nums[right];
            nums[right] = temp;
            left++;right--;
        }
    }
    /**
     * Method returns the longest palindrome substring
     * @param str
     * @return
     */
    public String longestPalindrome(String str){
        if(str==null || str.length()==0){
            throw new IllegalArgumentException("Illegal Input String");
        }
        String longest = str.substring(0,1);
        for(int i=0;i<str.length();i++){
            String temp = helper(str,i,i);
            if(temp.length()>longest.length()){
                longest = temp;
            }
            temp = helper(str,i,i+1);
            if(temp.length()>longest.length()){
                longest = temp;
            }
        }
        return longest;
    }

    private String helper(String str,int begin,int end){
        while(begin>=0 && end <=str.length()-1 &&
                str.charAt(begin)==str.charAt(end)){
            begin--;end++;
        }
        return str.substring(begin+1,end);
    }

    /**
     * Mthod will provide count of unique chars substring
     * @param s
     * @return length of substring with unique chars
     */
    public int longestUniqueCharSubstring(String s){
        if(s==null) return 0;
        if(s.length()<=1) return 1;
        int max = 0;
        int start=0;
        Map<Character,Integer> memo = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(memo.containsKey(c) && memo.get(c)>=start){
                start = memo.get(c)+1;
            }
            memo.put(c,i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }

    /**
     * Method will return longest common prefix String
     * @param strs
     * @return longest prefix substring
     */
    public String longestCommonPrefix(String[] strs){
        if(strs==null || strs.length==0) return "";
        String lcp = strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            String curr = strs[i];
            while(j<lcp.length() && j<curr.length() && lcp.charAt(j)==curr.charAt(j)){
                j++;
            }
            if(j==0) return "";
            lcp = curr.substring(0,j);
        }
        return lcp;
    }

    public List<List<String>> palindromePartitions(String s){
        if(s==null) return null;
        List<List<String>> result = new ArrayList<>();
        if(s.length()<=1){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            result.add(temp);
            return result;
        }
        List<String> current = new ArrayList<>();
        //Method to iterate String and backtrack it recursively
        partitions(s,0,current,result);
        return result;
    }

    private void partitions(String s,int index,List<String> current,List<List<String>> result){
        if(current.size()>0 &&s.length()<=index){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                current.add(s.substring(index,i+1));
                partitions(s,i+1,current,result);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    /**
     * Method matches for regular expression with . and *
     * . matches single char
     * * matches all preceding similar chars.
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        print(dp);
        return dp[s.length()][p.length()];

    }

    public void print(boolean[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void print(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int[] result = new int[5];
        Arrays.asList(result);
    }

    /**
     * Group Anagram
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0) return new ArrayList();
        Map<String,List<String>> m = new HashMap();
        for(String s:strs){
            char[] chars = new char[26];
            for(char c:s.toCharArray()){
                chars[c-'a'] = c;
            }
            String key = new String(chars);
            if(!m.containsKey(key)){
                m.put(key,new ArrayList());
            }
            m.get(key).add(s);
        }
        List<List<String>> result = new ArrayList();
        for(List<String> grp:m.values())
            result.add(grp);
        return result;
    }

    /**
     * Given two strings S and T, return if they are equal when both are typed into empty text editors.
     * # means a backspace character.
     * S = "ab#c", T = "ad#c" o/p true
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        if(S==null && T==null) return true;
        if(S==null || T==null) return false;

        Deque<Character> S_stack = new ArrayDeque<Character>();
        Deque<Character> T_stack = new ArrayDeque<Character>();
        int i=0,j=0;
        while(i<S.length() || j<T.length()){
            if(i>=0 && S.charAt(i)=='#'){
                if(!S_stack.isEmpty()) S_stack.pop();
            }else{
                S_stack.push(S.charAt(i));
            }

            if(j>=0 && T.charAt(j)=='#'){
                if(!T_stack.isEmpty()) T_stack.pop();
            }else{
                T_stack.push(T.charAt(j));
            }
            i++;j++;
        }

        if(S_stack.size() !=T_stack.size()) return false;
        for(int k=0;k<S_stack.size();k++){
            if(S_stack.pop()!=T_stack.pop()){
                return false;
            }
        }
        return true;
    }

    /**
     * Find first repeating char's Index
     * geeksforgeeks ans 0
     * @param s
     * @return
     */
    public int findFirstRepeatingCharIndex(String s){
        if(s==null || s.length()==0) return -1;
        int[] chars = new int[256];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<256;i++) chars[i]=-1;
        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)]==-1){
                chars[s.charAt(i)]=i;
            }else{
                res = Math.min(res,chars[s.charAt(i)]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    /**
     * Find first non repeating char
     * @param s
     * @return
     */
    public int findFirstNonRepeatingCharIndex(String s){
        if(s==null || s.length()==0) return -1;
        int[] chars = new int[256];
        for(int i=0;i<256;i++){
            chars[i]=-1;
        }
        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)]==-1){
                chars[s.charAt(i)] = i;
            }else{
                chars[s.charAt(i)] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<256;i++){
            if(chars[i]>=0){
                res = Math.min(res,chars[i]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    /**
     * Find the lexicographical rank given string
     * in all the permutation of sorted string
     * @param s
     * @return
     */
    public int lexicographicalRank(String s){
        if(s==null ||s.length()==0) return 0;
        int rank = 1;
        int n=s.length();
        Long fact = factorial(n);
        int[] count = new int[256];
        //store the frequency of each char in String;
        for(int i=0;i<n;i++){
            count[s.charAt(i)]++;
        }
        //store the Cumulative frequency of each char and its lesser in String;
        //Eg B = FreqOf(B)+FreqOf(A)
        for(int i=1;i<256;i++){
            count[i] = count[i]+count[i-1];
        }
        for(int i=0;i<n;i++){
            fact = fact/(n-i);
            if(count[s.charAt(i)-1]>=0)
                rank = rank+count[s.charAt(i)-1]* fact.intValue();
            for(int j=s.charAt(i);j<256;j++)
                count[j]--;
        }
        return rank;
    }

    private long factorial(int n){
        long fact = 1;
        while(n>1){
            fact*=n--;
        }
        return fact;
    }

    public boolean isPalindromicPattern(String s,String p){
        if(s==null || p==null){
            return false;
        }
        if(s.length()==0 && p.length()==0){
            return true;
        }
        if(s.length()==0 || p.length()==0){
            return false;
        }
        int[] countTextW = new int[256];
        int[] countPatW = new int[256];
        for(int i=0;i<p.length();i++){
            countTextW[s.charAt(i)]++;
            countPatW[p.charAt(i)]++;
        }
        for(int i=p.length();i<s.length();i++){
            if(areSame(countTextW,countPatW)){
                return true;
            }
            countTextW[s.charAt(i)]++;
            countTextW[s.charAt(i-p.length())]--;
        }
        return false;
    }

    private boolean areSame(int[] arr1,int[] arr2){
        if(arr1.length!=arr2.length) return false;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }

    public boolean checkIfCanBreak(String s1,String s2){
        if(s1==null || s1.length()== 0) return true;
        if(s2==null || s2.length()== 0) return false;
        char[] a_chars = s1.toCharArray();
        char[] b_chars = s2.toCharArray();
        Arrays.sort(a_chars);
        Arrays.sort(b_chars);
        boolean flag = true;
        for(int i=0;i<a_chars.length;i++){
            if(a_chars[i]<b_chars[i]){
                flag = false;
                break;
            }
        }
        if(flag) return flag;
        for(int i=0;i<b_chars.length;i++){
            if(a_chars[i]>b_chars[i]){
                return false;
            }
        }
        return true;
    }
}
