package br.com.locadora;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroLocatario extends JFrame {

    private JTextField campoCpf, campoNome, campoEndereco, campoTelefone, campoDataInicio, campoDataFim, campoContratoId;

    public TelaCadastroLocatario() {
        setTitle("Cadastro de Novo Locatário");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("CPF:"));
        campoCpf = new JTextField();
        add(campoCpf);

        add(new JLabel("Nome Completo:"));
        campoNome = new JTextField();
        add(campoNome);

        add(new JLabel("Endereço:"));
        campoEndereco = new JTextField();
        add(campoEndereco);

        add(new JLabel("Telefone:"));
        campoTelefone = new JTextField();
        add(campoTelefone);

        add(new JLabel("Data Início (AAAA-MM-DD):"));
        campoDataInicio = new JTextField();
        add(campoDataInicio);

        add(new JLabel("Data Fim (AAAA-MM-DD):"));
        campoDataFim = new JTextField();
        add(campoDataFim);

        add(new JLabel("ID do Contrato:"));
        campoContratoId = new JTextField();
        add(campoContratoId);

        JButton botaoSalvar = new JButton("Salvar");
        add(new JLabel());
        add(botaoSalvar);

        botaoSalvar.addActionListener(e -> salvarLocatario());
    }

    private void salvarLocatario() {
        try {
            String cpf = campoCpf.getText();
            String nome = campoNome.getText();
            String endereco = campoEndereco.getText();
            String telefone = campoTelefone.getText();
            String dataInicio = campoDataInicio.getText();
            String dataFim = campoDataFim.getText();
            int contratoId = Integer.parseInt(campoContratoId.getText());

            Locatario novoLocatario = new Locatario(cpf, nome, endereco, telefone, dataInicio, dataFim, contratoId);

            LocatarioDAO dao = new LocatarioDAO();
            dao.inserirLocatario(novoLocatario);

            JOptionPane.showMessageDialog(this, "Locatário salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID do Contrato inválido! Deve ser um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
