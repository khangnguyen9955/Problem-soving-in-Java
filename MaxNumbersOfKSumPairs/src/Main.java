import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public int maxOperations(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count =0;
            for (int i =0 ;i <nums.length;i++){
                int res = k - nums[i];
                if (map.containsKey(res)){
                    count++;
                    // == 1 means we only have one nums[i] with that value
                    if(map.get(res) == 1){
                        // remove it out
                        map.remove(res);
                    }
                    // else, means we have mroe than nums[i] in the map, so minus it
                    else map.put(res,map.get(res)-1);
                }
                else{
                    // add the nums[i] as key, value will be 1 or its value +1 (if existed nums[i] already)
                    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                }
            }
            return count;
        }
    }
}