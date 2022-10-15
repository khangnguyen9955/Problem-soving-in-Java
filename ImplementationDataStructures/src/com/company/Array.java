package com.company;

import java.util.*;

public class Array {

    // leet code merge sorted array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        for(int ai : n2){
//            // insert every element in array n2 into array n1
//            // m is length of array n1
//            // n is length of array n2
//            insertArray(ai,n1,m);
//            m++;
//        }
// ky thuat 2 co ntro
        // ky thuat 2 co ntro
        int flag = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[flag] = nums2[j];
                j--;
                flag--;
            } else {
                nums1[flag] = nums1[i];
                i--;
                flag--;
            }
        }

        while (j >= 0) {
            nums1[flag--] = nums2[j--];
        }

    }

    private static void insertArray(int x, int[] a, int m) {
        boolean isFound = false;

        for (int i = 0; i < m; i++) {
            if (a[i] > x) {
                isFound = true;

                for (int j = m - 1; j >= i; j--) {
                    a[j + 1] = a[j];
                }
                a[i] = x;
                break;
            }
        }
        if (isFound == false) {
            a[m] = x;
        }

    }

    // leet code remove element problem 26
    public static int removeElement(int[] arr, int value) {
        //        int n = arr.length;
//        for (int i = 0; i <n;) {
//            if (arr[i] == value){
//                for (int j = i; j <= (n-2) ; j++) {
//                    arr[j] = arr[j+1];
//                }
//                n--;
//            }else{
//                i++;
//            }
//        }
//        return n;
        // ky thuat 2 con tro
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != value) {
                arr[k] = arr[i]; // khi phan tu khac x thi thay the phan te o vi tri k = phan tu do => khi ptu == ptu muon xoa thi k van dung nguyen vi tri cu
                // noi ma ptu khac x dung' nen khi return arr se tra lai dung ptu nhu ouput
                k++;
            }
        }
        return k;
    }

    // leet code medium longest subarray without repeating characters
    public static int HashTable(String a) {
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        int count = 0;
        int index = 0;
        int temp = 0;
        int flag = 0;
        for (int i = 0; i < a.length(); i++, index++) {

            if (!table.containsKey(a.charAt(i))) {
                table.put(a.charAt(i), index);
                count++;
//               System.out.println("temp"+ temp);
            } else {
                flag = table.get(a.charAt(i));
                i = flag;
                index = i;
                table.clear();
                count = 0;

//                i = flag;
//               System.out.println("temp1" + temp1);
//                if(temp == temp1){
//                    return temp;
//                }
            }
            temp = Math.max(count, temp);
        }
        return temp;

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                System.out.println(s.charAt(i) + 1);
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static int arr[][] = new int[1000][1000];

    // Returns length of LCS for X[0..m-1], Y[0..n-1] */
    // memoization applied in recursive solution
    public static int lcs(String X, String Y, int m, int n) {

        // base case
        if (m == 0 || n == 0)
            return 0;

        // if the same state has already been
        // computed
        if (arr[m - 1][n - 1] != -1)
            return arr[m - 1][n - 1];

        // if equal, then we store the value of the
        // function call
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {

            // store it in arr to avoid further repetitive
            // work in future function calls
            arr[m - 1][n - 1] = 1 + lcs(X, Y, m - 1, n - 1);
             return arr[m - 1][n - 1];
        } else {

            // store it in arr to avoid further repetitive
            // work in future function calls
            arr[m - 1][n - 1] = max(lcs(X, Y, m, n - 1),
                    lcs(X, Y, m - 1, n));
            return arr[m - 1][n - 1];
        }
    }

    // Utility function to get max of 2 integers
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }


    public static int[] sortColors (int []nums){
        int left = 0 ;
        int right = nums.length-1;
        int temp;
        for (int i = left; i <=right; ) {
            if(nums[i] == 0) {
                temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
                i++;
            }
            else if (nums[i] == 2) {
                temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;

            }
            else{
                i++;
            }
        }
        System.out.println( nums);
        return nums;
        }
