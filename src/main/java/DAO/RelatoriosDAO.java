package DAO;
import DTO.TotalVendas;
import org.example.Conexao.Conect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelatoriosDAO {
    public TotalVendas somarVendas(){
        try (Connection conn = Conect.Conectar()){
            PreparedStatement stmt = conn.prepareStatement("""
                    SELECT
                        v.nome,
                        COUNT(c.id) AS totalConsultas,
                        SUM(c.valor) AS totalFaturado
                        FROM consulta c
                        JOIN veterinario v ON c.veterinario_id = v.id
                        WHERE c.status = 'FINISHED'
                        GROUP BY v.nome;       
                                  """);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new TotalVendas(
                        rs.getString("nome"),
                        rs.getInt("totalConsultas"),
                        rs.getDouble("totalFaturado")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
