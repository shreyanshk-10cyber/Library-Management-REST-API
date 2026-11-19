package com.example.mse2;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    // In-memory storage
    private List<Book> books = new ArrayList<>();
    // (b) Add a new book
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        // Check duplicate ID
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                return ResponseEntity.badRequest()
                        .body("Book ID already exists!");
            }
        }
        books.add(book);
        return ResponseEntity.ok("Book added successfully!");
    }
    // (c) Retrieve all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.ok(books);
    }
    // (c) Retrieve a specific book by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return ResponseEntity.ok(b);
            }
        }
        return ResponseEntity.status(404).body("Book not found!");
    }
    // (d) Update book details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(
            @PathVariable Integer id,
            @RequestBody Book updatedBook) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
                b.setCategory(updatedBook.getCategory());
                b.setAvailableCopies(updatedBook.getAvailableCopies());
                return ResponseEntity.ok(b);
            }
        }
        return ResponseEntity.status(404).body("Book not found!");
    }
    // (e) Delete book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                books.remove(b);
                return ResponseEntity.ok("Book deleted successfully!");
            }
        }
        return ResponseEntity.status(404).body("Book not found!");
    }
}
