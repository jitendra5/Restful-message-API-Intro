package org.restapi.messageapp.database;

import java.util.HashMap;
import java.util.Map;

import org.restapi.messageapp.model.BookBean;
import org.restapi.messageapp.model.MessageBean;

public class DatabaseCon {
private static Map<Integer,MessageBean> messages=new HashMap<>(); 
private static Map<Integer, BookBean> books=new HashMap<>();

public static Map<Integer,BookBean> getBooks(){
	return books;
}
public static Map<Integer,MessageBean> getMessages(){
	return messages;
	}
}
