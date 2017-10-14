package cn.whsw.lib.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.whsw.lib.Domain.RBooks;

/**
 * @author DGW-PC
 * @data 2017年8月27日
 */
@Repository
@Transactional
public class RbooksDao extends JdbcDaoSupport {
    
	@Autowired
	private void setJT(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}
	/**
	 * 查询书
	 * @param bookname
	 * @return
	 */
	public String queryExistBook(String bookname) {
		String sql="select bookname FROM rbooks WHERE bookname=?";//
		//String ob = this.getJdbcTemplate().queryForObject(sql, String.class,bookname);
		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class, bookname);
		if (list.size()==0) {
			return null;
		}
		return "true";
	}
	public void insertBook(RBooks books) {
		String sql="INSERT into rbooks(bookname,author,datepicker,average,price)VALUES(?,?,?,?,?)";
		  this.getJdbcTemplate().update(sql, new Object[] {
				books.getBookname(),books.getAuthor(),books.getDatepicker(),
				books.getAverage(),books.getPrice()
		});
	}
	public void addAttentionCout(String bookname) {
		String sql="select attention FROM rbooks WHERE bookname=?";
		String sql2="update rbooks set attention=? WHERE bookname=?";
		String num = this.getJdbcTemplate().queryForObject(sql, String.class,bookname);
		int attnum=Integer.parseInt(num);
		this.getJdbcTemplate().update(sql2,new Object[] {
				++attnum,bookname
		});
	}
	
	public List<Map<String,Object>> queryBookAttentionNumber() {
		String sql="SELECT  bookname,attention FROM rbooks ORDER BY attention DESC  LIMIT ?";
		//List<String> list = this.getJdbcTemplate().queryForList(sql, String.class, 6);
		List<Map<String,Object>> list = this.getJdbcTemplate().queryForList(sql, 6);
		return list;
	}
	
	public List<Map<String,Object>> findBooks(int currenpage,int count) {
		String sql="select * from rbooks ORDER BY attention DESC limit ?,?";
		List<Map<String,Object>> list = this.getJdbcTemplate().queryForList(sql, currenpage,count);
		return list;
	}
	public List<Map<String,Object>> findBooks() {
		String sql="select * from rbooks ORDER BY attention DESC";
		List<Map<String,Object>> list = this.getJdbcTemplate().queryForList(sql);
		return list;
	}
	/*
	 * 复制rbooks表结构到replay表
	 */
	public void copyOfTable() {
		this.getJdbcTemplate().execute("TRUNCATE replay");
		this.getJdbcTemplate().execute("INSERT INTO replay SELECT * FROM rbooks");
	}
	/*
	 * 重建表结构
	 */
	public void copyTRUNCATE() {
		this.getJdbcTemplate().execute("TRUNCATE replay");
	}
	/**
	 * @return 查询replay 表的数据内容
	 */
	public List<Map<String,Object>> findReplayBooks() {
		String sql="select * from replay";
		List<Map<String,Object>> list = this.getJdbcTemplate().queryForList(sql);
		return list;
	}
	/**
	 * 查询书
	 * @param bookname
	 * @return 查询结果
	 */
	public String queryExistReplayBook(String bookname) {
		String sql="select bookname FROM replay WHERE bookname=?";
		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class, bookname);
		if (list.size()==0) {
			return null;
		}
		return "true";
	}
	/**
	 * 删除指定的数据内容
	 * @param bookname
	 * @return 是否正确的删除了 数据
	 */
	public boolean removeGaolBooks(String bookname) {
		String sql="delete from rbooks where bookname= "+"\'"+bookname+"\'";
		int i = this.getJdbcTemplate().update(sql);
		if (i!=0) {
			return true;
		}
		return false;
	}
	public void insertReplayBook(RBooks books) {
		String sql="INSERT into replay(bookname,author,datepicker,average,price)VALUES(?,?,?,?,?)";
		  this.getJdbcTemplate().update(sql, new Object[] {
				books.getBookname(),books.getAuthor(),books.getDatepicker(),
				books.getAverage(),books.getPrice()
		});
	}
}
