package LintCode;

/**
 * LintCode 74
 * 第一个错误版本
 * 经典二分法
 * Created by Administrator on 2017/8/6 0006.
 */
public class Solution_74 {
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
