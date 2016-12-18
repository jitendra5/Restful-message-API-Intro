package org.restapi.messageapp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.restapi.messageapp.model.Comment;
import org.restapi.messageapp.model.MessageBean;
import org.restapi.messageapp.services.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService message=new MessageService();
	
	@GET
	public List<MessageBean> getMessage(@QueryParam("year") String year){
			if(year==null){
			return message.getAllMessages();
			}
			else{
			System.out.println(Integer.valueOf(year));
			if(Integer.valueOf(year)>0)
			return message.getMessageByYear(Integer.valueOf(year));
			else
				return message.getAllMessages();
			}
			
		}
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MessageBean getMessageById(@PathParam("id") int id){
		return message.getMesage(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageBean createMessage(MessageBean msg){
		return message.addMessage(msg);
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageBean updateMessage(@PathParam("id") int id, MessageBean msg){
		msg.setMsgId(id);
		return message.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MessageBean deleteMessage(@PathParam("id") int id){
		return message.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommentResource handleComments(){
		return new CommentResource();
	}
}
