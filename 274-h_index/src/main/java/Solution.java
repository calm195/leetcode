import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

/**
 * @author wjx
 * @date 2024/02/15 04:34 PM
 */
public class Solution {
    public static int hIndex(int[] citations) {
        int len = citations.length;
        int h = 0;

        int left = 0, right = len;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            for (int citation : citations) {
                if (citation >= mid) {
                    h++;
                }
            }
            if (h >= mid) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
            h = 0;
        }
        return left;

        /* 计数排序搜索
        int[] counter = new int[len + 1];
        for (int citation : citations) {
            if (citation >= len) counter[len]++;
            else counter[citation]++;
        }
        for (int i = len; i >= 0; i--) {
            h += counter[i];
            if (h >= i) {
                return i;
            }

        }
        return 0;*/

        /* 排序后倒序数数
        int i = len - 1;
        Arrays.sort(citations);
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;*/
    }

    public static void main(String[] args) {
        int[] citations = {1};
        System.out.println(hIndex(citations));
    }
}
