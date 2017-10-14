package cn.whsw.lib.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author DGW-PC
 * @data   2017年8月30日
 * 拦截异常登录请求
 */
public class LoginFiler implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest srequest = (HttpServletRequest) request;
        HttpServletResponse sresponse = (HttpServletResponse) response;
        String currentURL = srequest.getRequestURI();
        String targetURL = currentURL.substring(currentURL.indexOf("/",1),currentURL.length());
        System.out.println(targetURL);
        //如果session不为空就返回该session，如果为空就返回null
        HttpSession session = srequest.getSession(false);
        if("/main/admin.html".equals(targetURL)||"/main/info.html".equals(targetURL)){
            if(session==null||session.getAttribute("user")==null){
                sresponse.sendRedirect("login.jsp");
                return;
            }
        }
        chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
	}
}
