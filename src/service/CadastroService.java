package service;

import view.CadastroView;

import java.util.Scanner;

public class CadastroService {

    private CadastroView cadastroView;
    private Scanner scanner;
    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;

    public CadastroService(CadastroView cadastroView){
        this.cadastroView = cadastroView;
        this.scanner = new Scanner(System.in);
    }

    public void cadastro(){
        cadastroView.startView();

        cadastroView.campoNome();
        nome = scanner.nextLine();

        cadastroView.campoSobreNome();
        sobrenome = scanner.nextLine();

        cadastroView.campoUsuarioCadastro();
        usuario = scanner.nextLine();

        cadastroView.campoSenhaCadastro();
        senha = scanner.nextLine();

        //Usar o SalvarCadastroUsuarioService para salvar as informações no banco de dados
    }
}
