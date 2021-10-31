package ua.nic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nic.entity.Author;
import ua.nic.service.BaseService;

import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AuthorController {

	private BaseService<Author> authorService;

	@Autowired
	public AuthorController(BaseService<Author> authorService) {
		this.authorService = authorService;
	}

	/*---Add new author---*/
	@PostMapping("/author")
	public ResponseEntity<Author> save(@RequestBody Author author) {
		System.out.println("the json value of book is :::::: " + author);
		return ResponseEntity.ok().body(authorService.save(author));
	}

	/*---Get a author by id---*/
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> get(@PathVariable("id") Long id) {
		Author authors = authorService.get(id);
		return ResponseEntity.ok().body(authors);
	}

	/*---get all authors---*/
	@GetMapping("/author")
	public ResponseEntity<Set<Author>> list() {
		Set<Author> authors = authorService.getAll();
		return ResponseEntity.ok().body(authors);
	}

	/*---Update a author by id---*/
	@PutMapping("/author/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Author author) {
		authorService.update(id, author);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*---Delete a author by id---*/
	@DeleteMapping("/author/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		authorService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}

}
