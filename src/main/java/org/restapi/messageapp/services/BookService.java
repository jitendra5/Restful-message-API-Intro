package org.restapi.messageapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restapi.messageapp.database.DatabaseCon;
import org.restapi.messageapp.model.BookBean;

public class BookService {
	private Map<Integer,BookBean> books=DatabaseCon.getBooks();
	
	public BookService(){
		books.put(1, new BookBean(1,"harrypotter","jkrowlings",4));
		books.put(2, new BookBean(2,"twilight","jacob",5));
	}
	public List<BookBean> getAllBooks(){
		return new ArrayList<BookBean>(books.values());
	}
	public BookBean getBookById(int id){
		return books.get(id);
	}
	public BookBean addBook(BookBean book){
		book.setBookId(books.size()+1);
		return books.put(book.getBookId(), book);
	}
	public BookBean updateBook(BookBean book){
		if(book.getBookId()<1){
			return null;
		}
		return books.put(book.getBookId(), book);
	}
	public BookBean deleteBook(int id){
		return books.remove(id);
	}
}
