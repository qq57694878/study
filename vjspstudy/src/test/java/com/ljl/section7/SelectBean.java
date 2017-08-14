package com.ljl.section7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/11/011.
 */
@Service("SelectBean")
public class SelectBean {

    @Autowired
    private OneClass oneClass;
    @Autowired
    @Qualifier("two")
    private OneClass twoClass;

    public void sayHello(){
        System.out.println(this.oneClass);
    }
    public void sayHello1(){
        System.out.println(this.twoClass);
    }

}
