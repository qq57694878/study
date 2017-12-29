package cn.com.jldata.search.spmsearch.controller;

import cn.com.jldata.search.spmsearch.service.CreateIndexService;
import cn.com.jldata.search.spmsearch.vo.RestResult;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateIndexController {
    @Autowired
    private CreateIndexService service;

    @RequestMapping("reIndexAll")
    public RestResult reIndexAll() throws Exception {
        service.reIndexall();
        return new RestResult();
    }
    @RequestMapping("deleteAll")
    public RestResult deleteAll() throws Exception {
        service.deleteAll();
        return new RestResult();
    }
}
