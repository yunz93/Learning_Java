package Interview.sohu;

import java.util.Scanner;

public class KeepTheMax {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int cnt = scanner.nextInt();
        char[] arr = str.toCharArray();
        int[] num = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            num[i] = arr[i]-48;    // 将字符转换成数字放进数组中
        }

        int i = 0;
        int count = num.length;
        int flag = 0,j;
        int delcount = 0;//记录已删除个数的临时变量

        while( cnt > delcount && flag == 0 )//没有删够数量，还没有到最后一个数字
        {
            i++;
            if (num[i-1] < num[i])//前一个数字比后一个数字小，删除
            {
                for (j=i-1; j<=count-delcount-2; j++)//后面的数字依次往前进一格
                {
                    num[j]=num[j+1];
                }
                delcount++;//删除数量增1
                i=0;//从头开始查递增区间
            }
            if (i==count-delcount-1)//如果是最后一个数字
            {
                flag=1;
            }
        }

        for (i=0; i<count-cnt; i++)//依次输出数组中各个数字
        {
            System.out.print(num[i]);
        }
    }
}
