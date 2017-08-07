package LintCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LintCode 90
 * K数和II
 * 递归思想，注意剪枝
 * 这题真是耗尽精力，怎么写都不对，bug了n久，返回的list一直是空的，脑子都糊了
 * 最后找了一下官方的答案，才知道这里将allist加到另一个reslist中，不能直接add(allist)
 * 需要add(new ArrayList<>(allist))
 * Created by Administrator on 2017/8/6 0006.
 */
public class Solution_90 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        Solution_90 s = new Solution_90();

        System.out.println(s.kSumII(A, k, target));
    }

    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (A == null || A.length == 0) {
            return res;
        }
        ArrayList<Integer> al = new ArrayList<>();
        Arrays.sort(A);
        find (A, 0, k, target, 0, al, res);
        System.out.println(res);
        return res;
    }

    void find(int[] A, int index, int k, int target, int sum,
              ArrayList<Integer> al,  ArrayList<ArrayList<Integer>> res) {
        if (al.size() == k && target == sum) {
            res.add(new ArrayList<Integer>(al));
            System.out.println( sum + " + " + al + " + "  + res);
            return;
        }
        if (sum > target) {
            return;
        }
        if (index > A.length - 1) {
            return;
        }
        al.add(A[index]);
        sum = sum + A[index];
        find (A, index + 1, k, target, sum, al, res);

        al.remove(al.size() - 1);
        sum = sum - A[index];
        find (A, index + 1, k,  target, sum, al, res);

        System.out.println();
    }
}
