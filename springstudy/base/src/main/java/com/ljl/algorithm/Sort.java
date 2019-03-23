package com.ljl.algorithm;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/16/016.
 */
public class Sort {
    private static int[] data = {2,1,3,5,8,4,9,7,6,0,10,11,-1};

    public static void main(String[] args) {
        //selectSort(data,0,data.length);
        //insertSort(data,0,data.length);
        //popSort(data,0,data.length);
        //quickSort(data,0,data.length-1);
       // int[]temp= new int[data.length];
        //mergeSort(data,temp,0,data.length-1);
        shellSort(data,0,data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int[]data,int[] temp,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(data,temp,low,mid);
            mergeSort(data,temp,mid+1,high);
            merge(data,temp,mid,low,high);
        }
    }

    private static void merge(int[] data, int[] temp, int mid, int low, int high) {
        int len = high-low+1;
        if (data[mid]< data[mid+1]) {
            return;
        }
         for(int i=low,m=low,n=mid+1;i<=high;i++){
             if(n<=high&&data[n]<=data[m]||m>mid){
                 temp[i] = data[n++];
             }else{
                 temp[i] = data[m++];
             }
         }
         System.arraycopy(temp,low,data,low,len);

    }

    public static void quickSort(int[]data,int low,int high){
        if(low<high){
            int pos = partition(data,low,high);
            quickSort(data,low,pos-1);
            quickSort(data,pos+1,high);
        }

    private static int partition(int[] data, int low, int high) {
        int temp = data[low];
        while(low<high){
            if(low<high){
                while(low<high&&data[high]>=temp){high--;}
                swap(data,high,low);
                while(low<high&&data[low]<=temp){low++;}
                swap(data,low,high);
            }
        }
        return low;
    }


    public static void popSort(int[]data,int low,int high){
        for(int i=low;i<high;i++){
            for(int j=0;j<high-i-1;j++){
                if(data[j]>data[j+1]){
                    swap(data,j,j+1);
                }
            }
        }
    }
    public static void shellSort(int[]data,int low,int high){
        int len=high-low +1;
        for(int grap=len/2;grap>=1;grap/=2){
            for(int i=low;i<high;i+=grap){
                for(int j=i;j>0&&data[j]<data[j-grap];j-=grap){
                    swap(data,j,j-grap);
                }
            }
        }

    }

    public static void insertSort(int[]data,int low,int high){
        for(int i=low;i<high;i++){
            for(int j=i;j>0&&data[j]<data[j-1];j--){
                swap(data,j,j-1);
            }
        }
    }

    public static void selectSort(int[]data,int low,int high){
        for(int i=low;i<high;i++){
            int k=i;
            for(int j=i+1;j<high;j++){
                if(data[j]<data[k]){
                    k=j;
                }
            }
            if(k!=i){
                swap(data,i,k);
            }
        }
    }
    public static void swap(int[] data,int i,int j){
      int temp = data[i];
      data[i] = data[j];
      data[j] = temp;
    }
}
