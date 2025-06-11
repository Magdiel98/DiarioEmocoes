package view;

public class LoginView implements View{

    @Override
    public void startView(){
        System.out.println("--Página Login--");
    }

    public void campoUsuario(){
        System.out.println("Digite o usuário: ");
    }

    public void campoSenha(){
        System.out.println("Digite a senha: ");
    }
}
