package login;

import information.InformationCustomer;

import java.io.Serializable;

public class Account implements Serializable {
    private String userName, password;
    private InformationCustomer informationCustomer;

    public Account() {
    }


    public Account(String userName, String password, InformationCustomer informationCustomer) {
        this.userName = userName;
        this.password = password;
        this.informationCustomer = informationCustomer;
    }

    public Account(InformationCustomer informationCustomer) {
        this.informationCustomer = informationCustomer;
    }

    public Account(String name, String password) {
        this.userName = name;
        this.password = password;
    }


    public Account(String username, String password, String nameCustomer, String address, int telephone) {
    }

    public Account(String nameCustomer, String address, int telephone) {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InformationCustomer getInformationCustomer() {
        return informationCustomer;
    }

    public void setInformationCustomer(InformationCustomer informationCustomer) {
        this.informationCustomer = informationCustomer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", informationCustomer=" + informationCustomer +
                '}';
    }
}
