package Interview.netease;

import java.util.Scanner;

/**
 * 网易2017年春招题
 * 调整队形
 * 最终目标是将男孩移到最左边，或者将女孩移到最左边。
 * 如果有B个男孩，则移到最左边的index分别为：0,1,2...B-1,所以所有index的和为（B-1）*B/2
 * 一次遍历，计算目前男孩所在的index的和为sumB，则sumB减去上面的和就是所求的结果。
 * 因此只要一次遍历，计算男孩所在的男孩的个数和男孩所在的index的和，求之差就行了。女孩同理。最后求最小值。
 * Created by Administrator on 2017/8/9 0009.
 */
public class AdjustQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int bNum = 0;
        int gNum = 0;

        int bSum = 0;
        int gSum = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'G'){
                gSum+= i;
                gNum++;
            }else if(s.charAt(i) == 'B'){
                bSum+= i;
                bNum++;
            }
        }

        int gRes = gSum - gNum*(gNum-1)/2;
        int bRes = bSum - bNum*(bNum-1)/2;
        System.out.println(Math.min(gRes, bRes));
    }
}
