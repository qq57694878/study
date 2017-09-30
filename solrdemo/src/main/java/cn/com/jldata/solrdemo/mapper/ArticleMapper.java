package cn.com.jldata.solrdemo.mapper;

import cn.com.jldata.solrdemo.domain.Article;
import com.github.pagehelper.Page;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Sep 28 16:30:54 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Sep 28 16:30:54 CST 2017
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Sep 28 16:30:54 CST 2017
     */
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Sep 28 16:30:54 CST 2017
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Sep 28 16:30:54 CST 2017
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Sep 28 16:30:54 CST 2017
     */
    int updateByPrimaryKey(Article record);

    /**
     *
     * @return
     */
    Page<Article> selectAll();
}