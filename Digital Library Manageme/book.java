package digitallibrarymanagement;
import java.util.ArrayList;
import java.util.List;

public class Book {
	    private String bookId;
	    private String title;
	    private String author;
	    private boolean isIssued;

	    public Book(String bookId, String title, String author) {
	        this.bookId = bookId;
	        this.title = title;
	        this.author = author;
	        this.isIssued = false;
	    }

	    public String getBookId() {
	        return bookId;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public boolean isIssued() {
	        return isIssued;
	    }

	    public void setIssued(boolean issued) {
	        isIssued = issued;
	    }

	    public void displayDetails() {
	        System.out.println("Book ID: " + bookId);
	        System.out.println("Title: " + title);
	        System.out.println("Author: " + author);
	        System.out.println("Issued: " + (isIssued ? "Yes" : "No"));
	    }
	}

	// User class
	class User {
	    private String userId;
	    private String password;

	    public User(String userId, String password) {
	        this.userId = userId;
	        this.password = password;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public String getPassword() {
	        return password;
	    }
	}
	class Admin extends User {
	    public Admin(String userId, String password) {
	        super(userId, password);
	    }
	    public void addBook(List<Book> books, Book book) {
	        books.add(book);
	        System.out.println("Book added successfully!");
	    }

	    public void removeBook(List<Book> books, String bookId) {
	        Book bookToRemove = null;
	        for (Book book : books) {
	            if (book.getBookId().equals(bookId)) {
	                bookToRemove = book;
	                break;
	            }
	        }
	        if (bookToRemove != null) {
	            books.remove(bookToRemove);
	            System.out.println("Book removed successfully!");
	        } else {
	            System.out.println("Book not found.");
	        }
	    }

	    public void updateBook(List<Book> books, String bookId, String newTitle, String newAuthor) {
	        for (Book book : books) {
	            if (book.getBookId().equals(bookId)) {
	                book.setIssued(false); // reset issued status
	                book = new Book(bookId, newTitle, newAuthor); // replace book with new details
	                System.out.println("Book updated successfully!");
	                return;
	            }
	        }
	        System.out.println("Book not found.");
	    }
	}

	// LibrarySystem class
	class LibrarySystem {
	    private List<User> users;
	    List<Book> books;

	    public LibrarySystem() {
	        users = new ArrayList<>();
	        books = new ArrayList<>();
	    }

	    public void addUser(User user) {
	        users.add(user);
	    }

	    public boolean authenticate(String userId, String password) {
	        for (User user : users) {
	            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void issueBook(String bookId) {
	        for (Book book : books) {
	            if (book.getBookId().equals(bookId) && !book.isIssued()) {
	                book.setIssued(true);
	                System.out.println("Book issued successfully!");
	                return;
	            }
	        }
	        System.out.println("Book not found or already issued.");
	    }

	    public void returnBook(String bookId) {
	        for (Book book : books) {
	            if (book.getBookId().equals(bookId) && book.isIssued()) {
	                book.setIssued(false);
	                System.out.println("Book returned successfully!");
	                return;
	            }
	        }
	        System.out.println("Book not found or not issued.");
	    }

	    public void browseBooks() {
	        for (Book book : books) {
	            book.displayDetails();
	            System.out.println();
	        }
	    }

	    public void searchBook(String keyword) {
	        for (Book book : books) {
	            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword)) {
	                book.displayDetails();
	                System.out.println();
	            }
	        }
	    }
	}


	
