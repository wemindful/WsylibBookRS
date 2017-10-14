package cn.whsw.lib.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ErrorProcess extends ActionSupport {
	/**
	 * 全局异常处理
	 */
	private static final long serialVersionUID = 1L;
	private Exception exception;

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	@Override
	public String execute() {
		ActionContext.getContext().getValueStack().push(this.exception.getMessage());// 放到值栈顶
		return ActionContext.SESSION;
	}
}
