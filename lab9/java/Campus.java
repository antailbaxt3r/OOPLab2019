public class Campus {
	
	private static String name;
	private int hostelCount;
	private Hostel[] hostels;
	private AcadBlock acadBlock;
	static int MAX_NUMBER_OF_HOSTELS =  10 ;
	
	public Campus (String name, AcadBlock acadBlock) { 
		Campus.name = name;
		this .hostels =  new  Hostel[MAX_NUMBER_OF_HOSTELS]; this .acadBlock = acadBlock;
		this .hostelCount =  0 ;
	}
	
	public   static  String  getName () {
		return  name; 
	}
	
	public   void   addHostel (String hostelName) throws MaximumCapacityException{ 
		/*
		Add Hostel to Campus and throw MaximumCapacityException
		when number of hostels exceed the maximum limit
		*/

		if (hostelCount < MAX_NUMBER_OF_HOSTELS) {
			hostels[hostelCount] = new Hostel(hostelName);
			hostelCount++;
			return;
		}else{
			throw new MaximumCapacityException("Hostel", this.getName());

		}
	}
	
	public   int   calculateRepairingCost () { 
		int  cost =  0 ;
		for (Hostel hostel: hostels) { 
			if (hostel !=  null )
                cost += hostel.calculateRepairingCost();
		}
        cost += acadBlock.calculateRepairingCost();

	return  cost; 
	}

	public   float   calculateAverageRepairingCost () throws DivideZeroException{ 
		float avgCost;
		/*
		Complete the function to calculate the average cost and throw DivideZeroException
		when divided by 0
		*/

		if (this.hostelCount == 0) {
			throw new DivideZeroException("Hostel");
		}else{
			avgCost = (float)this.calculateRepairingCost()/(float)this.hostelCount;
		}

		return avgCost;
	}
	
	
}