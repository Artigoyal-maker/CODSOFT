package ATM_Interface;
import java.util.Scanner;

class BankAccount{
	private double balance;
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposit successful!");
	}
	
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful!");
		}else {
			System.out.println("Insufficient balance.");
		}
	}
	
	public double checkBalnce() {
		return balance;
	}
}

class ATM {
	BankAccount account;
	ATM(BankAccount account){
		this.account = account;
	}
	
	public void showMenu() {
		Scanner s = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("\n===== ATM MENU =====");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.print("Choose option: ");
			choice = s.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Balance: "+account.checkBalnce());
				break;
				
			case 2:
				System.out.println("Enter deposit amount: ");
				double deposit = s.nextDouble();
				account.deposit(deposit);
				break;
				
			case 3:
				System.out.println("Enter withdrawal amount: ");
				double withdraw = s.nextDouble();
				account.withdraw(withdraw);
				break;
				
			case 4: 
				System.out.println("Thank You for using ATM!");
				break;
				
			default:
				System.out.println("Invalid option.");
			}
		} while(choice != 4);
		
		s.close();
	}
}

public class ATM_Machine {
	public static void main(String[] args){
		BankAccount userAccount = new BankAccount(6000);
		ATM atm = new ATM(userAccount);
		
		atm.showMenu();
	}
}
