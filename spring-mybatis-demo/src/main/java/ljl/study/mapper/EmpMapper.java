package ljl.study.mapper;

import ljl.entity.Emp;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMP
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Short empno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMP
     *
     * @mbg.generated
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMP
     *
     * @mbg.generated
     */
    int insertSelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMP
     *
     * @mbg.generated
     */
    Emp selectByPrimaryKey(Short empno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMP
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table EMP
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Emp record);
}