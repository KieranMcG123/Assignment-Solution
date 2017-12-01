//Kieran Mc Guinness
//L00129140
//CSDF
package ie.lyit.serialize;
import java.util.*;
import java.io.*;
import ie.lyit.hotel.Customer;
public class CustomerSerializer {
	
	private ArrayList<Customer> customers;
	private final String FILENAME = "customers.ser";
	
		public CustomerSerializer()
		{
			// Construct customers ArrayList
			customers = new ArrayList<Customer>();
		}	
		
		public void add()
		{
		
			Customer customer = new Customer();
			customer.read();
			//  if the cancel button is clicked null gets entered as a value this code stops that from happening
			if(customer.getName() !=null && customer.getAddress() != null && customer.getPhoneNumber() != null) {
				customers.add(customer);	
			}
			
		}
        
		public Customer view()
		{
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

		
		
		public void list() 
		{
	     for(Customer tmpCust:customers)
				// display it
				System.out.println(tmpCust);
		
		}
		
		public void edit()
		{
			// Call view() to find, display, & return the book to edit
			Customer tempCust = view();
			// If the book != null, i.e. it was found then...
		    if(tempCust != null){
			   // get it's index
			   int index=customers.indexOf(tempCust);
			   // read in a new book and...
			   tempCust.read();
			   // reset the object in books
			   customers.set(index, tempCust);
		    }
		}
		
		public void delete()
		{
			// Call view() to find, display, & return the customer to delete
			Customer tempCust = view();
			// If the customer != null, i.e. it was found then...
		    if(tempCust != null)
			   // ...remove it from books
		       customers.remove(tempCust);
		}
		
		
		//SERIALIZE
		public void writeRecordsToFile(){
			ObjectOutputStream os=null;
			try {
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
				 os = new ObjectOutputStream(fileStream);
				os.writeObject(customers);
				}catch(FileNotFoundException fNFE){
					System.out.println("Cannot create file to store customers.");
				}catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}finally {
					try {
						os.close();
						}
					catch(IOException ioE){
						System.out.println(ioE.getMessage());
					}
						}
					}
			
		//DESERIALISE 
		public void readRecordsFromFile(){
			ObjectInputStream is=null;
			
			try {
				FileInputStream fileStream = new FileInputStream(FILENAME);
				is = new ObjectInputStream(fileStream);
				customers = (ArrayList<Customer>)is.readObject();
				is.close();
			    }
				catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
				}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
			//lets the program get the last number of customer entered and starts with the 
			//next number when the program is resumed/restarted.
			int highestNo = 0;
			for (Customer tmp:customers) {
				if(tmp.getNumber() >highestNo) {
					highestNo = tmp.getNumber();
				}
			}
			highestNo++;
			Customer.setNextNumber(highestNo);
		
		
			}
		}
			
		
		
		
