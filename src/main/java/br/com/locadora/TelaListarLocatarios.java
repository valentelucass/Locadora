package br.com.locadora;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class TelaListarLocatarios extends JFrame {

    private JTable tabela;
    private DefaultTableModel modeloTabela;

    public TelaListarLocatarios() {
        // --- Configurações da Janela ---
        setTitle("Consulta de Locatários");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Painel principal com bordas (espaçamento) ---
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(painelPrincipal);

        // --- Título da Tela ---
        JLabel labelTitulo = new JLabel("Locatários Cadastrados", SwingConstants.LEFT);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        painelPrincipal.add(labelTitulo, BorderLayout.NORTH);

        // --- Tabela para exibir os dados ---
        String[] colunas = {"CPF", "Nome", "Endereço", "Telefone", "Início Contrato", "Fim Contrato", "ID Contrato"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede a edição direta na tabela
            }
        };
        tabela = new JTable(modeloTabela);

        // --- Estilizando a Tabela ---
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabela.setRowHeight(28);
        tabela.setGridColor(new Color(80, 80, 80));
        tabela.setSelectionBackground(new Color(90, 90, 130)); // Cor ao selecionar uma linha

        // Estilizando o Cabeçalho da Tabela
        JTableHeader header = tabela.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setOpaque(false);
        header.setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // --- Painel de Botões ---
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        painelBotoes.add(btnAtualizar);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        btnAtualizar.addActionListener(e -> carregarDados());

        carregarDados();
    }

    private void carregarDados() {
        modeloTabela.setRowCount(0);

        LocatarioDAO dao = new LocatarioDAO();
        List<Locatario> locatarios = dao.listarLocatarios();

        for (Locatario locatario : locatarios) {
            modeloTabela.addRow(new Object[]{
                    locatario.getCpf(),
                    locatario.getNome(),
                    locatario.getEndereco(),
                    locatario.getTelefone(),
                    locatario.getDataInicio(),
                    locatario.getDataFim(),
                    locatario.getContratoId()
            });
        }
    }
}
