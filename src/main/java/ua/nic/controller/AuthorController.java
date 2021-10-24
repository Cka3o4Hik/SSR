package ua.nic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nic.entity.Author;
import ua.nic.service.BaseService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AuthorController {

	private BaseService authorService;

	@Autowired
	public AuthorController(BaseService authorService) {
		this.authorService = authorService;
	}

	/*---Add new author---*/
	@PostMapping("/author")
	public ResponseEntity save(@RequestBody Author author) {
		System.out.println("the json value of book is :::::: " + author);
		int id = authorService.save(author);
		return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	}

	/*---Get a author by id---*/
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> get(@PathVariable("id") int id) {
		Author authors = (Author) authorService.get(id);
		return ResponseEntity.ok().body(authors);
	}

	/*---get all authors---*/
	@GetMapping("/author")
	public ResponseEntity<List<Author>> list() {
		List<Author> authors = authorService.getAll();
		return ResponseEntity.ok().body(authors);
	}

	/*---Update a author by id---*/
	@PutMapping("/author/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Author author) {
		authorService.update(id, author);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*---Delete a author by id---*/
	@DeleteMapping("/author/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		authorService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}

}
