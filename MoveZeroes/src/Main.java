public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public void moveZeroes(int[] nums) {
//            int zeroSize = 0; // length of the zero
//            for (int i = 0; i < nums.length;i++){
//                if (nums[i] == 0)  {
//                    zeroSize++; // increase the size
//                }
//                else if (zeroSize > 0){ // if the size is > 0
//                    // swap the first 0 with the nums[i]
//                    nums[i-zeroSize] = nums[i];
//                    nums[i] = 0;
//                }
//            }
            // approach 2:
            // use the first loop to get push all the num
            // use the second loop to append the 0
            int zeroPointer= 0;
            for(int i = 0 ; i < nums.length; i++){
                if(nums[i] != 0) {
                    nums[zeroPointer++] = nums[i];
                }
            }

            for(;zeroPointer < nums.length; zeroPointer++){
                nums[zeroPointer] = 0;
            }
        }
    }
}