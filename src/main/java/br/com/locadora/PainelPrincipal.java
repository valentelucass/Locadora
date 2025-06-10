package br.com.locadora;

import javax.swing.*;
import java.awt.*;

public class PainelPrincipal extends JFrame {

    public PainelPrincipal() {
        // --- Configuração da Janela ---
        setTitle("Sistema de Gestão - Locadora de Veículos");
        setSize(550, 400); // Um pouco maior para respirar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Painel principal com bordas (espaçamento) e cor de fundo ---
        JPanel painel = new JPanel(new BorderLayout(20, 20));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(painel);

        // --- Título ---
        JLabel labelTitulo = new JLabel("Painel de Controle", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28)); // Fonte mais moderna
        painel.add(labelTitulo, BorderLayout.NORTH);

        // --- Imagem de boas-vindas (Opcional, mas dá um toque legal) ---
        // Para usar, coloque uma imagem chamada "car_icon.png" na pasta "src/main/resources"
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/car_icon.png"));
            JLabel imageLabel = new JLabel(icon);
            painel.add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            JLabel welcomeText = new JLabel("Bem-vindo!", SwingConstants.CENTER);
            welcomeText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            painel.add(welcomeText, BorderLayout.CENTER);
        }

        // --- Painel de Botões ---
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 15, 15)); // Botões lado a lado
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0)); // Espaço acima dos botões

        JButton btnCadastrarContrato = new JButton("<html><center>Cadastrar<br>Contrato</center></html>");
        JButton btnCadastrarLocatario = new JButton("<html><center>Cadastrar<br>Locatário</center></html>");
        JButton btnVisualizarLocatarios = new JButton("<html><center>Visualizar<br>Locatários</center></html>");

        Font fontBotoes = new Font("Segoe UI", Font.BOLD, 14);
        btnCadastrarContrato.setFont(fontBotoes);
        btnCadastrarLocatario.setFont(fontBotoes);
        btnVisualizarLocatarios.setFont(fontBotoes);

        painelBotoes.add(btnCadastrarContrato);
        painelBotoes.add(btnCadastrarLocatario);
        painelBotoes.add(btnVisualizarLocatarios);

        painel.add(painelBotoes, BorderLayout.SOUTH);

        // --- Ações dos Botões ---a
        btnCadastrarContrato.addActionListener(e -> new TelaCadastroContrato().setVisible(true));
        btnCadastrarLocatario.addActionListener(e -> new TelaCadastroLocatario().setVisible(true));
        btnVisualizarLocatarios.addActionListener(e -> new TelaListarLocatarios().setVisible(true));
    }
}
