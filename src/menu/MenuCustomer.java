package menu;

import cart.CartManage;
import login.LoginManage;
import productManage.ProductManage;

import java.util.Scanner;

public class MenuCustomer {
    public static void Menu() {
        ProductManage productManage = new ProductManage();
        Scanner scanner = new Scanner(System.in);
        CartManage cartManage = new CartManage();
        LoginManage loginmanage = new LoginManage();
//        CartManage.readDocuments();
        int choice;
        do {
            System.out.println("----Welcome to Hoàng Triều Store----");
            System.out.println("1. Giới thiệu về shop");
            System.out.println("2. Các sản phẩm của shop");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("4. Mua sắm thôi nào. Gét gô!!!!");
            System.out.println("5. Hiển thị giỏ hàng");
            System.out.println("6. Xóa sản phẩm bạn iu chọn nhầm nhé");
            System.out.println("7. Thanh toán");
            System.out.println("8. Có góp ý gì thì để tại đây nhé bạn❤");
            System.out.println("0. Đăng xuất");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Shop Thời Trang Hoàng Triều Store với phương châm" + "\n" +
                            "\"Đồng hành cùng phong cách thời trang của bạn\" " +
                            "sẽ là nơi mua sắm an toàn và uy tín. " + "\n" +
                            "Bởi chúng tôi luôn đề cao tiêu chí mang đến cho quý khách những sản phẩm chất lượng nhất với giá cả luôn phải chăng. ");
                    break;
                case 2:
                    productManage.displayProduct();
                    break;
                case 3:
                    productManage.searchByName(scanner);
                    break;
                case 4:
                    cartManage.addCart();
                    break;
                case 5:
                    cartManage.displayCart();
                    break;
                case 6:
                    cartManage.deleteProductInCart();
                    break;
                case 7:
                    cartManage.pay();
                    break;
                case 8:
                    cartManage.feedback(scanner);
                    break;
                case 0:
                    MenuLogin.LoginMenu();
                    break;
            }
        } while (choice != 0);


    }
}
