package br.com.locadora;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class TelaCadastroContrato extends JFrame {

    private JTextField campoId;
    private JTextField campoPlaca;
    private JTextField campoCpf;
    private JTextField campoValorMensal;
    private JTextField campoCaucao;
    private JTextField campoDataInicio;
    private JTextField campoDataFim;
    private JTextField campoStatus;

    public TelaCadastroContrato() {
        setTitle("Cadastro de Novo Contrato");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 10, 10));

        // Adicionando os componentes
        add(new JLabel("ID do Contrato:"));
        campoId = new JTextField();
        add(campoId);

        add(new JLabel("Placa do Veículo:"));
        campoPlaca = new JTextField();
        add(campoPlaca);

        add(new JLabel("CPF do Locatário:"));
        campoCpf = new JTextField();
        add(campoCpf);

        add(new JLabel("Valor Mensal (Ex: 1500.00):"));
        campoValorMensal = new JTextField();
        add(campoValorMensal);

        add(new JLabel("Valor Caução (Ex: 3000.00):"));
        campoCaucao = new JTextField();
        add(campoCaucao);

        add(new JLabel("Data Início (AAAA-MM-DD):"));
        campoDataInicio = new JTextField();
        add(campoDataInicio);

        add(new JLabel("Data Fim (AAAA-MM-DD):"));
        campoDataFim = new JTextField();
        add(campoDataFim);

        add(new JLabel("Status (Ex: Ativo):"));
        campoStatus = new JTextField();
        add(campoStatus);

        JButton botaoSalvar = new JButton("Salvar Contrato");
        add(new JLabel());
        add(botaoSalvar);

        botaoSalvar.addActionListener(e -> salvarContrato());
    }

    private void salvarContrato() {
        try {
            int id = Integer.parseInt(campoId.getText());
            String placa = campoPlaca.getText();
            String cpf = campoCpf.getText();
            BigDecimal valorMensal = new BigDecimal(campoValorMensal.getText());
            BigDecimal caucao = new BigDecimal(campoCaucao.getText());
            String dataInicio = campoDataInicio.getText();
            String dataFim = campoDataFim.getText();
            String status = campoStatus.getText();

            Contrato novoContrato = new Contrato(id, placa, cpf, valorMensal, caucao, dataInicio, dataFim, status);

            ContratoDAO dao = new ContratoDAO();
            dao.inserirContrato(novoContrato);

            this.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro de formato em algum campo numérico.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
