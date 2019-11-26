package acads;

import extracurriculars.*;

public interface IAssociation extends Organization{

	//fields
	static final int BASE_BUDGET = 20000;

	//methods
	int calculateProjectBudget();
}