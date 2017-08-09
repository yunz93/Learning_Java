package interview.netease;

/**
 * 网易17年笔试题
 * 赶去公司
 * 解题思路：简单计算
 * Created by Administrator on 2017/8/9 0009.
 */
import java.util.*;

public class GotoWork {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // 打车点坐标
        String[] tx = sc.nextLine().split(" ");
        String[] ty = sc.nextLine().split(" ");
        int[][] taxi = new int[n][2];
        for (int i = 0; i < n; i++) {
            taxi[i][0] = Integer.parseInt(tx[i]);
            taxi[i][1] = Integer.parseInt(ty[i]);
        }
        // 公司坐标
        String[] g = sc.nextLine().split(" ");
        int gx = Integer.parseInt(g[0]);
        int gy = Integer.parseInt(g[1]);
        // 速度
        String[] speed = sc.nextLine().split(" ");
        int walkSpeed = Integer.parseInt(speed[0]);
        int taxiSpeed = Integer.parseInt(speed[1]);
        // 步行时间
        int MinSumTime = (Math.abs(gx) + Math.abs(gy)) * walkSpeed;
        int tempTime;
        int mx = 0, my = 0;

        for (int i = 0; i < n; i++) {
            tempTime = (Math.abs(taxi[i][0] - mx) + Math.abs(taxi[i][1] - my)) * walkSpeed
            + (Math.abs(gx - taxi[i][0]) + Math.abs(gy - taxi[i][1])) * taxiSpeed;
            if (tempTime < MinSumTime) {
                MinSumTime = tempTime;
            }
        }
        System.out.println(MinSumTime);
    }
}
