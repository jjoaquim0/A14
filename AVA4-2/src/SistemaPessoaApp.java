import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

// Classe principal do sistema
public class SistemaPessoaApp {

    public static void main(String[] args) {
        SistemaPessoaApp app = new SistemaPessoaApp();
        app.iniciar();
    }

    private void iniciar() {
        final String versaoSistema = "12.1.2024";
        String nomeUsuario = "denys.silva";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String dataAcesso = dateFormat.format(new Date());

        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        // Configurações de menu e rodapé
        MenuSistema menuSistema = new MenuSistema(principal);
        principal.setJMenuBar(menuSistema.getMenuBar());

        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "    Usuário: " + nomeUsuario + "    Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);

        // Área de trabalho central
        JTextArea areaTrabalho = new JTextArea();
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        // Centraliza e exibe a janela principal
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}

// Classe para o menu do sistema
class MenuSistema {

    private JMenuBar menuPrincipal;

    public MenuSistema(JFrame principal) {
        menuPrincipal = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent e) { }
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        itemMenuCadastroUsuarios.addActionListener(e -> new CadastroUsuarios(principal));

        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        itemMenuCadastroPessoas.addActionListener(e -> new CadastroPessoas(principal));

        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        itemMenuVisualizacaoListaUsuarios.addActionListener(e -> new ListaUsuarios(principal));

        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        itemMenuVisualizacaoListaPessoas.addActionListener(e -> new ListaPessoas(principal));

        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);
    }

    public JMenuBar getMenuBar() {
        return menuPrincipal;
    }
}

// Classe de cadastro de usuários
class CadastroUsuarios extends JDialog {
    public CadastroUsuarios(JFrame parent) {
        super(parent, "Cadastro de Usuários", true);
        setSize(600, 300);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        JRadioButton radioAtivo = new JRadioButton();
        painelCampos.add(radioAtivo);

        JPanel painelBotoes = PainelBotoes.criarPainelBotoes(this);

        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}

// Classe de cadastro de pessoas
class CadastroPessoas extends JDialog {
    public CadastroPessoas(JFrame parent) {
        super(parent, "Cadastro de Pessoa", true);
        setSize(600, 300);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Pessoa", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Feminino"});
        painelCampos.add(comboSexo);

        JPanel painelBotoes = PainelBotoes.criarPainelBotoes(this);

        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}

// Classe para a lista de usuários
class ListaUsuarios extends JDialog {
    public ListaUsuarios(JFrame parent) {
        super(parent, "Lista de Usuários", true);
        setSize(750, 650);
        setLayout(new BorderLayout());

        add(new JLabel("Lista de Usuários", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JTextArea("Exemplo de lista de usuários..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> setVisible(false));
        add(btnFechar, BorderLayout.SOUTH);

        setLocationRelativeTo(parent);
        setVisible(true);
    }
}

// Classe para a lista de pessoas
class ListaPessoas extends JDialog {
    public ListaPessoas(JFrame parent) {
        super(parent, "Lista de Pessoas", true);
        setSize(750, 650);
        setLayout(new BorderLayout());

        add(new JLabel("Lista de Pessoas", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JTextArea("Exemplo de lista de pessoas..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> setVisible(false));
        add(btnFechar, BorderLayout.SOUTH);

        setLocationRelativeTo(parent);
        setVisible(true);
    }
}

// Classe utilitária para criar o painel de botões
class PainelBotoes {
    public static JPanel criarPainelBotoes(JDialog dialog) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if (label.equals("Sair")) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}
