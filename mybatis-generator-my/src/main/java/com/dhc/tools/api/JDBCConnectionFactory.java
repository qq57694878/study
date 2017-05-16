/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.dhc.tools.api;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnectionFactory  {

    private String userId;
    private String password;
    private String connectionURL;
    private String driverClass;
    private Properties otherProperties;

    /**
     * This constructor is called when there is a JDBCConnectionConfiguration
     * specified in the configuration.
     * 
     * @param config
     */
    public JDBCConnectionFactory(com.dhc.tools.config.Config config) {
        super();
        userId = config.getDbUser();
        password = config.getDbPass();
        connectionURL = config.getDbURL();
        driverClass = config.getDriverClassName();

    }


    public Connection getConnection()
            throws Exception {
        Driver driver = getDriver();

        Properties props = new Properties();

            props.setProperty("user", userId); //$NON-NLS-1$

            props.setProperty("password", password); //$NON-NLS-1$


        Connection conn = driver.connect(connectionURL, props);


        return conn;
    }

    private Driver getDriver() throws Exception{
            Class<?> clazz = Class.forName(driverClass);
        Driver   driver = (Driver) clazz.newInstance();
        return driver;
    }

}
