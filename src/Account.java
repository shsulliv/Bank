import java.text.NumberFormat;
import java.util.Date;

public class Account {
  int acctNumber;
  double balance;
  String name;
  Date dateCreated;
  double overdraftLimit;

  //-----------------------------------------------------------------
  //  Sets up the account by defining its owner's name, account
  //   number, and initial balance.
  //-----------------------------------------------------------------
  public Account(String x, int y, double z) {
    name = x;
    acctNumber = y;
    balance = z;
    dateCreated = new Date();
  }

  public Account(String x, int y) {
    this(x, y, 0);
  }

  //-----------------------------------------------------------------
  //  Deposits the specified amount x into the account.
  //-----------------------------------------------------------------
  public void deposit(double x) {
    balance = balance + x;
  }

  //-----------------------------------------------------------------
  //  Withdraws the specified amount from the account and applies
  //  the fee.
  //-----------------------------------------------------------------
  public void withdraw(double x, double fee) {
    if (x + fee > balance + overdraftLimit) {
      System.out.println("There are insufficient funds in your account.");
    } else {
      balance = balance - x - fee;
    }
  }

  public void withdraw(double x) {
    withdraw(x, 0);
  }

  //-----------------------------------------------------------------
  //  Returns the current balance of the account.
  //-----------------------------------------------------------------
  public double getBalance() {
    return balance;
  }

  //-----------------------------------------------------------------
  //  Adds the interest to the balance
  //-----------------------------------------------------------------
  public void addInterest(double rate) {
    balance += (balance * rate);
  }

  //-----------------------------------------------------------------
  //  Sets an overdraft limit
  //-----------------------------------------------------------------
  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }

  //-----------------------------------------------------------------
  //  Returns a one-line description of the account as a string.
  //-----------------------------------------------------------------
  public String toString() {
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
  }
}