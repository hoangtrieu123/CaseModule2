package login;

import information.InformationCustomer;
import menu.MenuAdmin;
import menu.MenuCustomer;
import menu.MenuLogin;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class LoginManage {
    public static ArrayList<Account> arrayListAccounts = new ArrayList<>();

    public Account creatAccount(Scanner scanner) {
        String Username;
        do {
            System.out.println("1. Nhập tài khoản mới: ");
            Username = scanner.nextLine();
        }
        while (!checkAccount(Username));
        System.out.println("2. Nhập mật khẩu mới: ");
        String password = scanner.nextLine();
        System.out.println("Cho mình xin tên bạn ạ: ");
        String nameCustomer = scanner.nextLine();
        System.out.println("Cho mình xin địa chỉ ạ: ");
        String address = scanner.nextLine();
        System.out.println("Cho mình xin số điện thoại ạ: ");
        String telephone = scanner.nextLine();
        InformationCustomer information = new InformationCustomer(nameCustomer, address, telephone);
        return new Account(Username, password, information);
    }

    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = creatAccount(scanner);
        arrayListAccounts.add(account);
        writeDocuments(arrayListAccounts);
    }

    public boolean checkAccount(String name) {
        String admin = "admin";
        if (name.equals(admin)) {
            System.out.println("Trùng với tài khoản admin rồi bạn ơi!");
            return false;
        }
        for (Account account : arrayListAccounts) {
            if (account.getName().equals(name)) {
                System.out.println("Tài Khoản Đã Tồn Tại");
                return false;
            }
        }
        return true;
    }


    public void login(Scanner scanner) {
        int count=0;
        do {
            System.out.println("Nhập vào tài khoản: ");
            String name = scanner.next();
            System.out.println("Nhập vào mật khẩu: ");
            String password = scanner.next();
            Account account = new Account(name, password);
            if (checkAdmin(account)) {
                MenuAdmin.Menu();
            } else {
                checkAccount(account);
            }
            count ++;
        }
        while (count<3);
            System.out.println("Liên Hệ Admin");
            MenuLogin.LoginMenu();
    }

    public boolean checkAdmin(Account account) {

        if (account.getName().equals("admin") && account.getPassword().equals("admin")) {
            return true;
        } else {
            return false;
        }

    }


    public static void checkAccount(Account account) {
        boolean check = false;
        for (Account a : arrayListAccounts) {
            if (a.getName().equals(account.getName()) && a.getPassword().equals(account.getPassword())) {
                check = true;
                System.out.println("đăng nhập thành công");
                MenuCustomer.Menu();
            }
        }
        if (!check) {
            System.out.println("Sai mật khẩu hoặc tên đăng nhập khách ơi.");
        }
    }

    public static void displayInformationCustomer() {
        System.out.printf("%-3s%25s%20s%30s", "Tên đăng nhập", "Tên khách hàng", "Địa chỉ", "Số điện thoại");
        System.out.println();
        for (int i = 0; i < arrayListAccounts.size(); i++) {
            System.out.println();
            System.out.printf("%-22s%-25s%-30s%s", arrayListAccounts.get(i).getName(), arrayListAccounts.get(i).getInformationCustomer().getNameCustomer(), arrayListAccounts.get(i).getInformationCustomer().getAddress(), arrayListAccounts.get(i).getInformationCustomer().getTelephone());
            System.out.println();
        }
    }

    public static void deleteAccount(Scanner scanner) {
        System.out.println("Tên tài khoản muốn xóa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < arrayListAccounts.size(); i++) {
            if (arrayListAccounts.get(i).getName().equals(name)) {
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
