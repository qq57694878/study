package com.kulongtai.search.s.controller;

import com.kulongtai.search.s.common.RestResult;
import com.kulongtai.search.s.model.Article;
import com.kulongtai.search.s.service.XuningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Title: XuningController
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 16:45
 */
class PageParam{
	private int pageNumber;
	private int pageSize;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
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


	@RequestMapping(value = "search",method = RequestMethod.GET)
	public RestResult search(@RequestParam("q") String q,@RequestParam("pageNumber") int pageNumber,@RequestParam("pageSize") int pageSize,
			PageParam ppp ) throws Exception {
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		Page<Article> list  = xuningService.search(q,pageable);
		return new RestResult(list);
	}

	@RequestMapping(value = "findOne",method = RequestMethod.GET)
	public RestResult findOne(@RequestParam("id") String id)throws Exception{
		Article attachment  = xuningService.findOne(id);
		return new RestResult(attachment);
	}
	@RequestMapping(value ="create",method = RequestMethod.POST)
	public RestResult create(@RequestBody Article article)throws Exception{
		xuningService.create(article);
		return new RestResult();
	}
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public RestResult delete(@RequestParam("id") String id)throws Exception{
		xuningService.delete(id);
		return new RestResult();
	}
	@RequestMapping(value ="update",method = RequestMethod.POST)
	public RestResult update(@RequestBody Article article)throws Exception{
		xuningService.update(article);
		return new RestResult();
	}
}
