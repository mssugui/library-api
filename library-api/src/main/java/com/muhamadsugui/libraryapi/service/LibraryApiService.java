package com.muhamadsugui.libraryapi.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.muhamadsugui.libraryapi.entities.Book;
import com.muhamadsugui.libraryapi.entities.BookFamily;

public interface LibraryApiService {

	public List<BookFamily> getBookFamily();

	public List<Book> getBook();

	public BookFamily getBookFamilyById(int familyId);

	public Book getBookById(int bookId);

	public BookFamily addBookFamily(BookFamily bookFamily) throws DataIntegrityViolationException;

	public Book addBook(Book book) throws DataIntegrityViolationException;

	public BookFamily updateBookFamily(BookFamily bookFamily) throws DataIntegrityViolationException;

	public Book updateBook(Book book) throws DataIntegrityViolationException;
}
