package org.example;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-26 12:54:00
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-26 13:04:39
 * @Description: to be added
 */

public class Solution {
    Map<Character, Integer> ori;
    Map<Character, Integer> cnt;

    public Solution() {
        this.ori = new HashMap<>();
        this.cnt = new HashMap<>();
    }

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry entry : ori.entrySet()) {
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }

    class Good{
        public String minWindow(String s, String t) {
            int[] a = new int[60];
            for (int i = 0; i < t.length(); i++) {
                a[t.charAt(i) - 'A'] ++;
            }
            int[] b = new int[60];
            int count = 0;
            int min = 0;
            int max = Integer.MAX_VALUE;
            int start= 0;
            for (int i = 0; i < s.length(); i++) {
                b[s.charAt(i) - 'A'] ++;
                if (a[s.charAt(i) - 'A'] > 0 && b[s.charAt(i) - 'A'] <= a[s.charAt(i) - 'A'])
                    count ++;
                while (count == t.length()) {
                    b[s.charAt(start) - 'A'] --;
                    if (i - start < max - min) {
                        min = start;
                        max = i;
                    }
                    if (a[s.charAt(start) - 'A'] > 0 && b[s.charAt(start) - 'A'] < a[s.charAt(start) - 'A'])
                        count --;
                    start ++;
                }
            }
            return max == Integer.MAX_VALUE ? "":s.substring(min, max + 1);
        }
    }
}
