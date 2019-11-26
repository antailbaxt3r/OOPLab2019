import java.util.*;
import java.lang.*;

public class DivideZeroException extends Exception{
	
	//Divide By Zero Exception Class

	public DivideZeroException​(java.lang.String type){
		super("Cannot calculate average cost because number of " + type + " are insufficient");
	}

}