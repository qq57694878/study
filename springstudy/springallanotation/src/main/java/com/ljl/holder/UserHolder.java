package com.ljl.holder;

import com.ljl.entity.Sysuser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jinliang on 2016/9/6.
 */
public class UserHolder {
    private static Logger logger = LoggerFactory.getLogger(UserHolder.class);
    private static final ThreadLocal<Sysuser> tl = new ThreadLocal<Sysuser>();
    public static void setThreadLocalUser(Sysuser user) {
        tl.set(user);
       // logger.info("user:{}",user);
    }

    public static void removeThreadLocalUser() {
        tl.remove();
      //  logger.info("user removed");
    }

    public static Sysuser getThreadLocalUser() {
        Sysuser result = tl.get();
        if (result == null)
            throw new IllegalStateException("需要事先使用 UserHolder.setThreadLocalUser(user) 将 user对象存入，才可以调用 UserHolder.getThreadLocalUser(user) 方法");
        return result;
    }
}
