package extracurriculars;

public class Department implements Organization{

	//fields
	private static java.lang.String name;
	private int sessionCountPerWeek;
	private int budget;
	private int memberCount;
	private int maxMemberCount;

	//constructors
	public Department​(java.lang.String name, int sessionCountPerWeek, int memberCount){

		this.name = name;
		this.sessionCountPerWeek = sessionCountPerWeek;
		this.memberCount = memberCount;
		this.maxMemberCount = 30 * sessionCountPerWeek;
		this.budget = 0;
	}

	//methods
	public static java.lang.String getName(){
		return name;
	}

	public int getSessionCountPerWeek(){
		return sessionCountPerWeek;
	}

	public int getMemberCount(){
		return memberCount;
	}

	public int calculateBudget(){

		budget=5000*sessionCountPerWeek*memberCount;
		return budget;
	}

	public boolean addNewMember(){

		if (this.getMemberCount() < maxMemberCount) {
			
			this.memberCount++;
			return true;
		}else{
			return false;
		}
	}

}