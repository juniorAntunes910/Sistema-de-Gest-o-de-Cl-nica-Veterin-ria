package Entities;

import java.time.LocalDate;

public class Consultation {
    private int id;
    private int pet_id;
    private int vet_id;
    private LocalDate dayOfConsultation;
    private Double value;
    private String status;

    public Consultation(int id, int pet_id, int vet_id, LocalDate dayOfConsultation, Double value, String status) {
        this.id = id;
        this.pet_id = pet_id;
        this.vet_id = vet_id;
        this.dayOfConsultation = dayOfConsultation;
        this.value = value;
        this.status = status;
    }

    public Consultation(int pet_id, int vet_id, LocalDate dayOfConsultation, Double value, String status) {
        this.pet_id = pet_id;
        this.vet_id = vet_id;
        this.dayOfConsultation = dayOfConsultation;
        this.value = value;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public int getVet_id() {
        return vet_id;
    }

    public void setVet_id(int vet_id) {
        this.vet_id = vet_id;
    }

    public LocalDate getDayOfConsultation() {
        return dayOfConsultation;
    }

    public void setDayOfConsultation(LocalDate dayOfConsultation) {
        this.dayOfConsultation = dayOfConsultation;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", pet_id=" + pet_id +
                ", vet_id=" + vet_id +
                ", dayOfConsultation=" + dayOfConsultation +
                ", value=" + value +
                ", status='" + status + '\'' +
                '}';
    }
}
