package cn.com.jldata.solrdemo.config;

import cn.com.jldata.solrdemo.domain.Article;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SolrIndexDemoAspect {

    @Pointcut("execution(* cn.com.jldata.solrdemo.mapper.ArticleMapper.insert*(..)) && args(cn.com.jldata.solrdemo.domain.Article)")
    public void insertArticle() {}
    @After("cn.com.jldata.solrdemo.config.SolrIndexDemoAspect.insertArticle() && args(pjp,article)")
    public void afterInsertArticle(JoinPoint pjp, Article article) throws Throwable {
        System.out.println(article);
    }
}
