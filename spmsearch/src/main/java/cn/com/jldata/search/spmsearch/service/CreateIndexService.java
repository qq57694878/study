package cn.com.jldata.search.spmsearch.service;

import cn.com.jldata.search.spmsearch.domain.Attachment;
import cn.com.jldata.search.spmsearch.mapper.SpHelpFileMapper;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreateIndexService {
    @Autowired
    private SpHelpFileMapper spHelpFileMapper;
    @Autowired
    @Qualifier("solrClient")
    private SolrClient solrClient;
    public void reIndexall() throws Exception {
        solrClient.deleteByQuery("*:*");
        Page<Map<String,Object>> page = new Page<Map<String,Object>>(1,100);
        Page<Map<String,Object>> list  = this.findAll(page);
        this.createIndex(list);
        for(int i=2;i<=list.getPages();i++){
            page.setPageNum(i);
            page.setPageSize(100);
            list  = this.findAll(page);
            this.createIndex(list);
        }
        solrClient.optimize();
    }

    public void createIndex(Page<Map<String,Object>> list) throws Exception{
        if(list!=null&&list.size()>0){
            for(Map<String,Object> obj:list){
                SolrInputDocument solrInputDocument =new SolrInputDocument();

                solrInputDocument.addField("file_id",obj.get("file_id"));
                solrInputDocument.addField("file_title",obj.get("file_title"));
                solrInputDocument.addField("file_url",obj.get("file_url"));
                solrInputDocument.addField("file_description",obj.get("file_description"));
                solrInputDocument.addField("file_type",obj.get("file_type"));
                solrInputDocument.addField("file_extension_name",obj.get("file_extension_name"));
                solrInputDocument.addField("create_date",obj.get("create_date"));
                solrInputDocument.addField("file_content",obj.get("file_content"));
                solrClient.add(solrInputDocument);
                solrClient.commit();
            }

        }
    }
    private Page<Map<String,Object>> findAll(Page<Map<String, Object>> page) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            return spHelpFileMapper.selectAll();
    }
}
