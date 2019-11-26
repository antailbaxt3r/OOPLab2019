import java.util.*;
import java.lang.*;

public class invalidDeviceException extends Exception{

	public invalidDeviceException​(java.lang.String roomType, java.lang.String appliance){
		super(roomType + " cannot have appliance " + appliance);
	}
}