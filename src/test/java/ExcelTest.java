import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuxueli.poi.excel.ExcelExportUtil;

import cn.whsw.lib.Domain.ReplyBooks;
import cn.whsw.lib.dao.RbooksDao;

/**
 * @author DGW-PC
 * @data 2017年9月13日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExcelTest {

	@Autowired
	private RbooksDao rbookDao;

	/*
	 * 产生图书excel test
	 */
	@Test
	public void test1() {
		List<Map<String, Object>> books = rbookDao.findBooks();
		ArrayList<ReplyBooks> list = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			Map<String, Object> map = books.get(i);
			list.add(new ReplyBooks((Integer) map.get("bid"), (String) map.get("bookname"), (String) map.get("author"),
					(String) map.get("average"), (String) map.get("price"), (String) map.get("price"),
					(Integer) map.get("attention")));
		}
		
		 String filePath="src/main/webapps/resource/图书推荐表.xls"; 
		 ExcelExportUtil.exportToFile(list, filePath);
	}
}
