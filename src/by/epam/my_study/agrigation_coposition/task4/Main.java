package by.epam.my_study.agrigation_coposition.task4;

/*
Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета. Реальзовать поиск
и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим положительный и отрицательный
балансы отдельно.
 */


public class Main {
    public static void main(String[] args){
        Customer dorozhko = new Customer("Sergey", "Dorozhko", 1000.5);
        System.out.println(dorozhko.showMoneyInWallet());
        dorozhko.earnOrSpendMoney(500);

        dorozhko.earnOrSpendMoney(-20.56);


        Bank prior = new Bank("Priorbank");
        prior.createAccount(dorozhko,1000);  //0


        prior.changeAccountBalance(dorozhko, 0, 100);


        prior.changeAccountBalance(dorozhko, 0, -100);


        prior.setAccountStatus(0, false);

        prior.changeAccountBalance(dorozhko, 0, 200);


        prior.createAccount(dorozhko, 300);  //1

        prior.changeAccountBalance(dorozhko, 1, 100);

        dorozhko.earnOrSpendMoney(10_000);


        prior.createAccount(dorozhko, 5000);  //2

        prior.createAccount(dorozhko, 800);  //3

        prior.setAccountStatus(2, false);
        prior.changeAccountBalance(dorozhko,2,30);
        prior.setAccountStatus(2, true);
        prior.changeAccountBalance(dorozhko,2,50);

        prior.setAccountStatus(5, true);


        Customer taranov = new Customer("Ivan", "Taranov", 10_000);

        prior.createAccount(taranov, 5000); //4
        prior.createAccount(taranov, 300);  //5
        prior.createAccount(taranov,800);   //6

        prior.changeAccountBalance(dorozhko,5, 1000);

        prior.createAccount(dorozhko,3_000);//7
        prior.changeAccountBalance(dorozhko,2,2000);

        for (BankAccount el: prior.showAccounts(dorozhko)){
            System.out.format("Account id#%d ; Customer: %s %s; is unlock : %s; balance: %.2f;%n",el.getAccountId(),el.getBelongTo().getFirstName(), el.getBelongTo().getLastName(), el.isUnlockStatus(), el.getBalance());
        }

        for (BankAccount el: prior.showAccounts(taranov)){
            System.out.format("Account id#%d ; Customer: %s %s; is unlock : %s; balance: %.2f;%n",el.getAccountId(),el.getBelongTo().getFirstName(), el.getBelongTo().getLastName(), el.isUnlockStatus(), el.getBalance());
        }


        prior.sortByBalance(dorozhko);

        prior.showSummOfAllAccounts(dorozhko);
        prior.showSummOfAllAccounts(taranov);

        prior.changeAccountBalance(dorozhko,3,-2000);
        prior.changeAccountBalance(dorozhko,1,-1000);
        prior.sortByBalance(dorozhko);

        prior.showSummOfAllAccountsPositiv(dorozhko);
        prior.showSummOfAllAccountsNegotiv(dorozhko);


    }
}

