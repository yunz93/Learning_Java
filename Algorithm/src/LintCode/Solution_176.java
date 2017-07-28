package LintCode;

import java.util.*;

/**
 * LintCode 图中两点之间的连线
 * 经典的DFS/BFS问题
 * DFS:简单的方法就是递归，不使用递归则使用栈
 * BFS:使用队列
 * Created by Administrator on 2017/7/26 0026.
 */
public class Solution_176 {
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (graph.isEmpty()) {
            return false;
        }

        //return DFSCheck(s, t);
        return BFSCheck(s, t);
    }

    Map<DirectedGraphNode,Boolean> visitedMap = new HashMap<>();

    boolean DFSCheck(DirectedGraphNode s, DirectedGraphNode t) {
        if (s == null || t == null)
            return false;

        if (s == t)
            return true;

        visitedMap.put(s, true);

        for (DirectedGraphNode neighbor : s.neighbors) {
            if (!visitedMap.containsKey(neighbor) && DFSCheck(neighbor, t)) {
                return true;
            }
        }
        return false;
    }

    Queue<DirectedGraphNode> queue = new LinkedList<>();

    boolean BFSCheck(DirectedGraphNode s, DirectedGraphNode t) {
        if (s == null || t == null)
            return false;

        if (s == t)
            return true;

        visitedMap.put(s, true);
        queue.offer(s);

        while(!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();

            for (DirectedGraphNode neighbor : node.neighbors) {
                if (neighbor == t) {
                    return true;
                }

                visitedMap.put(neighbor, true);
                queue.offer(neighbor);
            }
        }

        return false;
    }
}
