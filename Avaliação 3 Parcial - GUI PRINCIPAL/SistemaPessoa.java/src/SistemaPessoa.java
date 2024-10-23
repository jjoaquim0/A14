import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {
        // Configurações da janela principal
        setTitle("Sistema de Pessoa");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criar barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Criar menus
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        // Criar itens de menu para "Cadastro"
        JMenuItem itemUsuarios = new JMenuItem("Usuários");
        JMenuItem itemPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemUsuarios);
        menuCadastro.add(itemPessoas);

        // Criar itens de menu para "Visualização"
        JMenuItem itemListaUsuarios = new JMenuItem("Lista de usuário");
        JMenuItem itemListaPessoas = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(itemListaUsuarios);
        menuVisualizacao.add(itemListaPessoas);

        // Adicionar ação ao menu "Sair"
        menuSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Adicionar ação ao menu "Usuários"
        itemUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroUsuarios(); // Abre a janela de cadastro de usuários
            }
        });

        // Adicionar menus à barra de menu
        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);

        // Definir a barra de menu na janela
        setJMenuBar(menuBar);

        // Criar o rodapé
        JPanel rodape = criarRodape();
        add(rodape, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Método para criar o rodapé
    private JPanel criarRodape() {
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza os componentes

        // Obter a data e hora atuais
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataAcesso = sdf.format(new Date());

        // Label para a versão
        JLabel versaoLabel = new JLabel("Versão: 12.1.2024");
        
        // Label para o usuário
        JLabel usuarioLabel = new JLabel("Usuário: joaquim.filho");

        // Label para a data de acesso
        JLabel dataAcessoLabel = new JLabel("Data de acesso: " + dataAcesso);

        // Adicionar os componentes ao rodapé
        rodape.add(versaoLabel);
        rodape.add(usuarioLabel);
        rodape.add(dataAcessoLabel);

        return rodape;
    }

    // Método para abrir a janela de Cadastro de Usuários
    private void abrirCadastroUsuarios() {
        JFrame frameCadastro = new JFrame("Cadastro de Usuários");
        frameCadastro.setSize(400, 300);
        frameCadastro.setLayout(new BorderLayout());

        // Painel de formulário
        JPanel painelFormulario = new JPanel(new GridLayout(5, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Componentes do formulário
        painelFormulario.add(new JLabel("Usuário:"));
        JTextField campoUsuario = new JTextField();
        painelFormulario.add(campoUsuario);

        painelFormulario.add(new JLabel("Senha:"));
        JPasswordField campoSenha = new JPasswordField();
        painelFormulario.add(campoSenha);

        painelFormulario.add(new JLabel("Email:"));
        JTextField campoEmail = new JTextField();
        painelFormulario.add(campoEmail);

        painelFormulario.add(new JLabel("Ativo:"));
        JCheckBox checkAtivo = new JCheckBox();
        painelFormulario.add(checkAtivo);

        // Adiciona o painel de formulário à janela de cadastro
        frameCadastro.add(painelFormulario, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        String[] titulosBotoes = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};

        // Cria os botões e trata os eventos
        for (String titulo : titulosBotoes) {
            JButton botao = criarBotaoArredondado(titulo);
            painelBotoes.add(botao);

            // Evento dos botões
            botao.addActionListener(e -> {
                if (titulo.equals("Sair")) {
                    frameCadastro.dispose(); // Fecha a janela de cadastro
                } else if (titulo.equals("Cancelar")) {
                    campoUsuario.setText("");
                    campoSenha.setText("");
                    campoEmail.setText("");
                    checkAtivo.setSelected(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Botão clicado: " + titulo);
                }
            });
        }

        // Adiciona o painel de botões à janela
        frameCadastro.add(painelBotoes, BorderLayout.SOUTH);

        frameCadastro.setVisible(true);
    }

    // Método para criar botões com bordas arredondadas
    private JButton criarBotaoArredondado(String texto) {
        JButton botao = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Shape shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
                g2.setColor(getBackground());
                g2.fill(shape);
                g2.setColor(getForeground());
                g2.draw(shape);
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        botao.setContentAreaFilled(false);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return botao;
    }

    public static void main(String[] args) {
        new SistemaPessoa();
    }
}
