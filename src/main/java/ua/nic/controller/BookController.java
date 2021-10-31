package ua.nic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nic.entity.Book;
import ua.nic.service.BaseService;

import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookController {

	private BaseService<Book> bookService;

	@Autowired
	public BookController(BaseService<Book> bookService) {
		this.bookService = bookService;
	}

	/*---Add new book---*/
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		System.out.println("the json value of book is :::::: " + book);
		return ResponseEntity.ok().body(bookService.save(book));
	}

	/*---Get a book by id---*/
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") Long id) {
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}

	/*---get all books---*/
	@GetMapping("/book")
	public ResponseEntity<Set<Book>> list() {
		return ResponseEntity.ok(bookService.getAll());
	}

	/*---Update a book by id---*/
	@PutMapping("/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Book book) {
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*---Delete a book by id---*/
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}

}
