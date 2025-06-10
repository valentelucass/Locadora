package br.com.locadora;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando aplicação...");
        LocatarioDAO dao = new LocatarioDAO();

        // Criar um objeto para um novo locatário
        Locatario novoLocatario = new Locatario(
                "123.456.789-00",
                "Lucas Andrade",
                "Rua dos Testes, 123",
                "(11) 99999-8888",
                "2025-06-01",
                "2025-12-01",
                1 // IMPORTANTE: Este ID de contrato precisa existir na sua tabela de Contratos!
        );

        // Chamar o método para inserir o locatário no banco de dados
        dao.inserirLocatario(novoLocatario);

        // Chamar o método para listar todos os locatários e verificar se a inserção funcionou
        dao.listarLocatarios();

        System.out.println("\nAplicação finalizada.");
    }
}