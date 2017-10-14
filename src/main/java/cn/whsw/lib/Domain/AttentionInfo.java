package cn.whsw.lib.Domain;

public class AttentionInfo {
	
	private String bookname;
	private Integer attention;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Integer getAttention() {
		return attention;
	}
	public void setAttention(Integer attention) {
		this.attention = attention;
	}
	@Override
	public String toString() {
		return "AttentionInfo [bookname=" + bookname + ", attention=" + attention + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attention == null) ? 0 : attention.hashCode());
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
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
		AttentionInfo other = (AttentionInfo) obj;
		if (attention == null) {
			if (other.attention != null)
				return false;
		} else if (!attention.equals(other.attention))
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		return true;
	}
}
