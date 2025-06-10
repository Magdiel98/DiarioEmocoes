package service;

import view.CadastroView;
import view.LoginView;
import view.MainView;

import java.util.Scanner;

public class MainService {
    private MainView view;
    private LoginView loginView;
    private CadastroView cadastroView;
    private Scanner scanner;

    public MainService(MainView view){
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.loginView = new LoginView();
        this.cadastroView = new CadastroView();
    }

    public void capturar(){
        int opcao = 0;
        while(opcao < 1 || opcao > 3){
            view.startView();
            opcao = scanner.nextInt();
        }

        switch (opcao) {
            case 1 -> loginView.startView();
            case 2 -> cadastroView.startView();
            case 3 -> System.out.println("Saindo...");
        }
    }

}
