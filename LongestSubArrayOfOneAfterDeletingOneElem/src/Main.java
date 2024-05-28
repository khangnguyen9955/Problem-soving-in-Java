public class Main {
        public static int longestSubarray(int[] nums) {
            int deleteCount = 1;
            int startPointer = 0;
            for(int i =0 ; i < nums.length;i++)   {
                if (nums[i] == 0){
                    deleteCount--;
                }
                if(deleteCount < 0 && nums[startPointer++] == 0){ // cannot delete more but current num is 0 -> move the start
                    deleteCount++;
                }
            }
            return nums.length - startPointer - 1;
        }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int i = longestSubarray(new int[]{0,1,1,1,0,1,1,0,1});
    }

}