public class Hostel extends CampusBuilding  { 
	
	private HostelRoom[] hostelRooms;
	static int  MAX_NUMBER_OF_HOSTEL_ROOMS =  100 ;
	
	public   Hostel (String name) { 
		super (name);
		hostelRooms =  new HostelRoom[MAX_NUMBER_OF_HOSTEL_ROOMS];
	}

	public void addHostelRoom (HostelRoom hostelRoom) throws MaximumCapacityException{ 
		/*
		Add hostel room to Hostel and throw MaximumCapacityException
		when number of hostel rooms exceed the maximum limit
		*/

		if (this.numberOfRooms < MAX_NUMBER_OF_HOSTEL_ROOMS) {
			hostelRooms[this.numberOfRooms] = hostelRoom;
			this.numberOfRooms++;
			return;
		}else{
			throw new MaximumCapacityException("HostelRoom", super.getName());
			
		}

	}

	public   int   calculateRepairingCost () { 
		int  cost =  0 ;
		for (HostelRoom hostelRoom: hostelRooms) 
			if (hostelRoom !=  null )
                cost +=hostelRoom.calculateRepairingCost();
		return  cost; 
	}

	public   float   calculateAverageRepairingCost () throws DivideZeroException{ 
		float avgCost;
		/*
		Complete the function to calculate the average cost and throw DivideZeroException
		when divided by 0
		*/

		if (this.numberOfRooms == 0) {
			throw new DivideZeroException("HostelRoom");
		}else{
			avgCost = (float)this.calculateRepairingCost()/(float)this.numberOfRooms;
		}
		return avgCost;
	}
	
}