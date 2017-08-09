package LintCode;

/**
 * lintcode 422 最后一个单词的长度
 * Created by Administrator on 2017/8/7 0007.
 */
public class Solution_422 {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null) {
            return 0;
        }

        String[] str = s.split(" ");
        return str[str.length - 1].length();
    }
}
