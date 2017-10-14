package cn.whsw.lib.sevices;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xuxueli.poi.excel.ExcelExportUtil;

import cn.whsw.lib.Domain.RBooks;
import cn.whsw.lib.Domain.ReplyBooks;
import cn.whsw.lib.dao.RbooksDao;

/**
 * @author DGW-PC
 * @data   2017年8月28日
 */
@Service
public class RbooksServices {
	@Autowired
	private  RbooksDao rbooksDao;
	/**
	 * 如果数据存在则关注度加一,否则数据全部入库
	 */
	public void recommBook(RBooks books) {
		if (rbooksDao.queryExistBook(books.getBookname())!=null) {
			rbooksDao.addAttentionCout(books.getBookname());
		}else {
			rbooksDao.insertBook(books);
		}
	}
	/**
	 * 返回json 数组 键为 bookname 值为attention
	 * @return 
	 *  
	 */
	public String queryBookAttention() {
		List<Map<String,Object>> number = rbooksDao.queryBookAttentionNumber();
	    String json = JSON.toJSONString(number);
		JSONArray array = JSON.parseArray(json);
		JSONObject object = new JSONObject();
		object.put("data", array);
		String jsonString = JSON.toJSONString(object);
		System.out.println(jsonString);
		return jsonString;
	}
	/*
	 * 根据需要的返回的数据大小返回 书本数
	 */
	public String findPage(int currenpage,int count) {
		List<Map<String,Object>> list = rbooksDao.findBooks(currenpage,count);
		String json = JSON.toJSONString(list);
		JSONArray array = JSON.parseArray(json);
		JSONObject object = new JSONObject();
		object.put("book", array);
		String string = JSON.toJSONString(object);
		System.out.println(string);
		return string;
	}
	public String findPage() {
		List<Map<String,Object>> list = rbooksDao.findBooks();
		String json = JSON.toJSONString(list);
		JSONArray array = JSON.parseArray(json);
		JSONObject object = new JSONObject();
		object.put("book", array);
		String string = JSON.toJSONString(object);
		System.out.println(string);
		return string;
	}
	/*
	 * 直接返回 replay 表存在饿记录数
	 */
	public String getReplayBooks() {
		List<Map<String,Object>> list = rbooksDao.findReplayBooks();
		String json = JSON.toJSONString(list);
		JSONArray array = JSON.parseArray(json);
		JSONObject object = new JSONObject();
		object.put("book", array);
		String string = JSON.toJSONString(object);
		System.out.println(string);
		return string;
	}
	/*
	 * 产生最新的数据表excel
	 * @param filepath 为 excel本地持久化路径
	 * 周期为 10分钟 持久化一次
	 */
	@Scheduled(cron = "0/30 * * * * ?")
	public void generateExcel() {
		List<Map<String, Object>> books = rbooksDao.findBooks();
		ArrayList<ReplyBooks> list = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			Map<String, Object> map = books.get(i);
			list.add(new ReplyBooks((Integer) map.get("bid"), (String) map.get("bookname"), (String) map.get("author"),
					(String) map.get("average"), (String) map.get("price"), (String) map.get("price"),
					(Integer) map.get("attention")));
		}
		String filepath = null;
		Properties properties = new Properties();
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("projectpath.properties");
		try {
			properties.load(stream);
			filepath=new String(properties.getProperty("excelpath"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 //String filePath="D:/DevTools/apache-tomcat-9.0.0.M22/webapps/BooksRecommand/resource/图书推荐表.xls"; 
		 ExcelExportUtil.exportToFile(list, filepath);
	}
	/**
	 * 复制主表的到从表显示推荐数据,
	 * 由管理员控制数据内容
	 */
	/*@Scheduled(cron = "* 0/10 * * * ?")
	public void generateReplayTable() {
		rbooksDao.copyOfTable();
	}*/
}
