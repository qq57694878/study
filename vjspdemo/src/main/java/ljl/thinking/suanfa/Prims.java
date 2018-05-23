package ljl.thinking.suanfa;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Prims  implements Iterator<java.lang.Long>{


    private Iterator iter;
    public Prims(){
        iter = new Iterator() {
            private long n=1;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Object next() {
                return n=n+2;
            }
        };
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {

        return null;
    }
}
