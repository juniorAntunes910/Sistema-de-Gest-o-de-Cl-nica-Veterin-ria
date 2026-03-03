package DAO;

import Entities.MedicalRecord;
import org.example.Conexao.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalRecodDAO {
    public void insertMedicalRecord(MedicalRecord medicalRecord){
        try(Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO prontuario
                    (consulta_id, descricao, prescricao, data_registro)
                    VALUES
                    (?,?,?,?)
                    """);
            stmt.setInt(1, medicalRecord.getConsultation_id());
            stmt.setString(2, medicalRecord.getDescription());
            stmt.setString(3, medicalRecord.getPreDescription());
            stmt.setDate(4, java.sql.Date.valueOf(medicalRecord.getData_registro()));
            stmt.executeUpdate();
            System.out.println("Medical Record added to system!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
