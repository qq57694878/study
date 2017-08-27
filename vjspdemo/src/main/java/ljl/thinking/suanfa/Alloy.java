package ljl.thinking.suanfa;

/**
 * Created by Administrator on 2017/8/16/016.
 */
public class Alloy {
    public static void main(String[] args) {
        System.out.println(Alloy.nthAlloy(100)) ;
    }
    public  static int nthAlloy(int n ){
        int result=12;
        int i=0;
          for(int j=0;j<Integer.MAX_VALUE;j++){
              int sum=0;
              for(int k=1;k<j;k++){
                 if(j%k==0){
                     sum+=k;
                 }
              }
              if(sum>j){
                  result= j;
                  i++;
                  if(i==n){
                      break;
                  }
              }
          }
      return result;
    }
}
