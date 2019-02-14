package ljl.thinking;

import Jama.Matrix;

/**
 * Title: MatrixMultiply
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/13 13:16
 */
public class MatrixMultiply {
	public static void main(String[] args) {

		double[][] a={{2,2,2},{2,2,2}};
		double[][] b={{2,2},{2,2},{2,2}};
		print(multiply(a,b));

		Matrix ma = new Matrix(a);
		Matrix mb = new Matrix(b);
		Matrix mc = 	ma.times(mb);
		mc.print(3,3);

	}
	public static void print(double a[][]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]);
				System.out.print(",");
			}
			System.out.print("\r\n");
		}
	}

	public static double[][] multiply(double a[][],double b[][]){
		int i=a.length;
		int j = b[0].length;
		int k = a[0].length;
		int k1= b.length;
		if(k!=k1){
			System.out.println("输入的矩阵不满足矩阵乘机条件");
			return null;
		}
		double c[][]=new double[i][j];
		for(int m=0;m<i;m++){
			for(int n=0;n<j;n++){
				double v=0;
				for(int p=0;p<k;p++){
					v+=a[m][p]*b[p][n];
				}
				c[m][n]=v;
			}
		}
		return c;
	}
}
