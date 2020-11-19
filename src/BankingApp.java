import java.util.Scanner;
import java.util.*;

public class BankingApp {
    public static void main(String[] args) {

//        create an object to display our user name and id
        BankAccount obj1 = new BankAccount("Lakhiwe", "Liwani");
        obj1.showMenu();
    }
}

//  create a class with BankAccount variables.
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    //    create a bank account constructor that takes two parameters customer name and customer Id
    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    //    create a method that takes an amount parameter.
    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //    create a withdraw method that also take a parameter amount for the withdrawn amount.
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //    create a method that shows the previous amount that been withdrawn
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposited amount is: " + previousTransaction);
        }
        else if (previousTransaction < 0){
            System.out.println("The withdrawn amount is: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No transaction occured");
        }
    }

    //    create a method to show the menu for the customer
    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. check a balance ");
        System.out.println("B. Make a Deposit ");
        System.out.println("C. Cash withdrawal ");
        System.out.println("D. Previous transaction ");
        System.out.println("E. Exit");

        do {
            System.out.println("===============================================");
            System.out.println("Please enter an option");
            System.out.println("===============================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'A':
                    System.out.println("-------------------------------");
                    System.out.println("The balance is: " + balance);
                    System.out.println("-------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("--------------------------------");
                    System.out.println("Please enter the amount to deposit: ");
                    System.out.println("--------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("---------------------------------");
                    System.out.println("Enter the amount to withdraw: ");
                    System.out.println("---------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("---------------------------------");
                    getPreviousTransaction();
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("**********************************");
                    break;

                default:
                    System.out.println("Invalid option!!. Please enter again");
                    break;
            }

        }while (option != 'E');

        System.out.println("Thank You for using our services");
    }

}