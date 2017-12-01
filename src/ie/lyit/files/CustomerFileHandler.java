//Kieran Mc Guinness
//L00129140
//CSDF
package ie.lyit.files;
import ie.lyit.hotel.Customer;

import java.io.*;
import java.util.*;

	public class CustomerFileHandler {
		// Constant FILENAME for the file to be created
		final String FILENAME = "customer.ser";

		// Declare ArrayList called books - for storing a list of books
		private ArrayList<Customer> customers;
		

		// Default Constructor
		public CustomerFileHandler(){
			// Construct books ArrayList
			customers = new ArrayList<Customer>();
		}

		//////////////////////////////////////////////////////
		// Method Name : add()								//
		// Return Type : void								//
		// Parameters : None								//
		// Purpose : Reads one Book record from the user    //
		//           and adds it to the ArrayList books     //
		//////////////////////////////////////////////////////	
		public void add(){
			// Create a Book object
			Customer customer = new Customer();
			// Read its details
			customer.read();	
			// And add it to the books ArrayList
			customers.add(customer);
		}

		////////////////////////////////////////////////////////
		// Method Name : list()							      //
		// Return Type : void			  				      //
		// Parameters : None						 	      //
		// Purpose : Lists all Book records in the ArrayList  //
		////////////////////////////////////////////////////////	
		public void list(){
			for(Customer tmpCust:customers)
				// display it
				System.out.println(tmpCust);
		}
		
		////////////////////////////////////////////////////////////
		// Method Name : view()									  //
		// Return Type : void								      //
		// Parameters : None								      //
		// Purpose : Displays the required Book record on screen  //
		//         : And returns it, or null if not found         //   
		////////////////////////////////////////////////////////////	
		public Customer view(){
			Scanner keyboardIn = new Scanner(System.in);		

			// Read the number of the customer to be viewed from the user
			System.out.println("Please enter Customer No. : ");
			int customerToView=keyboardIn.nextInt();
			
			// for every Customer object in customers
		    for(Customer tmpCust:customers){
			   // if it's number equals the number of the customerToView
			   if(tmpCust.getNumber() == customerToView){
			      // display it
				  System.out.println(tmpCust);
				  return tmpCust;
			   }
			}
		    // if we reach this code the customer was not found so return null
		    return null;			
		}

		///////////////////////////////////////////////////////////
		// Method Name : delete()								 //
		// Return Type : void									 //
		// Parameters : None									 //
		// Purpose : Deletes the required Book record from books //
		///////////////////////////////////////////////////////////	
		
		public void delete(){	
			// Call view() to find, display, & return the customer to delete
			Customer tempCust = view();
			// If the customer != null, i.e. it was found then...
			 if(tempCust != null)
			// ...remove it from books
			customers.remove(tempCust);
		}
		
		///////////////////////////////////////////////////////////
		// Method Name : edit()			  					     //
		// Return Type : void									 //
		// Parameters : None									 //
		// Purpose : Edits the req Customer record in customers  //
		///////////////////////////////////////////////////////////	
		public void edit(){	
			// Call view() to find, display, & return the customer to edit
						Customer tempCust = view();
						// If the book != null, i.e. it was found then...
					    if(tempCust != null){
						   // get it's index
						   int index=customers.indexOf(tempCust);
						   // read in a new custoemr and...
						   tempCust.read();
						   // reset the object in customer
						   customers.set(index, tempCust);
		    }
		}
		
		///////////////////////////////////////////////////////
		// Method Name : writeRecordsToFile()    			 //
		// Return Type : void								 //
		// Parameters : None								 //
		// Purpose : Writes the ArrayList customer to the    //
		//File Customer.bin before closing the File          //
		///////////////////////////////////////////////////////	
		public void writeRecordsToFile(){
			try{
				// Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
		
				os.writeObject(customers);
		
				os.close();
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
