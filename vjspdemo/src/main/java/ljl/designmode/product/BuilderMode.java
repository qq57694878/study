package ljl.designmode.product;

/**
 * Title: Productor
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/14 15:37
 */
public class BuilderMode{
	static class A{
		private String a;
		private String b;
		private String c;
		public A(Builder p){
			this.a =p.a;
			this.b =p.b;
			this.c =p.c;
		}
	}

	static class Builder {
		String a;
		String b;
		String c;
		public Builder setA(String a) {
			this.a = a;
			return this;
		}

		public Builder setB(String b) {
			this.b = b;
			return this;
		}

		public Builder setC(String c) {
			this.c = c;
			return this;
		}

		public  A build() {
			return new A(this);
		}

		public static void main(String[] args) {
			A  a = new Builder().setA("1").setB("2").setC("3").build();
			System.out.println(a);
		}
	}
}

