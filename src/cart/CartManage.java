package cart;

import productManage.Product;
import productManage.ProductManage;

import java.util.ArrayList;
import java.util.Scanner;

import static productManage.ProductManage.arrayListProduct;
public class CartManage {
    Scanner scanner = new Scanner(System.in);
    ProductManage productManage = new ProductManage();
    public static ArrayList<Cart> arrayListCart = new ArrayList<>();

    public CartManage() {
    }

    public Cart createCart() {
        System.out.print("Nhập mã sản phẩm muốn mua đi homieee: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = getProductByID(id);
        System.out.print("Nhập số lượng cần mua: ");
        int newAmount = Integer.parseInt(scanner.nextLine());
        for (Product a : arrayListProduct) {
            if (newAmount > a.getAmount()) {
                System.out.println("Trong kho tui còn có " + a.getAmount() + " mà bạn chọn " + newAmount + " thì sao đủ đáp ứng ạ!!!");
                System.out.println();
            }
        }
        int totalPrice = newAmount * product.getPrice();
        return new Cart(newAmount, product, totalPrice);
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
//        writeDocuments(arrayListCart);
    }

    public void displayCart() {

        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Mã Số", "Hãng", "Tên Sản Phẩm", "Giá", "Số Lượng", "Kích Cỡ");
        for (int i = 0; i < arrayListCart.size(); i++) {
            System.out.println();
            System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", arrayListCart.get(i).getProduct().getId(),
                    arrayListCart.get(i).getProduct().getBrand().getName(), arrayListCart.get(i).getProduct().getName(), "$",
                    arrayListCart.get(i).getProduct().getPrice(), arrayListCart.get(i).getCount(), arrayListCart.get(i).getProduct().getSize());
            System.out.println();
        }

    }

    public void pay() {
        int sum = 0;
        for (Cart a : arrayListCart) {
            sum += a.getTotalPrice();
        }
        System.out.println("❤❤❤❤ Thanh toán thành công ❤❤❤❤");
        System.out.printf("%s%s%s", "Tổng tiền của quý khách là: ", "$", sum + "\n");
        productManage.updateAmount();
        arrayListCart.clear();
    }

    //    public void writeDocuments(ArrayList<Cart> arrayListCart) {
//        File file = new File("Cart.txt");
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//            objectOutputStream.writeObject(arrayListCart);
//            objectOutputStream.close();
//        } catch (Exception e) {
//            System.out.println(".");
//        }
//    }
//
//    public static void readDocuments() {
//        File file = new File("Cart.txt");
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
//            arrayListCart = (ArrayList<Cart>) objectInputStream.readObject();
//            objectInputStream.close();
//        } catch (Exception e) {
//            System.out.println(".");
//        }
//    }
//
    public void deleteProductInCart() {
        System.out.print("Nhập vào mã sản phẩm cần xóa đi homieee: ");
        int id;
        id = scanner.nextInt();
        for (int i = 0; i < arrayListCart.size(); i++) {
            if (id == arrayListCart.get(i).getId()) {
                arrayListCart.remove(i);
            }
        }
//        writeDocuments(arrayListCart);
    }
}

