package ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class OptionsMenu extends Account
{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'Rs'###,##0.00");
	
	HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
	
	public void getLogin() throws IOException
	{
		int x = 1;
		do
		{
			try
			{
				data.put(110599, 7424);
				data.put(110598, 7222);
				
				System.out.println("Welcome to ATM project!!!");
				System.out.println("Enter your customer number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN number: ");
				setPinNumber(menuInput.nextInt());
			}catch(Exception e)
			{
				System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
				x = 2;
			}
			
			getAccountType();
		}while(x==1);
	}
	
	public void getAccountType()
	{
		System.out.println("Select the account you want to access: ");
		System.out.println(" Type 1 - Current Account ");
		System.out.println(" Type 2 - Saving Account ");
		System.out.println(" Type 3 - Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1 :
			getCurrent();
			break;
			
		case 2 : 
			getSaving();
			break;
			
		case 3 : 
			System.out.println("Thank you for using ATM, BYE! \n");
			break;
			
		default :
			System.out.println("\n"+"Invalid Choice."+"\n");
		}
	}
	
	public void getCurrent()
	{
		System.out.println("Current Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Amount");
		System.out.println("Type 3 - Deposit Amount");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			System.out.println("Current Account Balance: "+ moneyFormat.format(getCurrentBalance()));
			getAccountType();
			break;
			
		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getCurrentDepositInput();
			getAccountType();
			
		case 4:
			System.out.println("Thank you for using ATM, BYE!");
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			
		}
	}
	
	public void getSaving()
	{
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Amount");
		System.out.println("Type 3 - Deposit Amount");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1 :
			System.out.println("Savings Account Balance: "+ moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
			
		case 2 : 
			getSavingWithdrawInput();
			getAccountType();
			break;
			
		case 3 : 
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank you for using ATM, BYE!");
			break;
			
		default :
			System.out.println("\n"+"Invalid Choice."+"\n");
		}
	}
}
