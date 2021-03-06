package menu;

import cart.CartManage;
import login.LoginManage;
import productManage.ProductManage;

import java.io.Serializable;
import java.util.Scanner;

public class MenuAdmin implements Serializable {
    public static void Menu() {
        ProductManage productManage = new ProductManage();
        CartManage cartManage = new CartManage();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
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
            System.out.println("6. Tìm sản phẩm theo tên hãng");
            System.out.println("7. Hiển thị toàn bộ sản phẩm của shop");
            System.out.println("8. Hiển thị các tài khoản đã đăng ký");
            System.out.println("9. Xóa tài khoản khách");
            System.out.println("10. Feedback của khách");
            System.out.println("0. Đăng xuất");
            System.out.print("Nhập lựa chọn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng!");
            }

            switch (choice) {
                case 1:
                    productManage.addProduct(scanner);
                    break;
                case 2:
                    System.out.print("Nhập vào id sản phẩm cần sửa: ");
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
                    productManage.searchByBrand(scanner);
                    break;
                case 7:
                    productManage.displayProduct();
                    productManage.updateAmount();
                    break;
                case 8:
                    LoginManage.displayInformationCustomer();
                    break;
                case 9:
                    LoginManage.deleteAccount(scanner);
                    break;
                case 10:
                    cartManage.displayFeedback();
                    break;
                case 0:
                    MenuLogin.LoginMenu();
                    break;
            }
        } while (choice != 0);
    }
}
