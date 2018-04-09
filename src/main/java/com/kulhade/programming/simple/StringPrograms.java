package com.kulhade.programming.simple;

import java.util.*;

/**
 * Created by vn05f93 on 3/11/18.
 * Some if the String problems are solved by Dynamic Programming
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
            throw new IllegalArgumentException("Incorrect index provided!!");
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
}
