package interview.huawei;


import java.util.Scanner;

public class  DuplicateRemove{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String num = in.nextLine();
            String res = solution(num);
            System.out.println(res);
        }
        in.close();
    }

    private static String solution(String num) {
        int[] c = new int[10];
        int index = 0;
        if (num == "0")
            return "0";
        for (int i = 0; i < num.length(); i++) {
            index = num.charAt(i) - '0';
            if(c[index] == 0)
                c[index] = 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int j = 9; j >=0; j--) {
            if (c[j] != 0) {
                sb.append(j);
            }
        }
        return sb.toString();
    }
}