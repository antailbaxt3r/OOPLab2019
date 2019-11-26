public class Book implements java.lang.Comparable<Book>{

	//fields
	public static java.util.HashMap<Book,Shelf> bookToShelf = new java.util.HashMap<Book, Shelf>();
	private int id;
	private java.lang.String name;
	private java.lang.String author;

	//constructor
	public Book​(java.lang.String name, java.lang.String author, int id){
		this.name = name;
		this.author = author;
		this.id = id;

	}

	//methods
	public int getId(){
		return id;
	}

	public java.lang.String getName(){
		return name;
	}

	public java.lang.String getAuthor(){
		return author;
	}

	public int compareTo​(Book obj){

		if (this.equals​(obj)) {
			return 0;
		}else{
			return this.getId() - obj.getId();
		}

	}

	public boolean equals​(Book obj){

		if (this.getName() == obj.getName() && this.getId() == obj.getId() && this.getAuthor() == obj.getAuthor()){
			return true;
		}else{
			return false;
		}
	}

	public Shelf getShelf(){
		return bookToShelf.get(this);
	}

}