package com.ljl.vuehttp.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: A
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/13 16:11
 */
public class A {
	public static void main(String[] args) {
		List list = new ArrayList(40000);
		for (int i = 0; i <40000 ; i++) {
			list.add("1234567"+i);
		}
		System.out.println(System.currentTimeMillis());
		list.contains("1234567"+1000);
		System.out.println(System.currentTimeMillis());
	}
}
