package questao03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ControladorFinanceiro {
    public static void main(String[] args) {
        FluxoCaixa f1 = new FluxoCaixa("Empresa", "1230210");

        ITransacao d1 = new DespesaComAgua(LocalDateTime.of(2022, 2, 13, 14, 34), "Agua", 32);
        ITransacao d2 = new DespesaComEnergia(LocalDateTime.of(2022, 3, 24, 18, 54), "Energia", 300);
        ITransacao d3 = new DespesaComInternet(LocalDateTime.of(2021, 6, 20, 12, 36), "Internet", 600);
        f1.adicionarTransacao(d1);
        f1.adicionarTransacao(d2);
        f1.adicionarTransacao(d3);

        ITransacao r1 = new LicencaEnterprise(LocalDateTime.of(2021, 6, 16, 17, 49), "Licenca Enterprise", 6);
        ITransacao r2 = new LicencaBasica(LocalDateTime.of(2022, 3, 15, 19, 44), "Licenca Basica", 10);
        ITransacao r3 = new LicensaPlus(LocalDateTime.of(2022, 4, 22, 20, 56), "Licenca Plus", 4);
        f1.adicionarTransacao(r1);
        f1.adicionarTransacao(r2);
        f1.adicionarTransacao(r3);

        System.out.printf("Despesas entre: %.2f%n", f1.calcularDespesas(LocalDate.of(2021, 2, 21), LocalDate.of(2021, 10, 30)));
        System.out.printf("Receitas entre: %.2f%n", f1.calcularReceitas(LocalDate.of(2020, 6, 19), LocalDate.of(2022, 5, 21)));
        System.out.printf("Percentual Receitas: %.2f%n", f1.percentualReceitasNoMes(6, 2021));
        System.out.printf("Percentual Dispesas: %.2f%n", f1.percentualDespesasNoMes(3, 2022));
        System.out.printf("Saldo Atual: %.2f%n", f1.saldoAtual());

        List<ITransacao> lista = f1.listarTransacoesNoMes(6, 2021);
        System.out.println("Listar transacoes no mes:");
        for(ITransacao temp: lista){
            System.out.println(temp);
        }

    }
}
