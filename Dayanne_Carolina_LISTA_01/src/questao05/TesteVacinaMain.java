package questao05;

import java.time.LocalDate;

public class TesteVacinaMain {
    static void imprimir(RelacaoVacinados relacaoVacinados){
        System.out.printf("%-10s| %-20s| %4s | %1s%n", "CPF", "Nome", "Idade", "Data Indicada p. 2a Dose");

        System.out.printf("------------------------------------------------------------%n");
        relacaoVacinados.listarPessoasQueNãoTomaram2aDose();

        System.out.printf("------------------------------------------------------------%n");
        System.out.println("Total de Vacinados acima de 65 anos: " + relacaoVacinados.calcularTotalVacinadosAcimaDe(65));
        System.out.println("Total de vacinados que não tomaram a 2a. dose: " + relacaoVacinados.getVacinado1dose());
        System.out.println("Total de vacinados que tomaram a 2a. dose: " + relacaoVacinados.getVacinado2dose());
    }
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("0333787383", "Jose Maria", LocalDate.of(1955,06,10));
        Pessoa p2 = new Pessoa("3830333787", "Maria Jose", LocalDate.of(1953,06,10));
        Pessoa p3 = new Pessoa("7870333383", "Jose Silva", LocalDate.of(1951,06,10));
        Pessoa p4 = new Pessoa("3787303383", "Maria Silva", LocalDate.of(1956,06,10));
        Pessoa p5 = new Pessoa("3348730338", "Maria do Jose",LocalDate.of(1950,06,10));

        Vacina v1 = new Vacina();
        v1.setNome("CORONAVAC");
        Vacina v2 = new Vacina();
        v2.setNome("OXFORD");

        RegistroVacina r1 = new RegistroVacina();
        r1.setVacina(v1);
        r1.setVacinado(p1);
        r1.setDose(1);
        r1.setData_vacinacao(LocalDate.of(2021, 04, 22));

        RegistroVacina r2 = new RegistroVacina();
        r2.setVacina(v1);
        r2.setVacinado(p2);
        r2.setDose(1);
        r2.setData_vacinacao(LocalDate.of(2021, 04, 25));

        RegistroVacina r3 = new RegistroVacina();
        r3.setVacina(v2);
        r3.setVacinado(p3);
        r3.setDose(1);
        r3.setData_vacinacao(LocalDate.of(2021, 04, 24));

        RegistroVacina r4 = new RegistroVacina();
        r4.setVacina(v2);
        r4.setVacinado(p4);
        r4.setDose(1);
        r4.setData_vacinacao(LocalDate.of(2021, 04, 30));

        RegistroVacina r5 = new RegistroVacina();
        r5.setVacina(v1);
        r5.setVacinado(p5);
        r5.setDose(1);
        r5.setData_vacinacao(LocalDate.of(2021, 04, 12));

        RegistroVacina r6 = new RegistroVacina();
        r6.setVacina(v1);
        r6.setVacinado(p5);
        r6.setDose(2);
        r6.setData_vacinacao(LocalDate.of(2021, 04, 23));

        RelacaoVacinados relacaoVacinados = new RelacaoVacinados();
        relacaoVacinados.adicionar(r1);
        relacaoVacinados.adicionar(r2);
        relacaoVacinados.adicionar(r3);
        relacaoVacinados.adicionar(r4);
        relacaoVacinados.adicionar(r5);
        relacaoVacinados.adicionar(r6);

        imprimir(relacaoVacinados);

    }
}
