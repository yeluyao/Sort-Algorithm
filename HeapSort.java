/**
 * 堆排序 特点：在排序过程中，将L[1...n]视为一棵完全二叉树的顺序存储结构，利用完全二叉树中双亲节点和孩子节点之间的内在关系，
 * 在当前无序区中选择关键字最大（或最小的元素） 堆排序的关键是构造初始堆，对初始序列建堆，就是一个反复筛选的过程。
 * n个节点的完全二叉树，最后一个结点是第n/2(向下取整)个结点的孩子。对第n/2个结点为根的子树筛选（对于大根堆，
 * 若根结点的关键字小于左右子女中关键字较大者，则交换） 使该子树成为堆。
 */

public class HeapSort {
	
	// 建立大根堆的算法,这里下标从0开始，所以最后一个结点是第n/2-1个结点的孩子。
	public void buildMaxHeep(int arr[]) {
		int len = arr.length;
		for (int i = len / 2 - 1; i >= 0; i--) {// 反复调整堆
			ajustDown(arr, i, len);
		}
	}

	// 调整堆，将元素k向下进行调整
	public void ajustDown(int arr[], int k, int len) {
		int temp = arr[k];
		for (int i = 2 * k + 1; i < len; i = 2 * i + 1) {// 沿key较大的子结点向下筛选
			if (i < len - 1 && arr[i] < arr[i + 1])// 如果左结点小于右结点，下标指向右节点
				i++;
			if (temp > arr[i])// 如果根结点比左右结点都大
				break;
			else {
				arr[k] = arr[i];// 将arr[i]调整到父结点上
				k = i;// 修改k的值，继续向下筛选
			}
		} // for
		arr[k] = temp;// 被筛选结点的值放入最终位置
	}

	// 堆排序算法
	public void heapSort(int arr[]) {
		buildMaxHeep(arr);

		int len = arr.length;

		for (int i = len - 1; i > 0; i--) {
			int temp = arr[i];// 将堆顶元素跟堆底元素交换
			arr[i] = arr[0];
			arr[0] = temp;
			ajustDown(arr, 0, i);// 整理，把剩余的i-1个元素整理成堆
		}
	}
}