package view;

public class CadastroView implements View{

    @Override
    public void startView(){
        System.out.println("--Página Cadastro--");
    }

    public void campoNome()
    {
        System.out.println("Digite seu nome: ");
    }

    public void campoSobreNome()
    {
        System.out.println("Digite seu sobrenome: ");
    }

    public void campoUsuarioCadastro()
    {
        System.out.println("Digite seu usuário: ");
    }

    public void campoSenhaCadastro()
    {
        System.out.println("Digite sua senha: ");
    }
}
