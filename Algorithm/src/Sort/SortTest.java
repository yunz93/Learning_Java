package Sort;

/**
 * ≈≈–ÚÀ„∑®≤‚ ‘¿‡
 * Created by Administrator on 2017/6/17 0017.
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
        int left = 0;
        int right = arr.length - 1;
        int[] temp = new int[arr.length];

        Sort s = new Sort();
        // √∞≈›≈≈–Ú≤‚ ‘
//        s.BubbleSort(arr);
        // ∏ƒΩ¯√∞≈›≈≈–Ú≤‚ ‘
//        s.BetterBubbleSort(arr);
        // º¶Œ≤æ∆≈≈–Ú≤‚ ‘
//        s.CocktailSort(arr);
        // ºÚµ•—°‘Ò≈≈–Ú≤‚ ‘
//        s.SelectionSort(arr);
        // ≤Â»Î≈≈–Ú≤‚ ‘
//        s.InsertSort(arr);
        // ∂˛∑÷≤Â»Î≈≈–Ú≤‚ ‘
//        s.BinaryInsertSort(arr);
        // shell ≈≈–Ú≤‚ ‘
//        s.ShellSort(arr);
        // øÏÀŸ≈≈–Ú≤‚ ‘
//        s.QuickSort(arr, left, right);
        // πÈ≤¢≈≈–Ú≤‚ ‘
//        s.MergeSort(arr, left, right, temp);
        // ∂—≈≈–Ú≤‚ ‘
        s.HeapSort(arr, arr.length);
    }
}
