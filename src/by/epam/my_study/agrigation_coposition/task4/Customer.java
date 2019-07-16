package by.epam.my_study.agrigation_coposition.task4;

public class Customer {
    private String firstName;
    private String lastName;
    private double hasMoneyInWallet;

    Customer(String firstName, String lastName, double hasMoneyInWallet){
        this.firstName = firstName;
        this.lastName = lastName;

        if(hasMoneyInWallet > 0){
            this.hasMoneyInWallet = hasMoneyInWallet;
        }else{
            System.out.println("In your wallet no money.");
        }
    }

    public void earnOrSpendMoney(double money){
        if(money >= 0) {
            hasMoneyInWallet += money;
            System.out.println("In " + lastName + "'s wallet " + hasMoneyInWallet + "BYN");
        }else if(money < 0 && hasMoneyInWallet >= money){
            hasMoneyInWallet += money;
            System.out.println("In " + lastName + "'s wallet " + hasMoneyInWallet + "BYN");
        }else{
            hasMoneyInWallet = 0;
            System.out.println("In " + lastName + "'s wallet " + hasMoneyInWallet + "BYN");
        }
    }

    public double showMoneyInWallet(){
        return hasMoneyInWallet;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }




}

