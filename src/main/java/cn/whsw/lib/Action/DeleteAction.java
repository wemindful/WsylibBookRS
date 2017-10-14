package cn.whsw.lib.Action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.whsw.lib.dao.RbooksDao;

/**
 * @author DGW-PC
 * @data   2017年10月2日
 */
public class DeleteAction extends ActionSupport{

	/**
	 * 删除记录数
	 * deleteAction
	 */
	private static final long serialVersionUID = 1L;
    final HttpServletRequest request = ServletActionContext.getRequest();
    
    @Autowired
    private RbooksDao bookdao;
    
	@Override
	public String execute() throws Exception {
		String bookname = request.getParameter("bookname");
		bookdao.removeGaolBooks(bookname);
		return ActionSupport.SUCCESS;
	}
}
