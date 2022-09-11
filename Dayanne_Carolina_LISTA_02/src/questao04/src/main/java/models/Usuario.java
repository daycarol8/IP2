package models;
import java.time.LocalDate;

public class Usuario {

    private String email;
    private String nome;
    private LocalDate dataNascimento;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String senha;

    public Usuario(String email, String nome, LocalDate dataNascimento, String senha) {
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


}
