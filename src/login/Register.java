package login;

import java.io.Serializable;

public class Register implements Serializable {
    private String name, password;

    public Register(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Register() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "register{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}