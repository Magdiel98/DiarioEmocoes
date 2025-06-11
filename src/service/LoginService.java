package service;

import view.LoginView;

import java.util.Scanner;

public class LoginService {
    private LoginView loginView;
    private Scanner scanner;
    private String login;
    private String senha;

    public LoginService(LoginView loginView)
    {
        this.loginView = loginView;
        this.scanner = new Scanner(System.in);
    }

    public void login()
    {
        loginView.startView();
        boolean autenticado = false;

        while(!autenticado) {
            loginView.campoUsuario();
            this.login = scanner.nextLine();
            loginView.campoSenha();
            this.senha = scanner.nextLine();
            //Usar o autenticacaoService para fazer a autenticacao no banco
        }
    }
}
