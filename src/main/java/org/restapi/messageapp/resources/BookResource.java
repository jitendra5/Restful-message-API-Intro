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
import javax.ws.rs.core.MediaType;

import org.restapi.messageapp.model.BookBean;
import org.restapi.messageapp.services.BookService;

@Path("/books")

public class BookResource {
	
	BookService bookService=new BookService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookBean> getBooks(){
		return bookService.getAllBooks();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookBean getBookById(@PathParam("id")int id){
		return bookService.getBookById(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookBean addBooktoStore(BookBean book){
		return bookService.addBook(book);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookBean updateBook(@PathParam("id")int id, BookBean book){
		book.setBookId(id);
		return bookService.updateBook(book);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public BookBean deleteBook(@PathParam("id")int id){
		return bookService.deleteBook(id);
	}
}
