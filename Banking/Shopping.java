import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private String customerID;
    private String name;
    private String address;
    private int purchaseValue;

    public Customer(String customerID, String name, String address, int purchaseValue) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.purchaseValue = purchaseValue;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", purchaseValue=" + purchaseValue +
                '}';
    }
}

public class Shopping {
    static Scanner sc;

    public static void main(String[] args) {
        functionalities();
    }

    private static void functionalities(){
        int sum = 0;
        float average = 0;
        int size;
        Scanner sc = new Scanner(System.in);

        String id, name, address;
        int purchaseValue;

        Customer[] customers;

        try {

            System.out.println("Enter Number of customers");
            size = Integer.parseInt(sc.nextLine());
            customers = new Customer[size];

            for (int i = 0; i < size; i++) {

                System.out.println("Enter id");
                id = sc.nextLine();

                System.out.println("Enter name");
                name = sc.nextLine();

                System.out.println("Enter address");
                address = sc.nextLine();

                System.out.println("Enter purchase value");
                purchaseValue = Integer.parseInt(sc.nextLine());

                customers[i] = new Customer(id, name, address, purchaseValue);
            }

            for (Customer c : customers) {
                sum = sum + c.getPurchaseValue();
                System.out.println(c.toString());
            }

            average = sum / customers.length;
            System.out.println("Average purchase value = " + average);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input");
            functionalities();
        }
    }
}