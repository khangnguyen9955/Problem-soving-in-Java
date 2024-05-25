public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public int maxArea(int [] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            // get min height element because we will only contain with the min height of one of them not both
            int minHeight = Math.min(height[left], height[right]);
            int area = minHeight * (right - left);
            maxArea = Math.max(area, maxArea);

            // move the pointer to get the higher elem
            while (left < right && height[left] <= minHeight) {
                left++;
            }
            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }
        return maxArea;
    }
}