package productManage;

import java.io.Serializable;

public class Product implements Serializable {
    public static int ID = 0;
    private int id;
    private String name;
    private String price;
    private int amount;
    private String size;
    private Brand brand;

    public Product(int id, String name, String price, int amount, String size, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
        this.brand = brand;
    }

    public Product(String name, String price, int amount, String size, Brand brand) {
        try {
            ID = ProductManage.arrayListProduct.get(ProductManage.arrayListProduct.size() - 1).getId();
        } catch (Exception e) {
            ID = 0;
        }
        this.id = ++ID;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
        this.brand = brand;
    }

    public Product() {

    }

    public Product(String brand, Product product) {
    }



    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Product.ID = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "productManage.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", size='" + size + '\'' +
                ", brand=" + brand +
                '}';
    }
}
