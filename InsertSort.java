//直接插入排序
public class InsertSort {
	public void insertSort(int arr[]){
		int i,j,temp;
		for(i=1;i<arr.length;i++){
			temp=arr[i];
			j=i-1;
			
			while(j>=0 && temp<arr[j]){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
}
