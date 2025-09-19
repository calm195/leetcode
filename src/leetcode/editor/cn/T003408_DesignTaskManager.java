/**
 * 一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。
 * <p>
 * 请你设计一个 TaskManager 类：
 * <p>
 * <p>
 * TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId,
 * priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。
 * void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 priority 的
 * 任务 taskId ，输入 保证 taskId 不在系统中。
 * void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入 保
 * 证 taskId 存在于系统中。
 * void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。
 * int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任务后
 * ，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。
 * <p>
 * <p>
 * 注意 ，一个用户可能被安排多个任务。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"] [[[[1, 1
 * 01, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105
 * , 15], []]
 * <p>
 * <p>
 * 输出： [null, null, null, 3, null, null, 5]
 * <p>
 * 解释： TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3,
 * 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。
 * taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
 * taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
 * taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
 * taskManager.rmv(101); // 将系统中的任务 101 删除。
 * taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
 * taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= tasks.length <= 10⁵
 * 0 <= userId <= 10⁵
 * 0 <= taskId <= 10⁵
 * 0 <= priority <= 10⁹
 * 0 <= newPriority <= 10⁹
 * add ，edit ，rmv 和 execTop 的总操作次数 加起来 不超过 2 * 10⁵ 次。
 * 输入保证 taskId 是合法的。
 * <p>
 * <p>
 * Related Topics 设计 哈希表 有序集合 堆（优先队列）
 * 👍 10 👎 0
 */

package leetcode.editor.cn;

import java.util.*;

// 3408 - 设计任务管理器
public class T003408_DesignTaskManager {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 101, 10},
                {2, 102, 20},
                {3, 103, 15}
        };
        List<List<Integer>> tasks = new ArrayList<>();
        for (int[] row: arr) {
            List<Integer> list = new ArrayList<>();
            for (int value: row) {
                list.add(value);
            }
            tasks.add(list);
        }
        TaskManager taskManager = new T003408_DesignTaskManager().new TaskManager(tasks);

        taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
        taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
        taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
        taskManager.rmv(101); // 将系统中的任务 101 删除。
        taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
        taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
    }


    class TaskManagerTimeout {

        private final TreeSet<Task> taskTreeSet = new TreeSet<>();

        public TaskManagerTimeout(List<List<Integer>> tasks) {
            for (List<Integer> task: tasks) {
                Task temp = new Task();
                temp.userId = task.get(0);
                temp.taskId = task.get(1);
                temp.priority = task.get(2);
                taskTreeSet.add(temp);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task temp = new Task();
            temp.userId = userId;
            temp.taskId = taskId;
            temp.priority = priority;
            taskTreeSet.add(temp);
        }

        public void edit(int taskId, int newPriority) {
            Iterator<Task> iterator = taskTreeSet.iterator();
            Task temp = null;
            boolean changed = false;
            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp.taskId == taskId) {
                    changed = true;
                    iterator.remove();
                    temp.priority = newPriority;
                    break;
                }
            }
            if (changed) {
                taskTreeSet.add(temp);
            }
        }

        public void rmv(int taskId) {
            taskTreeSet.removeIf(temp -> temp.taskId == taskId);
        }

        public int execTop() {
            if (taskTreeSet.isEmpty()) {
                return -1;
            } else {
                Task temp = taskTreeSet.pollFirst();
                assert temp != null;
                return temp.userId;
            }
        }

        private class Task implements Comparator<Task>, Comparable<Task> {
            public int userId;
            public int taskId;
            public int priority;

            public Task(){}

            @Override
            public int hashCode() {
                return this.taskId;
            }

            @Override
            public int compare(Task o1, Task o2) {
                return o2.priority - o1.priority;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Task){
                    Task other = (Task) obj;
                    return other.taskId == this.taskId;
                }
                return false;
            }

            @Override
            public int compareTo(Task o) {
                if (o.priority == this.priority) {
                    return o.taskId - this.taskId;
                } else {
                    return o.priority - this.priority;
                }
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TaskManager {
        private final Map<Integer, int[]> taskInfo = new HashMap<>();
        // 优先队列不直接删除数据，等到弹出时判断是否存在于taskInfo
        private final PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task: tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                taskInfo.put(taskId, new int[]{priority, userId});
                priorityQueue.offer(new int[]{priority, taskId});
            }
        }

        public void add(int userId, int taskId, int priority) {
            taskInfo.put(taskId, new int[]{priority, userId});
            priorityQueue.offer(new int[]{priority, taskId});
        }

        public void edit(int taskId, int newPriority) {
            if (taskInfo.containsKey(taskId)) {
                taskInfo.get(taskId)[0] = newPriority;
                priorityQueue.offer(new int[]{newPriority, taskId});
            }
        }

        public void rmv(int taskId) {
            taskInfo.remove(taskId);
        }

        public int execTop() {
            while (!priorityQueue.isEmpty()) {
                int[] task = priorityQueue.poll();
                int priority = task[0];
                int taskId = task[1];

                if (taskInfo.containsKey(taskId) && taskInfo.get(taskId)[0] == priority) {
                    int userId = taskInfo.get(taskId)[1];
                    taskInfo.remove(taskId);
                    return userId;
                }
            }
            return -1;
        }
    }

    /**
     * Your TaskManager object will be instantiated and called as such:
     * TaskManager obj = new TaskManager(tasks);
     * obj.add(userId,taskId,priority);
     * obj.edit(taskId,newPriority);
     * obj.rmv(taskId);
     * int param_4 = obj.execTop();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}
