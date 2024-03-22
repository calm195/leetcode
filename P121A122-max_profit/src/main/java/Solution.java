/**
 * @author wjx
 * @date 2024/02/14 05:00 PM
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // 7
//        int[] prices = {1, 2, 3, 4, 5}; // 4
//        int[] prices = {7, 6, 4, 3, 1}; // 0
        System.out.println(maxProfitSingle(prices));
        System.out.println(maxProfit(prices));
    }

    private static int maxProfitSingle(int[] prices) {
        int len = prices.length;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > min){
                max = Math.max(max, prices[i] - min);
                continue;
            }
            min = prices[i];
        }
        return max ;

        // 暴力， time out
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (prices[j] > prices[i]) {
//                    int temp = prices[j] - prices[i];
//                    max = Math.max(max, temp);
//                }
//            }
//        }
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]){
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }
}
