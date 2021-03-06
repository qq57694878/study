package cn.com.jldata.search.spmsearch.mapper;

import cn.com.jldata.search.spmsearch.domain.SpHelpFile;
import com.github.pagehelper.Page;

import java.util.Map;

public interface SpHelpFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_help_file
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_help_file
     *
     * @mbg.generated
     */
    int insert(SpHelpFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_help_file
     *
     * @mbg.generated
     */
    int insertSelective(SpHelpFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_help_file
     *
     * @mbg.generated
     */
    SpHelpFile selectByPrimaryKey(String fileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_help_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SpHelpFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sp_help_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpHelpFile record);

    Page<Map<String,Object>> selectAll();
}