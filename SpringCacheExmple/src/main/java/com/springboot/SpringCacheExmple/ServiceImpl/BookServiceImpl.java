package com.springboot.SpringCacheExmple.ServiceImpl;

import org.springframework.stereotype.Service;

import com.springboot.SpringCacheExmple.Vo.Book;

@Service
public interface BookServiceImpl {
	
	public Book getBook(int id);
	
	public Book insertBook(Book book);
	
	public Book updateBook(Book book);
	
	public String deleteBook(int id);

}
