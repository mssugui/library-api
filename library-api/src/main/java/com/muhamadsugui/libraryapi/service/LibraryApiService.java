package com.muhamadsugui.libraryapi.service;

import java.util.List;

import com.muhamadsugui.libraryapi.entities.Book;
import com.muhamadsugui.libraryapi.entities.BookFamily;

public interface LibraryApiService {

	public List<BookFamily> getBookFamily();

	public List<Book> getBook();

	public BookFamily getBookFamilyById(int familyId);

	public Book getBookById(int bookId);

	public BookFamily addBookFamily(BookFamily bookFamily);

	public Book addBook(Book book);

	public BookFamily updateBookFamily(BookFamily bookFamily);

	public Book updateBook(Book book);
}
