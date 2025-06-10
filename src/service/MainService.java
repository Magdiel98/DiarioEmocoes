package service;

import view.MainView;

import java.util.Scanner;

public class MainService {
    private MainView view;
    private Scanner scanner;

    public MainService(MainView view){
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void capturar(){
        int opcao = 0;
        while(opcao < 1 || opcao > 3){
            view.startView();
            opcao = scanner.nextInt();
        }
    }

}
