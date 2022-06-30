package login;

import menu.MenuAdmin;
import menu.MenuCustomer;
import menu.MenuLogin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManage implements Serializable {
    public static ArrayList<Register> arrayListRegister = new ArrayList<>();

    public Register creatAccount(Scanner scanner) {
        System.out.println("1. Nhập tài khoản mới: ");
        String name = scanner.next();
        System.out.println("2. Nhập mật khẩu mới: ");
        String password = scanner.next();
        return new Register(name, password);
    }

    public void addAccount(Scanner scanner) {
        Register register = creatAccount(scanner);
        arrayListRegister.add(register);
        writeDocuments(arrayListRegister);
    }

    public void inputAccount(Scanner scanner) {
        System.out.println("Nhập vào tài khoản: ");
        String name = scanner.next();
        System.out.println("Nhập vào mật khẩu: ");
        String password = scanner.next();
        Login login = new Login(name, password);
        if (checkAdmin(login)) {
            MenuAdmin.Menu();
        } else {
            checkAccount(login);
        }

    }

    public boolean checkAdmin(Login login) {

        if (login.getName().equals("admin") && login.getPassword().equals("admin")) {
            return true;
        } else {
            return false;
        }

    }

    public void checkAccount(Login login) {
        boolean check = false;
        for (Register register : arrayListRegister) {
            if (login.getName().equals(register.getName()) && login.getPassword().equals(register.getPassword())) {
                check = true;
                MenuCustomer.Menu();
            }
        }
        if (!check) {
            System.out.println("Sai mật khẩu hoặc tên đăng nhập khách ơi.");
            MenuLogin.LoginMenu();
        }
    }

    public static void writeDocuments(ArrayList<Register> arrayListRegister) {
        File file = new File("Account.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(arrayListRegister);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("File đã tồn tại");
        }
    }

    public static void readDocuments() {
        File file = new File("Account.txt");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            arrayListRegister = (ArrayList<Register>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            System.out.println("File đã tồn tại");
        }
    }

    public static void deleteAccount(Scanner scanner) {
        String name = "";
        System.out.println("Nhập tên đăng nhập muốn xóa: ");
        name = scanner.nextLine();
        for (int i = 0; i < arrayListRegister.size(); i++) {
            if (arrayListRegister.get(i).getName().equals(name)) {
                arrayListRegister.remove(i);
                writeDocuments(arrayListRegister);
            }
        }
    }

    public static void displayAccount() {
        for (Register a : arrayListRegister) {
            System.out.println("Tên đăng nhập: " + a.getName());
        }
    }
}
