package cart;

import login.Account;
import login.LoginManage;
import productManage.Product;
import productManage.ProductManage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static productManage.ProductManage.arrayListProduct;

public class CartManage {
    Scanner scanner = new Scanner(System.in);
    public static ArrayList<Cart> arrayListCart = new ArrayList<>();
    public CartManage() {
    }

    public Cart createCart() {
        System.out.println("Nhập mã sản phẩm muốn mua đi homieee: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = getProductByID(id);
        System.out.println("Nhập số lượng cần mua");
        int amount = Integer.parseInt(scanner.nextLine());
        int totalPrice = amount * product.getPrice();
        return new Cart(amount, product, totalPrice);
    }

    public Product getProductByID(int id) {
        for (Product product : arrayListProduct) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public void addCart() {

        Cart cart = createCart();
        arrayListCart.add(cart);
        writeDocuments(arrayListCart);
    }

    public void displayCart() {
        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Mã Số", "Hãng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Kích Cỡ");
        for (int i = 0; i < arrayListCart.size(); i++) {
            System.out.println();
            System.out.printf("%-16s%-16s%-27s%-17s%-21s%s\n", arrayListCart.get(i).getProduct().getId(),
                    arrayListCart.get(i).getProduct().getBrand().getName(), arrayListCart.get(i).getProduct().getName(),
                    arrayListCart.get(i).getProduct().getPrice(), arrayListCart.get(i).getCount(), arrayListCart.get(i).getProduct().getSize());
            System.out.println();
        }
    }
        public void writeDocuments(ArrayList<Cart> arrayListCart) {
        File file = new File("Cart.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(arrayListCart);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(".");
        }
    }

    public static void readDocuments() {
        File file = new File("Cart.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            arrayListCart = (ArrayList<Cart>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println(".");
        }
    }
    public void deleteProductInCart() {
        System.out.print("Nhập vào mã sản phẩm cần xóa đi homieee: ");
        int id;
        id = scanner.nextInt();
        for (int i = 0; i < arrayListCart.size(); i++) {
            if (id==arrayListCart.get(i).getId()){
                arrayListCart.remove(i);
            }
        }
    }
}




//


//    public void pickProduct(Scanner scanner) {
//        System.out.println("Nhập mã sản phẩm muốn mua đi homieee: ");
//        int id = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < arrayListCart.size(); i++) {
//            if (arrayListProduct.get(i).getId() == (id)) {
//                arrayListCart.add(arrayListProduct.get(i));
//                choseAmount(scanner,id);
//            }
//        }
//    }
//
//    public void choseAmount(Scanner scanner,int id) {
//        System.out.println("Nhập số lượng bạn cần mua ạ: ");
//        int amountBuy = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < arrayListCart.size(); i++) {
//            if (arrayListCart.get(i).getId() == (id)) {
//                arrayListCart.get(i).setAmount(amountBuy);
//            }
//        }
//    }
//
//    public void displayCart(Scanner sc) {
//        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Mã Số", "Hãng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Kích Cỡ");
//        for (int i = 0; i < arrayListCart.size(); i++) {
//            System.out.println();
//            System.out.printf("%-16s%-16s%-27s%-17s%-21s%s\n", arrayListCart.get(i).getId(), arrayListCart.get(i).getBrand().getName(), arrayListCart.get(i).getName(), arrayListCart.get(i).getPrice(), arrayListCart.get(i).getAmount(), arrayListCart.get(i).getSize());
//            System.out.println();
//        }

