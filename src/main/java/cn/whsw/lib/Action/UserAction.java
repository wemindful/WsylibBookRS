package cn.whsw.lib.Action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.whsw.lib.Domain.User;

/**
 * @author DGW-PC
 * @data 2017年8月29日 登录 注销
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 由于只需要一个管理员: 索性本地化解决 帐号root 密码 pwdroot
	 */
	private User user;
	/*
	 * (non-Javadoc) user modal
	 * 
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */

	@Override
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	@Override
	public String execute() throws Exception {
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		if (user.getUsername().trim().equalsIgnoreCase("root")
				&& user.getPassword().trim().equalsIgnoreCase("pwdroot")) {
			System.out.println("登录成功");
			HttpSession session = ServletActionContext.getRequest().getSession(false);
			session.setAttribute("user", "root");
		} else {
			this.addActionError("账户名或密码错误!");
		}
	}
}
