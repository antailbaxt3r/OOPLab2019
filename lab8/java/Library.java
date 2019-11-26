import java.util.*;

public class Library{

	//fields
	private java.lang.String name;
	private int maxShelves;
	private java.util.List<Shelf> shelvesList;
	private int numShelves;

	//constructor
	public Library​(java.lang.String name, int capacity){
		this.name = name;
		this.maxShelves = capacity;
		this.shelvesList = new ArrayList<Shelf>();
		numShelves = 0;
	}

	//methods
	public boolean addShelf​(java.lang.String category, int capacity){
		Shelf shl = new Shelf(category, capacity);

		if (!(shelvesList.size() < maxShelves)) {
			return false;
		}

		shelvesList.add(shl);
		return true;
	}

	public int getNumBooks(){

		int total  = 0;
		for (int i = 0; i < shelvesList.size(); i++) {
			total += shelvesList.get(i).getNumBooks();
		}
		return total;
	}

	public java.lang.String getName(){
		return name;
	}

	public int getMaxShelves(){
		return maxShelves;
	}

	public java.util.List<Shelf> getShelvesList(){
		return shelvesList;
	}

	public java.util.Set<Shelf> searchBook​(java.lang.String name){
		Set set = new HashSet();

		for (int i = 0; i < shelvesList.size(); i++) {
			List bookList = shelvesList.get(i).getBooks();
			for (int j = 0; j < bookList.size(); j++) {
				if (((Book)bookList.get(j)).getName() == name) {
					set.add(shelvesList.get(i));
				}
			}
		}
		return set;
	}

	public Shelf getShelf​(java.lang.Integer i){
		return shelvesList.get(i);
	}

	public java.lang.Integer getNumShelves(){
		return shelvesList.size();
	}


}