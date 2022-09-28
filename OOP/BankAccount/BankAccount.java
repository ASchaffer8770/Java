public class BankAccount {
    //attributes (which are always private!)
    private double cash;
    private static int memberAccounts;
    private static double totalCash;

    //constructor
    public BankAccount(){
        memberAccounts++; //no "this" for static variables
    }

    //getters and setters
    public double getCash(){
        return this.cash;
    }

    public static int getBankAccounts(){
        return memberAccounts;
    }

    public static double getTotalCash(){
        return totalCash;
    }

    //custom methods
    public void depositCash(int depositCash){
        this.cash += depositCash;
        totalCash += depositCash;
    }

    public void withdrawCash(int withdrawCash){
        if(this.cash <= withdrawCash){
            System.out.println("=================== Insufficient funds cannot complete withdraw ===================");
        } else {
        this.cash -= withdrawCash;
        totalCash -= withdrawCash;
        }
    }
}