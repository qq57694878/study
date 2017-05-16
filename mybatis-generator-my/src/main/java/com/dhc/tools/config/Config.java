package com.dhc.tools.config;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Config {

    private String driverClassName;

    private String  pack;

    private String[] tNames;

    private String dbURL;

    private String dbUser = "test";

    private String dbPass = "test";

    private String sourcePackage="src/main/java";


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String[] gettNames() {
        return tNames;
    }

    public void settNames(String[] tNames) {
        this.tNames = tNames;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getSourcePackage() {
        return sourcePackage;
    }

    public void setSourcePackage(String sourcePackage) {
        this.sourcePackage = sourcePackage;
    }
}
