package digitallibrarymanagement;

import java.util.Scanner;

public class Main {
		    public static void main(String[] args) {
	        LibrarySystem system = new LibrarySystem();
	        Admin admin = new Admin("admin", "admin123");
	        system.addUser(admin);

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the Digital Library Management System");

	        System.out.println("Enter User ID:");
	        String userId = scanner.nextLine();

	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();

	        if (system.authenticate(userId, password)) {
	            System.out.println("Login successful!");
	            if (userId.equals("admin")) {
	                while (true) {
	                    System.out.println("1. Add Book");
	                    System.out.println("2. Remove Book");
	                    System.out.println("3. Update Book");
	                    System.out.println("4. View Books");
	                    System.out.println("5. Issue Book");
	                    System.out.println("6. Return Book");
	                    System.out.println("7. Exit");
	                    System.out.println("Enter your choice:");
	                    int choice = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline

	                    if (choice == 1) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        System.out.println("Enter Title:");
	                        String title = scanner.nextLine();
	                        System.out.println("Enter Author:");
	                        String author = scanner.nextLine();
	                        Book book = new Book(bookId, title, author);
	                        admin.addBook(system.books, book);
	                    } else if (choice == 2) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        admin.removeBook(system.books, bookId);
	                    } else if (choice == 3) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        System.out.println("Enter New Title:");
	                        String newTitle = scanner.nextLine();
	                        System.out.println("Enter New Author:");
	                        String newAuthor = scanner.nextLine();
	                        admin.updateBook(system.books, bookId, newTitle, newAuthor);
	                    } else if (choice == 4) {
	                        system.browseBooks();
	                    } else if (choice == 5) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        system.issueBook(bookId);
	                    } else if (choice == 6) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        system.returnBook(bookId);
	                    } else if (choice == 7) {
	                        System.out.println("Exiting...");
	                        break;
	                    } else {
	                        System.out.println("Invalid choice. Please try again.");
	                    }
	                }
	            } else {
	                while (true) {
	                    System.out.println("1. View Books");
	                    System.out.println("2. Issue Book");
	                    System.out.println("3. Return Book");
	                    System.out.println("4. Search Book");
	                    System.out.println("5. Exit");
	                    System.out.println("Enter your choice:");
	                    int choice = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline

	                    if (choice == 1) {
	                        system.browseBooks();
	                    } else if (choice == 2) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        system.issueBook(bookId);
	                    } else if (choice == 3) {
	                        System.out.println("Enter Book ID:");
	                        String bookId = scanner.nextLine();
	                        system.returnBook(bookId);
	                    } else if (choice == 4) {
	                        System.out.println("Enter keyword:");
	                        String keyword = scanner.nextLine();
	                        system.searchBook(keyword);
	                    } else if (choice == 5) {
	                        System.out.println("Exiting...");
	                        break;
	                    } else {
	                        System.out.println("Invalid choice. Please try again.");
	                    }
	                }
	            }
	        } else {
	            System.out.println("Invalid login credentials. Access denied.");
	        }
	        scanner.close();
	    }
}
