public class Day{

	//fields
	int dayIndex;
	Node head;

	//constructor
	public Day(int dayNumber){
		head = new Node(null);
		dayIndex = dayNumber;
	}

	//methods 
	public boolean addEvent​(Day.Node.Event ev){

		Node newNode = new Node(ev);	
		if (ev.getStartTime() > 24 || ev.getEndTime() > 24) {
			return false;
		}
		if(head == null){
			newNode.next = head;
			head = newNode;
			return true;
		}else{
			Node current = head;
			while(current.next.event.getStartTime() < current.event.getStartTime()){
				current = current.next;
			}
			Node temp = current.prev;
			current.prev= newNode;
			temp.next = newNode;
			newNode.prev = temp;
			newNode.next = current;
			return true;
		}
		
	}

	public boolean deleteEventAtIndex​(int index){

		Node temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.next;			
		}

		if (temp == null) {
			return false;			
		}else{
			(temp.prev).next = temp.next;
			(temp.next).prev = temp.prev;
			return true;
		}
	}

	public void modifyTime​(int index, int change){

		Node temp = head;

		for (int i = 0; i < index -1; i++) {
			temp = temp.next;			
		}
		temp.event.addBST​(change);
		temp.event.addBST​(change);
	}


	//nested Node class
	class Node{

		//fields for Node
		Event event;
		Node prev, next;

		//constructors for Node
		Node(int eventStartTime, int eventEndTime, String eventName){
			
			event = new Event(eventStartTime, eventEndTime, eventName);
			prev = null;
			next = null;
		}

		Node(Event ev){
			event = ev;
			prev = null;
			next = null;
		}

		//nested Event class
		class Event{
			
			//fields for Event
			private int startTime;
			private int endTime;
			String name;

			//constructor for Event
			public Event(int startTime, int endTime, String eventName){
				this.name = eventName;
				this.startTime = startTime;
				this.endTime = endTime;
			}
			
			//methods for Event
			
			public int getStartTime(){
				return this.startTime;
			}

			public int getEndTime(){
				return this.endTime;
			}

			public void changeStartTime​(int newStartTime){
				this.startTime = newStartTime;
			}

			public void changeEndTime​(int newEndTime){
				this.endTime = newEndTime;
			}

			public void addBST​(int bstValue){
				changeEndTime​(this.endTime + bstValue);
				changeStartTime​(this.startTime + bstValue);
			}



		}

	}


}