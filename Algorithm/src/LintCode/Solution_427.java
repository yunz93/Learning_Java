package LintCode;

import java.util.ArrayList;

/**
 * LintCode 427
 * 生成括号
 * 采用递归树的思想，当左括号数大于右括号数时可以加左或者右括号，否则只能加左括号
 * 当左括号数达到n时，剩下全部加右括号
 * Created by Administrator on 2017/8/2 0002.
 */
public class Solution_427 {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        String item = new String();
        getgenerateParentList(res, item, n, 0, 0);
        return res;
    }

    public void getgenerateParentList(ArrayList<String> res, String item,
                                      int n, int lge ,int rge) {
        if(lge==n){
            for(int i=0;i<n-rge;i++){
                item += ")";
            }
            res.add(new String(item));
            return;
        }


        getgenerateParentList(res, item+"(", n, lge+1, rge);

        if(lge > rge){
            getgenerateParentList(res, item+")", n, lge, rge+1);
        }
    }
}
