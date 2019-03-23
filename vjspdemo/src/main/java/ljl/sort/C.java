package ljl.sort;

/**
 * Created by Administrator on 2019/2/23 0023.
 */
public class C {
    public static void main(String[] args) {
       int[]data ={2,1,3,7,6,5,9,4,8};
      //bubbleSort(data);
        //insertSort(data);
        //selectSort(data);
       // quickSort(data,0,data.length-1);
       // int[] tdata = new int[data.length];
      //  mergeSort(data,0,data.length-1,tdata);

       // insertSort1(data);
        shellSort(data);
       print(data);
    }

    /**
     * 归并排序
     * @param data
     * @param i
     * @param j
     */
    public static void mergeSort(int[]data,int i,int j,int[]tdata){
        if(i<j){
            int m = (i+j)/2;
            mergeSort(data,i,m,tdata);
            mergeSort(data,m+1,j,tdata);
            merge(data,i,j,m,tdata);
        }
    }

    private static void merge(int[] data, int i, int j, int m, int[] tdata) {
        int l=i;
        int h=m+1;
        for(int k=i;k<=j;k++){
            if(h>j||l<=m&&data[l]<data[h]){
                tdata[k]=data[l++];
            }else{
                tdata[k]=data[h++];
            }
        }
        System.arraycopy(tdata,i,data,i,j-i+1);
    }


    /**
     * 快速排序
     * @param data
     * @param i
     * @param j
     */
    public static void quickSort(int[]data,int i,int j){
        if(i<j){
            int partition = partition(data,i,j);
            quickSort(data,i,partition-1);
            quickSort(data,partition+1,j);
        }
    }

    private static int partition(int[] data, int i, int j) {
        int temp = data[i];
        while (i < j) {
            while(i<j&&data[j]>=temp){j--;}
            swap(data,i,j);
            while(i<j&&data[i]<=temp){i++;}
             swap(data,i,j);
        }
        return i;
    }
    /**
     * 打印
     * @param data
     */
    public static void print(int[]data){
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.println();
        }
    }

    /**
     * 选择排序，每次找最小
     * @param data
     */
    public static void selectSort(int[]data) {
        for (int i = 0; i < data.length; i++) {
            int k=i;
            for(int j=i+1;j<data.length;j++){
                if(data[j]<data[k]){
                    k=j;
                }
            }
            if(k!=i){
                swap(data,k,i);
            }
        }
    }
    /**
     * 插入排序
     * @param data
     */
    public static void insertSort(int[]data){
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j=i-1;
            while(j>=0&&data[j]>temp){
                swap(data,j,j+1);
                j--;
            }
           data[j+1]=temp;
        }
    }

    /**
     *  希尔排序
     * @param data
     */
    public static void shellSort(int[]data){
        int len = data.length;
        for(int g=len/2;g>=1;g/=2){
            for (int i = g; i < data.length; i+=g) {
                for(int j=i;j>0&&data[j]<data[j-g];j-=g){
                    swap(data,j,j-g);
                }
            }
        }

    }

    public static void insertSort1(int[]data){
        for (int i = 1; i < data.length; i++) {
            for(int j=i;j>0&&data[j]<data[j-1];j--){
                swap(data,j,j-1);
            }
        }
    }

    /**
     * 冒泡排序
     * @param data
     */
    public static void bubbleSort(int[]data){
        for(int i=0;i<data.length;i++){
            for(int j=1;j<data.length-i;j++){
                if(data[j-1]>data[j]){
                    swap(data,j,j-1);
                }
            }
        }
    }


    /**
     *
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[] data,int i,int j){
        int t= data[i];
        data[i]= data[j];
        data[j]=t;
    }
}
