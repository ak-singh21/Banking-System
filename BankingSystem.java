import java.util.ArrayList; //Import ArrayList class for managing transactions
import java.util.Scanner;   //Import Scanner class for user input

class BankAccount {
    private double balance; //Variable to store the account balance
    private ArrayList<String> transactions; //List to record the transaction history

    //Constructor to initialize the bank account
    public BankAccount() {
        this.balance = 0.0; //Set initial balance to 0
        this.transactions = new ArrayList<>(); //Initialize transactions list
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) { //Check if the deposit amount is valid
            balance += amount; //Add amount to balance
            transactions.add("Deposited: $" + amount); //Record the transaction
            System.out.println("Deposited $" + amount); //Confirm the deposit
        } else {
            System.out.println("Invalid deposit amount."); //Error message for an invalid amount
        }
    }

    //Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { //Check if withdrawal amount is valid
            balance -= amount; //Deduct the amount from balance
            transactions.add("Withdrew: $" + amount); //Record the transaction
            System.out.println("Withdrew $" + amount); //Confirm the withdrawal
        } else if (amount > balance) {
            System.out.println("Insufficient balance."); //Error for insufficient funds
        } else {
            System.out.println("Invalid withdrawal amount."); //Error for invalid amount
        }
    }

    //Method to check the current account balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance); //Show the balance
    }

    //Method to show the transaction history
    public void showTransactions() {
        if (transactions.isEmpty()) { //Check if there are no transactions
            System.out.println("No transactions yet."); //Tell the user
        } else {
            System.out.println("Transaction History:"); //Title for transaction history
            for (String transaction : transactions) { //Loop through transactions
                System.out.println(transaction); //Print each transaction
            }
        }
    }
}

public class SimpleBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Make Scanner object for input
        BankAccount account = new BankAccount(); //Make a new BankAccount instance

        while (true) { //Infinite loop for user interaction
            //Show menu options
            System.out.println("\nWelcome to the Simple Bank!");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); //Get user's choice

            switch (choice) { //Process user's choice
                case 1: //Deposit option
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble(); //Get deposit amount
                    account.deposit(depositAmount); //Call the deposit method
                    break;
                case 2: //Withdraw option
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble(); //Get withdrawal amount
                    account.withdraw(withdrawalAmount); //Call the withdraw method
                    break;
                case 3: //Check balance option
                    account.checkBalance(); //Call the checkBalance method
                    break;
                case 4: //Show transaction history option
                    account.showTransactions(); //Call the showTransactions method
                    break;
                case 5: //Exit option
                    System.out.println("Exiting the bank. Goodbye!"); //Exit message
                    scanner.close(); //Close the scanner
                    return; //Exit the program
                default: //Invalid option handling
                    System.out.println("Invalid choice, please try again."); //Error message
            }
        }
    }
}