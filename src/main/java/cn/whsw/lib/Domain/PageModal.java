package cn.whsw.lib.Domain;

import java.util.ArrayList;

public class PageModal<E>{
	 
	private int currentPage;
	private int count;
	private int totalRocord;
	private int totalPage;
	private ArrayList<E> listBook;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalRocord() {
		return totalRocord;
	}
	public void setTotalRocord(int totalRocord) {
		this.totalRocord = totalRocord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public ArrayList<E> getListBook() {
		return listBook;
	}
	public void setListBook(ArrayList<E> listBook) {
		this.listBook = listBook;
	}
	@Override
	public String toString() {
		return "PageModal [currentPage=" + currentPage + ", count=" + count + ", totalRocord=" + totalRocord
				+ ", totalPage=" + totalPage + ", listBook=" + listBook + "]";
	}
}
