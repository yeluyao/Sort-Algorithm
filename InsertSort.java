//直接插入排序,每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子序列中，直到全部插入完成。
//空间复杂度为O(1),最好情况（已经有序）时间复杂度为O(n),平均和最坏时间复杂度都为O(n^2)
public class InsertSort {
	public void insertSort(int arr[]){
		int i,j,temp;
		//一开始假设arr[0]是有序的
		for(i=1;i<arr.length;i++){
			temp=arr[i]; //取当前元素与前面有序子序列中的元素比较
			j=i-1; //j表示有序子序列的的下标，从最后一个元素开始
			
			while(j>=0 && temp<arr[j]){ //如果当前的元素比有序子序列中的小，则继续往前，同时有序的元素后移一位
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp; //如果当前的元素比有序子序列的大，则放在该元素后面。
		}
	}
}
