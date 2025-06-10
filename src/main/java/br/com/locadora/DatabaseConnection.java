package br.com.locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // IMPORTANTE: Altere a URL, usuário e senha conforme a sua configuração do MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/locadora";
    private static final String USER = "root";
    private static final String PASSWORD = "@sua senha do MySQL"; // <-- COLOQUE SUA SENHA AQUI

    public static Connection connect() {
        try {
            // Esta linha não é mais necessária nas versões recentes do JDBC
            // Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("### ERRO DE CONEXÃO COM O BANCO ###");
            System.out.println("Mensagem: " + e.getMessage());
            e.printStackTrace(); // Isso ajuda a ver mais detalhes do erro
            return null;
        }
    }
}
