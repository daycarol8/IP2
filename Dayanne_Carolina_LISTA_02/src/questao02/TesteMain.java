package questao02;

import java.time.LocalDate;

public class TesteMain {
    public static void main(String[] args) {
        RepositorioPessoas repositorioPessoas = new RepositorioPessoas();

        //Clientes
        Cliente cliente1 = new Cliente("Ana", LocalDate.of(2002,10,02),392140);
        Cliente cliente2 = new Cliente("Joao", LocalDate.of(1992,10,02),3922140);
        Cliente cliente3 = new Cliente("Fernando", LocalDate.of(1953,10,02),3412140);
        Cliente cliente4 = new Cliente("Sara", LocalDate.of(2006,10,02),3124);
        Cliente cliente5 = new Cliente("Leo", LocalDate.of(2001,10,02),5292140);

        repositorioPessoas.cadastrarPessoa(cliente1);
        repositorioPessoas.cadastrarPessoa(cliente2);
        repositorioPessoas.cadastrarPessoa(cliente3);
        repositorioPessoas.cadastrarPessoa(cliente4);
        repositorioPessoas.cadastrarPessoa(cliente5);
        Cliente cliente6 = new Cliente("Ana", LocalDate.of(2002,10,02),392140);
        repositorioPessoas.cadastrarPessoa(cliente6);

        //Funcionarios
        Funcionario funcionario1 = new Funcionario("Rafael", LocalDate.of(2000,12,01),2500);
        Funcionario funcionario2 = new Funcionario("Ana", LocalDate.of(1962,12,01),7000);
        Funcionario funcionario3 = new Funcionario("Lucas", LocalDate.of(2001,12,01),9700);
        Funcionario funcionario4 = new Funcionario("Mateus", LocalDate.of(2000,12,01),2550);
        Funcionario funcionario5 = new Funcionario("Maria", LocalDate.of(2002,12,01),3000);

        repositorioPessoas.cadastrarPessoa(funcionario1);
        repositorioPessoas.cadastrarPessoa(funcionario2);
        repositorioPessoas.cadastrarPessoa(funcionario3);
        repositorioPessoas.cadastrarPessoa(funcionario4);
        repositorioPessoas.cadastrarPessoa(funcionario5);
        Funcionario funcionario6 = new Funcionario("Rafael", LocalDate.of(2000,12,01),2500);
        repositorioPessoas.cadastrarPessoa(funcionario6);

        //Gerentes
        Gerente gerente1 = new Gerente("Elias", LocalDate.of(2000,10,2), 8000, "Design");
        Gerente gerente2 = new Gerente("Jose", LocalDate.of(1998,12,12), 9000, "Negocios");
        Gerente gerente3 = new Gerente("Joao", LocalDate.of(1980,8,2), 8500, "Dev");
        Gerente gerente4 = new Gerente("Mateus", LocalDate.of(1997,7,02), 10000, "Design");
        Gerente gerente5 = new Gerente("Clara", LocalDate.of(2001,1,30), 9000, "Dev");

        repositorioPessoas.cadastrarPessoa(gerente1);
        repositorioPessoas.cadastrarPessoa(gerente2);
        repositorioPessoas.cadastrarPessoa(gerente3);
        repositorioPessoas.cadastrarPessoa(gerente4);
        repositorioPessoas.cadastrarPessoa(gerente5);
        Gerente gerente6 = new Gerente("Elias", LocalDate.of(2000,10,02), 8000, "Design");
        repositorioPessoas.cadastrarPessoa(gerente6);

        System.out.println("\n Todas as pessoas");
        for(Pessoa a: repositorioPessoas.getPessoas()){
            System.out.println(a);
        }


        System.out.println("\n Pessoas Maiores de idade");
        for(Pessoa a: repositorioPessoas.listarPessoasMaioresIdade()){
            System.out.println(a);
        }

        System.out.println("\n Clientes Maiores de idade");
        for(Pessoa a: repositorioPessoas.listarClientesMaioresIdade()){
            System.out.println(a);
        }

        System.out.println("\n Funcionarios salarios maior que ");
        for(Pessoa a: repositorioPessoas.listarFuncionariosComSalarioMaiorQue(3000)){
            System.out.println(a);
        }

        System.out.println("\n Gerentes da area ");
        for(Pessoa a: repositorioPessoas.listarGerentesDaArea("Design")){
            System.out.println(a);
        }
    }
}
