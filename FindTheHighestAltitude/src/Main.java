public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
        public int largestAltitude(int[] gain) {
            int[] altitude = new int[gain.length+1];
            int max = 0;
            altitude[0] = 0;
            for (int i =0; i < gain.length; i++){
                altitude[i+1] = altitude[i] + gain[i];
                max = Math.max(max,altitude[i+1]);
            }
            return max;
        }
}