package br.com.locadora;

import java.math.BigDecimal;

public class Contrato {
    private int id;
    private String placa;
    private String cpf;
    private BigDecimal valorMensal;
    private BigDecimal caucao;
    private String dataInicio;
    private String dataFim;
    private String status;

    // Construtor
    public Contrato(int id, String placa, String cpf, BigDecimal valorMensal, BigDecimal caucao, String dataInicio, String dataFim, String status) {
        this.id = id;
        this.placa = placa;
        this.cpf = cpf;
        this.valorMensal = valorMensal;
        this.caucao = caucao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
    }

    // Getters para todos os campos
    public int getId() { return id; }
    public String getPlaca() { return placa; }
    public String getCpf() { return cpf; }
    public BigDecimal getValorMensal() { return valorMensal; }
    public BigDecimal getCaucao() { return caucao; }
    public String getDataInicio() { return dataInicio; }
    public String getDataFim() { return dataFim; }
    public String getStatus() { return status; }
}
