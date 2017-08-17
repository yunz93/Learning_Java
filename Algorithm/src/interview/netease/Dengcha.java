package interview.netease;

import java.util.*;

public class Dengcha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] =  sc.nextInt();
        }
        boolean res = solution(arr);
        if (res)
            System.out.println("Possible");
        else
            System.out.println("Impossible");
    }

    private static boolean solution(int[] arr) {
        if(arr.length == 1)
            return true;
        Arrays.sort(arr);
        int cha = arr[1] - arr[0];
        int last = arr[0];
        for (int i=1; i<arr.length; i++) {
            if((arr[i]-last) != cha) {
                return false;
            }
            last = arr[i];
        }
        return true;
    }
}
