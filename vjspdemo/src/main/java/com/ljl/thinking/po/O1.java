package com.ljl.thinking.po;

/**
 * Created by Administrator on 2017/7/13/013.
 */
public class O1 implements Comparable<O1>{
    private int id;

    public O1(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        O1 o1 = (O1) o;

        return id == o1.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(O1 o) {
        return this.id >o.id?1:this.id==o.id? 0: -1;
    }

    @Override
    public String toString() {
        return ""+id ;
    }
}
