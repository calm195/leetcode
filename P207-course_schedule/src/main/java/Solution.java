/*
 * @Author: Chrissy 1804659599@qq.com
 * @Date: 2024-05-24 15:00:04
 * @LastEditors: Chrissy 1804659599@qq.com
 * @LastEditTime: 2024-05-27 10:28:06
 * @Description: to be added
 */

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    private class VNode {
        int value;
        ENode toNodes;

        VNode(int value){
            this.value = value;
        }

        void addEnode(int value){
            if (toNodes == null) {
                toNodes = new ENode();
                toNodes.node = new VNode(value);
                return;
            }
            ENode tmp = toNodes;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ENode();
            tmp.next.node = new VNode(value);
        }
    }

    private class ENode{
        VNode node;
        ENode next;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        VNode[] courses = new VNode[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new VNode(i); 
        } 

        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].addEnode(prerequisites[i][1]);
        }
        return true;
    }
}
