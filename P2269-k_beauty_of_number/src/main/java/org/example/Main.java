package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-10 21:12:03
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-11 00:25:34
 * @Description: to be added
    The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

    It has a length of k.
    It is a divisor of num.
    Given integers num and k, return the k-beauty of num.

    Note:
    Leading zeros are allowed.
    0 is not a divisor of any value.
    A substring is a contiguous sequence of characters in a string.

    Example 1:
    Input: num = 240, k = 2
    Output: 2
    Explanation: The following are the substrings of num of length k:
    - "24" from "240": 24 is a divisor of 240.
    - "40" from "240": 40 is a divisor of 240.
    Therefore, the k-beauty is 2.

    Example 2:
    Input: num = 430043, k = 2
    Output: 2
    Explanation: The following are the substrings of num of length k:
    - "43" from "430043": 43 is a divisor of 430043.
    - "30" from "430043": 30 is not a divisor of 430043.
    - "00" from "430043": 0 is not a divisor of 430043.
    - "04" from "430043": 4 is not a divisor of 430043.
    - "43" from "430043": 43 is a divisor of 430043.
    Therefore, the k-beauty is 2.

    Constraints:
    1 <= num <= 109
    1 <= k <= num.length (taking num as a string)
 */

public class Main {
    public static void main(String[] args) {
        int num = 142369;
        int k = 6;

        System.out.println(divisorSubstrings(num, k));
    }

    private static int divisorSubstrings(int num, int k) {
        long m = (long) Math.pow(10, k);
        int ans = 0;
        for (int n = num; n >= m / 10; n /= 10) {
            int x = (int) (n % m);
            if (x > 0 && num % x == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int divisorSubstrings2(int num, int k) {
        String s = Integer.toString(num);   // num 十进制表示字符串
        int n = s.length();
        int res = 0;
        for (int i = 0; i <= n - k; ++i) {
            // 枚举所有长度为 k 的子串
            int tmp = Integer.parseInt(s.substring(i, i + k));
            if (tmp != 0 && num % tmp == 0) {
                ++res;
            }
        }
        return res;
    }

}