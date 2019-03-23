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
	private static int[] data = {2,1,3,5,8,4,9,7,6,12,10,11,0};

	public static void main(String[] args) {

		mergeSort(data,0,data.length-1,new int[data.length]);
		print(data);
	}
	public static void print(int[] data){
		System.out.println(Arrays.toString(data));
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
				for(int i=low+1;i<=high;i++){
					int j=i-1;
//					int temp  = 0;
//					for (int k = j; k >=low ; k--) {
//						 if(data[])
//					}
				}
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

	public void swap(int[] data,int i,int j){
		int temp = data[i];
		data[i]=data[j];
		data[j]=temp;
	}


}
