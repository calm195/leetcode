import java.util.Arrays;

/**
 * @author wjx
 * @date 4/8/2024 3:23 PM
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        int[] height = {9,6,8,8,5,6,3};
        System.out.println(test.trap(height));
    }

    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int contain = 0;
        int[] top_indexes = new int[(len >> 1) + 1];

        int index = 0;
        if (height[0] > height[1]) {
            top_indexes[0] = 0;
            index ++;
        }
        for (int i = 1; i < len - 1; i++) {
            if ((height[i] >= height[i - 1] && height[i] > height[i + 1]) || (height[i] > height[i - 1] && height[i] >= height[i + 1])) {
                top_indexes[index] = i;
                index++;
            }
        }
        if (height[len - 1] > height[len - 2]) {
            top_indexes[index] = len - 1;
            index++;
        }
        System.out.println(Arrays.toString(top_indexes));

        int left= 0;
        int less_max = -1;
        for (int i = 1; i < index; i++) {
//            System.out.println(top_indexes[left] + "  " + contain);
            if (height[top_indexes[i]] >= height[top_indexes[left]]){
                int min = Math.min(height[top_indexes[i]], height[top_indexes[left]]);
                for (int j = top_indexes[left] + 1; j < top_indexes[i]; j++) {
                    contain += min > height[j] ? min - height[j] : 0;
                }

                left = i;
                System.out.println(left);
                less_max = -1;
            } else {
                if (less_max == -1) {
                    less_max = i;
                    if (less_max == index - 1){
                        int min = Math.min(height[top_indexes[less_max]], height[top_indexes[left]]);
                        for (int j = top_indexes[left] + 1; j < top_indexes[less_max]; j++) {
                            contain += min > height[j] ? min - height[j] : 0;
                        }
                        left = less_max;
                    }
                    continue;
                }
                less_max = height[top_indexes[i]] >= height[top_indexes[less_max]] ? i: less_max;
                if (i == index - 1){
                    int min = Math.min(height[top_indexes[less_max]], height[top_indexes[left]]);
                    for (int j = top_indexes[left] + 1; j < top_indexes[less_max]; j++) {
                        contain += min > height[j] ? min - height[j] : 0;
                    }
                    System.out.println(top_indexes[left] + "  " + contain);
                    if (less_max != i) {
                        left = less_max;
                        i = left;
                        less_max = -1;
                    }
                    System.out.println(left);
                }
            }
        }

        return contain;
    }

    /*public int trap(int[] height) {
        int contain = 0;
        int len = height.length;
        int left;
        for (int i = 0; i < len - 1; i++) {
            if (height[i] > height[i + 1]) {
                left = i;
                do i++;
                while (i < len - 1 && height[i] >= height[i + 1]);

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
    }*/
}
