/**
 * @author wjx
 * @date 2024/02/17 10:26 AM
 */
public class Solution {
    public static void main(String[] args) {
        int[] rating = {1, 0, 2};
        Solution solution = new Solution();
        System.out.println(solution.candy(rating));
    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len <= 1) {
            return len;
        }
        if (len == 2) {
            return ratings[0] != ratings[1] ? 3 : 2;
        }
        int total = 1;
        int pre = 1;
        int dec = 0;
        int inc = 1;

        for (int i = 1; i < len; i++) {
            if (ratings[i] >= ratings[i -  1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                inc = pre;
                total += pre;
            } else  {
                dec ++;
                if (dec == inc){
                    dec ++;
                }
                total += dec;
                pre = 1;
            }
        }

        return total;
    }
}
