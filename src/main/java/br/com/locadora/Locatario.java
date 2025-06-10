package br.com.locadora;

public class Locatario {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String dataInicio;
    private String dataFim;
    private int contratoId;

    // Construtor
    public Locatario(String cpf, String nome, String endereco, String telefone, String dataInicio, String dataFim, int contratoId) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.contratoId = contratoId;
    }

    // Getters
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public int getContratoId() {
        return contratoId;
    }
}
