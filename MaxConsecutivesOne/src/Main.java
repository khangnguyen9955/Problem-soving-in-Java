public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public int longestOnes(int[] nums, int k) {
            // using sliding window
            // keep sliding until k
            // remove the first 0
            // add new
            int max = 0;
            int zeroCount = 0;
            int startPointer = 0;
            for(int i =0 ; i<nums.length;i++){
                if (nums[i] == 0){
                    zeroCount++;
                }
                if(zeroCount > k ){
                    if(nums[startPointer]==0) zeroCount--; // if start pointer is 0 then minus 0 and conitnue slide
                    startPointer++; // slide
                }
                max = Math.max(max,i-startPointer+1);
            }
            return max;


        }
    }
}