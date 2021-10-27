package ua.nic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nic.entity.Publisher;
import ua.nic.service.BaseService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PublisherController {

	private BaseService publisherService;

	@Autowired
	public PublisherController(BaseService publisherService) {
		this.publisherService = publisherService;
	}


	/*---Add new publisher---*/
	@PostMapping("/publisher")
	public ResponseEntity<?> save(@RequestBody Publisher publisher) {
		System.out.println("the json value of book is :::::: " + publisher);
		return ResponseEntity.ok().body(publisherService.save(publisher));
	}

	/*---Get a publisher by id---*/
	@GetMapping("/publisher/{id}")
	public ResponseEntity<Publisher> get(@PathVariable("id") int id) {
		Publisher publishers = (Publisher) publisherService.get(id);
		return ResponseEntity.ok().body(publishers);
	}

	/*---get all publishers---*/
	@GetMapping("/publisher")
	public ResponseEntity<List<Publisher>> list() {
		List<Publisher> publishers = publisherService.getAll();
		return ResponseEntity.ok().body(publishers);
	}

	/*---Update a publisher by id---*/
	@PutMapping("/publisher/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Publisher publisher) {
		publisherService.update(id, publisher);
		return ResponseEntity.ok().body("Book has been updated successfully.");
	}

	/*---Delete a publisher by id---*/
	@DeleteMapping("/publisher/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		publisherService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted successfully.");
	}
}
