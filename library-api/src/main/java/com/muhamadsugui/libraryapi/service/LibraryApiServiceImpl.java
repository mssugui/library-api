package com.muhamadsugui.libraryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muhamadsugui.libraryapi.dao.LibraryApiDAO;
import com.muhamadsugui.libraryapi.entities.Book;
import com.muhamadsugui.libraryapi.entities.BookFamily;

@Service
public class LibraryApiServiceImpl implements LibraryApiService {

	private LibraryApiDAO libraryApiDAO;

	@Autowired
	public LibraryApiServiceImpl(LibraryApiDAO libraryApiDAO) {
		this.libraryApiDAO = libraryApiDAO;
	}

	@Override
	@Transactional
	public List<BookFamily> getBookFamily() {
		return libraryApiDAO.getBookFamily();
	}

	@Override
	@Transactional
	public BookFamily getBookFamilyById(int familyId) {
		return libraryApiDAO.findBookFamilyById(familyId);
	}

	@Override
	@Transactional
	public BookFamily addBookFamily(BookFamily bookFamily) throws DataIntegrityViolationException {
		return libraryApiDAO.saveBookFamily(bookFamily);
	}

	@Override
	@Transactional
	public BookFamily updateBookFamily(BookFamily bookFamily) throws DataIntegrityViolationException {
		return libraryApiDAO.saveBookFamily(bookFamily);
	}

	@Override
	@Transactional
	public List<Book> getBook() {
		return libraryApiDAO.getBook();
	}

	@Override
	@Transactional
	public Book getBookById(int bookId) {
		return libraryApiDAO.findBookById(bookId);
	}

	@Override
	@Transactional
	public Book addBook(Book book) throws DataIntegrityViolationException {
		return libraryApiDAO.saveBook(book);
	}

	@Override
	@Transactional
	public Book updateBook(Book book) throws DataIntegrityViolationException {
		return libraryApiDAO.saveBook(book);
	}
}
