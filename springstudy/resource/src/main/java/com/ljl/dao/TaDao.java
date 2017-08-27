package com.ljl.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/8/15/015.
 */
@Repository
public class TaDao {

    public void sayHell(){
        System.out.println("TaDao sayHello");
    }
    @Transactional
    public void save(){
        System.out.println("TaDao sayHello");
    }
}
