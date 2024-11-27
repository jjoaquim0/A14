import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//
// Classe principal que inicializa o sistema
public class SistemaPessoa {
    public static void main(String[] args) {
        ConfiguracoesSistema configuracoes = new ConfiguracoesSistema();
        MenuPrincipal menu = new MenuPrincipal(configuracoes);
        menu.exibir();
    }
}

// Classe para armazenar as configurações globais do sistema
class ConfiguracoesSistema {
    public final String versaoSistema = "12.1.2024";
    public final String nomeUsuario = "denys.silva";
    public final String dataAcesso;

    public ConfiguracoesSistema() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.dataAcesso = dateFormat.format(new Date());
    }
}

// Classe responsável pelo menu principal e pela exibição da interface
class MenuPrincipal {
    private final JFrame principal;
    private final ConfiguracoesSistema configuracoes;

    public MenuPrincipal(ConfiguracoesSistema configuracoes) {
        this.configuracoes = configuracoes;
        this.principal = new JFrame("Sistema Pessoa");
        configurarJanela();
        configurarMenu();
        configurarRodape();
    }

    // Configura a janela principal
    private void configurarJanela() {
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
    }

    // Configura o menu principal e suas opções
    private void configurarMenu() {
        JMenuBar menuPrincipal = new JMenuBar();

        // Menu de Cadastro
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        // Menu de Visualização
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        // Menu de Sair
        JMenu menuSair = new JMenu("Sair");
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        // Adiciona os menus à barra de menu
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        // Adiciona a barra de menu à janela
        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);

        // Área de trabalho no centro
        JTextArea areaTrabalho = new JTextArea();
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
    }

    // Configura o rodapé com as informações do sistema
    private void configurarRodape() {
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel(
            "Versão: " + configuracoes.versaoSistema +
            "               Usuário: " + configuracoes.nomeUsuario +
            "               Data de acesso: " + configuracoes.dataAcesso
        );
        painelRodape.add(labelRodape);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);
    }

    // Exibe a janela principal
    public void exibir() {
        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }
}
