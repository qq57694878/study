package cn.com.jldata.solrdemo.service;

import cn.com.jldata.solrdemo.domain.Article;
import cn.com.jldata.solrdemo.mapper.ArticleMapper;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper  articleMapper;

    public int create(Article article) {
       return  articleMapper.insertSelective(article);
    }

    public int delete(Integer id) {
        return  articleMapper.deleteByPrimaryKey(id);
    }

    public int update(Article article) {
        return  articleMapper.updateByPrimaryKeySelective(article);
    }

    public Article findOne(Integer id) {
        return  articleMapper.selectByPrimaryKey(id);
    }

    public Page<Article> findPage(Article article,Page<Article> page) {
        return   null;
    }
}
