package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Book extends Outlet {
	private String publisher;
	private LocalDate publishDate;
	private String isbn;
	private String[] authers;
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String[] getAllAuthers() {		
		return authers!=null?authers.clone():null;
	}
	
	public void setAuthers(String[] authers) {
		this.authers = authers;
	}
	
	@Override
	public String toString() {
		return super.toString() 
				+ "\n, 出版商=" + publisher + ", 出版日期=" + publishDate + ", isbn=" + isbn 
				+ "\n, authers=" + Arrays.toString(authers);
	}
}
