package questao02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RepositorioPessoas {
    ArrayList<Pessoa> pessoas;

    public RepositorioPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void cadastrarPessoa(Pessoa pessoa){
        if(!pessoas.contains(pessoa)){
            pessoas.add(pessoa);
        }
    }

    public ArrayList<Pessoa> listarPessoasMaioresIdade(){
        ArrayList<Pessoa> maioresIdade = new ArrayList<>();
        for(Pessoa a: pessoas){
            if(calcularIdade(a.getDataNascimento()) >= 18){
                maioresIdade.add(a);
            }
        }

        return maioresIdade;
    }

    public ArrayList<Cliente> listarClientesMaioresIdade(){
        ArrayList<Cliente> maioresIdade = new ArrayList<>();
        for(Pessoa a: pessoas){
            if(a instanceof Cliente){
                if(calcularIdade(a.getDataNascimento()) >= 18){
                    maioresIdade.add((Cliente) a);
                }
            }
        }
        return maioresIdade;
    }

    public ArrayList<Funcionario> listarFuncionariosComSalarioMaiorQue(double salario){
        ArrayList<Funcionario> salariosMaioresQue = new ArrayList<>();
        for(Pessoa a: pessoas){
            if(a instanceof Funcionario){
                if(((Funcionario) a).getSalario() > salario){
                    salariosMaioresQue.add((Funcionario) a);
                }
            }
        }

        return salariosMaioresQue;
    }

    public ArrayList<Gerente> listarGerentesDaArea(String area){
        ArrayList<Gerente> gerentesArea = new ArrayList<>();
        for(Pessoa a: pessoas){
            if(a instanceof Gerente){
                if(((Gerente) a).getArea().equals(area)){
                    gerentesArea.add((Gerente) a);
                }
            }
        }

        return gerentesArea;
    }

    public long calcularIdade(LocalDate data){
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(data, now);
    }

}
