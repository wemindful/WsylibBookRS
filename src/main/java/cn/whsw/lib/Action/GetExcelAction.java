package cn.whsw.lib.Action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author DGW-PC
 * @data   2017年9月22日
 */
public class GetExcelAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private InputStream inputStream;
	private String filename;
	
	public GetExcelAction() {
		
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	@Override
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/resource/图书推荐表.xls");
		String name = FilenameUtils.getName(path);
		filename = name;
		filename = URLEncoder.encode(filename, "utf-8");
		inputStream = new FileInputStream(path);
		return ActionSupport.SUCCESS;
	}
	

}
