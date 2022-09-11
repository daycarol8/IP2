package questao02;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {
    static final protected double SALARIO_TETO_IMPOSTO = 5000;
    private double salario;


    public Funcionario(String nome, LocalDate dataNascimento, double salario) {
        super(nome, dataNascimento);
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() + '\''+
                ", imposto= "+ calcularImpostoDevido() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Funcionario that = (Funcionario) o;
        return Double.compare(that.salario, salario) == 0;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calcularImpostoDevido(){
        double imposto = 0;
        if(salario <= SALARIO_TETO_IMPOSTO){
            imposto = salario*0.05;
        } else{
            imposto = salario*0.075;
        }
        return imposto;
    }
}
