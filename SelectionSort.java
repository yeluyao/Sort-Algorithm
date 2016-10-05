//选择排序，进n-1遍的处理，第i遍将L[i...n]中最小者与L[i]交换位置。
public class SelectionSort {
	public void selectionSort(int arr[]){
		int len=arr.length;
		int index;//记录当前最小的元素下标
		for(int i=0;i<len-1;i++){
			index=i;
			for(int j=i+1;j<len;j++){//查找最小值
				if(arr[index]>arr[j]){
					index=j;
				}
			}
			if(index!=i){
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
			}
		}
	}
}
