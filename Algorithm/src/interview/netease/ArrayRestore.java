package interview.netease;

/**
 * 网易2017年笔试题
 * 数组还原
 * Created by Administrator on 2017/8/11 0011.
 */
import java.util.*;

public class ArrayRestore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] A = new int[n];
            boolean[] flag = new boolean[n+1];
            for (int i = 0; i < n ; i++) {
                A[i] = sc.nextInt();
                if (A[i] != 0) {
                    flag[A[i]] = true;
                }
            }
            // 找出模糊的数字
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (flag[i] == false) {
                    list.add(i);
                }
            }

            List<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();

            // 计算全排列
            calPerm(perm, list, 0);
            
            //统计已有的排列的顺序对
            int cv = 0;
            for(int i=0;i<n;i++){
                if(A[i]!= 0){
                    for(int j=i+1;j<n;j++){
                        if(A[j] != 0 && A[i] < A[j]) {
                            cv++;
                        }
                    }
                }
            }
            // 结果
            int res = 0; 
            
            //计算每个模糊数字排列的顺序对，如果与k相等，则结果res加一
            for(ArrayList<Integer> tmp : perm){
                int val = cv;
                int[] tmpA = Arrays.copyOf(A, n);
                val += calValue(tmp, tmpA);
                if(val == k)
                    res++;
            }

            System.out.println(res);
        }
    }

    private static int calValue(ArrayList<Integer> list, int[] A) {
        int val = 0;
        int j = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                A[i] = list.get(j++);
                for(int k = 0; k < i; k++){
                    if(A[k]!=0 && A[k]<A[i])
                        val++;
                }

                for(int k = i+1;k < A.length; k++){
                    if(A[k]!=0 && A[k]>A[i])
                        val++;
                }
            }
        }
        return val;
    }

    private static void calPerm(List<ArrayList<Integer>> perm, ArrayList<Integer> list, int n) {
        if (n == list.size()) {
            perm.add(new ArrayList<>(list));
        } else {
            for (int i = n; i < list.size(); i++) {
                Collections.swap(list, i, n);
                calPerm(perm, list, n+1);
                Collections.swap(list, i, n);
            }
        }
    }
}
