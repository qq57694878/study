package com.vjsp;
import com.dhc.tools.config.Config;
import com.dhc.tools.config.ConfigParser;
import org.junit.Before;

/**
 * Created by Administrator on 2017/5/3.
 */
public class BaseTest {
    protected Config config;
    @Before
    public void loadConfig(){
        config = ConfigParser.parseConfig();
    }

}
