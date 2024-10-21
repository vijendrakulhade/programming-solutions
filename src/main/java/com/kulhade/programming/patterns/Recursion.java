package com.kulhade.programming.patterns;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){

            return Arrays.asList(new ArrayList<>());
        }
        int first= nums[0]; //1 ,2 ,3
        int n = nums.length;
        int[] subArr = Arrays.copyOfRange(nums,1,nums.length); //{2,3} {3} {}
        List<List<Integer>> rres = subsets(subArr); // [[]] [[],[3]] [[],[2],[3],[2,3]] [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        List<List<Integer>> ans = new ArrayList();
        for(List<Integer> rr:rres){
            List<Integer> temp = new ArrayList();
            temp.addAll(rr);
            ans.add(temp);
            List<Integer> temp2 = new ArrayList();
            temp2.add(first);
            temp2.addAll(rr);
            ans.add(temp2);
        }
        return ans;
    }
    public void printPermutations(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            String ros = left+right;
            printPermutations(ros,ans+c);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return Arrays.asList(new ArrayList());
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int cn = nums[i];
            int[] rem = arrayCopyExcept(nums,i);
            List<List<Integer>> res  = permute(rem);
            for(List<Integer> e:res){
                e.add(cn);
                ans.add(e);
            }

        }
        return ans;

    }

    public static int[]  arrayCopyExcept(int[] in, int idx){
        int[] res = new int[in.length-1];
        int j=0;
        while(j<idx){
            res[j] = in[j];
            j+=1;
        }
        if(idx==j) j+=1;
        int i = j>0?j-1:0;
        while(i<res.length){
            res[i] = in[j];
            j+=1;
            i+=1;
        }
        return res;
    }
    public List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,res,new ArrayList());
        System.out.println(res);
        return res;
    }
    public void helper(int[] nums,int idx, List<List<Integer>> ans, List<Integer> asf){
        if(idx>=nums.length-1){
            List<Integer> ca = new ArrayList(asf);
            ans.add(ca);
            return;
        }

        for(int i=idx+1;i<nums.length;i++){
            helper(nums,i,ans,asf);
            asf.add(nums[idx]);
        }
    }
}
