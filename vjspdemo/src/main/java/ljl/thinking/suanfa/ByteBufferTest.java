package ljl.thinking.suanfa;

import java.math.BigDecimal;
import java.nio.*;

/**
 * Created by Administrator on 2017/7/14/014.
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(4096);
        System.out.println(new BigDecimal(Math.pow(2,32)));;
    }
}
