package com.muhamadsugui.libraryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhamadsugui.libraryapi.entities.Book;
import com.muhamadsugui.libraryapi.entities.BookFamily;
import com.muhamadsugui.libraryapi.exception.FunctionalErrorResponse;
import com.muhamadsugui.libraryapi.exception.FunctionalException;
import com.muhamadsugui.libraryapi.service.LibraryApiService;

@RestController
@RequestMapping("/library-api")
public class LibraryApiController {

	private LibraryApiService libraryApiService;

	@Autowired
	public LibraryApiController(LibraryApiService libraryApiService) {
		this.libraryApiService = libraryApiService;
	}

	@GetMapping("/bookfamily")
	public List<BookFamily> findAllBookFamilies() {
		return libraryApiService.getBookFamily();
	}

	@GetMapping("/bookfamily/{bookFamilyId}")
	public BookFamily getBookFamily(@PathVariable int bookFamilyId) {
		return this.libraryApiService.getBookFamilyById(bookFamilyId);
	}

	@PostMapping("/bookfamily")
	public BookFamily addBookFamily(@RequestBody BookFamily bookFamily) {
		BookFamily bookFamilyCreated = libraryApiService.addBookFamily(bookFamily);
		return bookFamilyCreated;
	}

	@PutMapping("/bookfamily")
	public BookFamily updatedBookFamily(@RequestBody BookFamily newBookFamily) {

		if (newBookFamily.getId() == 0) {
			BookFamily registeredBookFamily = libraryApiService.getBookFamilyById(newBookFamily.getId());
			if (registeredBookFamily != null) {
				return libraryApiService.updateBookFamily(newBookFamily);
			} else {
				throw new FunctionalException(FunctionalException.ITEM_NOT_FOUND);
			}
		} else {
			throw new FunctionalException(FunctionalException.INTERNAL_ERROR);
		}
	}

	@GetMapping("/book")
	public List<Book> findAllBooks() {
		return libraryApiService.getBook();
	}

	@GetMapping("/book/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		return this.libraryApiService.getBookById(bookId);
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		Book bookCreated = libraryApiService.addBook(book);
		return bookCreated;
	}

	@PutMapping("/book")
	public Book updatedBook(@RequestBody Book newBook) {

		if (newBook.getId() == 0) {
			Book registeredBook = libraryApiService.getBookById(newBook.getId());
			if (registeredBook != null) {
				return libraryApiService.updateBook(newBook);
			} else {
				throw new FunctionalException(FunctionalException.ITEM_NOT_FOUND);
			}
		} else {
			throw new FunctionalException(FunctionalException.INTERNAL_ERROR);
		}
	}

	@ExceptionHandler
	public ResponseEntity<FunctionalErrorResponse> handleException(FunctionalException exc) {

		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		FunctionalErrorResponse functError = new FunctionalErrorResponse();
		functError.setStatus(httpStatus.value());
		functError.setMessage(exc.getMessage());
		functError.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(functError, httpStatus);

	}

	@ExceptionHandler
	public ResponseEntity<FunctionalErrorResponse> handleException(Exception exc) {

		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		FunctionalErrorResponse functError = new FunctionalErrorResponse();
		functError.setStatus(httpStatus.value());
		functError.setMessage(exc.getMessage());
		functError.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(functError, httpStatus);

	}

}
