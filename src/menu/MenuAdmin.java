package menu;

import login.LoginManage;
import productManage.ProductManage;

import java.io.Serializable;
import java.util.Scanner;

public class MenuAdmin implements Serializable {
    public static void Menu() {
        ProductManage productManage = new ProductManage();
        Scanner scanner = new Scanner(System.in);
        productManage.readDocuments();
        int choice;
        do {
            System.out.println("--------Welcome to Hoàng Triều Store--------");
            System.out.println("|                                          |");
            System.out.println("|   Địa chỉ: Lương Khánh Thiện - Hà Nội    |");
            System.out.println("|   Số điện thoại: 0912081098              |");
            System.out.println("|                                          |");
            System.out.println("--------------------------------------------");
            System.out.println("----Menu Quản lý----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Tìm sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Hiển thị toàn bộ sản phẩm của shop");
            System.out.println("7. Hiển thị các tài khoản đã đăng ký");
            System.out.println("8. Xóa tài khoản khách");
            System.out.println("0. Đăng xuất");
            System.out.println("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.addProduct(scanner);
                    break;
                case 2:
                    System.out.println("Nhập vào id sản phẩm cần sửa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("1. Sửa tên hãng");
                    System.out.println("2. Sửa tên sản phẩm");
                    System.out.println("3. Sửa giá sản phẩm");
                    System.out.println("4. Sửa số lượng sản phẩm");
                    System.out.println("5. Sửa kích cỡ sản phẩm");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            productManage.editBrandName(scanner, id);
                            break;
                        case 2:
                            productManage.editProduceName(scanner, id);
                            break;
                        case 3:
                            productManage.editProducePrice(scanner, id);
                            break;
                        case 4:
                            productManage.editProduceAmount(scanner, id);
                            break;
                        case 5:
                            productManage.editProduceSize(scanner, id);
                            break;
                    }
                    break;
                case 3:
                    productManage.deleteProduct(scanner);
                    break;
                case 4:
                    productManage.searchById(scanner);
                    break;
                case 5:
                    productManage.searchByName(scanner);
                    break;
                case 6:
                    productManage.displayProduct();
                    break;
                case 7:
                    LoginManage.displayInformationCustomer();
                    break;
                case 8:
                    LoginManage.deleteAccount(scanner);
                    break;

                case 0:
                    MenuLogin.LoginMenu();
                    break;
            }
        } while (choice != 0);
    }
}
