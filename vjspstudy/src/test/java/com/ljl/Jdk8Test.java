package com.ljl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Jdk8Test {

    public static void main(String[] args) {

    }
    @Test
    public void testStream(){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
       long n =  list.stream().filter(p -> p>5).count();
        System.out.println(n);
    }
}
