import java.text.DecimalFormat;
import java.util.Scanner;

public class Accounts {
    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingsBalance = 0;

    
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int getCustomerNumber() {
        return customerNumber;
    }
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    
    public int getPinNumber() {
        return pinNumber;
    }
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    } 

    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double calcCurrentDepositBalance(double amount){
        currentBalance += amount;
        return currentBalance;
    }

    public double calcCurrentWithdrawBalance(double amount){
        currentBalance -= amount;
        return currentBalance;
    }

    public double calcSavingsDepositBalance(double amount){
        savingsBalance += amount;
        return savingsBalance;
    }

    public double calcSavingsWithdrawBalance(double amount){
        savingsBalance -= amount;
        return savingsBalance;
    }

    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
        System.out.println("Enter amount you want to Withdraw: ");
        double amount = sc.nextDouble();
        if((currentBalance - amount) >= 0){
            calcCurrentWithdrawBalance(amount);
            System.out.println("New Current Account Balance is: " + moneyFormat.format(getCurrentBalance()));
        }
        else{
            System.out.println("Not Enough Balance" + "\n");
        }
    }

    public void getCurrentDepositInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
        System.out.println("Enter amount you want to Deposit: ");
        double amount = sc.nextDouble();
        if(amount > 0){
            calcCurrentDepositBalance(amount);
            System.out.println("New Current Account Balance is: " + moneyFormat.format(getCurrentBalance()));
        }
        else{
            System.out.println("Amount to be deposit cannot be negative!!!");
        }
        
    }
    
    public void getSavingsWithdrawInput(){
        System.out.println("Your Savings Account Balance is: " + moneyFormat.format(savingsBalance));
        System.out.println("Enter the amount you want to withdraw: ");
        double amount = sc.nextDouble();

        if((savingsBalance-amount) >= 0){
            calcSavingsWithdrawBalance(amount);
            System.out.println("New Savings Balance is: " + moneyFormat.format(savingsBalance));
        }
        else{
            System.out.println("Not enough Balance!");
        }
    }

    public void getSavingsDepositInput(){
        System.out.println("Your Savings Account Balance is: " + moneyFormat.format(savingsBalance));
        System.out.println("Enter the amount you want to Deposit: ");
        double amount = sc.nextDouble();

        if(amount > 0){
            calcSavingsDepositBalance(amount);
            System.out.println("New Savings Balance is: " + moneyFormat.format(savingsBalance));
        }
        else{
            System.out.println("Amount to be deposit cannot be Negative!");
        }
    }

}
