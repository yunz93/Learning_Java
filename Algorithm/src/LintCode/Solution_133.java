package LintCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * LintCode 133
 * 最长单词
 * 给一个词典，找出其中所有最长的单词
 * 两次遍历的话，很简单，一次找最大长度，一次找最大长度的单词
 * 一次遍历的话，可以使用栈来处理，比当前最大长度大的单词入栈，并更新最大长度
 * 这样遍历一遍，栈顶端就是最大长度单词或之一，最后将顶端长度为最大长度的单词pop出来
 * Created by Administrator on 2017/7/17 0017.
 */
public class Solution_133 {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> al = new ArrayList<>();

        if (null == dictionary) {
            return al;
        }

        int maxLen = 0;
        Stack<String> s = new Stack<>();

        for(int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() >= maxLen) {
                s.push(dictionary[i]);
                maxLen = dictionary[i].length();
            }
        }

        while (!s.isEmpty()) {
            if (s.peek().length() == maxLen) {
                al.add(s.pop());
            } else {
                break;
            }
        }

        return al;
    }
}
