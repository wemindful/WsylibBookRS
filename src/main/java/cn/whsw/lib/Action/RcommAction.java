package cn.whsw.lib.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.whsw.lib.Domain.RBooks;
import cn.whsw.lib.sevices.RbooksServices;
@Controller
public class RcommAction extends ActionSupport {

	/**
	 * 推送图书action
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest servletRequest;
	
	@Autowired
	private RbooksServices rbookservice;
    /**
     * json: {"bookname":"","author":"","pubdate":"","average":"","price":""}
     */
	@Override
	public String execute() throws Exception {
		servletRequest = ServletActionContext.getRequest();
		servletRequest.setCharacterEncoding("UTF-8");
		String bookname = servletRequest.getParameter("bookname");
		String author = servletRequest.getParameter("author");
		String pubdate = servletRequest.getParameter("pubdate");
		String average = servletRequest.getParameter("average");
		String price = servletRequest.getParameter("price");
		RBooks books = new RBooks(bookname, author, pubdate, average, price);
		rbookservice.recommBook(books);
		System.out.println(books.toString());
		return ActionSupport.SUCCESS;
	}
}
