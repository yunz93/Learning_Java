package Sort;

import java.util.Arrays;

/**
 * 排序
 * Created by Administrator on 2017/6/17 0017.
 */
class Sort {
    /**
     * 冒泡排序
     */
    void BubbleSort(int[] arr) {
        int length = arr.length;
        int temp;

        for (int i = 0; i < length; i++) {
            System.out.println("第 " + i +" 趟排序的结果为：" + Arrays.toString(arr));

            for(int j = 1; j < length - i; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                }
            }
        }
    }

    /**
     * 改进冒泡排序
     * @param arr
     */
    void BetterBubbleSort(int[] arr) {
        int len = arr.length;
        boolean flag;

        for (int i = 0; i < len; i++) {
            System.out.println("第 " + i +" 趟排序的结果为：" + Arrays.toString(arr));

            flag = false;
            for(int j = 1; j < len - i; j++){
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    /**
     * 鸡尾酒排序
     * @param arr
     */
    void CocktailSort(int[] arr) {
        int index = 0;
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            System.out.println("第 " + index +" 趟排序的结果为：" + Arrays.toString(arr));
            for (int i = left; i < right; i++)  // 前半轮,将最大元素放到后面
                if (arr[i] > arr[i + 1])
                {
                    swap(arr, i, i + 1);
                }
            right--;
            for (int i = right; i > left; i--)  // 后半轮,将最小元素放到前面
                if (arr[i-1] > arr[i])
                {
                    swap(arr, i - 1, i);
                }
            left++;
            index++;
        }
    }

    /**
     * 简单选择排序
     */
    void SelectionSort(int[] arr) {
        int len = arr.length;
        int min;
        System.out.println("原始序列为：" + Arrays.toString(arr));
        for (int i = 0; i < len - 1; i++) { // i 表示已排序序列的末尾
            min = i;
            // 找出未排序序列中的最小值
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            // 放置到已排序序列的末尾
            if (min != i)
                swap(arr, min, i);
            System.out.println("第 " + (i+1) +" 趟排序的结果为：" + Arrays.toString(arr));
        }
    }

    /**
     * 插入排序
     */
    void InsertSort(int[] arr) {
        int len = arr.length;
        int a;  // 每一趟的待排序数
        System.out.println("原始序列为：" + Arrays.toString(arr));
        for (int i = 1; i < len; i++) { // 第一位元素被认为是已排序的
            a = arr[i];
            int j = i - 1;
            // 将待排序数插入到已排序序列的正确位置
            while (j >= 0 && arr[j] > a) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = a;

            System.out.println("第 " + i +" 趟排序的结果为：" + Arrays.toString(arr));
        }
    }

    /**
     * 二分插入排序
     */
    void BinaryInsertSort(int[] arr) {
        int len = arr.length;
        int a;  // 每一趟的待排序数
        int left, right, middle;
        System.out.println("原始序列为：" + Arrays.toString(arr));
        for (int i = 1; i < len; i++) { // 第一位元素被认为是已排序的
            a = arr[i];
            left = 0;
            right = i - 1;

            while (left <= right) {
                middle = (left+right)/2;
                if (arr[middle] > a)
                    right = middle-1;
                else
                    left = middle+1;
            }

            for(int j=i-1; j>=left; j--)
            {
                arr[j+1] = arr[j];
            }

            arr[left] = a;

            System.out.println("第 " + i +" 趟排序的结果为：" + Arrays.toString(arr));
        }
    }

    /**
     * shell 排序
     */
    void ShellSort(int[] arr) {
        int len = arr.length;
        int h = 0;
        int a;

        System.out.println("原始序列为：" + Arrays.toString(arr));

        h = len >> 1;  // 这里初始步长选取为序列长度的一半

        while (h >= 1)
        {
            for (int i = h; i < len; i++)
            {
                int j = i - h;
                a = arr[i];
                while ((j >= 0) && (arr[j] > a))
                {
                    arr[j + h] = arr[j];
                    j = j - h;
                }
                arr[j + h] = a;
            }
            System.out.println("步长 h 为: " + h + ", 插入排序的结果为：" + Arrays.toString(arr));

            h = h >> 1; // 递减增量
        }
    }

    /**
     * 快速排序
     */
    void QuickSort(int[] arr, int left, int right) {
        if (right <= left)
            return;

        int index = partition(arr, left, right);

        QuickSort(arr, left, index - 1);
        QuickSort(arr, index + 1, right);

        System.out.println(Arrays.toString(arr));
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];                    // 选择最后一个元素作为基准
        int tail = left - 1;                       // tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i < right; i++)         // 遍历基准以外的其他元素
        {
            if (arr[i] <= pivot)                   // 把小于等于基准的元素放到前一个子数组中
            {
                tail++;
                swap(arr, tail, i);
            }
        }
        swap(arr, tail + 1, right);              // 最后把基准放到前一个子数组的后边,剩下的子数组既是大于基准的子数组
        return tail + 1;                           // 返回基准的索引
    }

    /**
     * 归并排序
     */
    // 之所以把临时数组当做形参，是不想在递归的过程中去生成，这会生成很多临时数组，浪费资源
    void MergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right)
            return;

        int middle = (left + right) / 2;

        MergeSort(arr, left, middle, temp);
        MergeSort(arr, middle + 1, right, temp);
        // 归并两个已排序序列
        Merge(arr, left, middle, right, temp);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并操作
     */
    private void Merge(int[] arr, int left, int middle, int right, int[] temp) {
        int i = left, j = middle + 1;
        int m = middle,   n = right;
        int k = 0;

        // 两个序列的值按大小顺序依次拷贝到临时数组中，完成归并
        while (i <= m && j <= n)
        {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= m)
            temp[k++] = arr[i++];

        while (j <= n)
            temp[k++] = arr[j++];

        // 再将临时数组中的元素拷贝回原数组
        for (i = 0; i < k; i++)
            arr[left + i] = temp[i];
    }

    /**
     * 堆调整
     */
    private void heapify(int arr[], int i, int n)            // 堆调整函数(这里使用的是最大堆)
    {
        int leftchild = 2 * i + 1;          // 左孩子索引
        int rightchild = 2 * i + 2;         // 右孩子索引
        int largest;                        // 选出当前结点与左右孩子之中的最大值
        if (leftchild < n && arr[leftchild] > arr[i])
            largest = leftchild;
        else
            largest = i;
        if (rightchild < n && arr[rightchild] > arr[largest])
            largest = rightchild;
        if (largest != i)
        {
            swap(arr, i, largest);        // 把当前结点和它的最大(直接)子节点进行交换
            heapify(arr, largest, n);            // 递归调用，继续从当前结点向下进行堆调整
        }
    }

    private void buildheap(int arr[], int n)          // 建堆函数
    {
        for (int i = n / 2 - 1; i >= 0; i--) // 对每一个非叶结点
            heapify(arr, i, n);                  // 不断的堆调整
    }

    void HeapSort(int[] arr, int n) {
        int index = 1;
        System.out.println("原始序列为：" + Arrays.toString(arr));
        buildheap(arr, n);
        System.out.println("大顶堆序列为：" + Arrays.toString(arr));
        for (int i = n - 1; i >= 1; i--) {
            swap(arr, 0, i); // 将堆顶元素(当前最大值)与堆的最后一个元素互换(该操作很有可能把后面元素的稳定性打乱,所以堆排序是不稳定的排序算法)
            n--;                     // 从堆中去掉最后一个元素
            heapify(arr, 0, n);                  // 从新的堆顶元素开始进行堆调整
            System.out.println("第" + index + " 趟排序后序列为：" + Arrays.toString(arr));
            index++;
        }
    }


        /**
         * 交换元素
         */
    private void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
