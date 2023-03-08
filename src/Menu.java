import java.util.HashMap;
import java.util.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class Menu extends Accounts{
    
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap <Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException{
        int x = 1; 
        do{
            try {
                data.put(23234, 1234);
                data.put(98987, 4567);
                
                System.out.println("Welcome to ATM");
                System.out.println("Enter Customer number: ");
                setCustomerNumber(sc.nextInt());

                System.out.println("Enter PIN Number: ");
                setPinNumber(sc.nextInt());
            }
            catch (Exception e) {
                System.out.println("\n" + "Invalid Input!!!" + "\n" );
                x=2;
            }
        
            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if(data.containsKey(cn) && data.get(cn) == pn){
                System.out.println("Login Successful");
                getAccountType();
            }
            else{
                System.out.println("\n" + "Invalid customer number or PIN number" +"\n");
            }
        }
        while(x==1);            
        
    }

    public void getAccountType(){
        System.out.println("Enter the choice for Account Type: ");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Exit");

        int choice = sc.nextInt();
        switch(choice){
            case 1:{
                getCurrent();
                break;
            }
            case 2:{
                getSavings();
                break;
            }
            case 3:{
                System.out.println("Thank you for using this ATM");
                break;
            }
            default:{
                System.out.println("Invalid Choice!!!" + "\n");
                getAccountType();
            }
        }
    }

    public void getCurrent(){
        System.out.println("\n" +"-----------Current Account-----------"+"\n");
        System.out.println("Enter 1 to View Balance");
        System.out.println("Enter 2 to Withdraw Amount");
        System.out.println("Enter 3 to Deposit Amount");
        System.out.println("Enter 4 to Exit");

        int choice = sc.nextInt();

        switch(choice){
            case 1:{
                System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
                getCurrent();
                break;
            }
            case 2:{
                getCurrentWithdrawInput();
                getCurrent();
                break;
            }
            case 3:{
                getCurrentDepositInput();
                getCurrent();
                break;
            }
            case 4:{
                System.out.println("Thanks for using this ATM");
                break;
            }
            default:{
                System.out.println("Invalid Input!!!");
                getCurrent();
            }
        }

    }

    public void getSavings(){
        System.out.println("\n" +"-----------Savings Account-----------"+"\n");
        System.out.println("Enter 1 to View Balance");
        System.out.println("Enter 2 to Withdraw Amount");
        System.out.println("Enter 3 to Deposit Amount");
        System.out.println("Enter 4 to Exit");

        int choice = sc.nextInt();
        switch(choice){
            case 1:{
                System.out.println("Savings account balance is: " + moneyFormat.format(getSavingsBalance()));
                getSavings();
                break;
            }
            case 2:{
                getSavingsWithdrawInput();
                getSavings();;
                break;
            }
            case 3:{
                getSavingsDepositInput();
                getSavings();
                break;
            }
            case 4:{
                System.out.println("Thank you for using this ATM");
                break;
            }
            default:{
                System.out.println("Invalid Input!!!");
                getSavings();
                break;
            }
        }
    }

}
