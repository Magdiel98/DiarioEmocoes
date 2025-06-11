package entity;

public class Usuario {
    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;

    public Usuario(String nome, String sobrenome, String usuario, String senha)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuario = usuario;
        this.senha = senha;
    }
}
