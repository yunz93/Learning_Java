package Sort;

/**
 * �����㷨������
 * Created by Administrator on 2017/6/17 0017.
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
        int left = 0;
        int right = arr.length - 1;
        int[] temp = new int[arr.length];

        Sort s = new Sort();
        // ð���������
//        s.BubbleSort(arr);
        // �Ľ�ð���������
//        s.BetterBubbleSort(arr);
        // ��β���������
//        s.CocktailSort(arr);
        // ��ѡ���������
//        s.SelectionSort(arr);
        // �����������
//        s.InsertSort(arr);
        // ���ֲ����������
//        s.BinaryInsertSort(arr);
        // shell �������
//        s.ShellSort(arr);
        // �����������
//        s.QuickSort(arr, left, right);
        // �鲢�������
//        s.MergeSort(arr, left, right, temp);
        // ���������
        s.HeapSort(arr, arr.length);
    }
}
