package org.restapi.messageapp.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.restapi.messageapp.database.DatabaseCon;
import org.restapi.messageapp.model.Comment;
import org.restapi.messageapp.model.MessageBean;

public class MessageService {
	private Map<Integer,MessageBean> messages=DatabaseCon.getMessages();
	public MessageService(){
		messages.put(1, new MessageBean(2,"Hello rest","23/10/1989","pavel"));
		messages.put(2, new MessageBean(1,"Hello world","12/10/2014","jitendra"));
		Map<Integer,Comment> comments=new HashMap<>();
		comments.put(1, new Comment(1, "hey","Jitendra" , "10/12/2015"));
		comments.put(1, new Comment(2, "Namaste","Nikil" , "23/12/2016"));
		messages.get(1).setComments(comments);
	}
	public List<MessageBean> getAllMessages(){
		return new ArrayList<MessageBean>(messages.values());
	}
	public List<MessageBean> getMessageByYear(int year){
		ArrayList<MessageBean> list=new ArrayList<>();
		for(MessageBean msg:messages.values()){
			int requiredYear=Integer.parseInt(msg.getCreationDate().substring(6));
			if(requiredYear==year){
				list.add(msg);
			}
		}
		return list;
	}
	public MessageBean getMesage(int id){
		return messages.get(id);
	}
	public MessageBean addMessage(MessageBean msg){
		msg.setMsgId(messages.size()+1);
		messages.put(msg.getMsgId(), msg);
		return msg;
	}
	public MessageBean updateMessage(MessageBean msg){
		if(msg.getMsgId()<=0){
			return null;
		}
			messages.put(msg.getMsgId(), msg);
			return msg;
	}
	public MessageBean removeMessage(int id){
		
		return messages.remove(id);
	}
}
