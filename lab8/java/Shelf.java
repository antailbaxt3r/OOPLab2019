import java.util.*;

public class Shelf{

	//fields
	private java.lang.String category;
	private java.util.List<Book> books;
	private int capacity;

	//constructor
	public Shelf​(java.lang.String category, int capacity){
		this.category = category;
		this.capacity = capacity;
		books = new java.util.ArrayList<Book>();
	}

	//methods
	public java.lang.String getCategory(){
		return category;
	}

	public int getCapacity(){
		return capacity;
	}

	public int getNumBooks(){
		return books.size();
	}

	public Book getBooks(int id){
		
		for(int i = 0; i < this.books.size(); i++){
			if (this.books.get(i).getId() == id) {
				return this.books.get(i);
			}
			
		}
		return null;
	}

	public java.util.List<Book> getBooks(){
		return books;
	}

	public boolean addBook(Book book){

		if (!(books.size() < capacity)) {
			return false;
		}
		books.add(book);
		Book.bookToShelf.put(book, this);
		return true;
		
	}

	public boolean addBook(java.lang.String name, java.lang.String author, int id){
		if (!(books.size() < capacity)) {
			return false;
		}

		Book book = new Book(name, author, id);
		books.add(book);
		Book.bookToShelf.put(book, this);
		return true;
	}

	public java.lang.Boolean organize(){
		Collections.sort(books);
		return true;
	}

	public java.lang.Boolean isRedundant(Shelf shelf){
		// if (this.getBooks() == shelf.getBooks()) {
		// 	return true;
		// }else{
		// 	return false;
		// }

		return shelf.getBooks().containsAll(this.books);
	}



}