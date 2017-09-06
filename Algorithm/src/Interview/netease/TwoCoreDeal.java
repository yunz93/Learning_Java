package Interview.netease;

/**
 * 网易17年笔试题
 * 双核处理
 * 解题思路：01背包问题
 * Created by Administrator on 2017/8/9 0009.
 */
import java.lang.*;
import java.util.*;

public class TwoCoreDeal {
    public static void main(String[] args){
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        num = Integer.valueOf(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int[] task = new int[num];
        int sum = 0;
        for(int i = 0; i < num; i++){
            task[i] = Integer.valueOf(strings[i]) / 1024;
            sum += task[i];
        }
        int[][] handler = new int[num + 1][sum/2 + 1];
        for(int i = 0; i <= num; i++)
            for(int j = 0; j <= sum/2; j++){
                handler[i][j] = i==0 ? 0 : handler[i - 1][j];
                if(i > 0 && j >= task[i-1]) handler[i][j] = Math.max(handler[i-1][j], handler[i-1][j-task[i-1]] + task[i-1]);
            }
        System.out.print(Math.max(handler[num][sum/2], sum - handler[num][sum/2])*1024);
    }
}
