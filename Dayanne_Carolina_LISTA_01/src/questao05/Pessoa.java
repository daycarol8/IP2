package questao05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(){}
    public Pessoa(String cpf, String nome, LocalDate dataNascimento){
        this.cpf= cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

   public String getCpf(){
       return cpf;
   }

   public void setCpf(String cpf){
       this.cpf = cpf;
   }

   public String getNome(){
       return nome;
   }

   public void setGrupo(String grupo){
       this.nome = nome;
   }

   public LocalDate getDataNascimento(){
       return dataNascimento;
   }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long calcularIdade(){
       LocalDate now = LocalDate.now();
       return ChronoUnit.YEARS.between(dataNascimento, now);
    }
}
