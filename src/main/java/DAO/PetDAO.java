package DAO;

import Entities.Pet;
import org.example.Conexao.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetDAO {
    public void insertPet(Pet pet){
        try(Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO pet
                    (
                    cliente_id,
                    nome,
                    especie,
                    raca,
                    data_nascimento
                    )
                    VALUES
                    (?,?,?,?,?)
                    """);
            stmt.setInt(1, pet.getClient_id());
            stmt.setString(2, pet.getName());
            stmt.setString(3, pet.getSpecie());
            stmt.setString(4, pet.getRace());
            stmt.setDate(5, java.sql.Date.valueOf(pet.getDateOfBirth()));
            stmt.executeUpdate();
            System.out.println("Pet added to system!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Pet> selectPet(){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT 
                    
                    id,
                    cliente_id,
                    nome,
                    especie,
                    raca,
                    data_nascimento
                    
                    FROM pet
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Pet> listPet = new ArrayList<>();
            while (rs.next()) {
                listPet.add(
                        new Pet(
                                rs.getInt("id"),
                                rs.getInt("cliente_id"),
                                rs.getString("nome"),
                                rs.getString("especie"),
                                rs.getString("raca"),
                                rs.getDate("data_nascimento").toLocalDate()
                        )
                );
            }
            return listPet;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
