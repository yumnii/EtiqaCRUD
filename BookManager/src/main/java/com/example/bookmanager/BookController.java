package com.example.bookmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private Map<Long, Book> bookMap = new HashMap<>();
	private Long idCounter = 1L;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.ok(new ArrayList<>(bookMap.values()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Book book = bookMap.get(id);
		if (book != null) {
			return ResponseEntity.ok(book);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		if (book.getTitle() == null || book.getTitle().isEmpty() ||
				book.getAuthor() == null || book.getAuthor().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		
		book.setId(idCounter++);
		bookMap.put(book.getId(), book);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		if (bookMap.containsKey(id)) {
			bookMap.remove(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}	
}



















