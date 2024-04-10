/**
 * @author wjx
 * @date 4/9/2024 12:19 PM
 */
public class Failure {
    // 贪心不行
    public int trap_greed(int[] height) {
        int contain = 0;
        int len = height.length;
        int left;
        for (int i = 0; i < len - 1; i++) {
            if (height[i] > height[i + 1]) {
                left = i;
                i++;
                while (i < len - 1) {
                    if (height[i] >= height[i + 1]) i++;
                    else {
                        do i++;
                        while (i < len - 1 && height[i] <= height[left]);
                        int temp_height = Math.min(height[i], height[left]);
                        for (int j = left + 1; j < i; j++) {
                            contain += temp_height - height[j];
                        }
                        System.out.println(left + " " + temp_height);
//                        System.out.println(contain);
                        i--;

                        break;
                    }
                }
            }
        }

        return contain;
    }
}
