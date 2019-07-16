package by.epam.my_study.simple_classes.task8;

public class Main {
    public static void main(String[] args){
        Customer ivanov = new Customer("Vasily", " Ivanov", "4444.3589.6378.1236");
        Customer gatalsky = new Customer("Zan", "Gatalsky", "Aluksadrovich", "Minsk, Kuibucheva, 35", "4435963635874563", 1336453366);
        Customer urgat = new Customer("Ivan", "Urgant", "3335-6569-3598-9635");
        Customer petrov = new Customer("Petr", "Petrov", "6657 6544 6369 8525");
        Customer zhuravel = new Customer("Evgeny", "Zhuravel", "Sergeevich", "Minsk, Very Horyzhey, 85", "4653.6935.4586.4563", 1236548524);

        CustomersArray bankDobrobit = new CustomersArray();
        bankDobrobit.addCustomer(ivanov);
        bankDobrobit.addCustomer(gatalsky);
        bankDobrobit.addCustomer(urgat);
        bankDobrobit.addCustomer(petrov);
        bankDobrobit.addCustomer(zhuravel);

        for (Customer el : bankDobrobit.showCustomer()){
            System.out.println(el);
        }

        System.out.println("\n\t\tAfter remove\n");

        bankDobrobit.removeCustomer(3);

        for (Customer customer: bankDobrobit.showCustomer()){
            System.out.println(customer);
        }


        System.out.println("\n\n\t\tFrom RANGE");

        bankDobrobit.showCardFromTo(0, 56666666_6666_9999L);
    }
}
