package Interview.netease;

import java.util.*;

/**
 * 网易17年春招笔试题
 * 消除重复元素
 * Created by Administrator on 2017/8/10 0010.
 */
public class EliminateDuplicate {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        int[] seq = new int[n];
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(s[i]);
        }
        //
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i --) {
            if (!q.contains(seq[i])) {
                q.offerFirst(seq[i]);
            }
        }
        int count = q.size();
        for (int i = 0; i < count - 1; i ++) {
            System.out.print(q.poll() + " ");
        }
        System.out.println(q.poll());
    }
}
