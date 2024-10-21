package com.kulhade.programming.simple;


import java.util.*;

import static com.kulhade.programming.simple.BitManipulation.toBinary;
import static com.kulhade.programming.simple.BitManipulation.toDecimal;

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
        while(start<=end){
            m = start+(end-start)/2;
            if(nums[m]<target){
                start = m+1;
            }else if(nums[m]==target){
                return m;
            }else{
                end = m-1;
            }
        }
        return start;
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
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> pair = new ArrayList<>(3);
                        pair.add(nums[i]);
                        pair.add(nums[j]);
                        pair.add(nums[k]);
                        result.add(pair);
                        j++;
                        k--;
                        //Handle Duplicate
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
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
    public int[] rotate(int[] nums,int k) throws IllegalArgumentException{
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

    /**
     * move all zeros to right
     */

    public void moveZeroesRight(int[] nums) {
        if(nums==null || nums.length==0) return;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }

    }

    /**
     * move all zeros to left
     */

    public void moveZerosLeft(int[] nums) {
        if(nums==null || nums.length==0) return;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }

    }

    public class ListContainer implements Comparable{

        private List<Integer> list;
        private int index;

        public ListContainer(List<Integer> list,int index){
            this.list = list;
            this.index= index;
        }


        @Override
        public int compareTo(Object o) {
            ListContainer i = (ListContainer) o;
            return this.list.get(index) - i.list.get(i.index);
        }
    }
    /**
     * Merge K sorted Arrays
     */
    public List<Integer> mergeKSortedList(List<List<Integer>> lists){
        List<Integer> result = new ArrayList<>();
        PriorityQueue<ListContainer> q = new PriorityQueue<>(lists.size());
        for(List<Integer> list:lists){
            ListContainer container = new ListContainer(list,0);
            q.offer(container);
        }

        while(!q.isEmpty()){
            ListContainer container = q.poll();
            result.add(container.list.get(container.index));
            if(container.index < container.list.size()-1)
                q.offer(new ListContainer(container.list,container.index+1));
        }

        return result;
    }

    int[] cellCompete(int[] stats,int days){
        int[] result = new int[stats.length];
        for(int i=0;i<days;i++){
            result[0]=0^stats[0];
            for(int j=1;j<stats.length-1;j++){
                result[j]=stats[j-1]^stats[j+1];
            }
            result[stats.length-1]=0^stats[stats.length-2];
            stats = result;
        }
        return result;
   }

    /**
     * Stock buy sell when multiple txn allowed
     * get all the price pairs
     */
    public static class Pair<U,V>{
        U a;
        V b;
        public Pair(U i,V j){
            a=i;
            b=j;
        }
        public U getA(){
            return a;
        }
        public V getB(){
            return b;
        }
    }
    public List<Pair> stockBuySell(int[] prices){
        if(prices==null || prices.length==0)
            return new ArrayList<>();

        int localMin = Integer.MAX_VALUE;
        int localMax = Integer.MIN_VALUE;

        List<Pair> result = new ArrayList<>();
        for(int i = 0; i<prices.length;i++){
            if(prices[i]>localMax){
                localMax = prices[i];
            }else if(prices[i]<localMin){
                localMin = prices[i];
            }else{
                result.add(new Pair(localMin,localMax));
                localMin = prices[i];
                localMax = Integer.MIN_VALUE;
            }
        }
        result.add(new Pair(localMin,localMax));
        return result;
    }

    /**
     * Kandan's Algorithm
     * Find the max sum with contiguous elements from array
     * {-2,1,-3,4,-1,2,1,-5,4} o/p 6 {4,-1,2,1}
     * @param arr
     * @return
     */
    public int maxSubarraySum(int[] arr){
        if(arr==null || arr.length==0)
            return 0;

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        int maxElem = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxEndHere = Math.max(0,maxEndHere+arr[i]);
            maxSoFar = Math.max(maxSoFar,maxEndHere);
            maxElem = Math.max(maxElem,arr[i]);
        }
        if(maxSoFar==0) return maxElem;
        return maxSoFar;
    }

    /**
     * Merge sort Top Down implementation
     * @param input
     * @return
     */
    public int[] merge_sort(int[] input){
        if(input==null || input.length<=1) return input;
        int pivot = input.length/2;
        int[] left = merge_sort(Arrays.copyOfRange(input,0,pivot));
        int[] right = merge_sort(Arrays.copyOfRange(input,pivot,input.length));
        return merge(left,right);
    }

    private int[] merge(int[] left,int[] right){
        int left_i=0,right_i=0,i=0;
        int[] res = new int[left.length+right.length];
        while(left_i<left.length || right_i<right.length){
            if(left_i<left.length && right_i<right.length){
                if(left[left_i]<right[right_i]){
                    res[i++] = left[left_i++];
                }else{
                    res[i++] = right[right_i++];
                }
                continue;
            }
            if(left_i<left.length){
                res[i++] = left[left_i++];
            }
            if(right_i<right.length){
                res[i++] = right[right_i++];
            }
        }
        return res;
    }

    /**
     * Search in a rotated sorted array
     */
    public int searchInRotatedSorted(int[] nums,int target){
            if(nums==null || nums.length==0) return -1;
            int l=0,r=nums.length-1;
            while(l<=r){
                int m = (l+r)/2;
                if(nums[m]==target) return m;
                if(nums[m]<=nums[r]){
                    if(nums[m]<target && target>=nums[r]){
                        l = m+1;
                    }else{
                        r = m-1;
                    }
                }else{
                    if(nums[l] <=target && nums[m]>target){
                        r = m-1;
                    }else{
                        l=m+1;
                    }
                }
            }
            return -1;
        }

    /**
     * Sliding window Maximum
     * return all the maximum on sliding windows
     */
    public int[] slidingWindowMax(int[] nums,int k){
        if(nums==null || nums.length==0) return nums;
        int n =  nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int j=0;
        for(int i=0;i<n;i++){
            while (!dq.isEmpty() && dq.peek()<=i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.add(i);
            if(i>=k-1){
                res[j++] = nums[dq.peek()];
            }
        }

        return res;


    }

    public float[] slidingWindowAvg(int[] input, int k){
        if(input==null || input.length==0){
            return null;
        }
        float[] result = new float[input.length-k+1];
        if(k==1){
            for(int i=0;i<input.length;i++){
                result[i]=input[i];
            }
            return result;
        }
        float sum=0;
        int i=0;
        for(;i<k;i++){
            sum+=input[i];
        }
        result[i-k]=sum/k;
        for(;i<input.length;i++){
            sum += input[i]-input[i-k];
            result[i-k+1]=sum/k;
        }
        return result;

    }

    /**
     * Smallest Sub array size for a given Sum
     */
    int smallestSubArrSizeSum(int[] arr,int sum){
        if(arr==null || arr.length==0){
            return 0;
        }
        int start=0,end=0,minSize=Integer.MAX_VALUE,wSum=0;
        for(;end<arr.length;end++){
            wSum +=arr[end];
            while(wSum>=sum){
                wSum -= arr[start];
                minSize = Math.min(minSize,(end-start+1));
                start++;
            }
        }
        return minSize;
    }
    /**
     * Convert all 0 to 5
     */
    int convertFive(int num) {
        // Your code here
        if(num<0) throw new IllegalArgumentException("Only Positive Number expected");
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='0')
                chars[i]='5';
        }
        return Integer.parseInt(new String(chars));
    }
    /**
     * Majority element
     * One Element appeared more than n/2 times
     */
    public int majority(int[] arr){
        int count=0,major=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                major = arr[i];
            }
            if(major==arr[i]){
                count++;
            }else{
                count--;
            }
        }
       return  major;
    }

    /**
     * Majority elements
     * Element appeared more than n/3 times
     * [1,1,1,3,3,2,2,2]
     */
    public List<Integer> majority2(int[] arr){
        if(arr==null || arr.length==0) return null;
        List<Integer> res = new ArrayList<>();
        int maj1=arr[0];int maj2=Integer.MIN_VALUE;
        int count1=1,count2=0;
        for(int j=1;j<arr.length;j++){
            if(maj1==arr[j]){
                count1++;//3
            }else if(maj2==arr[j]){
                count2++;
            }else if(count1==0){
                maj1=arr[j];//2
                count1=1;
            }else if(count2==0){
                maj2=arr[j];//3,2
                count2=1;
            }else{
                count1--;//2,1
                count2--;//0,0
            }
        }

        //Check if count is greater than n/3
        int n=arr.length;
        count1=0;count2=0;
        for(int i=0;i<n;i++){
            if(maj1==arr[i]) count1++;
            else if(maj2==arr[i]) count2++;
        }
        if(count1>n/3) res.add(maj1);
        if(count2>n/3) res.add(maj2);
        return res;
    }


    public int carFleet(int target, int[] position, int[] speed) {
        double[][] car = new double[position.length][2];
        for(int i=0;i<position.length;i++){
            car[i][0] = position[i]*1d;
            car[i][1] = (target-position[i])*1d/speed[i];
        }
        Arrays.sort(car,(a,b)->(Double.compare(a[0],b[0])));
        double tt = car[car.length-1][1];
        int res = 1;
        for(int i=car.length-2;i>=0;i--){
            if(car[i][1]>tt){
                res+=1;
                tt = car[i][1];
            }
        }
        return res;
    }

}
