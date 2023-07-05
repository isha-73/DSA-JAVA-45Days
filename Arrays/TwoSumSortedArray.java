/*
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        

        int [] idx= new int[2];
        int head=0;
        int tail=n-1;

        while(head<=tail){
                if(numbers[head]+numbers[tail]==target) {
                    idx[0]=head+1;
                    idx[1]=tail+1;
                    return idx;
                }
                else if(numbers[head]+numbers[tail]>target){
                    tail--;
                }else head++;
        }
        return idx;
    }
}