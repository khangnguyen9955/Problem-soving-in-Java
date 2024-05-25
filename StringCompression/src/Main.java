public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public int compress(char[] chars) {
            int index = 0; // used this for looping through the char
            int countIndex = 0; // used thsi to count the chars as well as the index of the compressed string
            while (index < chars.length){
                char curChar = chars[index];
                int countChar = 0;
                // while the cur char is the same, keep counting and moving
                while(index< chars.length && chars[index] == curChar){
                    countChar++;
                    index++;
                }
                chars[countIndex] = curChar;
                // move the countIndex to next
                countIndex++;
                if (countChar > 1){ // if there is more than 1 same char
                    for (char c:  Integer.toString(countChar).toCharArray()){
                        // get every single char of the number to count
                        chars[countIndex] = c;
                        countIndex++;
                    }
                }
            }
            return countIndex;

        }
    }
}