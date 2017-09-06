package Interview.nowcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContinueInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            // 排序
            Arrays.sort(nums);
            Set<Integer> set = new HashSet<>();
            for (Integer i : nums) {
                set.add(i);
            }
            // 判断重复值
            if (set.size() != n) {
                System.out.println("mistake");
            }

            if (nums[n-1] - nums[0] == n) {
                // 则涂抹的是中间的数
                for (int i = 0; i < n - 1; i++) {
                    if(nums[i]+2 == nums[i+1]) {
                        System.out.println(nums[i] + 1);
                    }
                }
            } else if (nums[n-1] - nums[0] == n-1) {
                if (nums[0] == 1) {
                    System.out.println(nums[n-1] + 1);
                } else if (nums[0] > 1) {
                    System.out.println((nums[0] - 1) + " " + (nums[n-1] + 1));
                } else {
                    System.out.println("mistake");
                }
            } else {
                System.out.println("mistake");
            }
        }
    }
}
