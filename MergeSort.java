/**
 * 归并排序
 */
public class MergeSort {
    public void mergeSort(int arr[]) {
        mergeSort_help(arr, 0, arr.length - 1);
    }

    private void mergeSort_help(int arr[], int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort_help(arr, l, mid);
            mergeSort_help(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    private void merge(int arr[], int l, int mid, int h) {
        int len = arr.length;
        int tempArr[] = new int[len];// 辅助数组
        for (int i = l; i <= h; i++) { // 将arr中的元素复制到辅助数组中
            tempArr[i] = arr[i];
        }
        int i = l;
        int j = mid + 1;
        int k = i;
        for (; i <= mid && j <= h; k++) {
            if (tempArr[i] < tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
        }
        while (i <= mid)// 若前半部分没复制完
            arr[k++] = tempArr[i++];
        while (j <= h)// 若后半部分没复制完
            arr[k++] = tempArr[j++];
    }
}