package Entities;

public class Vet {
    private int id;
    private String name;
    private String crmv;
    private String specialty;

    public Vet(int id, String name, String crmv, String specialty) {
        this.id = id;
        this.name = name;
        this.crmv = crmv;
        this.specialty = specialty;
    }

    public Vet(String name, String crmv, String specialty) {
        this.name = name;
        this.crmv = crmv;
        this.specialty = specialty;
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }



    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", crmv='" + crmv + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
