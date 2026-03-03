package org.example.Conexao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    private static final String URL = "jdbc:mysql://localhost:3308/vetLog?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

public static Connection Conectar() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
}

}
