package ljl.dao;

import ljl.entity.TCourse;

public interface TCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COURSE
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COURSE
     *
     * @mbg.generated
     */
    int insert(TCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COURSE
     *
     * @mbg.generated
     */
    int insertSelective(TCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COURSE
     *
     * @mbg.generated
     */
    TCourse selectByPrimaryKey(Long cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COURSE
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_COURSE
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TCourse record);
}