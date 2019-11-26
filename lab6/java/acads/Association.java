package acads;

import extracurriculars.*;

public class Association implements java.lang.Comparable<Association>, IAssociation{

	//fields
	private java.lang.String name;
	private java.lang.String prez;
	private int memberCount;
	private int budget;
	private static final int MAX_NO_OF_MEMBERS = 1000;

	//constructor
	public Association​(java.lang.String name, java.lang.String prez, int memberCount){
		this.name = name;
		this.prez = prez;
		this.memberCount = memberCount;
		this.budget = 0;
	}

	//methods
	public java.lang.String getName(){
		return name;
	}

	public java.lang.String getPrez(){
		return prez;
	}

	public int getMemberCount(){
		return memberCount;
	}

	public int compareTo​(Association assoc){
		if (this.getMemberCount() < assoc.getMemberCount()) {
			return -1;
		}else if (this.getMemberCount() > assoc.getMemberCount()) {
			return 1;
		}else{
			return 0;
		}
	}

	public int calculateProjectBudget(){
		return 3000 * MAX_NO_OF_MEMBERS;
	}

	public int calculateBudget(){
		budget = IAssociation.BASE_BUDGET + this.calculateProjectBudget();
		return budget;
	}

	public int extraBudget(){
		return IAssociation.BASE_BUDGET - Organization.BASE_BUDGET;
	}

	public boolean addNewMember(){

		if (this.getMemberCount() < MAX_NO_OF_MEMBERS) {
			
			this.memberCount++;
			return true;
		}else{
			return false;
		}
	}

}