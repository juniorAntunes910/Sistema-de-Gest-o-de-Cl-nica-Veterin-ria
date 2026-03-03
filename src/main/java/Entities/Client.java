package Entities;

public class Client {
    private int id;
    private String name;
    private String cpf;
    private String telephone;
    private String city;
    private String state;

    public Client(int id, String name, String cpf, String telephone, String city, String state) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.city = city;
        this.state = state;
    }

    public Client(String name, String cpf, String telephone, String city, String state) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
        this.city = city;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telephone='" + telephone + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
