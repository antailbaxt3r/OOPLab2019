public class Waves{

	//fields
	java.util.ArrayList<Day> days;

	//constructor
	public Waves(){
		days = new java.util.ArrayList<Day>();
	}

	//methods
	public boolean addDay​(Day d){
		int n = days.size();
		if (d.dayIndex > n) {
			return false;
		}else{
			days.add(d);
			return true;
		}
	}

	public boolean deleteDay​(Day d){

		if (!days.contains(d)) {
			return false;
		}
		else{
			days.remove(d);
			return true;
		}
		
	}

	public boolean addEvent​(int dayIndex, int startTime, int endTime, java.lang.String eventName){

		if(dayIndex < 0 || dayIndex >= days.size()){
			return false;
		}else{
			Day.Node.Event event = days.get(dayIndex).head.new Event(startTime, endTime, eventName);
			return days.get(dayIndex).addEvent​(event);
			
		}
	}

	public void modifyBST​(int dayIndex, int eventIndex, int bst){
		if(dayIndex < 0 || dayIndex >= days.size()){	
		}else{
			days.get(dayIndex).modifyTime(eventIndex, bst);		
		}
	}




}	