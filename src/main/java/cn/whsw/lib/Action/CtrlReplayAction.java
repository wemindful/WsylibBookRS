package cn.whsw.lib.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.whsw.lib.Domain.RBooks;
import cn.whsw.lib.dao.RbooksDao;

public class CtrlReplayAction extends ActionSupport{

	/**
	 *  在此提供分页的的数据传送
	 */
	private static final long serialVersionUID = 1L;
	final HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private RbooksDao rDao;

	@Override
	public String execute() throws Exception {
		
		/*
		 * /main/ctrlReplayAction.action?page=
		 */
		int curentPage =Integer.parseInt(request.getParameter("page"));
		
	    ArrayList<RBooks> list2 = new ArrayList<>();
		List<Map<String,Object>> list = rDao.findBooks((curentPage-1)*2, 2);
	    for (Map<String, Object> map : list) {
	    	  list2.add(new RBooks((String)map.get("bookname"), (String)map.get("author"), (String)map.get("datepicker"), (String)map.get("average"),(String)map.get("price")));
		}
	    ActionContext context = ActionContext.getContext();
	    context.put("books", list2);
	   // context.put("currentpage", curentPage);
	    request.setAttribute("currentpage", curentPage);
		return ActionSupport.SUCCESS;
	}
	
	
}
