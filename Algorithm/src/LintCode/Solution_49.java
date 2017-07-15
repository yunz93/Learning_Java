package LintCode;

/**
 * LintCode 49
 * 字符大小写排序
 * 和lintcode 373 奇偶分割数组是一样的
 * Created by Administrator on 2017/7/14 0014.
 */
public class Solution_49 {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if (null == chars || chars.length == 0)
            return;

        int i = 0, j = chars.length - 1;

        while (i < j) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                j--;
            } else {
                i++;
            }
        }
    }
}
