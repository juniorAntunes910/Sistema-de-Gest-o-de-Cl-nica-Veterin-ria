package DAO;

import Entities.Consultation;
import org.example.Conexao.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultationDAO {
    public void insertConsultation(Consultation consultation){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO consulta
                    (
                    pet_id,
                    veterinario_id,
                    data_consulta,
                    valor,
                    status
                    )
                    VALUES
                    (?,?,?,?,?)
                    """);
            stmt.setInt(1, consultation.getPet_id());
            stmt.setInt(2, consultation.getVet_id());
            stmt.setDate(3, java.sql.Date.valueOf(consultation.getDayOfConsultation()));
            stmt.setDouble(4, consultation.getValue());
            stmt.setString(5, consultation.getStatus());
            stmt.executeUpdate();
            System.out.println("Consultation Added to system!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Consultation> selectConsultation(){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT
                    id,
                    pet_id,
                    veterinario_id,
                    data_consulta,
                    valor,
                    status
                    from consulta
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Consultation> listConsultation = new ArrayList<>();
            while (rs.next()){
                listConsultation.add(
                        new Consultation(
                                rs.getInt("id"),
                                rs.getInt("pet_id"),
                                rs.getInt("veterinario_id"),
                                rs.getDate("data_consulta").toLocalDate(),
                                rs.getDouble("valor"),
                                rs.getString("status")
                        )
                );
            }
            return listConsultation;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
