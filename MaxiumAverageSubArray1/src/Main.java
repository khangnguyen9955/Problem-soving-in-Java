public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int i =0 ; i <nums.length;i++){
                sum += nums[i];
                if (i-k>=0) sum -= nums[i-k]; // remove the first num in window
                if (i +1 >= k) maxSum = Math.max(maxSum, sum); // enough nums -> update the max
            }
            return (double)maxSum/k;
        }
    }

    }