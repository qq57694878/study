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
import java.util.Map;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("findAll")
    public RestResult findAll(Page<Article>page) throws Exception {
        Page<Article> list  = articleService.findAll(page);
        return new RestResult(list.toPageInfo());
    }

    @RequestMapping("reIndexAll")
    public RestResult reIndexAll() throws Exception {
        articleService.reIndexall();

        return new RestResult();
    }


    @RequestMapping("search")
    public RestResult search(@RequestBody Map<String,String> param) throws Exception {
        int pageNum =Integer.parseInt(param.get("pageNum"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        String word =  param.get("word");
        Page<Article> page =new Page<>(pageNum,pageSize);
        Page<Article> list  = articleService.search(word,page);
        return new RestResult(list.toPageInfo());
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
