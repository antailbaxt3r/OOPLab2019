import java.util.*;
import java.lang.*;

public class InvalidStateException extends Exception{

	public InvalidStateException(){
		super("Invalid state given. Possible states are true and false only.");
	}
}