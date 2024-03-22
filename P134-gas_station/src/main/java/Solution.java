/**
 * @author wjx
 * @date 2024/02/16 06:58 PM
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int total = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
