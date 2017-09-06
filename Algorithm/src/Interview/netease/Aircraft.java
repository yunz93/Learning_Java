package Interview.netease;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 网易17年笔试题
 * 星际穿越
 * Created by Administrator on 2017/8/11 0011.
 */
public class Aircraft {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            long h = in.nextLong();
            double res = Math.floor((Math.sqrt(1 + 4 * h) - 1) / 2);

            DecimalFormat df = new DecimalFormat("0");
            System.out.println(df.format(res));
        }
    }
}
