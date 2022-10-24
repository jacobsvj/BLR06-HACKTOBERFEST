import java.util.Scanner;
class Customers {
    private int  CustomersID;
    private String Name;
    private String Address;
    private int PurchaseValue;

    public Customers(){}

    public Customers(int CustomersID, String name, String address, int purchaseValue) {
        CustomersID = CustomersID;
        Name = name;
        Address = address;
        PurchaseValue = purchaseValue;
    }

    public int getCustomersID() {
        return CustomersID;
    }

    public void setCustomersID(int CustomersID) {
        CustomersID = CustomersID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPurchaseValue() {
        return PurchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        PurchaseValue = purchaseValue;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "CustomersID=" + CustomersID +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", PurchaseValue=" + PurchaseValue +
                '}';
    }
}

public class ShopingMall{
    public static void  main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No of Records : ");
        int n = Integer.parseInt(sc.next());

        Customers[] c = new Customers[n];

        System.out.println("Enter the CustomersID, Name, Address & Purchase Value : ");
        try {
            for (int i = 0; i < n; i++) {
                c[i] = new Customers();
                c[i].setCustomersID(Integer.parseInt(sc.next()));
                c[i].setName(sc.nextLine());
                c[i].setAddress(sc.nextLine());
                c[i].setPurchaseValue(Integer.parseInt(sc.next()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(c[i].toString());
        }
    }
}


