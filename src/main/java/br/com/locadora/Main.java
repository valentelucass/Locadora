package br.com.locadora;

import com.formdev.flatlaf.FlatDarculaLaf; // Importa o tema escuro
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // --- CONFIGURA O TEMA MODERNO PARA TODA A APLICAÇÃO ---
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Falha ao carregar o tema FlatLaf.");
        }

        // Garante que a interface gráfica seja executada na thread correta
        SwingUtilities.invokeLater(() -> {
            PainelPrincipal painel = new PainelPrincipal();
            painel.setVisible(true);
        });
    }
}
