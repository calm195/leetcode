import official.OfficialSolution;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2 ){
            return len;
        }

        int have_processed = 2;
        int sequential_index = 2;
        while (sequential_index < len){
            if (nums[have_processed - 2] != nums[sequential_index]){
                nums[have_processed] = nums[sequential_index];
                have_processed++;
            }
            sequential_index++;
        }
        return have_processed;
    }

    /** 失败的想法，过于复杂
    public static int removeDuplicates(int[] nums) {
        int temp = nums[0];
        int index = 0;
        boolean flag = true;
        for (int i = 1; ; i++) {
            if (i == nums.length) {
                break;
            }
            if (temp == nums[i]) {
                if (flag) {
                    flag = false;
                    index = i;
                }
            } else {
                temp = nums[i];
                index++;
                if (!flag) {
                    for (int j = i; j < nums.length; j++) {
                        nums[index + j - i] = nums[j];
                    }
                    i = index;
                    flag = true;
                }
            }
        }
        return index;
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] expectedNums = {1, 1, 2, 2, 3};
//        int[] nums = {1, 1, 2, 2, 2, 2, 3, 4, 4};
//        int[] expectedNums = {1, 1, 2, 2, 3, 4, 4};
        System.out.println(Arrays.toString(nums));
//        int k = OfficialSolution.removeDuplicates(nums);
        int k = removeDuplicates(nums);
        System.out.println(Arrays.toString(expectedNums));
        System.out.println("k: " + k);
        for (int i = 0; i < k; i++) {
            if (nums[i] != expectedNums[i]) {
                System.out.println(i + ": " + nums[i]);
            }
            System.out.print(Integer.toString(nums[i]) + ' ');
        }
        System.out.println();
    }
}
