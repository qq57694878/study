package com.ljl.algorithm;

/**
 * Title: DemoObj
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/25 14:18
 */
public class DemoObj {
	static{
		System.out.println("DemoObj staic init");
	}
	private static String AA="1";
	private String s;
	public DemoObj() {
		System.out.println("DemoObj1 constructor is run");
	}
	public DemoObj(String s) {
		this.s = s;
		System.out.println("DemoObj constructor is run");
	}
}
