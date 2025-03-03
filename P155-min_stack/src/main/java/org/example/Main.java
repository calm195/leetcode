package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-03-03 15:22:36
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-03-03 15:46:49
 * 
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.
    You must implement a solution with O(1) time complexity for each function.

    Example 1:
    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]
    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
    

    Constraints:
    -231 <= val <= 231 - 1
    Methods pop, top and getMin operations will always be called on non-empty stacks.
    At most 3 * 104 calls will be made to push, pop, top, and getMin.@Description: to be added
 */

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        System.out.println("push -2");
        minStack.push(-2);
        minStack.print();

        System.out.println("push 0");
        minStack.push(0);
        minStack.print();
        
        System.out.println("push -3");
        minStack.push(-3);
        minStack.print();
        
        System.out.println("getMin");
        minStack.getMin(); // return -3
        minStack.print();

        System.out.println("pop");
        minStack.pop();
        minStack.print();

        System.out.println("get top");
        minStack.top();    // return 0
        minStack.print();

        System.out.println("getMin");
        minStack.getMin(); // return -2
        minStack.print();
    }
}