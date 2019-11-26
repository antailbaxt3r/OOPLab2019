import java.util.*;
import java.lang.*;

public class InvalidDimensionException extends Exception{

	//fields
	private int length;
	private int width;
	private int height;

	//constructor
	public InvalidDimensionException​(int length, int width, int height){
		this.length = length;
		this.width = width;
		this.height = height;
	}

	//methods
	public java.lang.String getMessage(){
		if (length <= 0 || width <= 0 || height <= 0) {
			return "Invalid dimensions given.";
		}else{
			return "";
		}
	}
}