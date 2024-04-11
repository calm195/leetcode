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
        int start = 0;
        int result =  0;
        int total = 0;

        for (int i = 0; i < len; i++) {
            total += nums[i];

            if (nums[i] < 0){

            }

            if (total == k){
                result ++;
                total -= nums[start];
                start ++;
            } else if (total > k){
                while (total > k && start <= i){
                    total -= nums[start];
                    start ++;
                }

                if (total == k && start <= i){
                    result ++;
                }
            }
        }

        return result;
    }
}
