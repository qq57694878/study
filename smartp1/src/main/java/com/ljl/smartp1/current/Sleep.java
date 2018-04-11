package com.ljl.smartp1.current;

import java.util.Random;

public class Sleep {
    public static void sleepRandom(){
        Random random = new Random();
        int _int = random.nextInt(5);
        try {
            Thread.sleep(_int*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