//    public static int[] dailyTemperatures(int[] temperatures) {
//        int []ans = new int [temperatures.length];
//        ans[temperatures.length-1] = 0;
//        for(int i = 0;i<=temperatures.length-2;i++){
//            int j = i+1;
//            int count = 1;
//            while(temperatures[i] >= temperatures[j]){
//                count++;
//                j++;
//                if(j == (temperatures.length)){
//                    count = 0;
//                    break;
//                }
//            }
//            ans[i] = count;
//
//        }
//        return ans;
//    }
//
//    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] stack = new int[temperatures.length];
//        int top = -1;
//        int[] ret = new int[temperatures.length];
//        for(int i = 0; i < temperatures.length; i++) {
//            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
//                int idx = stack[top--];
//                ret[idx] = i - idx;
//            }
//            stack[++top] = i;
//        }
//        return ret;
//    }

        public static int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int hottest = 0;
            int answer[] = new int[n];

            for (int currDay = n - 1; currDay >= 0; currDay--) {
                int currentTemp = temperatures[currDay];
                if (currentTemp >= hottest) {
                    hottest = currentTemp;
                    continue;
                }

                int days = 1;
                while (temperatures[currDay + days] <= currentTemp) {
                    // Use information from answer to search for the next warmer day
                    days += answer[currDay + days];
                }
                answer[currDay] = days;
            }

            return answer;
        }
public static int[] nextGreaterElement(int[]nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int num: nums2){
    while (!stack.empty() && stack.peek() < num ) {// so sanh voi stack[top] va so hien tai
            map.put(stack.pop(),num);
        }
        stack.push(num);
    }
    for (int i = 0; i < nums1.length; i++){
        nums1[i] = map.getOrDefault(nums1[i],-1);
    }
    return nums1;
}


public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs .length == 0) return new ArrayList<>();
        Map<String, List<String> > map = new HashMap<>();
        for(String s : strs){
                char[] ca = new char[26]; // use "a"-"z" technique
                for (char c: s.toCharArray()){
                    ca[c-'a']++;
                }
                String key = String.valueOf(ca);
                if(!map.containsKey(key)) map.put(key,new ArrayList<>());
                map.get(key).add(s);
            }
        return new ArrayList<>(map.values());
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    static class RandomizedSet {
        ArrayList<Integer> array;
        HashMap<Integer,Set<Integer>> map;
        java.util.Random rand = new java.util.Random();


        public RandomizedSet() {
            array = new ArrayList<Integer>();
            map = new HashMap<Integer,Set<Integer>>();

        }

        public boolean insert(int val) {
            boolean contain = map.containsKey(val);
            if ( ! contain )map.put( val, new HashSet<Integer>() );
          
            array.add(val);
            return ! contain ;

        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
          // get the location of the first val
            int location = map.get(val).iterator().next();
            // remove that location
            map.get(val).remove(location);
            if(location < array.size()-1) {// means that location is not the last element in the array
                int lastElement = array.get(array.size()-1); // get the last element
                array.set(location,lastElement); // change the index of the location we have stored by the lastElement
                map.get(lastElement).remove(array.size()-1); // get the last element and remove that location
                 map.get(lastElement).add(location); // add new location for the lastElement;
                }
            array.remove(array.size()-1); // remove the last index == the value that we set it to.
            if(map.get(val).isEmpty()) {
                map.remove(val); // if that value does not exist in the map anymore so we remove it. Check it by the location we store in Set.
            }
            return true;
        }


        public int getRandom() {
            return array.get(rand.nextInt(array.size()));

        }
    }

// this is the test from KMS fresher Java for example
 static class Test{
        ArrayList<Integer> arr;
        List<ArrayList<Integer>> kq;

        public Test (){
            arr =  new ArrayList<>();
            kq = new ArrayList<>();
        }
        
        public void insert (int val){
                arr.add(val);       
        }
        
        // in this we solve this problem by brute force approach
        // for better solution => we use hashtable
        public List count(int find){
            for (int i = 0; i < arr.size()-1 ; i++) {
                ArrayList<Integer> result = new ArrayList<>();
                for (int j = i+1; j < arr.size() ; j++) {
                        if(find - arr.get(i) == arr.get(j)){
                            result.add(arr.get(i));
                            result.add(arr.get(j));
                            kq.add(result);
                        }
                }
            }
            
            
            return  kq;
        }

        
 }
