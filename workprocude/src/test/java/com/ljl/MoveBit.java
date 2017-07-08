package com.ljl;

import org.junit.Test;

/**
 * Created by Administrator on 2017/6/26.
 */
public class MoveBit {

    @Test
    public void move(){
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;
        
        int i=10;
        i=i>>1;
        System.out.println(i);
    }
}
