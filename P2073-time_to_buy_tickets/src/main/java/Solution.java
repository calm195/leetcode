/*
 * @Author: chrissy wx2178@126.com
 * @Date: 2024-09-29 12:53:52
 * @LastEditors: chrissy wx2178@126.com
 * @LastEditTime: 2024-09-29 13:16:00
 * @Description: 
 * 
 * 横扫千军方法
 */
public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k){
        int len = tickets.length;
        int time = tickets[k];
        for (int i = 0; i < k; i++){
            time += tickets[i] >= tickets[k] ? tickets[k] : tickets[i];
        }
        for (int i = k + 1; i < len; i++){
            time += tickets[i] >= tickets[k] - 1 ? tickets[k] - 1 : tickets[i];
        }
        return time;
    }
}
