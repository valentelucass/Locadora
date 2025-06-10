package br.com.locadora;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContratoDAO {

    public void inserirContrato(Contrato contrato) {
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "INSERT INTO Contratos (ID_contratos, Placa, CPF, valor_mensal, Caucao, data_inicio, data_fim, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, contrato.getId());
                stmt.setString(2, contrato.getPlaca());
                stmt.setString(3, contrato.getCpf());
                stmt.setBigDecimal(4, contrato.getValorMensal());
                stmt.setBigDecimal(5, contrato.getCaucao());
                stmt.setString(6, contrato.getDataInicio());
                stmt.setString(7, contrato.getDataFim());
                stmt.setString(8, contrato.getStatus());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Contrato salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir contrato: \n" + e.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }
}
