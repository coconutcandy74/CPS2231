import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

class Account{
	private int userID;
	private double balance;		
	private Date dateCreated;
	ArrayList<Transaction> transactions;
	private String filename;                 // File name for storing service information

	Account(){}
	Account(int a, double b){
		userID = a;
		balance = b;
		dateCreated = new Date();
		transactions = new ArrayList<>();
		filename = "trans-" + userID;
	        LoadTransactions();
	}

	// Restores all historical business information from files to memory 
	void LoadTransactions() {
		BufferedReader objReader = null;
		try {
			String strCurrentLine;
			objReader = new BufferedReader(new FileReader(filename));

			// Read all business information by row, one at a time 
			while ((strCurrentLine = objReader.readLine()) != null) {
			
				// Each time a piece of business information is read from a file, it needs to be parsed
				Scanner input = new Scanner(strCurrentLine);
				String Type = input.next();
				double Amount = input.nextDouble();
				double Balance = input.nextDouble();

				try {
					// Format the read time so that transaction's add method accepts this parameter
					String DateLoaded = input.next();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
					Date date6 = sdf.parse(DateLoaded);

					// System.out.println("" + Type.charAt(0) + "  " + Amount + "  " + Balance + "  " + date6);

					// Update the user balance to the value recorded in the file
					balance = Balance;

					// Services read from files are restored to memory
					transactions.add(0, new Transaction(Type.charAt(0), Amount, balance, "loaded", date6));
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			
				
			}
		} catch (IOException e) {
//			e.printStackTrace();
		} finally {
			try {
				if (objReader != null)
					objReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// File all historical business information
	void SaveTransactions() {
		try {
			FileWriter file = new FileWriter(filename);
			BufferedWriter output = new BufferedWriter(file);


           		// Store in reverse order: that is, the oldest business is recorded at the front of the file
			for(int idx = transactions.size() - 1; idx >= 0; idx--) {
				output.write(transactions.get(idx).toSaveString());
				output.newLine();
			}


			output.flush();
			output.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

	int getUserID(){
		return userID;
	}
	void setUserID(int a){
		userID = a;
	}
	double getBalance(){
		return balance;
	}
	void setBalance(double a){
		balance = a;
	}
	Date getDateCreated(){
		return dateCreated;
	}

	// withdraw 
	public void withdraw(double Amount) {
		if(Amount > balance) {
			System.out.println("THE BALANCE IS NOT ENOUGH!");
		}
		else {
			balance = balance - Amount;
			transactions.add(0, new Transaction('W', Amount, balance, "withdraw"));
//			System.out.println(transactions.get(0).toString());
			SaveTransactions();
		}
	}

	// deposit 
	public void deposit(double Amount) {
		balance = balance + Amount;
		transactions.add(0, new Transaction('D', Amount, balance, "deposit"));
//		System.out.println(transactions.get(0).toString());
		SaveTransactions();
	}

	// All historical services are displayed 
	void displayAll(){
		System.out.println("Trans Type  Amount    Balance    Date");
		System.out.println("-----------------------------------------------");
		for(int idx = 0; idx < transactions.size(); idx++) {
			System.out.println(transactions.get(idx).toString());
		}
	}
	
}

class Transaction {
	private char type;
	private double amount;
	private double balance;
	private Date dateUpdated;
	private String description;

	// Used to create a new single service 
	public Transaction(char Type, double Amount, double Balance, String Desc) {
		dateUpdated = new Date();
		type = Type;
		amount = Amount;
		balance = Balance;
		description = Desc;
	}

	// Used to recover a single service information when loading a file
	public Transaction(char Type, double Amount, double Balance, String Desc, Date DateLoaded) {
		dateUpdated = DateLoaded;
		type = Type;
		amount = Amount;
		balance = Balance;
		description = Desc;
	}

	// An output string used to construct a single piece of business information 
	public String toString() {
		return "" + type + "           " + amount + "     " + balance + "      " + dateUpdated;
	}

	// A string used to construct a single piece of business information stored in a file
	public String toSaveString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
		String date6 = sdf.format(dateUpdated);
		return "" + type + "           " + amount + "     " + balance + "      " + date6;
	}
}

class ATM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int idx = 0;

		//Create a User account 
		Account[] user = new Account[10];
		for(idx = 0; idx < 10; idx++) {
			user[idx] = new Account(idx ,0);
		}

		while(true) {
			// Prompt and wait for the user to enter the ID 
			System.out.print("Enter an ID: ");
			int id_input = input.nextInt();

			// Always prompt when the input is incorrect until it is correct 
			while(id_input > 9 || id_input < 0) {
				System.out.print("This ID is invalid, please input again: ");
				id_input = input.nextInt();
			}

			while(true) {
				// Output menu
				System.out.println("\nMain menu");
				System.out.println("1: check balance");
				System.out.println("2. withdraw");
				System.out.println("3. deposit");
				System.out.println("4. displayAll");
				System.out.println("5. exit");
				System.out.print("Enter a choice: ");

				// Wait for the user to enter the selected menu item
				int choice = input.nextInt();

				// Determine whether to exit the menu first. If yes, exit the menu immediately
				if(choice == 5)
				{
					break;
				}

				// Perform actions based on the menu items selected by the user
				switch (choice) {
					case 1: {
						System.out.println("The balance is " + user[id_input].getBalance());
						break;
					}
					case 2: {
						System.out.print("Enter an amount to withdraw: ");
						double Amount = input.nextDouble();
						user[id_input].withdraw(Amount);
						break;
					}
					case 3: {
						System.out.print("Enter an amount to deposit: ");
						double Amount = input.nextDouble();
						user[id_input].deposit(Amount);
						break;
					}
					case 4: {
						user[id_input].displayAll();
						break;
					}
				}
			}
		}
	}
}


