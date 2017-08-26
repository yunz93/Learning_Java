package interview.pinduoduo;

import java.util.Scanner;

/**
 * 拼多多2017内推题一
 * 虽然不大喜欢这家公司，感觉可能长久不了，但刷刷题也无所谓
 * 这道题第一反应是动态规划，可是转头一想，限制了结果为三个数的乘积
 * 所以很简单了，直接找出最大的三个数和最小的两个数（因为有负数的存在）
 * 求最大三个数乘积与最大数与最小的两数乘积的较大值
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextLong();
        }
        getLargestMul(array,n);
    }

    static void getLargestMul(long[] num, int len){
        long max1=0, max2=0, max3=0, min1=0, min2=0;
        for (int i = 0; i < len ; i++) {
            if(num[i]!=0){
                if(num[i] > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = num[i];
                }else if(num[i] > max2){
                    max3 = max2;
                    max2 = num[i];
                }else if(num[i] > max3){
                    max3 = num[i];
                }else if(num[i] < min1 ){
                    min2 = min1;
                    min1 = num[i];
                }else if(num[i] > min1 && num[i] < min2){
                    min2 = num[i];
                }
            }else continue;

        }
        long max = Math.max(max1*max2*max3, max1*min1*min2);
        System.out.println(max);
    }
}
