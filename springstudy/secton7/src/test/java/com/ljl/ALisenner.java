package com.ljl;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/14/014.
 */
@Component
public class ALisenner
{
    public ALisenner(){
        System.out.println("1");
    }
    @EventListener({ContextStartedEvent.class})
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("hahahahaahahahahahahahahahaha"+contextStartedEvent);
    }
}
