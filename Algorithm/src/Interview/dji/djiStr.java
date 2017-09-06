package Interview.dji;

import java.util.*;

public class djiStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 处理输入
            int n = in.nextInt();
            // 去掉换行
            String s = in.nextLine();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.nextLine();
                int result = solution(strs[i]);
                System.out.println(result);
            }
        }
    }

    /**
     * 处理函数
     */
    private static int solution(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            // 寻找字符串中所有为‘j’的位置
            if (str.charAt(i) == 'j') {
                int numofd = 0;  // 该位置前面字符d的个数
                int numofi = 0;  // 该位置后面字符i的个数

                for (int j = 0; j < i; j++) {
                    if (str.charAt(j) == 'd') {
                        numofd++;
                    }
                }

                for (int j = i+1; j < str.length(); j++) {
                    if (str.charAt(j) == 'i') {
                        numofi++;
                    }
                }

                count = numofd * numofi;   // 相乘即为可能组成dji的方案数
            }
            result += count;    // 所有方案数之和即为结果
        }
        return result;
    }
}
