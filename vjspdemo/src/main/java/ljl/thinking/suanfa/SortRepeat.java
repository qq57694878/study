package ljl.thinking.suanfa;

import java.util.Arrays;

public class SortRepeat {
    private static int[] data = {2,1,3,5,8,4,9,7,6,12,10,11,0};
    public static void main(String[] args) {
         int[] temp = Arrays.copyOfRange(data,0,data.length);
        SortRepeat.mergeSort(data,temp,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int[] data,int[]temp, int low, int high){
        if(low<high){
            int mid = (low+high) /2;
            int len = high-low+1;
            mergeSort(data,temp,low,mid);
            mergeSort(data,temp,mid+1,high);
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
}
