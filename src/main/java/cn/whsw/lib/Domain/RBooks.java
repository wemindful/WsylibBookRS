package cn.whsw.lib.Domain;

import java.io.Serializable;

/**
 * @author DGW-PC
 * @data 2017年8月27日
 */
public class RBooks implements Serializable {

	/**
	 * CREATE TABLE `RBooks` (
	 * 
	 * `bid` integer NOT NULL AUTO_INCREMENT,
	 * 
	 * `bookname` varchar(300) NOT NULL,
	 * 
	 * `author` varchar(15) NULL,
	 * 
	 * `datepicker` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
	 * 
	 * `average` tinyint(5) NULL,
	 * 
	 * `price` varchar(100) NULL,
	 * 
	 * `attention` integer NULL,
	 * 
	 * PRIMARY KEY (`bid`)
	 * 
	 * );
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer bid;
	private String bookname;
	private String author;
	private String datepicker;
	private String average;
	private String price;
	private Integer attention;
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
	public Integer getAttention() {
		return attention;
	}
	public void setAttention(Integer attention) {
		this.attention = attention;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attention == null) ? 0 : attention.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((average == null) ? 0 : average.hashCode());
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + ((datepicker == null) ? 0 : datepicker.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RBooks other = (RBooks) obj;
		if (attention == null) {
			if (other.attention != null)
				return false;
		} else if (!attention.equals(other.attention))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (average == null) {
			if (other.average != null)
				return false;
		} else if (!average.equals(other.average))
			return false;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (datepicker == null) {
			if (other.datepicker != null)
				return false;
		} else if (!datepicker.equals(other.datepicker))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RBooks [bid=" + bid + ", bookname=" + bookname + ", author=" + author + ", datepicker=" + datepicker
				+ ", average=" + average + ", price=" + price + ", attention=" + attention + "]";
	}
	public RBooks(String bookname, String author, String datepicker, String average, String price) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.datepicker = datepicker;
		this.average = average;
		this.price = price;
	}
}
