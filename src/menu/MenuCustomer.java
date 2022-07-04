package menu;

import productManage.ProductManage;

import java.util.Scanner;

public class MenuCustomer {
    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        ProductManage.readDocuments();
        int choice;
        do {
            System.out.println("----Welcome to Hoàng Triều Store----");
            System.out.println("1. Giới thiệu về shop");
            System.out.println("2. Các sản phẩm của shop");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Shop Thời Trang Hoàng Triều Store với phương châm" + "\n" +
                        "\"Đồng hành cùng phong cách thời trang của bạn\" " +
                        "sẽ là nơi mua sắm an toàn và uy tín. " + "\n" +
                        "Bởi chúng tôi luôn đề cao tiêu chí mang đến cho quý khách những sản phẩm chất lượng nhất với giá cả luôn phải chăng. ");
                    break;
                case 2:
                    ProductManage.displayProduct();
            }
        } while (choice != 0);


    }
}
