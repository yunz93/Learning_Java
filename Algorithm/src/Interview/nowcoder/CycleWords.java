package Interview.nowcoder;

import java.util.*;

public class CycleWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            String[] words = new String[n];
            for (int i=0; i<n; i++) {
                words[i] = in.next();
                System.out.println("实际输入的是：" + words[i]);
            }

            int result = count(words);
            System.out.println(result);
        }
        in.close();
    }

    private static int count(String[] words) {
        if (words == null || words.length <= 0) {
            return 0;
        }
        ArrayList<String> list = new ArrayList<>();
        int count = 0;

        // 遍历数组所有单词
        for (int i=0; i<words.length; i++) {
            // 如果list中没有该单词，则加入
            String s = words[i];
            if (!list.contains(s)) {
                count++;
                list.add(s);
            }
            // 将该单词所有的循环单词全加入list
            for (int j=0; j<s.length()-1; j++) {
                char last = s.charAt(s.length() - 1);
                s = s.substring(0, s.length()-1);
                s = last + s;
                list.add(s);
            }
        }
        return count;
    }
}
