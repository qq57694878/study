package com.ljl.study.entity;

public class Dept {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DEPT.DEPTNO
     *
     * @mbg.generated
     */
    private Short deptno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DEPT.DNAME
     *
     * @mbg.generated
     */
    private String dname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DEPT.LOC
     *
     * @mbg.generated
     */
    private String loc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DEPT.DEPTNO
     *
     * @return the value of DEPT.DEPTNO
     *
     * @mbg.generated
     */
    public Short getDeptno() {
        return deptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DEPT.DEPTNO
     *
     * @param deptno the value for DEPT.DEPTNO
     *
     * @mbg.generated
     */
    public void setDeptno(Short deptno) {
        this.deptno = deptno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DEPT.DNAME
     *
     * @return the value of DEPT.DNAME
     *
     * @mbg.generated
     */
    public String getDname() {
        return dname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DEPT.DNAME
     *
     * @param dname the value for DEPT.DNAME
     *
     * @mbg.generated
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DEPT.LOC
     *
     * @return the value of DEPT.LOC
     *
     * @mbg.generated
     */
    public String getLoc() {
        return loc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DEPT.LOC
     *
     * @param loc the value for DEPT.LOC
     *
     * @mbg.generated
     */
    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }
}