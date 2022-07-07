package login;

import information.InformationCustomer;
import menu.MenuAdmin;
import menu.MenuCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginManage {
    public static ArrayList<Account> arrayListAccounts = new ArrayList<>();

    public Account creatAccount(Scanner scanner) {
        String name;
        do {
            System.out.print("1. Nhập tài khoản mới: ");
            name = scanner.nextLine();
            while (true) {
                Pattern p = Pattern.compile("^[a-z0-9._-]{2,15}$");
                if (p.matcher(name).find()) {
                    break;
                } else {
                    System.out.println("Tên đăng nhập phải từ 2-15 ký tự bạn nhé ");
                    System.out.print("1. Nhập tài khoản mới: ");
                    name = scanner.nextLine();
                }
            }
        }
        while (!checkSameAccount(name));
        System.out.print("2. Nhập mật khẩu mới: ");
        String password = scanner.nextLine();
        System.out.print("Cho mình xin tên bạn ạ: ");
        String nameCustomer = scanner.nextLine();
        System.out.print("Cho mình xin địa chỉ ạ: ");
        String address = scanner.nextLine();
        System.out.print("Cho mình xin số điện thoại ạ: ");
        String telephone = scanner.nextLine();
        while (true) {
            Pattern p = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
            if (p.matcher(telephone).find()) {
                break;
            } else {
                System.out.println("Nhập đúng định dạng số diện thoại giúp mình nhé");
                System.out.println("Nhập lại đi ạ");
                telephone = scanner.nextLine();
            }
        }
        InformationCustomer information = new InformationCustomer(nameCustomer, address, telephone);
        return new Account(name, password, information);
    }

//    public String decor() {
//        String b = null;
//        for (Account a : arrayListAccounts) {
//            if (a.getname().equals())
//                b = a.getname();
//        }
//        return b;
//    }

    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = creatAccount(scanner);
        arrayListAccounts.add(account);
        writeDocuments(arrayListAccounts);
    }

    public boolean checkSameAccount(String userName) {
        String admin = "admin";
        String none = "";
        String name = "an";
        if (userName.equals(name)) {
            System.err.println("Chúng tôi không hỗ trợ tên này!!!!");
            return false;
        }
        if (userName.equals(none)) {
            System.out.println("Không được để trống tên.");
            return false;
        }
        if (userName.equals(admin)) {
            System.out.println("Trùng với tài khoản admin rồi bạn ơi!");
            return false;
        }
        for (Account account : arrayListAccounts) {
            if (account.getname().equals(userName)) {
                System.out.println("Tài Khoản Đã Tồn Tại");
                return false;
            }
        }
        return true;
    }


    public void login(Scanner scanner) {
        int count = 0;
        do {
            System.out.print("Nhập vào tài khoản: ");
            String Username = scanner.nextLine();
            System.out.print("Nhập vào mật khẩu: ");
            String password = scanner.nextLine();
            if (checkAdmin(Username, password)) {
                MenuAdmin.Menu();
            } else {
                checkAccount(Username, password);
            }
            count++;
        }
        while (count < 3);
        System.err.println("QUÊN MẬT KHẨU HAY SAO MÀ NHẬP SAI NHIỀU VẬY -_-");
        System.err.println("     CHẠY LẠI CHƯƠNG TRÌNH ĐI NHÉ >.<");
        System.exit(0);
    }

    public boolean checkAdmin(String account, String password) {

        if (account.equals("admin") && password.equals("admin")) {
            return true;
        } else {
            return false;
        }

    }


    public static void checkAccount(String userName, String password) {
        boolean check = false;
        for (Account a : arrayListAccounts) {
            if (a.getname().equals(userName) && a.getPassword().equals(password)) {
                check = true;
                System.out.println("đăng nhập thành công");
                MenuCustomer menuCustomer = new MenuCustomer();
                menuCustomer.Menu();
            }
        }
        if (!check) {
            System.err.println("****  Sai mật khẩu hoặc tên đăng nhập khách ơi  ****");
        }
    }

    public static void displayInformationCustomer() {
        System.out.printf("%-3s%25s%20s%30s", "Tên đăng nhập", "Tên khách hàng", "Địa chỉ", "Số điện thoại");
        System.out.println();
        for (int i = 0; i < arrayListAccounts.size(); i++) {
            System.out.println();
            System.out.printf("%-22s%-25s%-30s%s", arrayListAccounts.get(i).getname(), arrayListAccounts.get(i).getInformationCustomer().getNameCustomer(), arrayListAccounts.get(i).getInformationCustomer().getAddress(), arrayListAccounts.get(i).getInformationCustomer().getTelephone());
            System.out.println();
        }
    }

    public static void deleteAccount(Scanner scanner) {
        System.out.println("Tên tài khoản muốn xóa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < arrayListAccounts.size(); i++) {
            if (arrayListAccounts.get(i).getname().equals(name)) {
                arrayListAccounts.remove(i);
            }
        }
        writeDocuments(arrayListAccounts);
    }

    public static void writeDocuments(ArrayList<Account> arrayListAccounts) {
        File file = new File("Account.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(arrayListAccounts);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("File đã tồn tại");
        }
    }

    public static void readDocuments() {
        File file = new File("Account.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            arrayListAccounts = (ArrayList<Account>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("File đã tồn tại");
        }
    }
}
