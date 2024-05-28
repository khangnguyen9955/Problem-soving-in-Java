public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public int maxVowels(String s, int k) {
            char[] chars = s.toCharArray();
            int[] vowels = new int[128]; // 128 characters
            int max = 0;
            vowels['a'] = vowels['i'] = vowels['e'] = vowels['o'] = vowels['u'] =  1;
            int count = 0;
            // first approach
            // for (int i = 0; i < chars.length; i++){
            //     if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o'  || chars[i] == 'u'){
            //         count++;
            //     }
            //     if (i >= k &&( chars[i-k] == 'a' || chars[i-k] == 'e' || chars[i-k] == 'i' || chars[i-k] == 'o'  || chars[i-k] == 'u')){
            //         // if the window size is >= k
            //         // we need to remove the first vowel of the window and continue to slide
            //             count--;
            //     }
            // max = Math.max(count, max);
            // if (max ==k) return max;
            // }
            //second approach
            for (int i = 0; i<k; i++){ // precompute the window
                count+= vowels[chars[i]];
            }
            max = count;
            for(int i = k; i < chars.length; i++){
                count += vowels[chars[i]] - vowels[chars[i-k]]; // get the new char and remove the first char in window
                max = Math.max(count,max);
                if ( max == k){
                    return max;
                }
            }
            return max;

        }
    }
}