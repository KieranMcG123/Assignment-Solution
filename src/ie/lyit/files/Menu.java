//Kieran Mc Guinness
//L00129140
//CSDF
package ie.lyit.files;
import java.util.*;
import ie.lyit.serialize.CustomerSerializer;
import java.io.Serializable;

public class Menu  implements Serializable{
	private int option;
	CustomerSerializer customerSerializer = new CustomerSerializer();
	
	public void display()
	{
		System.out.println("  Menu Options:  ");
		System.out.println("1  Add  ");
		System.out.println("2  View  ");
		System.out.println("3  List  ");
		System.out.println("4  Edit  ");
		System.out.println("5  Delete  ");
		System.out.println("6  Quit  ");
	}
		
	public void readOption() 
		{
			Scanner KeyBoardIn = new Scanner(System.in);
			System.out.println("  Please select an option from 1-6");
			option = KeyBoardIn.nextInt();
			
		}
		
	public int getOption()
	{
		return option;
	}
	
	
}


