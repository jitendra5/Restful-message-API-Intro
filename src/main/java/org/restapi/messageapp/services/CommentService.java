package org.restapi.messageapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restapi.messageapp.database.DatabaseCon;
import org.restapi.messageapp.model.Comment;
import org.restapi.messageapp.model.MessageBean;

public class CommentService {
private Map<Integer, MessageBean> messages=DatabaseCon.getMessages();

	public List<Comment> getAllComments(int msgId){
		Map<Integer, Comment> comments=messages.get(msgId).getComments();
		return new ArrayList<Comment>(comments.values());	
		}
	public Comment getCommentById(int msgId,int cmtId){
		Map<Integer,Comment> comment=messages.get(msgId).getComments();
		return comment.get(cmtId);
	}
	public Comment addComment(int msgId, Comment cmt){
		Map<Integer,Comment> comment=messages.get(msgId).getComments();
		cmt.setId(comment.size()+1);
		comment.put(cmt.getId(), cmt);
		return cmt;
	}
	public Comment updateComment(int msgId, Comment cmt){
		Map<Integer, Comment> comment=messages.get(msgId).getComments();
		if(cmt.getId()<=0){
			return null;
		}
		return comment.put(cmt.getId(),cmt);
	}
	public Comment removeComment(int msgId, int cmt){
		Map<Integer, Comment> comments=messages.get(msgId).getComments();
	return	comments.remove(cmt);
	}
}
