package service;

import view.CadastroView;
import view.LoginView;
import view.MainView;

import java.util.Scanner;

public class MainService {
    private MainView view;
    private LoginService loginService;
    private LoginView loginView;
    private CadastroService cadastroService;
    private CadastroView cadastroView;
    private Scanner scanner;
    int opcao;

    public MainService(MainView view){
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.loginView = new LoginView();
        this.loginService = new LoginService(loginView);
        this.cadastroView = new CadastroView();
        this.cadastroService = new CadastroService(cadastroView);
    }

    public void capturar(){
        opcao = 0;
        while(opcao < 1 || opcao > 3){
            view.startView();
            opcao = scanner.nextInt();
        }

        switch (opcao) {
            case 1 -> loginService.login();
            case 2 -> cadastroService.cadastro();
            case 3 -> System.out.println("Saindo...");
        }
    }

}
