package cn.com.jldata.common.entity;

import javax.persistence.*;
import java.util.Date;
 
/**
 * Created by Anonymous on 2016/4/12.
 */
 
@Table(name = "sssp_empoyee")
@Entity
public class Employee {
 
    private Integer id;
    private String lastName;
    private String email;
    private Date birth;
    private Date crateTime;
    private Department department;
 
 
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
 
    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }
 
    public void setBirth(Date birth) {
        this.birth = birth;
    }
 
 
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCrateTime() {
        return crateTime;
    }
 
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }
 
    @JoinColumn(name = "Department_ID")
    @ManyToOne
    public Department getDepartment() {
        return department;
    }
 
 
    public void setDepartment(Department department) {
        this.department = department;
    }
}