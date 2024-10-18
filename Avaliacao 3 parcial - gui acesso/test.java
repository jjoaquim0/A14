import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {

    public static void main(String[] args) {
        // Criação do JFrame
        JFrame frame = new JFrame("Acesso ao aplicativo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Campos de texto para usuário e senha
        JTextField usuarioField = new JTextField(20);
        JPasswordField senhaField = new JPasswordField(20);

        // Botões
        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");

        // Adicionando ActionListener para o botão Confirmar
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                // Verifica se o usuário e senha são "admin"
                if (usuario.equals("denys.silva") && senha.equals("Teste@2024")) {
                    JOptionPane.showMessageDialog(null, "Você entrou com sucesso!");
                    frame.dispose(); // Fecha a janela após login bem-sucedido
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
                }
            }
        });

        // Adicionando ActionListener para o botão Cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela se o botão cancelar for pressionado
            }
        });

        // Layout (usando JPanel e GridLayout para organizar os componentes)
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Usuário:"));
        panel.add(usuarioField);
        panel.add(new JLabel("Senha:"));
        panel.add(senhaField);
        panel.add(confirmarButton);
        panel.add(cancelarButton);

        // Adicionando o painel ao frame e ajustando o tamanho
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true); // Torna a janela visível
    }
}
