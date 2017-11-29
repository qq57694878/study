package cn.com.jldata.search.spmsearch.controller;

import cn.com.jldata.search.spmsearch.domain.Attachment;
import cn.com.jldata.search.spmsearch.service.AttachmentService;
import cn.com.jldata.search.spmsearch.vo.RestResult;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("findAll")
    public RestResult findAll(Page<Attachment>page) throws Exception {
        Page<Attachment> list  = attachmentService.findAll(page);
        return new RestResult(list.toPageInfo());
    }

    @RequestMapping("reIndexAll")
    public RestResult reIndexAll() throws Exception {
        attachmentService.reIndexall();

        return new RestResult();
    }


    @RequestMapping("search")
    public RestResult search(@RequestBody Map<String,String> param) throws Exception {
        int pageNum =Integer.parseInt(param.get("pageNum"));
        int pageSize = Integer.parseInt(param.get("pageSize"));
        String word =  param.get("word");
        Page<Attachment> page =new Page<>(pageNum,pageSize);
        Page<Attachment> list  = attachmentService.search(word,page);
        return new RestResult(list.toPageInfo());
    }

    @RequestMapping("findOne")
    public RestResult findOne(@RequestBody String id){
        Attachment attachment  = attachmentService.findOne(id);
        return new RestResult(attachment);
    }
    @RequestMapping("create")
    public RestResult create(@RequestBody Attachment attachment){
        attachmentService.create(attachment);
        return new RestResult();
    }
    @RequestMapping("delete")
    public RestResult delete(@RequestBody String id){
        attachmentService.delete(id);
        return new RestResult();
    }
    @RequestMapping("update")
    public RestResult update(@RequestBody Attachment attachment){
        attachmentService.update(attachment);
        return new RestResult();
    }
}
