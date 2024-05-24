import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        // first approach
        public String reverseVowels(String s) {
            Stack<Character> stack = new Stack<Character>();
            Set<Character> vowelSet = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
            char[] chars = s.toCharArray();
            for (int i = 0 ; i < chars.length;i++){
                if (vowelSet.contains(chars[i])){
                    // Set<int,char> set = new Set<int,char>(i,chars[i]);
                    stack.push(chars[i]);
                }
            }

            for(int i =0 ;i < chars.length;i++){
                if (vowelSet.contains(chars[i])){
                    char vowel = stack.pop();
                    chars[i] = vowel;
                }
            }
            return new String(chars);
        }
    }
}