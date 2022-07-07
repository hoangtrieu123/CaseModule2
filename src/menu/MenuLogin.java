package menu;

import login.LoginManage;

import java.util.Scanner;

public class MenuLogin {

    public static void LoginMenu() {
        LoginManage loginManager = new LoginManage();
        LoginManage.readDocuments();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-❤❤❤❤Welcome to Hoàng Triều Store❤❤❤❤-");
        System.out.println("|                                          |");
        System.out.println("|   Địa chỉ: Lương Khánh Thiện - Hà Nội    |");
        System.out.println("|   Số điện thoại: 0912081098              |");
        System.out.println("|                                          |");
        System.out.println("--------------------------------------------");
        int choice;
        do {
            System.out.println("1. Đăng ký tài khoản");
            System.out.println("2. Đăng nhập");

            System.out.print("Chọn đi khách iu <3: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    loginManager.addAccount();
                    break;
                case 2:
                    loginManager.login(scanner);
                    break;
            }
        } while (choice != 0);
    }
}
