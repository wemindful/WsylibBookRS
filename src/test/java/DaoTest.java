import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.whsw.lib.Domain.RBooks;
import cn.whsw.lib.dao.RbooksDao;
import cn.whsw.lib.sevices.RbooksServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class DaoTest {
	@Autowired
	private  RbooksDao rbooksDao;
	@Autowired
	private RbooksServices rbooksServices;
	@Test
	public void test() {
		System.out.println(rbooksDao.queryExistBook("Java编程思想2".trim()));
	}
	@Test
	public void test2() {
		RBooks books = new RBooks("武生院", "代购网", "2018-2", "0.3", "59");
		rbooksDao.insertBook(books);
	}
	@Test
	public void test3() {
		RBooks books = new RBooks("Java编程思想", "代购网", "2018-2", "0.3", "59");
		rbooksServices.recommBook(books);
	}
	
	@Test
	public void test4() {
		rbooksServices.queryBookAttention();
		//rbooksDao.queryBookAttentionNumber();
	}
	@Test
	public void test5() {
	/*	//String string = rbooksServices.getBooks(6);
		System.out.println(string);*/
	}
	@Test
	public void test6() {
		rbooksDao.copyOfTable();
	}
	@Test
	public void test7() {
		rbooksDao.insertReplayBook(new RBooks("202", "202", "202", "202", "202"));
	}
	
	@Test
	public void test8() {
		String page = rbooksServices.findPage(0, 6);
		System.out.println(page.toString());
	}
	@Test
	public void test9() {
	    ArrayList<RBooks> list2 = new ArrayList<>();
		List<Map<String,Object>> list = rbooksDao.findBooks(0, 8);
	    for (Map<String, Object> map : list) {
	    	  list2.add(new RBooks((String)map.get("bookname"), (String)map.get("author"), (String)map.get("datepicker"), (String)map.get("average"),(String)map.get("price")));
		}
	}
	@Test
	public void test10() {
		rbooksDao.removeGaolBooks("武生院");
	}
}
