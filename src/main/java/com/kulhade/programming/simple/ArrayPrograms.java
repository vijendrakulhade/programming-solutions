package com.kulhade.programming.simple;

import java.util.*;

/**
 * Created by vn05f93 on 10/5/17.
 */
public class ArrayPrograms {
    /**
     * method will search insert position of target or expected insert position
     * in a sorted array
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertPosition(int[] nums,int target){
        if(nums==null || nums.length==0) return 0;
        int start = 0;
        int end = nums.length-1;
        int m = 0;
        if(target>nums[end]){
            return end+1;
        }
        while(start<end){
            m = (start+end)/2;
            if(nums[m]<target){
                start = m;
            }else if(nums[m]==target){
                return m;
            }else{
                end = m;
            }
        }
        return m;
    }
    /**
     * Method will sort the array by using reverse method which will be actually reversing
     * the specific elements only
     * @See reverse
     * @param arr
     * @return
     */
    public int[] pancakeSort(int[] arr){
        int length = arr.length;
        while(length>0){
            int index_highest = findMaxIndex(arr,length);
            arr = reverse(arr,index_highest+1);
            arr = reverse(arr,length);
            length--;
        }
        return arr;
    }
    /**
     * Method will return triplets with sum 0
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        if(nums==null || nums.length <3){
            return null;
        }
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums); //Dual Pivot Quick Sort O(n log n)
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> pair = new ArrayList<>(3);
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    pair.add(nums[k]);
                    result.add(pair);
                    j++;k--;
                    //Handle Duplicate
                }else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
    /**
     * Method will return indexes with target sum in any unsorted/sorted array.
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target){
        if(numbers==null) return null;
        if(numbers.length==0) return null;
        int[] result = new int[2];
        HashMap<Integer,Integer> mem = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(mem.containsKey(numbers[i])){
                result[0]=mem.get(numbers[i]);
                result[1]=i+1;
                return result;
            }
            mem.put(target-numbers[i],i+1);
        }
        return null;
    }
    /**
     * Method will return indexes with target sum in sorted array
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumSortedInput(int[] numbers,int target){
        if(numbers==null) return null;
        if(numbers.length==0) return null;
        int i=0, j=numbers.length-1;
        while(i<j){
            int x = numbers[i]+numbers[j];
            if(x<target){
                i++;
            }else if(x>target){
                j--;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        return null;
    }
    /**
     * Method evaluates the polish notation
     * @param expressionInPolishNotation
     * @return
     */
    public Integer evaluate(char[] expressionInPolishNotation){
        Deque<Integer> stack  = new ArrayDeque<Integer>();
        String operators = "+-*/";
        for(char c:expressionInPolishNotation){
            if(!operators.contains(String.valueOf(c))){
                stack.push(Integer.parseInt(String.valueOf(c)));
            }else{
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (String.valueOf(c)) {
                    case "+" :
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * Method will reverse/flip first k elements
     * @param nums
     * @param right
     * @return nums
     */
    public int[] reverse(int[] nums,int right){
        if(nums==null || nums.length==0){
            return null;
        }
        if(right<0){
            throw new IllegalArgumentException("Incorrect index provided!!");
        }
        int left = 0;
        while(left<right-1){
            int temp = nums[left];
            nums[left]= nums[right-1];
            nums[right-1] = temp;
            left++;right--;
        }
        return nums;
    }
    /**
     * Method will reverse the input array in place
     * @param nums
     * @param left
     * @param right
     */
    public void reverse(int[] nums,int left,int right){
        if(nums==null || nums.length==0){
            return;
        }
        if(right<left){
            throw new IllegalArgumentException("Incorrect index provided!!");
        }
        while(left<right){
            int temp = nums[left];
            nums[left]= nums[right];
            nums[right] = temp;
            left++;right--;
        }
    }

    /**
     * Method will rotate array in place
     * @param nums
     * @param k
     */
    public void rotateInPlace(int[] nums,int k){
        if(nums==null || k<0){
            throw new IllegalArgumentException("Illegal Arguments");
        }
        if(nums.length==0 || k==0){
            return ;
        }
        int a = nums.length-k;
        reverse(nums,0,a-1);
        reverse(nums,a,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    /**
     * Method will rotate an array by k step
     * clock wise rotate i.e. last k element
     * Eg. [1,2,3,4,5,6,7] k=3 --> [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     * @return
     */
    public int[] rotate(int[] nums,int k){
        if(nums==null || k<0){
            throw new IllegalArgumentException("Illegal Arguments");
        }
        if(nums.length==0 || k==0){
            return nums;
        }
        int[] result = new int[nums.length];
        for(int i=0;i<k;i++){
            result[i] = nums[nums.length-k+i];
        }
        int j=0;
        for(int i=k;i<nums.length;i++){
            result[i]=nums[j++];
        }
        return result;
    }

    public int[] rotateLeftToRight(int[] nums,int k){
        if(nums==null || k<0){
            throw new IllegalArgumentException("Illegal Arguments");
        }
        if(nums.length==0 || k==0){
            return nums;
        }
        int[] result = new int[nums.length];
        int i=0;
        for(;i<nums.length-k;i++){
            result[i] = nums[k+i];
        }

        for(int j=0;j<k;j++){
            result[i]=nums[j];
            i++;
        }


        return result;
    }

    public int findMaxIndex(int[] arr,int length){
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int i=0;i<length;i++){
            if(arr[i]>max){
                max = arr[i];
                max_index = i;
            }
        }
        return max_index;
    }

    /**
     * Method will give set bits count of number
     * Brain Karnighan's Algorithm
     * Eg. 5 --> 0101 --> set bits 2
     * @param number
     * @return
     */
    public int findSetCountBit(int number){
        int setBitCount=0;
        while(number>0){
            number&=number-1;
            setBitCount++;
        }
        return setBitCount;
    }
    /**
     * This method will find a unique element in the Array
     * When other elements appears 2 time
     * Eg. {5,4,6,9,4,5,6} = 9
     * @param array
     * @return
     */
    public int findUniqueElement(int[] array){
        int num = 0;
        for(int i=0;i<array.length;i++){
            num ^= array[i];
        }
        return num;
    }

    /**
     * This method will find the unique element in Array
     * When other elements appears n times
     * Eg. {5,4,6,5,9,4,4,6,5,6} = 9
     * @param array
     * @param countOtherElementAppeared
     * @return
     */
    public int findUniqueElement(int[] array,int countOtherElementAppeared){
        int[] countBitSet = new int[32];
        int num = 0;
        for(int i=0;i<array.length;i++){
            int[] temp_arr = toBinary(array[i],32);
            sumCountSetBit(temp_arr,countBitSet);
        }
        // mod countSetBit elements by countOtherElementAppeared
        for (int i=0;i<countBitSet.length;i++){
            countBitSet[i]=countBitSet[i]%countOtherElementAppeared;
        }

        return toDecimal(countBitSet);
    }

    /**
     * Method will convert Integer to Binary and return binary bits in a array
     * @param number
     * @param length
     * @return
     */
    public  static int[] toBinary(int number, int length) {
        final int[] binary_digits = new int[length];
        for (int i = 0; i < length; i++) {
            binary_digits[length - 1 - i] = (1 << i & number) != 0?1:0;
        }
        return binary_digits;
    }

    /**
     * Method will convert  Binary to Decimal
     * @param binary_digits
     * @return
     */
    public static int toDecimal(int[] binary_digits) {
        int decimal_number = 0;
        for (int i = 0; i < binary_digits.length; i++) {
            decimal_number = decimal_number << 1  | binary_digits[i];
        }
        return decimal_number;
    }

    private void sumCountSetBit(int[] binary_arr,int[] countSetBit){
        if(binary_arr.length!=countSetBit.length){
            return ;
        }
        for(int i=0;i<countSetBit.length;i++){
            countSetBit[i]+=binary_arr[i];
        }
    }
    /**Array Jump Game
     * This method will check the end of the array with index jump
     * [2,1,0,4,3] return false;
     * [3,3,0,0,0] return true; complexity 2^n
     * @param numbers
     * @param index
     * @return
     */
    public boolean jump(int[] numbers,int index){
        if(numbers.length==0){
            return false;
        }else if(numbers.length==1){
            return true;
        }else if(index == numbers.length-1){
            return true;
        }

        int num_at_index = numbers[index];
        int max_allowed_jump = Math.min(num_at_index+index,numbers.length-1);
        if(max_allowed_jump==index){
            return false;
        }

        for(int i=max_allowed_jump;i>index;i--){
            if(jump(numbers,i)){
                return true;
            }
        }
        return false;
    }

    /**Array Jump Game
     * This method will check the end of the array with index jump
     * [2,1,0,4,3] return false;
     * [3,3,0,0,0] return true; complexity n^2
     * @param numbers
     * @return
     */
    public boolean jump_memorization(int[] numbers){

        boolean[] memo = new boolean[numbers.length];
        memo[numbers.length-1]=true;
        if(numbers.length==0){
            return false;
        }else if(numbers.length==1){
            return true;
        }
        return jump_recursion(numbers,0,memo);
    }

    private boolean jump_recursion(int[] numbers,int index,boolean[] memo){
        if(memo[index]){
            return true;
        }

        int num_index = numbers[index];
        int max_allowed_jump = Math.min(num_index+index,numbers.length-1);
        if(max_allowed_jump==index){
            return false;
        }
        for(int i=max_allowed_jump;i>index;i--){
            if(jump_recursion(numbers,i,memo)){
                memo[i]=true;
                return true;
            }
        }
        return false;
    }

    /**
     * Method will print all possible subsets of a given set
     * @param superset
     * @return
     */
    public List<List<Integer>> allSubsets(int[] superset){
        if(superset==null || superset.length==0) return null;
        int n = superset.length;
        List<List<Integer>> allSubsets = new ArrayList<>();
        if(n==1){
            allSubsets.add(Arrays.asList(superset[0]));
            return allSubsets;
        }
        for(int i=0;i<1<<n;i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j)) > 0){
                    subset.add(superset[j]);
                }
            }
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    public int findMinInRotatedSortedArray(int[] arr){
        if(arr==null || arr.length==0) throw new IllegalArgumentException("Illegal Argument");
        if(arr.length==1)return arr[0];
        return findMin(arr,0,arr.length-1);
    }

    private int findMin(int[] arr,int i,int j){
        if(j-i==1) return Math.min(arr[i],arr[j]);
        int middle =i+(j-i)/2;
        if(arr[i]<arr[j]){ //not rotated
            return arr[i];
        }else if(arr[middle]>arr[i]){
           return findMin(arr,middle,j);
        }else{
            return findMin(arr,i,middle);
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length<=1) return 0;
        int start=0;
        int end = nums.length-1;
        int i=1;
        while(i<=end){
            if(nums[start]==nums[i]){
                i++;
            }else{
                start++;
                nums[start]=nums[i++];
            }
        }
        return start+1;

    }

}
