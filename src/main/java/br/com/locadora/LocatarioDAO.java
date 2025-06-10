package br.com.locadora;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocatarioDAO {

    public void inserirLocatario(Locatario locatario) {
        // Usando o try-with-resources para garantir que a conexão seja fechada
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn == null) return; // Se a conexão falhar, não faz nada

            String sql = "INSERT INTO Locatarios (CPF, Nome, Endereco, Telefone, data_inicio_contrato, data_fim_contrato, fk_Contratos_ID_contrato) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, locatario.getCpf());
                stmt.setString(2, locatario.getNome());
                stmt.setString(3, locatario.getEndereco());
                stmt.setString(4, locatario.getTelefone());
                stmt.setString(5, locatario.getDataInicio());
                stmt.setString(6, locatario.getDataFim());
                stmt.setInt(7, locatario.getContratoId());

                stmt.executeUpdate();
                System.out.println("Locatário inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir locatário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listarLocatarios() {
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn == null) return;

            String sql = "SELECT * FROM Locatarios";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                System.out.println("\n--- LISTA DE LOCATÁRIOS ---");
                while (rs.next()) {
                    System.out.println("CPF: " + rs.getString("CPF"));
                    System.out.println("Nome: " + rs.getString("Nome"));
                    System.out.println("Endereço: " + rs.getString("Endereco"));
                    System.out.println("Telefone: " + rs.getString("Telefone"));
                    System.out.println("Início do contrato: " + rs.getDate("data_inicio_contrato"));
                    System.out.println("Fim do contrato: " + rs.getDate("data_fim_contrato"));
                    System.out.println("-----------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar locatários: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
