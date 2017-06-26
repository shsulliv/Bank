public class ManageAccount {
  public static void main(String[] args) {
    Account one = new Account("Donald Trump", 20230715, 400);
    Account two = new Account("Bill Gates", 31558040, 500);
    Account three = new Account("Tom Cruise", 44003050, 600);

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
  }

  private static double getBankTotal(Account a, Account b, Account c) {
    return a.getBalance() + b.getBalance() + c.getBalance();
  }
}