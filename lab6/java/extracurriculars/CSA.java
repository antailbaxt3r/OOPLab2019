package extracurriculars;

public class CSA{

	//fields
	private Organization[] orgList;
	private int orgCount;
	private static final int MAX_NO_OF_ORGANIZATIONS = 30;

	//constructor
	public CSA(){
		
		orgList = new Organization[MAX_NO_OF_ORGANIZATIONS];
		orgCount = 0;
	}

	//methods
	public boolean createNewOrganization​(Organization o){

		if (this.orgCount < MAX_NO_OF_ORGANIZATIONS) {
			
			orgList[orgCount] = o;
			orgCount++;
			return true;

		}else{
			return false;
		}
	}

	public int allocateBudget(){

		int total = 0;

		for (int i = 0; i < orgCount; i++) {
			
			total += orgList[i].calculateBudget();
		}
		return total;
	}
}