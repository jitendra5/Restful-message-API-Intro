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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.restapi.messageapp.model.Comment;
import org.restapi.messageapp.services.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	CommentService comments= new CommentService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Comment> getAllComments(@Context UriInfo uriInfo){
		String id[]= uriInfo.getPath().toString().split("/");
		//System.out.println(id[0]+id[1]+id[2]);
		return comments.getAllComments(Integer.valueOf(id[1]));
	}
	@GET
	@Path("/{cmtId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment getCommentById(@Context UriInfo uriInfo, @PathParam("cmtId") int cmtId){
		String id[]= uriInfo.getPath().toString().split("/");
		//System.out.println(id[0]+id[1]+id[2]);
		return null;
		//return comments.getCommentById(msgId, cmtId);
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("msgId") int msgId, Comment comment){
	return comments.addComment(msgId, comment);	
	}
	@PUT
	@Path("/{cmtId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment updateComment(@PathParam("msgId") int msgId, @PathParam("cmtId") int cid, Comment comment){
		comment.setId(cid);
		return comments.updateComment(msgId, comment);
	}
	@DELETE
	@Path("/{cmtId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment deleteComment(@PathParam("msgId") int msgId,@PathParam("cmtId") int cid){
		return comments.removeComment(msgId, cid);
	}
}
