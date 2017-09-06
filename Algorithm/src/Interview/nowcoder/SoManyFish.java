package Interview.nowcoder;

import java.util.*;

/**
 *
 */
public class SoManyFish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int minSize = in.nextInt();
            int maxSize = in.nextInt();
            int n = in.nextInt();
            int[] fishSize = new int[n];
            for (int i=0; i<n; i++) {
                fishSize[i] = in.nextInt();
            }

            int result = solution(minSize, maxSize, n, fishSize);
            System.out.println(result);
        }
        in.close();
    }

    private static int solution(int minSize, int maxSize, int n, int[] fishSize) {
        if (n == 0 || fishSize == null) {
            return maxSize - minSize + 1;
        }
        int count = 0;
        int[] fish = new int[1001];

        for (int i=0; i<n; i++) {
            for (int j = 2 * fishSize[i]; j <= maxSize && j <= 10 * fishSize[i]; j++) {
                fish[j] = 1;
            }
            for (int j = fishSize[i] / 2; j >= minSize && j >= Math.ceil(fishSize[i] / 10.0); j--) {
                fish[j] = 1;
            }
        }

        for (int i=minSize; i<=maxSize; i++) {
            if (fish[i] != 1) {
                count++;
            }
        }
        return count;
    }
}
