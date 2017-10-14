package cn.whsw.lib.Action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.whsw.lib.Domain.RBooks;
import cn.whsw.lib.dao.RbooksDao;

/**
 * @author DGW-PC
 * @data 2017年10月2日
 */
public class AddReplay extends ActionSupport {

	/**
	 * 完成增加书到replay
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final HttpServletRequest request = ServletActionContext.getRequest();
	@Autowired
	private RbooksDao bookDao;
	@Override
	public String execute() throws Exception {
		Enumeration<String> names = request.getParameterNames();
		RBooks books = null;
		while (names.hasMoreElements()) {
			books = new RBooks(request.getParameter((String) names.nextElement()),
					request.getParameter((String) names.nextElement()),
					request.getParameter((String) names.nextElement()),
					request.getParameter((String) names.nextElement()),
					request.getParameter((String) names.nextElement()));
		}
		bookDao.insertReplayBook(books);
		return ActionSupport.SUCCESS;
	}

}
