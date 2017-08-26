package LintCode;

import java.util.Stack;

/**
 * lintcode 227
 * 用栈模拟汉诺塔搬移
 * 汉诺塔问题是典型的递归问题，想将第n大的盘子搬到目标柱子，必须先把第n-1大的盘子搬到buffer柱子上
 * 然后将第n大的盘子移到目标柱子后，再将第n-1大的盘子从buffer柱子搬移到目标柱子
 */
public class Tower {
    private Stack<Integer> disks;
    // create three towers (i from 0 to 2)
    public Tower(int i) {
        disks = new Stack<Integer>();
    }

    // Add a disk into this tower
    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    // @param t a tower
    // Move the top disk of this tower to the top of t.
    public void moveTopTo(Tower t) {
        // Write your code here
        int top = disks.pop();
        t.add(top);
    }

    // @param n an integer
    // @param destination a tower
    // @param buffer a tower
    // Move n Disks from this tower to destination by buffer tower
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Write your code here
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    public Stack<Integer> getDisks() {
        return disks;
    }
}
