package cn.whsw.lib.Action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.whsw.lib.sevices.RbooksServices;

public class FindReplayAction extends ActionSupport{

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
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		String books = rbooksServices.getReplayBooks();
		result=books;	
		return ActionSupport.SUCCESS;
	}
	
}
