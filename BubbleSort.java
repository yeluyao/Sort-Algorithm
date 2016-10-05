//冒泡排序，每次都将最大的放到最后一个位置，小的元素“浮”在上面
//最好时间复杂度O(n),最坏O(n^2),稳定排序
public class BubbleSort{	
	public void bubbleSort(int arr[]){
		int len=arr.length;
		boolean flag;//记录是否有发生交换
		for(int i=0;i<len;i++){
			flag=false;
			for(int j=1;j<len-i;j++){
				if(arr[j-1]>arr[j]){//如果前面的元素比后面的大，则交换
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
					flag=true;
				}
			}
			if(!flag){
				return;//如果没有发生交换，则表示排序结束
			}
		}
	}
}