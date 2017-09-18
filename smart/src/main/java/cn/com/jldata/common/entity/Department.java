package cn.com.jldata.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * Created by Anonymous on 2016/4/12.
 */
 
@Table(name = "sssp_department")
@Entity
public class Department {
 
    private Integer id;
    private String departmentName;
 
 
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getDepartmentName() {
        return departmentName;
    }
 
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}