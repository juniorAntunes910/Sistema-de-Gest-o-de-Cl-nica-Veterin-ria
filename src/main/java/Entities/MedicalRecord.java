package Entities;

import java.time.LocalDate;

public class MedicalRecord {
    private int id;
    private int consultation_id;
    private String description;
    private String preDescription;
    private LocalDate data_registro;

    public MedicalRecord(int id, int consultation_id, String description, String preDescription, LocalDate data_registro) {
        this.id = id;
        this.consultation_id = consultation_id;
        this.description = description;
        this.preDescription = preDescription;
        this.data_registro = data_registro;
    }

    public MedicalRecord(int consultation_id, String description, String preDescription, LocalDate data_registro) {
        this.consultation_id = consultation_id;
        this.description = description;
        this.preDescription = preDescription;
        this.data_registro = data_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(int consultation_id) {
        this.consultation_id = consultation_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreDescription() {
        return preDescription;
    }

    public void setPreDescription(String preDescription) {
        this.preDescription = preDescription;
    }

    public LocalDate getData_registro() {
        return data_registro;
    }

    public void setData_registro(LocalDate data_registro) {
        this.data_registro = data_registro;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", consultation_id=" + consultation_id +
                ", description='" + description + '\'' +
                ", preDescription='" + preDescription + '\'' +
                ", data_registro=" + data_registro +
                '}';
    }
}
