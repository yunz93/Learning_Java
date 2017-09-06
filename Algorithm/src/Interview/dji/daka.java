package Interview.dji;

import java.util.*;

/**
 * 写了这么多还是90%，我也是醉醉哒
 */
public class daka {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 处理输入
            int n = in.nextInt();
            String na = in.nextLine();   // 去掉换行符
            String[][] s = new String[n][2];
            for (int i = 0; i < n; i++) {
                String[] str = in.nextLine().split(" ");  // 分割
                s[i][0] = str[0];    // 日期
                s[i][1] = str[1];    // 打卡时间
            }

            int[] MonthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //月份天数

            // 处理打卡时间，用距离3：00的秒数表示
            for (int i = 0; i < n; i++) {
                String[] time = s[i][1].split(":");
                String[] day = s[i][0].split("\\.");

                int hour = Integer.parseInt(time[0]);
                int min = Integer.parseInt(time[1]);
                int second = Integer.parseInt(time[2]);

                int months = Integer.parseInt(day[0]);
                int days = Integer.parseInt(day[1]);
                int seconds = hour * 60 * 60 + min * 60 + second;

                // 如果时间超过3:00，算作当天
                if (hour >= 3) {
                    seconds -= 3*60*60;
                } else {   // 如果没超过，则算作前一天
                    // 如果是1号，算作前一个月最后一天
                    if (days == 1) {
                        months -= 1;
                        days = MonthDays[months-1];
                        seconds += 21*60*60;
                    } else {  // 作前一天
                        days -= 1;
                        seconds += 21*60*60;
                    }
                }
                // 处理输出
                if(months < 10 && days < 10) {
                    s[i][0] = "0" + months + "." + 0 + days;
                    s[i][1] = String.valueOf(seconds);
                } else if (months < 10 && days >= 10) {
                    s[i][0] = "0" + months + "." + days;
                    s[i][1] = String.valueOf(seconds);
                } else if (months >= 10 && days < 10) {
                    s[i][0] = months + "." + "0" + days;
                    s[i][1] = String.valueOf(seconds);
                } else {
                    s[i][0] = months + "." + days;
                    s[i][1] = String.valueOf(seconds);
                }
            }

            Map<String, int[]> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                int[] time = new int[3];
                String key = s[i][0];

                if (!map.containsKey(key)) {
                    time[0] = Integer.parseInt(s[i][1]);
                    time[1] = Integer.parseInt(s[i][1]);
                    time[2] = 1;
                    map.put(key, time);
                } else {
                    time[0] = Math.min(map.get(key)[0], Integer.parseInt(s[i][1]));
                    time[1] = Math.max(map.get(key)[1], Integer.parseInt(s[i][1]));
                    time[2] = map.get(key)[2] + 1;
                    map.put(key, time);
                }
            }

            int count = 0; // 打卡次数超过2次的天数
            for (String key : map.keySet()) {
                if (map.get(key)[2] >= 2) {
                    count++;
                }
            }

            // System.out.println(count);

            int free_start = 12 * 60 * 60 + 30 * 60 - 3 * 60 * 60; //休息起始时间
            int free_end = 14 * 60 * 60 - 3 * 60 * 60; //休息结束时间
            int worktime = 0;
            if (count > 0) {
                for (String key : map.keySet()) {
                    if (map.get(key)[2] >= 2) {
                        int start = map.get(key)[0];
                        int end = map.get(key)[1];
                        if (end < free_start || start >= free_end) {
                            worktime = end - start;
                        } else if (end >= free_end && start < free_start) {
                            worktime = end - start - (free_end - free_start);
                        } else if (start < free_start && end < free_end) {
                            worktime = free_start - start;
                        } else if (start >= free_start && end >= free_end) {
                            worktime = end - free_end;
                        }

                        if (worktime != 0) {
                            System.out.println(key + " " + worktime);
                        }
                    }
                }
            } else {
                System.out.println("-1");
            }
        }
    }
}
