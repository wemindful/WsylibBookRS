package cn.whsw.lib.Action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.whsw.lib.sevices.RbooksServices;

public class GetAttention extends ActionSupport {

	@Autowired
	private RbooksServices rbooksServices;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * http://localhost:8080/BooksRecommand/main/admin.html
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		String json = rbooksServices.queryBookAttention();
		result=json;
		return ActionSupport.SUCCESS;
	}
}
