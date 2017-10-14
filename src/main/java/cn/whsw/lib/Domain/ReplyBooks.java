package cn.whsw.lib.Domain;

import java.io.Serializable;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;

/**
 * @author DGW-PC
 * @data   2017年9月13日
 */
@ExcelSheet(name="推荐表",headColor=HSSFColorPredefined.LIGHT_GREEN)
public class ReplyBooks implements Serializable 
{

	/**
	 * 产生数据表信息实体
	 */
	private static final long serialVersionUID = 1L;
	@ExcelField(name="图书id")
	private Integer bid;
	@ExcelField(name="图书名称")
	private String bookname;
	@ExcelField(name="作者")
	private String author;
	@ExcelField(name="提交事件")
	private String datepicker;
	@ExcelField(name="豆瓣评分")
	private String average;
	@ExcelField(name="图书价格")
	private String price;
	@ExcelField(name="受关注度")
	private Integer attention;
	
	public Integer getAttention() {
		return attention;
	}
	public void setAttention(Integer attention) {
		this.attention = attention;
	}
	public ReplyBooks(Integer bid, String bookname, String author, String datepicker, String average, String price,
			Integer attention) {
		this.bid = bid;
		this.bookname = bookname;
		this.author = author;
		this.datepicker = datepicker;
		this.average = average;
		this.price = price;
		this.attention = attention;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDatepicker() {
		return datepicker;
	}
	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ReplyBooks [bid=" + bid + ", bookname=" + bookname + ", author=" + author + ", datepicker=" + datepicker
				+ ", average=" + average + ", price=" + price + "]";
	}
}
