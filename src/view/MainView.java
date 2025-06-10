package view;

import java.util.Scanner;

public class MainView implements View{

    @Override
    public void startView(){
        System.out.println("--Tela Inicial");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastro");
        System.out.println("3 - Sair");
        System.out.println("Escolha uma opção: ");
    }
}
