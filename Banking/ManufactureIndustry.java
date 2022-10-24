import java.util.*;

class Products {
    private String productID;
    private String description;
    private String productName;
    private int pricePerUnit;
    private String supplierID;

    public Products(String productID, String description, String productName, int pricePerUnit, String supplierID) {
        this.productID = productID;
        this.description = description;
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
        this.supplierID = supplierID;
    }
    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getPricePerUnit() {
        return pricePerUnit;
    }
    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
    public String getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
}

class PriceComparator implements Comparator<Products>{
    public int compare(Products s1,Products s2){
        if(s1.getPricePerUnit()==s2.getPricePerUnit())
            return 0;
        else if(s1.getPricePerUnit()>s2.getPricePerUnit())
            return 1;
        else
            return -1;
    }
}

public class ManufactureIndustry {

    public static void main(String[] args) {

        ArrayList<Products> products = new ArrayList<Products>();
        products.add(new Products("1", "Bunch Of Pencils", "Pencil", 10, "A"));
        products.add(new Products("2", "School Bags", "Bags", 500, "B"));
        products.add(new Products("3", "Carton Of Mangoes", "Mangoes", 60, "C"));
        products.add(new Products("4", "Carton Of Apples", "Apples", 40, "D"));
        products.add(new Products("5", "Box of Chocolates", "Chocolates", 75, "E"));

        Collections.sort(products,new PriceComparator());
        for(Products p: products){
            System.out.println(p.getProductID() + " : " + p.getProductName() + " : " + p.getPricePerUnit());
        }

    }

}
