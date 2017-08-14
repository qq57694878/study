package com.ljl.thinking.suanfa;

import java.util.Arrays;



/**
 * Created by Administrator on 2017/7/23/023.
 */
public class SortTest {
    private static int[] data = {2,1,3,5,8,4,9,7,6,12,10,11,0};
    public static void main(String[] args) {
        //    insertSort(data,0,data.length-1);
        //selectSort(data,0,data.length-1);
       // quickSort(data,0,data.length-1);
        //int[]temp=new int[data.length];
       // mergeSort(data,temp,0,data.length-1);
       // shellSort(data,0,data.length-1);
        popSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int[] data,int[]temp, int low, int high){
        if(low<high){
            int mid = (low+high) /2;
            mergeSort(data,temp,low,mid);
            mergeSort(data,temp,mid+1,high);
            merge(data,temp,low,mid,high);
        }
    }

    private static void merge(int[] data, int[] temp, int low,int mid, int high) {
            for(int k=low,i=low,j=mid+1;k<=high;k++){
                if(j>high||i<=mid&&data[i]<=data[j]){
                    temp[k]=data[i++];
                }else{
                    temp[k]=data[j++];
                }
            }
            System.arraycopy(temp,low,data,low,high-low+1);
    }

    public static void quickSort(int[] data, int low, int high){
        if(low<high){
            int pos = partition(data,low,high);
            quickSort(data,low,pos-1);
            quickSort(data,pos+1,high);
        }
    }

    private static int partition(int[] data, int low, int high) {
      while(low<high){
          int temp = data[low];
          while(low<high&&data[high]>=temp){
              high--;
          }
          swap(data,low,high);
          while(low<high&&data[low]<=temp){
              low++;
          }
          swap(data,low,high);
      }
      return low;
    }

    public static void popSort(int[] data, int low, int high){
        for(int i=low;i<=high;i++){
            for(int j=low;j<high-i;j++){
                if(data[j]>data[j+1]){
                    swap(data,j,j+1);
                }
            }
        }
    }

    public static void selectSort(int[] data, int low, int high){
        for(int i=low;i<=high;i++){
            int k=i;
            for(int j=i;j<=high;j++){
                if(data[j]<data[k]){
                    k=j;
                }
            }
            if(k!=i){
                swap(data,k,i);
            }
        }
    }
    public static void shellSort(int[] data, int low, int high){
        int len=high-low +1;
        for(int grap=len/2;grap>=1;grap/=2){
            for(int i=low+grap;i<=high;i+=grap){
                for(int j=i;j>low&&data[j]<data[j-grap];j-=grap){
                    swap(data,j,j-grap);
                }
            }
        }
    }

    public static void insertSort(int[] data, int low, int high){
        for(int i=low+1;i<=high;i++){
            for(int j=i;j>low&&data[j]<data[j-1];j--){
                swap(data,j,j-1);
            }
        }
    }
    public static void swap(int[]data,int i,int j){
        int temp = data[i];
        data[i]= data[j];
        data[j]=temp;
    }
}
