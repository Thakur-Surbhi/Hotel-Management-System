package OOPS_Assignment;

/*Constructor - 5. Constructor Overloading
Problem: Create a class Book with two constructors: one accepts title and author, and the other accepts title, author, and price. Print the details of the book.
Input:
Book book1 = new Book("Java Basics", "John Doe");
Book book2 = new Book("Advanced Java", "Jane Doe", 49.99);
Output:
Title: Java Basics, Author: John Doe, Price: Not Available
Title: Advanced Java, Author: Jane Doe, Price: 49.99*/

public class Book {

	private String title;
	private String author;
	private Double price;

	public Book(String title,String author ) {
		this.title=title;
		this.author=author;
		this.price=null;
		System.out.println("Title : "+title+", Author : "+author+", Price : "+price);
	}

	public Book(String title,String author, double price ) {
		this.title=title;
		this.author=author;
		this.price=price;
		
			System.out.println("Title : "+title+", Author : "+author+", Price : "+price);
		}
		

	public void getDetails() {
		
		
	}


	public static void main(String[] args) {
		Book b1 = new Book("Java Basic","Jon Doe");
		Book b2 = new Book("Java Basic","Jon Doe", 49.99);
		b1.getDetails();
		b2.getDetails();
	}
}
