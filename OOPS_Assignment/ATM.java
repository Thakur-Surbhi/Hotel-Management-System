package OOPS_Assignment;

/*Encapsulation Question 1. ATMSystem
Problem: Design an ATM class with private fields pin, balance, and attempts. 
Implement methods to withdraw, deposit, and change PIN. 
Lock the account after 3 incorrect PIN attempts.
Input:
ATM atm = new ATM(1234, 5000); 
atm.withdraw(1234, 1000); 
atm.changePIN(1234, 5678); 
atm.withdraw(1111, 2000); 
atm.withdraw(1111, 2000); 
atm.withdraw(1111, 2000); 
atm.withdraw(1234, 500); 
Output:
Withdrawn: 1000 
PIN Changed 
Incorrect PIN 
Account Locked*/

public class ATM {

	private int pin;
	private  double Balance;
	private int attempts;
	private boolean locked;

	public ATM(int pin, double balance) {
		this.pin = pin;
		this.Balance=balance;
		this.attempts=0;
		this.locked=false;
	}

	public void withdraw(int enteredPin, double amount) {
		if(locked) {
			System.out.println("Account Locked");
			return;
		}

		if(enteredPin!=pin) {
			attempts++;
			System.out.println("Äccount Locked");

			if(attempts>=3) {
				locked=true;
				System.out.println("Account Locked");
			}
			return;
		}

		if(amount>Balance) {
			System.out.println("Insufficient Fund");
		}

		else {
			Balance-=amount;
			System.out.println("Withdrow : " +amount);
		}
	}

	public void Deposite(int enteredPin, double amount) {
		if(locked) {
			System.out.println("Account Locked");
			return;
		}

		if(enteredPin!=pin) {
			attempts++;
			System.out.println("Äccount Locked");

			if(attempts>=3) {
				locked=true;
				System.out.println("Account Locked");
			}
			return;
		}

		if(amount>Balance) {
			System.out.println("Insufficient Fund");
		}

		else {
			Balance+=amount;
			System.out.println("Deposite : " +amount);
		}
	}

	 public void changePIN(int enteredPin, int newPin) {
	        if (locked) {
	            System.out.println("Account Locked");
	            return;
	        }

	        if (enteredPin != pin) {
	            attempts++;
	            System.out.println("Incorrect PIN");
	            if (attempts >= 3) {
	                locked = true;
	                System.out.println("Account Locked");
	            }
	            return;
	        }

	        attempts = 0;
	        pin = newPin;
	        System.out.println("PIN Changed");
	    }
	 
	 public static void main(String[] args) {
		ATM atm = new ATM(1234, 5000);
		atm.Deposite(1111, 2000);
		atm.withdraw(1234, 1000);
		atm.changePIN(1234, 5678);
	}
}
	