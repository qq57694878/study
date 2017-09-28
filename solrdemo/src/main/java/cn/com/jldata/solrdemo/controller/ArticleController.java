package cn.com.jldata.solrdemo.controller;

import cn.com.jldata.solrdemo.domain.Article;
import cn.com.jldata.solrdemo.service.ArticleService;
import cn.com.jldata.solrdemo.vo.RestResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("findPage")
    public RestResult findPage(@RequestBody Article article, Page<Article>page){
        Page<Article> list  = articleService.findPage(article,page);
        return new RestResult(list);
    }

    @RequestMapping("findOne")
    public RestResult findOne(@RequestBody Integer id){
        Article article  = articleService.findOne(id);
        return new RestResult(article);
    }
    @RequestMapping("create")
    public RestResult create(@RequestBody Article article){
        articleService.create(article);
        return new RestResult();
    }
    @RequestMapping("delete")
    public RestResult delete(@RequestBody Integer id){
        articleService.delete(id);
        return new RestResult();
    }
    @RequestMapping("update")
    public RestResult update(@RequestBody Article article){
        articleService.update(article);
        return new RestResult();
    }
}
