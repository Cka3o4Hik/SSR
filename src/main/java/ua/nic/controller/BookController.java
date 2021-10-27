package ua.nic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nic.entity.Book;
import ua.nic.service.BaseService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookController {

	private BaseService bookService;

	@Autowired
	public BookController(BaseService bookService) {
		this.bookService = bookService;
	}

	/*---Add new book---*/
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		System.out.println("the json value of book is :::::: " + book);
		int id = bookService.save(book);
		return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}

	/*---Get a book by id---*/
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") int id) {
		Book book = (Book) bookService.get(id);
		return ResponseEntity.ok().body(book);
	}

	/*---get all books---*/
	@GetMapping("/book")
	public ResponseEntity<List<Book>> list() {
		return ResponseEntity.ok(bookService.getAll());
	}

	/*---Update a book by id---*/
	@PutMapping("/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Book book) {
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*---Delete a book by id---*/
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		bookService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}

}
