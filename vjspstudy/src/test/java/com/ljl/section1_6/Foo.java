package com.ljl.section1_6;

public class Foo {
    private Bar bar;
    private Baz baz;
    public Foo(Bar bar, Baz baz) {
       this.bar=bar;
       this.baz=baz;
    }
    public static class Bar{
        @Override
        public String toString() {
            return "Bar{}";
        }
    }
    public static class Baz{
        @Override
        public String toString() {
            return "Baz{}";
        }
    }
    public void sayHello(){
        System.out.println(this.bar+""+this.baz);
    }
}