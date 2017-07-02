# Programming Coursework
## Part II: Bank Account Management

### Project Overview
This is the hand-in report for Part II of the Programming in Java coursework for Ada College. Source code can be found in Appendix A.

### Sample Output

#### Exercise 1
Console output:
```
> 450.0
> 100.0
> 525.0
> 20230715	Donald Trump	$525.00
> 31558040	Bill Gates	$100.00
> 44003050	Tom Cruise	$600.00
```

#### Exercise 2
Code changed:
```java

// ManageAccount.java
private static double getBankTotal(Account a, Account b, Account c) {
  return a.getBalance() + b.getBalance() + c.getBalance();
}

System.out.println(getBankTotal(one, two, three));
```
Console output:
```
> 1225.0
```

#### Exercise 3
Code changed:
```java
// Account.java
public void withdraw(double x, double fee) {
  if (x + fee > balance) {
    System.out.println("There are insufficient funds in your account.");
  } else {
    balance = balance - x - fee;
  }
}
```
Console output:
```
> There are insufficient funds in your account.
```

#### Exercise 4
Code changed:
```java
// Account.java
public void withdraw(double x) {
  withdraw(x, 0);
}
```

#### Exercise 5
Code changed:
```java
// ManageAccount.java
private static double getTaxes(Account account) {
  double taxes = account.getBalance() * 0.15;
  account.withdraw(taxes);
  return taxes;
}

double totalTaxes = getTaxes(one) + getTaxes(two) + getTaxes(three);
```

#### Exercise 6
Code changed:
```java
// Account.java
public Account(String x, int y) {
  this(x, y, 0);
}

// ManageAccount.java
Account inland = new Account("Inland Revenue", 10000000);
```

#### Exercise 7
Code changed:
```java
// ManageAccount.java
inland.deposit(totalTaxes);
```

#### Exercise 8
Code changed:
```java
// Account.java
public void addInterest(double rate) {
  balance += (balance * rate);
}

// ManageAccount.java
one.addInterest(0.015);
two.addInterest(0.015);
three.addInterest(0.015);
inland.addInterest(0.015);
```

#### Exercise 9
Code changed:
```java
// Account.java
Date dateCreated;

public Account(String x, int y, double z) {
  name = x;
  acctNumber = y;
  balance = z;
  dateCreated = new Date();
}
```

#### Exercise 10
Code changed:
```java
// Account.java
double overdraftLimit;

public void withdraw(double x, double fee) {
  if (x + fee > balance + overdraftLimit) {
    System.out.println("There are insufficient funds in your account.");
  } else {
    balance = balance - x - fee;
  }
}

public void setOverdraftLimit(double overdraftLimit) {
  this.overdraftLimit = overdraftLimit;
}
```

### Appendix A

#### 1.1 Account.java
```java
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
```

#### 1.2 ManageAccount.java
```java
public class ManageAccount {
  public static void main(String[] args) {
    Account one = new Account("Donald Trump", 20230715, 400);
    Account two = new Account("Bill Gates", 31558040, 500);
    Account three = new Account("Tom Cruise", 44003050, 600);
    Account inland = new Account("Inland Revenue", 10000000);

    one.deposit(50);
    System.out.println(one.getBalance());

    two.withdraw(400, 0);
    System.out.println(two.getBalance());

    one.deposit(75);
    System.out.println(one.getBalance());

    System.out.println(one);
    System.out.println(two);
    System.out.println(three);

    System.out.println(getBankTotal(one, two, three));

    inland.deposit(getTaxes(one) + getTaxes(two) + getTaxes(three));

    one.addInterest(0.015);
    two.addInterest(0.015);
    three.addInterest(0.015);
    inland.addInterest(0.015);
  }

  private static double getBankTotal(Account a, Account b, Account c) {
    return a.getBalance() + b.getBalance() + c.getBalance();
  }

  private static double getTaxes(Account account) {
    double taxes = account.getBalance() * 0.15;
    account.withdraw(taxes);
    return taxes;
  }
}
```
