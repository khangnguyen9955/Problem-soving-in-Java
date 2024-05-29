public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
        public int pivotIndex(int[] nums) {
            if(nums.length==1){
                return 0;
            }
            if(nums == null || nums.length == 0){
                return -1;
            }
            int i =0;
            int j = nums.length-1;
            int leftSum=0;
            int rightSum = 0;
            // calculate all right sum
            while(j > 0 ){
                rightSum += nums[j];
                if(rightSum == leftSum ){
                    // if right sum == left sum = 0
                    if(j==1){
                        // if j = 1 and left sum = 0
                        // return the zero index since there is no left sum
                        return j-1;}
                }
                j--;
            }
            // calculate all left sum
            while(i<nums.length-1){
                leftSum += nums[i];
                // minus the next element from right sum
                rightSum -=nums[i+1];
                if(leftSum == rightSum){ // if left sum == right sum
                    // next elem is the pivot index
                    return i+1;
                }
                i++;

            }
            return -1;
        }
}