//
//    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//    Example 1:
//
//    Input: n = 3
//    Output: ["((()))","(()())","(())()","()(())","()()()"]
//    Example 2:
//
//    Input: n = 1
//    Output: ["()"]
//

    public static List<String> generateParenthesis(int n) {
                List<String> list = new ArrayList<>();
                backtracking(list,"",0,0,n);
                return list;
                // base case N*2 la se return ra cai solution do
                // vi du n = 3 => co 3 () thi str.length == 6 thi se tra ra solution do
    }

    public static void backtracking (List<String> list, String s, int open, int close, int max){
// max se la n*2
        if(s.length() == max*2){
            list.add(s);
            // du length roi thi add zo roi return thoi chu doi gi ??
            return;
        }

        // open la cu mo ngoac ( nen phai check no khi no mo 3 cai roi thi no ko con nho hon max nua nen phai chuyen qua close thoi
        if(open < max){
            // cho nay minh backtrack cho no mo ngoac nen open+1 , vi no mo thi open se tang len 1 cai ngoac mo
            backtracking(list,s+"(",open+1,close,max );
        }
        // co nghia la dong ngoac lai cho du cai ngoac da mo? nen phai check xem no co nho hon so ngoac open ko
        // vi du da open 3 cai thi close lai 3 cai
        if(close<open){
            // cho nay minh backtrack cho no dong ngoac nen close +1 , vi no dong thi close se tang len 1 cai ngoac dong
            backtracking(list,s+")",open,close+1,max);
        }






    }




    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        backtracking2(list,digits.toCharArray(), "", dict);
        return list;
    }


    public static void backtracking2(List<String> list, char[] digits, String s , String [] dic){
            if(s.length()== digits.length){
                list.add(s);
                return;
            }
            int i = s.length(); // bien nay dung de lay nhung thang char tiep theo , vi du khi no length 0 thi lay nhung thang char trong digits[0]
        // khi da lay thang digits[0] roi thi bh minh se bdau lay nhung thang char cua digits[1]
        // khi lay het thang digits[1] ropi thi quay lai lay het nhugnb thang char con lai trong digits[0]
            int digit = digits[i] - '0';  //
        for (char letter : dic[digit].toCharArray()) {
            backtracking2(list, digits, s + Character.toString(letter), dic);
        }
    }


//
//
//
//    public static int diagonalDifference(int [][] arr) {
//        int result = 0;
//        int num1=0;
//        int num2=0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j <= i; j++) {
//                num1+=arr[i][j];
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = arr.length-1 - i ;j<=arr.length-1-i ;j++) {
//                num2+=arr[i][j];
//            }
//        }
//        result = Math.abs(num1-num2);
//
//
//
//        return result;
//    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i <  candles.size(); i++) {
                if(!map.containsKey(candles.get(i))) {
                        map.put(candles.get(i), 1);
                }
                else{
                    map.put(candles.get(i), map.get(candles.get(i))+1);
                }
                max = Math.max(max,map.get(candles.get(i)));

        }


        return max;

    }







    public static void main(String[] args) {
//        int [] n1 = {2,2,3,3};
////        int [] n2 ={3,6};
////       merge(n1,4,n2);
////        System.out.println(removeElement(n1,2));
////        System.out.println(HashTable(a));
////        System.out.println(lengthOfLongestSubstring(a));
//

//        System.out.println("Length of LCS is " + lcs(X, Y, m, n));
//        System.out.println(dailyTemperatures(arr));
//        nextGreaterElement(arr1,arr2);
//        groupAnagrams(strs);
//        String str = "babad";
//longestPalindrome(str);
//            Test test = new Test();
//            test.insert(3);
//            test.insert(5);
//            test.insert(2);
//        test.insert(4);
//        test.insert(1);
//        test.insert(6);
//
//        test.count(8);
//        test.insert(7);
//        test.count(8);
        // ["RandomizedSet","insert","insert","getRandom","getRandom","insert","remove","getRandom","getRandom","insert","remove"]
//        String a = "23";
//        letterCombinations(a);
        //[[],[3],[3],[],[],[1],[3],[],[],[0],[0]]
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int [][] arr = new int [n][n];
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
        System.out.println(birthdayCakeCandles(arr));
//        System.out.println(diagonalDifference(arr));

    }



}













