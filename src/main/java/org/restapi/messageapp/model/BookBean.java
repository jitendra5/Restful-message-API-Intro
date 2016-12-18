package org.restapi.messageapp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookBean {

private int bookId;
private String bookName;
private String author;
private int quantity;
public BookBean(){
	
}
public BookBean(int bookId, String bookName, String author, int quantity) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.author = author;
	this.quantity = quantity;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
