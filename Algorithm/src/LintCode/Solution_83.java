package LintCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

/**
 * LintCode 83
 * 寻找落单的数II
 * 相对于第一题，重复数字出现的次数变成了三次，要求一次遍历
 * 很明显位运算有简单方法，我没想出来==
 * 所以我用了一种比较笨的方法，HashMap
 * Created by Mahe on 2017/7/21.
 */
public class Solution_83 {
    public int singleNumberII(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for( int i = 0;i< A.length ; i++){
            if(map.containsKey(A[i])){
                int n = map.get(A[i]);
                map.put(A[i], n + 1);
            }else{
                map.put(A[i],1);
            }
        }

        Set<Entry<Integer, Integer>> entries = map.entrySet();
        LinkedList<Integer> ls = new LinkedList<>();

        for (Entry entry : entries) {
            if ((int)entry.getValue() == 1) {
                ls.add((Integer)entry.getKey());
            }
        }
        return ls.get(0);
    }

    /**
     *  位运算方法
     *  当a出现一次的时候，ones能保存a。当a出现两次的时候，twos能保存a。
     *  当a出现三次的时候，ones和twos都清零。
     *  所以，如果一个数值中所有的数都通过这个循环的话，出现三次的数都清零了
     *  有一个数如果出现一次，它保存在ones中；如果出现两次的话保存在twos中。
     */
    public int singleNumberII_2(int[] A) {
        int n = A.length;
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < n; i++)
        {
            ones = (ones ^ A[i]) & (~twos);
            twos = (twos ^ A[i]) & (~ones);
        }

        return ones;
    }
}
