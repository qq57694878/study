package com.ljl.section1_6;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/10/010.
 */
@Service("commandManager")
public abstract class CommandManager {

    public void process() {
        Command command = createCommand();
        command.execute();
    }
    @Lookup("AsyncCommand")
    public abstract Command createCommand();
}
