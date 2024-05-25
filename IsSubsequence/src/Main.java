public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() > t.length()){
                return false;
            }
            if(s.length() == 0 || s == null){
                return true;
            }
            // convert to char array to be faster?
            char[] tA = t.toCharArray();
            char[] sA = s.toCharArray();
            int res =0;
            for(int i =0;i<tA.length;i++){
                if(sA[res] == tA[i]){
                    res++;
                }
                if(res == sA.length){
                    return true;
                }
            }
            return false;
        }
    }
}