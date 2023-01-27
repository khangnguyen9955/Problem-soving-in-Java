package com.company;

import java.util.*;

public class Test1 {


 public  static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

}
        public static int kthSmallest(int[][] matrix, int k) {
            int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
            while(lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = 0, j = matrix[0].length - 1;
                for(int i = 0; i < matrix.length; i++) {
                    while(j >= 0 && matrix[i][j] > mid) j--;
                    count += (j + 1);
                }
                if(count < k) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }

    public static int numSplits(String input) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int ans = 0;
        int count = 0;
        for(char c : input.toCharArray()) right.put(c, right.getOrDefault(c, 0) + 1);
        for(char c : input.toCharArray()) {
// Move character from right to left
            right.put(c, right.getOrDefault(c, 0) - 1);
            left.put(c, left.getOrDefault(c, 0) + 1);
            if(right.get(c) == 0) {
                count++;
            }
// Compare unique characters
            if((right.size() - count) == left.size()) ans++;
        }
        System.out.println(ans);
        return ans;
    }

    public static String minWindow(String s, String t) {
        // initialize the array with index of every char in T has value +1;
        int [] arr = new int [128];
        for(char c: t.toCharArray()){
            arr[c]++;
        }
        // slide window
        int windowStart = 0 ;
        int count = t.length();
        int minStart = 0; // store the start index
        int minLength = Integer.MAX_VALUE; // store the min length;
        for(int windowEnd = 0 ; windowEnd < s.length();windowEnd++){
            char c1 = s.charAt(windowEnd);
            // if we found that s.charAt(windowEnd) in T we minus count and minus that value in T by 1;
            if(arr[c1] > 0) count--;
            arr[c1]--;
            // valid
            while (count == 0){
                // store the string
                // store the length;
                if(minLength > windowEnd - windowStart + 1){
                    minLength = windowEnd - windowStart + 1;
                    minStart = windowStart;
                }
                // shrink
                char c2 = s.charAt(windowStart);
                arr[c2]++;
                // if that char is the char we need to find then our counter need to be plus 1
                if( arr[c2] > 0) count++;
                windowStart++;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);

    }


    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int [] dp = new int [target+1];
        Arrays.fill(dp,-1);// fill -1 into arrays
        dp[0] = 1;  // first index will be 1
        return dynamicProg(nums,target,dp);
    }

    public static int dynamicProg(int[] nums, int target, int [] dp){
        if(target < 0 ) return 0; // zero solution
        if(dp[target] >=0) return dp[target]; // if exist solution in dp array, return it
        int count = 0;
        for (int i  = 0 ;i < nums.length;i++){
            count+= dynamicProg(nums,target - nums[i], dp);
        }
        dp[target]= count;  // assign the solution to dp
        return count;
    }

      public static class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }
    class Solution {
        public static ListNode reverseKGroup(ListNode head, int k) {
            int n = 0;
            for (ListNode i = head; i != null; n++, i = i.next);

            ListNode dmy = new ListNode(0);
            dmy.next = head;
            for(ListNode prev = dmy, tail = head; n >= k; n -= k) {
                for (int i = 1; i < k; i++) {
//                    System.out.println("Start");
                    ListNode next = tail.next.next;
//                    System.out.println("Next"+ next.val);
                    tail.next.next = prev.next;
//                    System.out.println("Tail next next "+ tail.next.next.val);
                    prev.next = tail.next;
//                    System.out.println("Prev next"+ prev.next.val);
                    tail.next = next;
//                    System.out.println("Tail next"+tail.next.val);
                    System.out.println("End");
                }

                prev = tail;
                tail = tail.next;
            }
            return dmy.next;
        }
    }

//    class Solution {
//        public static List<List<String>> partition(String s) {
//        List<List<String>> res = new ArrayList<>();
//
//
//            return res;
//        }
//
//
//        public static void backtrack(){
//
//
//
//        }
//
//
//
//        public static boolean isPalindrome(String s,  int start,  int end ){
//            while(start < end){
//                if(s.charAt(start++) != s.charAt(end--)) return false;
//            }
//            return true;
//        }
//    }

        public static int longestConsecutive(int[] nums) {
            UnionFind uf = new UnionFind(nums.length);
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for(int i = 0; i < nums.length;i++){
                if(map.containsKey(nums[i])){
                    continue;
                }
                map.put(nums[i],i);
                if(map.containsKey(nums[i]+1)){
                    uf.union(i,map.get(nums[i]+1));
                }
                if(map.containsKey(nums[i]-1)){
                    uf.union(i,map.get(nums[i]-1));
                }
            }
            return uf.maxUnion();
        }

    static class UnionFind {
        private int[] list;
        private int[] sz;

        public UnionFind(int n) {
            list = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = i;
                sz[i] = 1;
            }
        }

        public int root(int p) {
            while (p != list[p]) {
                list[p] = list[list[p]];
                p = list[p];

            }
            return p;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (sz[p] < sz[q]) { // root with number of nodes smaller will be point to root that has larger number of nodes
                list[i] = j;
                sz[j] += sz[i];
            } else {
                list[j] = i;
                sz[i] += sz[j];
            }
        }

        public int maxUnion() {
            int[] count = new int[list.length];
            int max = 0;
            for (int i = 0; i < list.length; i++) {
                count[root(i)]++;
                max = Math.max(max, count[root(i)]);
            }
            return max;
        }
    }




    public static void main(String[] args){
//     longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     int a =0;
//     int [][] arr = new int[n][3];
//        for (int i = 0; i < n ; i++) {
//            for (int j = 0; j < 3; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            for (int j = 0; j < 3; j++) {
//                if(arr[i][j] == 1 ){
//                    count++;
//                }
//                if(count > 1){
//                    a++;
//                    break;
//                }
//
//            }
//        }
//    combinationSum4(new int [] {1,2,3},4 );
//        System.out.println(a);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        Solution.reverseKGroup(head,3);

    }
}
