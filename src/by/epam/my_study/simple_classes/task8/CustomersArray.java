package by.epam.my_study.simple_classes.task8;

public class CustomersArray {

    private Customer [] customer = new Customer[5];

    CustomersArray(){};

    CustomersArray(Customer customer){
        this.customer[0] = customer;
    }

    public void addCustomer(Customer customer) {
        for(int i = 0; i < this.customer.length; i++){
            if(this.customer[i] == null){
                this.customer[i] = customer;
                break;
            }

            if(i == this.customer.length - 1 && this.customer[i] != null){
                System.out.println("Cann't add, array is full");
            }
        }
    }

    public void removeCustomer(int custoomerId){
        for(int i = 0; i < this.customer.length; i++){
            if(this.customer[i] != null && this.customer[i].getId() == custoomerId){
                this.customer[i] = null;
                break;
            }

            if(i == this.customer.length - 1 && (this.customer[i] == null || this.customer[i].getId() != custoomerId)){
                System.out.println("There is no customer with id#" + custoomerId);
            }

        }
    }

    public Customer [] showCustomer(){
        int countCustomers = 0;
        for(int i = 0; i < customer.length; i++){
            if(customer[i] != null){
                countCustomers++;
            }
        }


        Customer[] showCustomer = new Customer[countCustomers];

        for(int i = 0, j = 0; i < customer.length; i++){
            if(customer[i] != null){
                showCustomer[j] = customer[i];
                j++;
            }
        }

        for(int i = 1; i < showCustomer.length; i++){

            char [] firstCustomer = showCustomer[i - 1].getLastName().trim().toCharArray();
            char [] secondCustomer = showCustomer[i].getLastName().trim().toCharArray();
            for(int j = 0; j < firstCustomer.length && j < secondCustomer.length; j++){
                if(firstCustomer[j] < secondCustomer[j]){
                    break;
                }else if(firstCustomer[j] > secondCustomer[j]){
                Customer change = showCustomer[i];
                showCustomer[i] = showCustomer[i - 1];
                showCustomer[i - 1] = change;
                if(i > 1){
                    i -= 2;
                }else{
                    i--;
                }
                break;
                }else{
                    continue;
                }
            }
        }
        return showCustomer;
    }


    public void showCardFromTo(long rangeFrom, long rangeTo){
        int countTrue = 0;
        for(int i = 0; i < showCustomer().length; i++){
            if(showCustomer()[i].getLongCardNumber() > rangeFrom && showCustomer()[i].getLongCardNumber() < rangeTo){
                System.out.println(showCustomer()[i]);
                countTrue++;
            }
        }
        if(countTrue == 0){
            System.out.println("No Custmers with cards from range started at " + rangeFrom + " ended at "  + rangeTo);
        }else{
            System.out.println("Find " + countTrue + "customers");
        }
    }


}
