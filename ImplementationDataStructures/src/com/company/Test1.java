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









    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int a =0;
     int [][] arr = new int[n][3];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if(arr[i][j] == 1 ){
                    count++;
                }
                if(count > 1){
                    a++;
                    break;
                }

            }
        }

        System.out.println(a);

    }
}
