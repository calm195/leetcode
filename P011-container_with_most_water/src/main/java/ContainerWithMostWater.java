/**
 * @author wjx
 * @date 4/7/2024 9:35 PM
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater test = new ContainerWithMostWater();
        System.out.println(test.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int area = 0;
        while (left < right){
            int smaller = Math.min(height[left], height[right]);
            int temp = (right - left) * smaller;
            area = Math.max(area, temp);
            if (height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return area;
    }
}
