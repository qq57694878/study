package com.ljl.thinking.suanfa;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/13/013.
 */
public class Sort {

    public static void main(String[] args) {
       //Sort.selectSort(data,0,data.length-1);
       // Sort.insertSort(data,0,data.length-1);
      //  Sort.insertSortSwap(data,0,data.length-1);
       // Sort.bubbleSort(data,0,data.length-1);
      //  Sort.quickSort(data,0,data.length-1);
       // int[] temp = Arrays.copyOfRange(data,0,data.length);
       // Sort.mergeSort(data,temp,0,data.length-1);
      //  Sort.mergeSortGj(data,temp,0,data.length-1);
        Sort.shellSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));

    }


    private static int[] data = {2,1,3,5,8,4,9,7,6,0,10,11};
    public static void mergeSortGj(int[]data,int[] temp,int low,int high){
        int length = high-low+1;
        if(length<7){
            insertSort(data,low,high);
        }
            int mid = (low+high)/2;
            mergeSort(data,temp,low,mid);
            mergeSort(data,temp,mid+1,high);
        merge2(data,temp,low,mid,high);

    }

    /**
     * 归并排序
     * 把待排序的数组分成两部分， 对两部分分别进行归并排序，直到两部分有序，再将有序的两部分数组合并为一个有序的数组。
     * @param data
     * @param low
     * @param high
     */
    public static void mergeSort(int[]data,int[] temp,int low,int high){

        if(low<high){
            int mid = (low+high)/2;
            mergeSort(data,temp,low,mid);
            mergeSort(data,temp,mid+1,high);
            merge2(data,temp,low,mid,high);
        }
    }

    private static void merge(int[] data,int[] temp, int low, int mid, int high) {
       // int[] temp = new int[high-low+1];
        //两个有序的数组合并为一个
        int len = high - low + 1;
        if (data[mid]< data[mid+1]) {
            System.arraycopy(temp,low,data,low,len);
            return;
        }
        int k=low,i=low,j=mid+1;
         while(i<=mid&&j<=high){
             if(data[i]<data[j]){
                 temp[k++]=data[i++];
             }else{
                 temp[k++]=data[j++];
             }
         }
         //把数组中剩余的复制上
        while(i<=mid){
            temp[k++]=data[i++];
        }
        while(j<=high){
            temp[k++]=data[j++];
        }
        System.arraycopy(temp,low,data,low,len);
    }
    private static void merge2(int[] data,int[] temp, int low, int mid, int high) {
        // int[] temp = new int[high-low+1];
        //两个有序的数组合并为一个
        int len = high - low + 1;
        if (data[mid]< data[mid+1]) {
            System.arraycopy(temp,low,data,low,len);
            return;
        }

        for(int k=low,i=low,j=mid+1;k<high;k++){
            if(j>high||i<=mid&&data[i]<data[j]){
                temp[k]= data[i++];
            }else{
                temp[k]= data[j++];
            }


        }
        System.arraycopy(temp,low,data,low,len);
    }


    /**
     * 1）选择一个基准元素,通常选择第一个元素或者最后一个元素,
     * 2）通过一趟排序讲待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小。另一部分记录的 元素值比基准值大。
     * 3）此时基准元素在其排好序后的正确位置
     * 4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
     * @param data
     * @param low
     * @param high
     */
    public static void quickSort(int[] data,int low,int high){
        if(low<high){
            int pos = partition(data,low,high);
            quickSort(data,low,pos-1);
            quickSort(data,pos+1,high);
        }
    }
    //    private static int[] data = {2,1,3,5,8,4,9,7,6,0,10,11};
    public static int partition(int[]data, int low, int high){
        int temp = data[low];
        while(low<high){
            while(low<high&&data[high]>=temp){high--;}
            swap(data,low,high);
            while(low<high&data[low]<=temp){low++;}
            swap(data,low,high);
        }
        return low;
    }
/*    public static int partition(int[]data, int low, int high){
        int temp = data[low];
        int i=low,j=high;
        while(i<j){
            while(i<j&&data[j]>=temp){j--;}
            swap(data,i,j);
            while(i<j&data[i]<=temp){i++;}
           swap(data,i,j);
        }
        return i;
    }*/

    /**
     * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒
     * @param data
     */
    public static void bubbleSort(int[]data,int low,int high){
        for (int i = low; i < high-1; i++) {
            boolean f=true;
            for(int j=low;j<high-i-1;j++){
                if(data[j]>data[j+1]){
                    swap(data,j,j+1);
                    f=false;
                }
            }
            if(f)break;
        }
    }

    /**
     * 选择排序
     * 从第1个位置开始，找到剩下没排序的最小的，如果找到的元素索引顺序和当前的元素索引不一致，于第0个元素交换
     * 再从第2个位置开始，找剩下元素最小的，如果找到的元素索引顺序和当前的元素索引不一致，于第1个元素交换...
     * @param data
     */
    public static void selectSort(int[]data,int low,int high){
        for(int i=low;i<high;i++){
            int k=i;
            for(int j=i+1;j<high;j++){
                if(data[j]<data[k]) k=j;
            }
            if(k!=i){
                swap(data,k,i);
            }
        }
    }
   public static void shellSort(int[] data, int low, int high){
        int len = high - low +1;
        for(int grap=len/2;grap>=1;grap/=2){ //进行多少次组内插入排序
            for(int i=grap;i<len;i+=grap){//对组内元素按交换插入排序
                for(int j=i;j>0&&data[j]<data[j-1];j-=grap){
                    swap(data,j,j-1);
                }
            }
        }
   }

    /**
     * 插入排序
     * 从第1个元素开始，与之前有序的序列，从后向前和当前元素比，如果比较的元素比当前元素大后移一位，
     * 交换元素
     * @param data
     */
    public static void insertSort(int[]data,int low,int high){
          for(int i=low+1;i<high;i++){
              int temp=data[i];
              int j=i;
              while(j>0&&temp<data[j-1]){
                  data[j]=data[j-1];
                  j--;
              }
              if(j!=i){
                  data[j]=temp;
             }
          }
    }

    /**
     * 交换插入排序
     * @param data
     * @param low
     * @param high
     */
    public static void insertSortSwap(int[]data,int low,int high){
        for(int i=low+1;i<high;i++){
            for(int j=i;j>0&&data[j]<data[j-1];j--){
                swap(data,j,j-1);
            }
        }
    }

    /**
     * 交换
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[]data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j]= temp;
    }
}
