package DAO;

import Entities.Client;
import org.example.Conexao.Conect;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAO {
    public void insertClient(Client client){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    INSERT INTO cliente 
                    (id,
                    nome,
                    cpf,
                    telefone,
                    cidade,
                    estado)
                    VALUES
                    (?,?,?,?,?,?)
                    """);
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getName());
            stmt.setString(3, client.getCpf());
            stmt.setString(4, client.getTelephone());
            stmt.setString(5, client.getCity());
            stmt.setString(6, client.getState());
            stmt.executeUpdate();
            System.out.println("Client added to system!");
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Client> selectAllClients(){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT 
                    id,
                    nome,
                    cpf,
                    telefone,
                    cidade,
                    estado 
                    from cliente;
                    """);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Client> listClient = new ArrayList<>();
            while (rs.next()){
                listClient.add(
                        new Client(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("cidade"),
                        rs.getString("estado")
                )
                );
            }
            return listClient;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
