package information;

public class InformationCustomer {
    private String name;
    private String address;
    private int telephone;


    public InformationCustomer(String name, String address, int telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "InformationCustomer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
