package by.epam.my_study.agrigation_coposition.task4;

public class Bank {
    private  String bankName;

    private BankAccount [] accounts = new BankAccount[10];

    Bank(String bankName){
        this.bankName = bankName;
    }

    public void createAccount(Customer customer, double money){
        boolean isCreated = false;

        for (int i = 0; i < accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = new BankAccount(customer, money);
                isCreated = true;
                break;
            }
        }

        if(isCreated){
            customer.earnOrSpendMoney(money * (-1));
        }else{
            System.out.println("Bank can not create account.");
        }

    }


    public void changeAccountBalance(Customer customer, int id, double money){
        boolean findAccount = false;
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null && accounts[i].getBelongTo() == customer && accounts[i].getAccountId() == id){
                if(accounts[i].isUnlockStatus()) {
                    if(money <= customer.showMoneyInWallet()) {
                        accounts[i].changeBalance(money);
                        findAccount = true;
                        break;
                    }else{
                        money = customer.showMoneyInWallet();
                        accounts[i].changeBalance(money);
                        findAccount = true;
                        System.out.println("not enought money, add " + money);
                        break;
                    }
                }else{
                    System.out.format("\nAccount id#%d is blocked.\n", id);
                    findAccount = true;
                    money = 0;
                    break;
                }
            }
        }


        if(findAccount) {
            customer.earnOrSpendMoney(money * (-1));
        }else{
            System.out.format("Account id#%d not found or belong to other customer\n", id);
        }


    }

    public void setAccountStatus(int id, boolean unlock){
        boolean isFind = false;
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null && accounts[i].getAccountId() == id){
                accounts[i].unlockAccount(unlock);
                isFind = true;
                break;
            }
        }

        if(!isFind){
            System.out.format("\nlock: Account id#%d didn't find\n", id);
        }
    }

    public BankAccount[] showAccounts(Customer customer){
        int countCustomerAccounts = 0;
        for (int i = 0; i < accounts.length; i++){
            if(accounts[i] != null && accounts[i].getBelongTo() == customer){
                countCustomerAccounts++;
            }
        }

        BankAccount[] customerAccounts = new BankAccount[countCustomerAccounts];
        for(int i = 0, j = 0; i < accounts.length; i++){
            if(accounts[i] != null && accounts[i].getBelongTo() == customer){
                customerAccounts[j] = accounts[i];
                j++;
            }
        }

        return customerAccounts;
    }

    public void sortByBalance(Customer customer){
        BankAccount[] sorted = new BankAccount[showAccounts(customer).length];
        for(int i = 0; i < showAccounts(customer).length; i++){
            sorted[i] = showAccounts(customer)[i];
        }

        for (int i = 1; i < sorted.length; i++){
            if(sorted[i - 1].getBalance() < sorted[i].getBalance()){
                BankAccount forChange = sorted[i];
                sorted[i] = sorted[i - 1];
                sorted[i - 1] = forChange;

                if(i > 1){
                    i -= 2;
                }else{
                    i--;
                }
            }
        }

        for(BankAccount el: sorted){
            System.out.format("Account id#%d ; Customer: %s %s; is unlock : %s; balance: %.2f;%n",el.getAccountId(),el.getBelongTo().getFirstName(), el.getBelongTo().getLastName(), el.isUnlockStatus(), el.getBalance());
        }
    }



    public void showSummOfAllAccounts(Customer customer){
        double balance = 0;
        for(int i = 0; i < showAccounts(customer).length; i++){
            balance += showAccounts(customer)[i].getBalance();
        }
        System.out.format("Customer %s %s has %.2f BYN in all accounts.%n",customer.getFirstName(), customer.getLastName(),balance);
    }

    public void showSummOfAllAccountsPositiv(Customer customer){
        double balance = 0;
        for(int i = 0; i < showAccounts(customer).length; i++){
            if(showAccounts(customer)[i].getBalance() >= 0) {
                balance += showAccounts(customer)[i].getBalance();
            }
        }
        System.out.format("Customer %s %s has %.2f BYN in all accounts.%n",customer.getFirstName(), customer.getLastName(),balance);
    }


    public void showSummOfAllAccountsNegotiv(Customer customer){
        double balance = 0;
        for(int i = 0; i < showAccounts(customer).length; i++){
            if(showAccounts(customer)[i].getBalance() < 0) {
                balance += showAccounts(customer)[i].getBalance();
            }
        }
        System.out.format("Customer %s %s has %.2f BYN in all accounts.%n",customer.getFirstName(), customer.getLastName(),balance);
    }



}

