public class Room{

	private int length;
	private int breadth;
	private int height;

	public Room​(int length, int breadth, int height){

		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public int getVolume​(){
		return this.length * this.breadth * this.height;
	}

	public int getSurfaceArea​(){
		return 2* (length * breadth + breadth * height + height * length);
	}

	public int calculateMaintenanceCost​(){
		return this.getVolume​() * 5 + this.getSurfaceArea​() * 2;
	}

}