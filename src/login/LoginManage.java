package login;

import menu.MenuAdmin;
import menu.MenuCustomer;
import menu.MenuLogin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class LoginManage {
    public static ArrayList<Account> arrayListAccounts = new ArrayList<>();
    public Account creatAccount(Scanner scanner) {
        String name;
        do {
            System.out.println("1. Nhập tài khoản mới: ");
            name = scanner.next();
        }
        while(!checkAccount(name));
        System.out.println("2. Nhập mật khẩu mới: ");
        String password = scanner.next();
        return new Account(name, password);
    }
    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = creatAccount(scanner);
        arrayListAccounts.add(account);
        writeDocuments(arrayListAccounts);
    }
    public boolean checkAccount(String name) {
        for (Account account :arrayListAccounts) {
            if(account.getName().equals(name)){
                System.out.println("Tài Khoản Đã Tồn Tại");
                return false;
            }
        }
        return true;
    }

    public void login(Scanner scanner){
        System.out.println("Nhập vào tài khoản: ");
        String name = scanner.next();
        System.out.println("Nhập vào mật khẩu: ");
        String password = scanner.next();
        Account account = new Account(name,password);
        if (checkAdmin(account)) {
            MenuAdmin.Menu();
        } else {
            checkAccount(account);
        }

    }

    public boolean checkAdmin(Account account) {

        if (account.getName().equals("admin") && account.getPassword().equals("admin")) {
            return true;
        } else {
            return false;
        }

    }

    public void checkAccount(Account account) {
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
            MenuLogin.LoginMenu();
        }
    }
    public static void displayAccount(){
        for (Account a: arrayListAccounts) {
            System.out.println("User Name: " + a.getName());
        }
    }
    public static void deleteAccount(Scanner scanner){
        System.out.println("Tên tài khoản muốn xóa: ");
        String name = scanner.nextLine();
        for (Account a: arrayListAccounts) {
            if (a.getName().equals(name));
        }
    }
    public void writeDocuments(ArrayList<Account> arrayListAccounts) {
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
