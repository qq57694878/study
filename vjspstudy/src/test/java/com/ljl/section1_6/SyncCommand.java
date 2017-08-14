package com.ljl.section1_6;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/10/010.
 */
@Service("SyncCommand")
public class SyncCommand implements Command{
    @Override
    public void execute() {
        System.out.println("SyncCommand execute!");
    }
}
