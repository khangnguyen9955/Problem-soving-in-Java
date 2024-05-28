public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public int maxVowels(String s, int k) {
            char[] chars = s.toCharArray();
            int max = 0;
            int count = 0;
            for (int i = 0; i < chars.length; i++){
                if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o'  || chars[i] == 'u'){
                    count++;
                }
                if (i >= k &&( chars[i-k] == 'a' || chars[i-k] == 'e' || chars[i-k] == 'i' || chars[i-k] == 'o'  || chars[i-k] == 'u')){
                    // if the window size is >= k
                    // we need to remove the first vowel of the window and continue to slide
                    count--;
                }
                max = Math.max(count, max);
            }
            return max;
        }
    }v
}