public class AccountTest {
    public static void main(String[] args){
        System.out.println("Total Accounts: " + BankAccount.getBankAccounts());
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount();
        BankAccount a3 = new BankAccount();

        a1.depositCash(2560);
        a3.depositCash(500);
        System.out.println("Account 1 Total Balance: " + a1.getCash());
        System.out.println("Account 2 Total Balance: " + a2.getCash());
        System.out.println("Account 3 Total Balance: " + a3.getCash());

        a1.withdrawCash(260);
        System.out.println("=================== Making Withdraw ===================");
        System.out.println("Account 1 Total Balance: " + a1.getCash());


        System.out.println("Total Accounts: " + BankAccount.getBankAccounts());
        System.out.println("Total Balance: " + BankAccount.getTotalCash());
        a1.withdrawCash(22260);


    }
}