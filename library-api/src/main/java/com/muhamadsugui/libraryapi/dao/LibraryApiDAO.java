package com.muhamadsugui.libraryapi.dao;

import java.util.List;

import com.muhamadsugui.libraryapi.entities.Book;
import com.muhamadsugui.libraryapi.entities.BookFamily;

public interface LibraryApiDAO {

	public List<BookFamily> getBookFamily();

	public List<Book> getBook();

	public BookFamily findBookFamilyById(int familyId);

	public Book findBookById(int bookId);

	public BookFamily saveBookFamily(BookFamily bookFamily);

	public Book saveBook(Book book);
}
