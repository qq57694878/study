package cn.com.jldata.solrdemo.controller;

import cn.com.jldata.solrdemo.domain.Article;
import cn.com.jldata.solrdemo.service.ArticleService;
import cn.com.jldata.solrdemo.vo.RestResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    public RestResult findPage(@RequestBody Article article, Page<Article>page){
        Page<Article> list  = articleService.findPage(article,page);
        return new RestResult(list);
    }


    public RestResult findOne(@RequestBody Integer id){
        Article article  = articleService.findOne(id);
        return new RestResult(article);
    }

    public RestResult create(@RequestBody Article article){
        articleService.create(article);
        return new RestResult();
    }
    public RestResult delete(@RequestBody Integer id){
        articleService.delete(id);
        return new RestResult();
    }
    public RestResult update(@RequestBody Article article){
        articleService.update(article);
        return new RestResult();
    }
}
