/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-31 09:07:59
 * @LastEditors: wx128 wx2048@protonmail.com
 * @LastEditTime: 2024-05-31 22:05:21
 * @Description: to be added
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s){
        int len = s.length();
        List<Integer> list = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }

        int left = -1;
        int right = 0;
        for (int i = 0; i < len; i++) {
            right = Math.max(right, lastIndexes[s.charAt(i) - 'a']);
            if (right == i) {
                list.add(right - left);
                left = i;
            }   
        }

        return list;
    }
}
