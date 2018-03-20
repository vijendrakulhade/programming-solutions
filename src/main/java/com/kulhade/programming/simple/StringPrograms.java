package com.kulhade.programming.simple;

/**
 * Created by vn05f93 on 3/11/18.
 */
public class StringPrograms {

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
