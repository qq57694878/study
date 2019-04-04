package com.kulongtai.search.s.controller;

import com.kulongtai.search.s.common.RestResult;
import com.kulongtai.search.s.model.Article;
import com.kulongtai.search.s.service.XuningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Title: XuningController
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 16:45
 */
@RequestMapping("xuning")
@RestController
public class XuningController {
	@Autowired
	private XuningService xuningService;

	@RequestMapping("reIndexAll")
	public RestResult reIndexAll() throws Exception {
		xuningService.reIndexall();
		return new RestResult();
	}
	@RequestMapping("rmIndexAll")
	public RestResult deleteAll() throws Exception {
		xuningService.rmIndexAll();
		return new RestResult();
	}


	@RequestMapping("search")
	public RestResult search(@RequestParam("term") String query,
			@PageableDefault(page = 0, size = 1) Pageable pageable) throws Exception {
		Page<Article> list  = xuningService.search(query,pageable);
		return new RestResult(list);
	}

	@RequestMapping("findOne")
	public RestResult findOne(@RequestBody String id){
		Article attachment  = xuningService.findOne(id);
		return new RestResult(attachment);
	}
	@RequestMapping("create")
	public RestResult create(@RequestBody Article article)throws Exception{
		xuningService.create(article);
		return new RestResult();
	}
	@RequestMapping("delete")
	public RestResult delete(@RequestBody String id){
		xuningService.delete(id);
		return new RestResult();
	}
	@RequestMapping("update")
	public RestResult update(@RequestBody Article article){
		xuningService.update(article);
		return new RestResult();
	}
}
