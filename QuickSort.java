/**
 * 快速排序，基于分治法，在待排序列L[1...n]中任取一个元素pivot作为基准，通过一趟排序将待排序表划分成L[1...k-1]和L[k+1...n]，
 * 使得前面子序列的值都小于pivot，后面子序列的值都大于pivot
 * 空间效率：因为采用了递归，所以需要借助一个递归工作栈来保存每一层递归调用的必要信息。最好情况下是log(n+1),平均情况下栈深度为O(logn),最坏为
 * O(n) 时间效率：时间与划分是否对称有关，基本有序和基本逆序的时候，时间复杂度为O(n^2)，平均和最好情况都为0(nlogn)
 * 改进快排的方法：当递归过程中划分比较小的时候，不再继续进行递归调用快排，可以采用直接插入排序进行后续的排序工作。
 * 另一种方法是尽量选取一个可以将数据中分的枢轴元素 如从序列的头中尾选择三个元素，选取中间值作为最终的枢轴，或者随机选择枢轴元素，这样都会避免最坏情况的发生
 */
public class QuickSort {

	public void quicksort(int arr[]) {
		quickSort_help(arr, 0, arr.length - 1);
	}

	public void quickSort_help(int arr[], int l, int h) {
		if (l < h) {
			int pivotpos = partition(arr, l, h);// 确定枢轴值的位置
			quickSort_help(arr, l, pivotpos - 1);// 在分别对两个子表进行快排
			quickSort_help(arr, pivotpos + 1, h);
		}
	}

	// 找出枢轴值的位置
	public int partition(int arr[], int l, int h) {
		int temp = arr[l];// 将当前表中第一个元素作为枢轴值
		while (l < h) {
			// 从后往前找出第一个比temp小的元素
			while (l < h && arr[h] >= temp)
				h--;
			arr[l] = arr[h];// 将比temp小的元素放到左端
			// 从前往后找第一个比temp大的元素
			while (l < h && arr[l] <= temp)
				l++;
			arr[h] = arr[l];// 将比temp大的元素放到右端
		}
		arr[l] = temp;// 结束时l==h，这个位置就是枢轴值的位置
		return l;
	}

}