package com.ljl.section1_6;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/10/010.
 */
public class ComplexBean {

    private Properties properties;
    private List someList;
    private Map someMap;
    private Set someSet;
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List getSomeList() {
        return someList;
    }

    public void setSomeList(List someList) {
        this.someList = someList;
    }

    public Map getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map someMap) {
        this.someMap = someMap;
    }

    public Set getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set someSet) {
        this.someSet = someSet;
    }

    @Override
    public String toString() {
        return "ComplexBean{" +
                "properties=" + properties +
                ", someList=" + someList +
                ", someMap=" + someMap +
                ", someSet=" + someSet +
                ", dataSource=" + dataSource +
                '}';
    }
}
