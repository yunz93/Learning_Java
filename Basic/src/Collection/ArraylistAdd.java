package Collection;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/6 0006.
 */
public class ArraylistAdd {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> aal = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] % 2) == 0) {
                al1.add(arr[i]);
            } else {
                al2.add(arr[i]);
            }
        }

        aal.add(new ArrayList<Integer>(al1));
        aal.add(al2);
        System.out.println(al1);
        System.out.println(al2);
        System.out.println(aal);
    }
}
