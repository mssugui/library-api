package com.muhamadsugui.libraryapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muhamadsugui.libraryapi.entities.Book;
import com.muhamadsugui.libraryapi.entities.BookFamily;
import com.muhamadsugui.libraryapi.exception.FunctionalException;

@Repository
public class LibraryApiDAOImpl implements LibraryApiDAO {

	private EntityManager entityManager;

	@Autowired
	public LibraryApiDAOImpl(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	@Override
	public List<BookFamily> getBookFamily() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<BookFamily> theQuery = currentSession.createQuery("from BookFamily", BookFamily.class);
		List<BookFamily> bookFamily = theQuery.getResultList();
		return bookFamily;
	}

	@Override
	public BookFamily findBookFamilyById(int familyId) {
		Session currentSession = entityManager.unwrap(Session.class);
		BookFamily bookFamily = currentSession.get(BookFamily.class, familyId);

		if (bookFamily == null) {
			throw new FunctionalException("Book family not found:" + familyId);
		}

		return bookFamily;
	}

	@Override
	public BookFamily saveBookFamily(BookFamily bookFamily) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(bookFamily);
		return bookFamily;
	}

	@Override
	public List<Book> getBook() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);
		List<Book> book = theQuery.getResultList();
		return book;
	}

	@Override
	public Book findBookById(int bookId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Book book = currentSession.get(Book.class, bookId);

		if (book == null) {
			throw new FunctionalException("Book not found:" + bookId);
		}

		return book;
	}

	@Override
	public Book saveBook(Book book) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(book);
		return book;
	}

}
