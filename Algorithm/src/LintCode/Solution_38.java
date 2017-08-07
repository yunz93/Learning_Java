package LintCode;

/**
 * LintCode 38
 * 搜索二维矩阵 II
 * 这种题目基本思路很容易找，重点在于根据所给数据的特点改进复杂度
 * Created by Administrator on 2017/8/5 0005.
 */
public class Solution_38 {
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int x = m;
        int y = 0;
        int num = 0;

        while (x >= 0 && y <= n) {
            if (matrix[x][y] == target) {
                x--;
                y++;
                num++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }

        return num;
    }
}
