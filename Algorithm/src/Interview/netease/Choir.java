package Interview.netease;

import java.util.Scanner;

/**
 * 网易17年笔试题
 * 合唱团
 * Created by Administrator on 2017/8/10 0010.
 */

public class Choir{
    public static void main(String[] args){
        // 处理输入
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = scan.nextInt();
        }

        int k = scan.nextInt();
        int d = scan.nextInt();

        // max[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
        // min[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
        long[][] max = new long[k+1][n];
        long[][] min = new long[k+1][n];
        // init
        for(int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                //min[i][j] = Integer.MAX_VALUE;
                max[i][j] = 1;
                if (i == 1) {
                    min[i][j] = nums[j];
                    max[i][j] = nums[j];
                }
            }
        }

        // dp
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for(int m = 1; m <= d; m++){
                    if(j - m >= 0){
                        if(nums[j] > 0){
                            min[i][j] = Math.min(min[i][j], min[i - 1][j - m] * nums[j]);
                            max[i][j] = Math.max(max[i][j], max[i - 1][j - m] * nums[j]);
                        } else {
                            min[i][j] = Math.min(min[i][j], max[i - 1][j - m] * nums[j]);
                            max[i][j] = Math.max(max[i][j], min[i - 1][j - m] * nums[j]);
                        }
                    }
                }
            }
        }
        long Max = 0;
        for(int i = 0; i < n; i++) {
            Max = Math.max(Max, max[k][i]);
        }

        System.out.println(Max);
    }
}
