/**
 * @author wjx
 * @date 4/11/2024 4:22 PM
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        SubArraySumEqualsK test = new SubArraySumEqualsK();
        System.out.println(test.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int result = 0;

        int[] res = new int[len];
        res[0] = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + nums[i];
        }

        for (int i = 0; i < len; i++) {
            if (res[i] == k){
                result ++;
            }
            for (int j = 0; j < i; j++) {
                if(res[i] - res[j] == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
