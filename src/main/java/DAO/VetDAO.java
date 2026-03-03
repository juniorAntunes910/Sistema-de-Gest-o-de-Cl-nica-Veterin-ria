package DAO;

import Entities.Vet;
import org.example.Conexao.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VetDAO {
    public void insertVet(Vet vet){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO veterinario
                    (
                    nome,
                    crmv,
                    especialidade
                    )
                    VALUES
                    (?,?,?)
                    """);
            stmt.setString(1, vet.getName());
            stmt.setString(2, vet.getCrmv());
            stmt.setString(3, vet.getSpecialty());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Vet> selectVet(){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT 
                    id,
                    nome,
                    crmv,
                    especialidade
                    from veterinario
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Vet> listVet = new ArrayList<>();
            while(rs.next()){
                listVet.add(
                        new Vet(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("crmv"),
                                rs.getString("especialidade")
                        )
                );
            }
            return listVet;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
