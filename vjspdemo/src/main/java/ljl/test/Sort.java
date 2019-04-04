package ljl.test;

import java.util.Arrays;

/**
 * Title: Sort
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/22 16:47
 */
public class Sort {
	private static int[] data = {14,1,3,5,8,4,9,7,6,12,10,11,0,19,16,15,17,18,13,11,12,2};

	public static void main(String[] args) {

		//mergeSort(data,0,data.length-1,new int[data.length]);
		//inserSort(data,0,data.length-1);
		//selectSort(data);
		//shellSort(data);
		quickSort(data,0,data.length-1);
		print(data);
	}
	public static void print(int[] data){
		System.out.println(Arrays.toString(data));
	}

	public static void quickSort(int[]data,int low,int high){
		if(low<high){
			int partition = partition(data,low,high);
			quickSort(data,low,partition);
			quickSort(data,partition+1,high);
		}
	}

	private static int partition(int[] data, int low, int high) {
		int o = data[low];
		int i=low,j=high;
		while(i<j){
			while(i<j&&data[j]>=o)j--;
			swap(data,i,j);
			while(i<j&&data[i]<=o)i++;
			swap(data,i,j);
		}
		return i;

	}


	public static void shellSort(int[] data){
		for (int grap = data.length/2; grap>=1 ; grap/=2) {
			for (int i = grap; i <data.length ; i+=grap) {
				int temp = data[i];
				int j = i-grap;
				for ( ;j  >=0&&data[j]>temp; j-=grap) {
					data[j+grap]=data[j];
				}
				data[j+grap]=temp;
			}
		}
	}

	/**
	 * 选择排序
	 * @param data
	 */
	public static void  selectSort(int[]data){
		for (int i = 0; i <data.length-1 ; i++) {
			int m=i;
			for (int j = i+1; j <data.length ; j++) {
				if(data[j]<data[m]){
					m=j;
				}
			}
			swap(data,m,i);
		}
	}

	/**
	 * 归并排序
	 * @param data
	 * @param low
	 * @param high
	 * @param temp
	 */
	public static void  mergeSort(int[]data,int low,int high,int[]temp){
		if(low<high){
			if(high-low<6){
				inserSort(data,low,high);
			}
			int mid = (low+high)/2;
			int len = high-low+1;
			mergeSort(data,low,mid,temp);
			mergeSort(data,mid+1,high,temp);
			for(int k=low,i=low,j=mid+1;k<=high;k++){
				if(j>high||i<=mid&&data[i]<data[j]){
					temp[k]=data[i++];
				}else{
					temp[k]=data[j++];
				}
			}
			System.arraycopy(temp,low,data,low,len);
		}
	}

	public static void inserSort(int[]data,int low,int high){
		for (int i = 1; i <=high ; i++) {
			int temp = data[i];
			int j = i-1;
			for ( ;j >=low&&data[j]>temp; j--) {
				data[j+1]=data[j];
			}
			data[j+1]=temp;
		}
	}

	public static void swap(int[] data,int i,int j){
		int temp = data[i];
		data[i]=data[j];
		data[j]=temp;
	}


}
