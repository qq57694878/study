package com.ljl.section7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by Administrator on 2017/8/11/011.
 */
@Configuration
public class ManageBean {
   @Bean("one")
   @Primary
    public OneClass one(){
        return new OneClass("one");
    }
    @Bean("two")
    public OneClass two(){
        return new OneClass("two");
    }

}
