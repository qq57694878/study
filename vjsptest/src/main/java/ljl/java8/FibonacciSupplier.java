package ljl.java8;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibonacciSupplier implements Supplier<BigInteger> {
    private BigInteger a;
    private BigInteger b;

    public FibonacciSupplier() {
        a=new BigInteger("0");
        b=new BigInteger("1");
    }

    @Override
    public BigInteger get() {
        BigInteger temp = a.add(b);
        a=b;
        b=temp;
        return a;
    }

    public static void main(String[] args) {
        Stream s = Stream.generate(new FibonacciSupplier());
        s.limit(10).forEach(System.out::println);
    }
}
