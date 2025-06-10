package br.com.locadora;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocatarioDAO {

    public void inserirLocatario(Locatario locatario) {
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                return;
            }

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
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir locatário: \n" + e.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- MÉTODO CORRIGIDO ---
    // A assinatura do método agora retorna uma List<Locatario>
    public List<Locatario> listarLocatarios() {
        // 1. Cria uma lista vazia para armazenar os locatários
        List<Locatario> locatarios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                return locatarios; // Retorna a lista vazia em caso de falha
            }

            String sql = "SELECT * FROM Locatarios";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                // 2. Itera sobre cada linha do resultado do banco
                while (rs.next()) {
                    // Pega os dados de cada coluna
                    String cpf = rs.getString("CPF");
                    String nome = rs.getString("Nome");
                    String endereco = rs.getString("Endereco");
                    String telefone = rs.getString("Telefone");
                    String dataInicio = rs.getString("data_inicio_contrato");
                    String dataFim = rs.getString("data_fim_contrato");
                    int contratoId = rs.getInt("fk_Contratos_ID_contrato");

                    // Cria um objeto Locatario e o adiciona na lista
                    Locatario locatario = new Locatario(cpf, nome, endereco, telefone, dataInicio, dataFim, contratoId);
                    locatarios.add(locatario);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar locatários: \n" + e.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }

        // 3. Retorna a lista preenchida (ou vazia, se não houver dados)
        return locatarios;
    }
}
