package Entities;

import java.time.LocalDate;

public class Pet {
    private int id;
    private int client_id;
    private String name;
    private String specie;
    private String race;
    private LocalDate dateOfBirth;

    public Pet(int id, int client_id, String name, String specie, String race, LocalDate dateOfBirth) {
        this.id = id;
        this.client_id = client_id;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.dateOfBirth = dateOfBirth;
    }

    public Pet(int client_id, String name, String specie, String race, LocalDate dateOfBirth) {
        this.client_id = client_id;
        this.name = name;
        this.specie = specie;
        this.race = race;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                ", race='" + race + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
