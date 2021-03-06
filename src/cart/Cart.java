package cart;

import login.Account;
import productManage.Brand;
import productManage.Product;

public class Cart extends Product {
    public static int ID = 1;
    private int id;
    private Account account;
    private int count;
    private Product product;
    private int totalPrice;

    public Cart() {

    }

    public Cart(int count, Product product, int totalPrice) {
        this.id = ID++;
        this.count = count;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Cart.ID = ID;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Giỏ hàng có gì nhỉ: " +
                "id=" + id +
                ", count=" + count + ", "+
                 product +
                "} ";
    }
}
