package by.epam.my_study.agrigation_coposition.task4;

public class BankAccount {
    private int accountId;
    private static int countId = 0;
    private double balance;
    private boolean unlockStatus;

    Customer belongTo;

    BankAccount(Customer customer, double money){
        balance = money;
        accountId = countId++;

        unlockStatus = true;
        belongTo = customer;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isUnlockStatus() {
        return unlockStatus;
    }

    public Customer getBelongTo() {
        return belongTo;
    }




    public void changeBalance(double money) {
        if(money >= 0) {
            this.balance += money;
        }else if(money < 0 && money <= this.balance){
            this.balance += money;
        }else{
            System.out.println("This account does not has this summ, we give you " + this.balance + "BYN.");
            this.balance = 0;
        }
    }

    public void setUnlockStatus(boolean unlockStatus) {
        this.unlockStatus = unlockStatus;
    }


    public void unlockAccount(boolean unlocked){
        this.unlockStatus = unlocked;
    }
}

