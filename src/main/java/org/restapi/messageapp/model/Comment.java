package org.restapi.messageapp.model;

public class Comment {
	private int id;
	private String comment;
	private String author;
	private String date;
	
	public Comment() {
		super();
	}
	public Comment(int id, String comment, String author, String date) {
		super();
		this.id = id;
		this.comment = comment;
		this.author = author;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
