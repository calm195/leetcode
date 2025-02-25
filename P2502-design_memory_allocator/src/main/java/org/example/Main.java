package org.example;
/*
 * @Author: chrissy wx2048@protonmail.com
 * @Date: 2025-02-25 14:41:16
 * @LastEditors: chrissy wx2048@protonmail.com
 * @LastEditTime: 2025-02-25 19:59:38
 * @Description: to be added
 * 
    You are given an integer n representing the size of a 0-indexed memory array. All memory units are initially free.

    You have a memory allocator with the following functionalities:

    Allocate a block of size consecutive free memory units and assign it the id mID.
    Free all memory units with the given id mID.
    Note that:

    Multiple blocks can be allocated to the same mID.
    You should free all the memory units with mID, even if they were allocated in different blocks.
    Implement the Allocator class:

    Allocator(int n) Initializes an Allocator object with a memory array of size n.
    int allocate(int size, int mID) Find the leftmost block of size consecutive free memory units and allocate it with the id mID. Return the block's first index. If such a block does not exist, return -1.
    int freeMemory(int mID) Free all memory units with the id mID. Return the number of memory units you have freed.
    

    Example 1:

    Input
    ["Allocator", "allocate", "allocate", "allocate", "freeMemory", "allocate", "allocate", "allocate", "freeMemory", "allocate", "freeMemory"]
    [[10], [1, 1], [1, 2], [1, 3], [2], [3, 4], [1, 1], [1, 1], [1], [10, 2], [7]]
    Output
    [null, 0, 1, 2, 1, 3, 1, 6, 3, -1, 0]

    Explanation
    Allocator loc = new Allocator(10); // Initialize a memory array of size 10. All memory units are initially free.
    res = loc.allocate(1, 1); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
    res = loc.allocate(1, 2); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
    res = loc.allocate(1, 3); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
    res = loc.freeMemory(2); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
    res = loc.allocate(3, 4); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
    res = loc.allocate(1, 1); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
    res = loc.allocate(1, 1); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
    res = loc.freeMemory(1); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
    res = loc.allocate(10, 2); // We can not find any free block with 10 consecutive free memory units, so we return -1.
    res = loc.freeMemory(7); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.
    

    Constraints:

    1 <= n, size, mID <= 1000
    At most 1000 calls will be made to allocate and freeMemory.
 */

public class Main {
    static Allocator loc = new Allocator(50);

    public static void main(String[] args) {
        System.out.println(loc);
        allo(12,6);
        allo(28, 16);
        allo(17, 23);
        allo(50, 23);
        free(6);
        free(10);
        free(10);
        allo(16, 8);
        allo(17, 41);
        allo(44, 27);
        allo(12, 45);
        free(33);
        free(8);
        free(16);
        free(23);
        free(23);
        free(23);
        free(29);
        allo(38, 32);
        free(29);
        free(6);
        allo(40, 11);
        free(16);
        allo(22, 33);
        allo(27, 5);
        free(3);
        free(10);
        free(29);
        allo(16, 14);
        
    }

    public static void allo(int a, int b) {
        int res = loc.allocate(a, b); // We can not find any free block with 10 consecutive free memory units, so we return -1.
        System.out.print(res);
        System.out.println(loc);
    }

    public static void free(int a) {
        int res = loc.freeMemory(a); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.
        System.out.print(res);
        System.out.println(loc);
    }
}