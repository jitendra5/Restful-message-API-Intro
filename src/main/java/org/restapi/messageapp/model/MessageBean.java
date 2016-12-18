package org.restapi.messageapp.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class MessageBean {
private int msgId;
private String msg;
private String creationDate;
private String author;
private Map<Integer,Comment> comments=new HashMap<>();

public MessageBean(){
	
}

public MessageBean(int msgId, String msg, String date, String author) {
	super();
	this.msgId = msgId;
	this.msg = msg;
	this.creationDate = date;
	this.author = author;
}
public int getMsgId() {
	return msgId;
}
public void setMsgId(int msgId) {
	this.msgId = msgId;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getCreationDate() {
	return creationDate;
}
public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
//to avoid comments to come up when call to messages is made, use @xmlTransient annotation,
@XmlTransient 
public Map<Integer, Comment> getComments() {
	return comments;
}

public void setComments(Map<Integer, Comment> comments) {
	this.comments = comments;
}

}
