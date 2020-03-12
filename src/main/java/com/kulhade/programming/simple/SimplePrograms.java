package com.kulhade.programming.simple;

import com.kulhade.programming.entity.Interval;

import java.io.*;
import java.time.Period;
import java.util.*;

/**
 * Created by vn05f93 on 7/29/17.
 */
public class SimplePrograms<T extends Comparable<T>> {
    /**
     * This method will count the words in a String
     * @param line
     * @return
     */
    public long wordCount(String line){
        long count=0;
        line = line.trim();
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)==' ' && line.charAt(i-1)!=' '){
                count++;
            }
        }
        return count+1;
    }

    /**
     * This method will give count each char occurred in String/Array
     * @param line
     * @return
     */
    public int getCharacterCount(String line,Character toFindCount){
        char[] chars = line.toCharArray();
        HashMap<Character,Integer> charMap = new HashMap<Character, Integer>(chars.length);
        for(int i=0;i<chars.length;i++){
            if(charMap.containsKey(chars[i])){
                int count=charMap.get(chars[i]);
                charMap.put(chars[i],++count);
                continue;
            }
            charMap.put(chars[i],1);
        }
        return charMap.get(toFindCount);
    }

    /**
     * This method will encrypt the input String with below rules.
     * https://www.hackerrank.com/challenges/encryption/problem
     */
    public String encrypt(String input){
        int L=input.length();
        double num=Math.sqrt(Double.valueOf(L));
        int row=(int)Math.floor(num);
        int column=(int)Math.ceil(num);
        char[][] encryptArr=new char[row][column];
        char[] chars = input.toCharArray();
            for(int j=0;j<row;j++){
                for(int k=0;k<column;k++){
                    encryptArr[j][k]=chars[k];
                }

            }
        return "";
    }

    public Map<String,Integer> sortWithLastNameAppearance(File fullNames) throws IOException{
        Map<String,String> firstLastNameMap = new HashMap<String, String>();
        InputStream is = new FileInputStream(fullNames);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String fullName = buf.readLine();
        while(fullName!=null){
            String[] names = fullName.split(" ");
            firstLastNameMap.put(names[0],names[1]);
            fullName = buf.readLine();
        }

        List<Map.Entry<String, String>> sortedEntries = sortMap(firstLastNameMap);
        Map<String,Integer> countMap = new HashMap<String, Integer>();
        for(Map.Entry<String,String> entry:sortedEntries){
            if(countMap.containsKey(entry.getValue())){
                countMap.put(entry.getValue(),countMap.get(entry.getValue())+1);
                continue;
            }
            countMap.put(entry.getValue(),1);
        }
        return countMap;
    }

    public List<Map.Entry<String,String>> sortMap(Map<String,String> firstLastNameMap){
        if(firstLastNameMap==null){
            return null;
        }
        Comparator<Map.Entry<String, String>> valueComparator = new Comparator<Map.Entry<String,String>>() {
            public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        List<Map.Entry<String,String>> entries = new ArrayList<Map.Entry<String, String>>(firstLastNameMap.entrySet());
        Collections.sort(entries,valueComparator);
        return entries;
    }


    /**
     * Method will merge the overlapping Intervals for interval list
     * @param intervals
     */
    public void mergeIntervalList(List<Interval> intervals){
        if(intervals==null || intervals.isEmpty()){
            return;
        }

        Collections.sort(intervals,(i1,i2)->{return i1.getStart().compareTo(i2.getStart());});
        ListIterator<Interval> intervalIterator = intervals.listIterator();
        Interval prev = null;
        while(intervalIterator.hasNext()){
            if(intervalIterator.hasPrevious()){
                 prev = intervalIterator.previous();
                 intervalIterator.next(); //If iterator has previous, next and previous will be same
            }
            Interval next = intervalIterator.next();
            if(prev!=null && prev.getEnd().compareTo(next.getStart())>=0){
                prev.setEnd(this.max(prev.getEnd(),next.getEnd()));
                intervalIterator.remove();
            }
        }
    }

    public void insertInterval(List<Interval> intervals,Interval newInterval){
        if(intervals==null) return;
        if(intervals.isEmpty()) return;
        intervals.add(newInterval);
        mergeIntervalList(intervals);
       PriorityQueue<Character> q  =  new PriorityQueue<>(10,(o1, o2) -> {return 1;});
    }

    private Comparable<T> max(Comparable<T> first,Comparable<T> second){
        if(first.compareTo((T) second)>=0){
            return first;
        }else{
            return second;
        }
    }

    /**
     * Flip Count
     * @param inputString
     * @return
     */
    public int flipCountReturn(String inputString) {
        if (null == inputString) {
            return 0;
        }

        int flipC = 0;
        int yCount = 0;
        int xCount = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'x') {
                if (yCount > 0) {
                    flipC = flipC + 1;
                } else {
                    continue;
                }
            } else {
                if ((i < inputString.length() - 2 && inputString.charAt(i + 1) != 'y') || (i > 0 && inputString.charAt(i - 1) != 'y')) {
                    yCount = yCount + 1;
                }
            }
        }
        return Math.min(flipC,yCount);
    }
}
