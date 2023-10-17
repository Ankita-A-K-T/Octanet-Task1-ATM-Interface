import java.util.*;


class ATM
{
  private String userID;
  private int pin;
  private double balance;
  Scanner sc=new Scanner(System.in);
  ATM(String userID,int pin,double initialBalance)
  {
  	this.userID=userID;
  	this.pin=pin;
  	this.balance=initialBalance;
  }
  public void Menu()
  {
  	System.out.println("Welcome to the Atm System!...");
  	System.out.println("1.Balance inquiry:");
  	System.out.println("2.Cash Withdrowal:");
  	System.out.println("3.Cash Deposite:");
  	System.out.println("4.Transfer:");
  	System.out.println("5.EXIT");
  }
  public void executeTransaction(int choice)
  {
    switch(choice)
    {
    case 1:
      System.out.println("Your balance is:" +balance);
      break;
    case 2:
      System.out.println("Enter Withdrowal amount:");
      double withdrawalAmount=sc.nextDouble();
      if(withdrawalAmount>0 && withdrawalAmount<=balance)
      {
        balance=balance-withdrawalAmount;
        System.out.println("withdrawal successfull:");

      }
      else {
        System.out.println("Insufficient funds or invalid amount:");

      }
      break;
    case 3:
      System.out.println("Enter deposit amount:");
      double depositAmount=sc.nextDouble();
      if(depositAmount>0)
      {
        balance+=depositAmount;
        System.out.println("deposit successful!");

      }
      else {
        System.out.println("invalid deposit amount");
      }
      break;
    case 4:
      System.out.println("Enter account number transfer money:");
      long acountno=sc.nextLong();
      System.out.println("enter transfer amount:");
      int amount=sc.nextInt();
      if(balance>0)
      {
        balance=balance-amount;
        System.out.println("transfer amount"+amount);
      }
      else 
      {
        System.out.println("Insufficient amount:");
      }
    case 5:
      System.out.println("Thank you for using the ATM. Goodbye!");
      System.exit(0);
      break;
    default:
       System.out.println("invalid choice.Please select a valid option");  
     }
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter your userID:");
    String userID=sc.nextLine();
    System.out.println("Enter your PIN:");
    int pin=sc.nextInt();
    ATM atm=new ATM(userID,pin,1000.0);
    while(true)
    {
      System.out.println("-------------------------");
      atm.Menu();
      System.out.println("Select an option(1-5)");
      int choice=sc.nextInt();
      atm.executeTransaction(choice);
    }
  }
}