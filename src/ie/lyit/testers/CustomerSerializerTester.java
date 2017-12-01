//Kieran Mc Guinness
//L00129140
//CSDF
package ie.lyit.testers;
import ie.lyit.serialize.*;
import ie.lyit.files.*;

public class CustomerSerializerTester {

	/*
	 * should be menu driven, giving the user the options to add, view, edit,
	 * delete, and list Customers, until they choose to quit. It should serialize
	 * the Customer ArrayList at the end of the program (i.e. store it in a file),
	 * and deserialize the Customer ArrayList at the start of the program (i.e.
	 * restore it from the file).
	 */

	public static void main(String[] args) {
		// Create an object of customerFileHandler
		CustomerSerializer customerSerializer = new CustomerSerializer();
		Menu menuObj = new Menu();

		// Deserialize the ArrayList from the File,
		// i.e. read the books ArrayList from the file back into the ArrayList
		customerSerializer.readRecordsFromFile();
		do {
			// Call it's display() method
			menuObj.display();
			// Call it's readOption() method
			menuObj.readOption();
			// switch on the option and call the appropriate method
			switch (menuObj.getOption()) {
			case 1:
				
				customerSerializer.add();
				break;
			case 2:
				customerSerializer.view();
				break;
			case 3:
				customerSerializer.list();
				break;
			case 4:
				customerSerializer.edit();
				break;
			case 5:
				customerSerializer.delete();
				break;
			case 6:
				break;
			default:
				System.out.println("INVALID OPTION...");
			}

		} while (menuObj.getOption() != 6);
		customerSerializer.writeRecordsToFile();

		// Serialize the ArrayList to the File
		// i.e. write the books ArrayList back into the the file
		customerSerializer.writeRecordsToFile();
	}

}
