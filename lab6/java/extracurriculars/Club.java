package extracurriculars;

public class Club implements Organization{

	//fields
	private static java.lang.String name;
	private int eventCount;
	private int budget;
	private int memberCount;
	private static final int MAX_NO_OF_MEMBERS = 40;

	//constructor
	public Club​(java.lang.String name, int eventCount, int memberCount){
		this.name = name;
		this.eventCount = eventCount;
		this.memberCount = memberCount;
		this.budget = 0;
	}

	//methods
	public static java.lang.String getName(){
		return name;
	}

	public int getEventCount(){
		return eventCount;
	}

	public int getMemberCount(){
		return memberCount;
	}

	public int calculateBudget(){
		budget = 3000 * eventCount * memberCount;
		return budget;
	}

	public boolean addNewMember(){

		if (this.getMemberCount() < 40) {
			this.memberCount++;
			return true;
		}else{
			return false;
		}
	}
}


