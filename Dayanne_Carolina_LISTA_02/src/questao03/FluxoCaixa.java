package questao03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FluxoCaixa {
    private String nomeEmpresa;
    private String cnpj;

    private List<ITransacao> transacoes = new ArrayList<>();

    public FluxoCaixa(String nomeEmpresa, String cnpj) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public void adicionarTransacao(ITransacao transacao){
        transacoes.add(transacao);
    }

    public double calcularDespesas(LocalDate inicio, LocalDate fim){
        double total = 0;
        for(ITransacao temp: transacoes){
            if(temp instanceof Despesa && estaNoPeriodo(inicio, fim, temp.getData().toLocalDate())){
                total += temp.calcularTotal();
            }
        }

        return total;
    }

    public double calcularReceitas(LocalDate inicio, LocalDate fim){
        double total = 0;
        for(ITransacao temp: transacoes){
            if(temp instanceof Receita && estaNoPeriodo(inicio, fim, temp.getData().toLocalDate())){
                total += temp.calcularTotal();
            }
        }

        return total;
    }

    public double percentualReceitasNoMes(int mes, int ano){
        double totalMes = 0;
        double totalAno = 0;
        for(ITransacao temp:transacoes){
            if(temp instanceof Receita){
                if(temp.getData().getMonthValue() == mes){
                    totalMes += temp.calcularTotal();
                }
                if(temp.getData().getYear() == ano){
                    totalAno += temp.calcularTotal();
                }
            }
        }
        return (totalMes * 100)/totalAno;
    }

    public double percentualDespesasNoMes(int mes, int ano){
        double totalMes = 0;
        double totalAno = 0;
        for(ITransacao temp:transacoes){
            if(temp instanceof Despesa){
                if(temp.getData().getMonthValue() == mes){
                    totalMes += temp.calcularTotal();
                }
                if(temp.getData().getYear() == ano){
                    totalAno += temp.calcularTotal();
                }
            }
        }
        return (totalMes * 100)/totalAno;
    }

    public double saldoAtual(){
        double total = 0;
        for(ITransacao temp: transacoes){
            if(temp instanceof Receita){
                total+= temp.calcularTotal();
            } else{
                total -= temp.calcularTotal();
            }
        }
        return total;
    }

    public List<ITransacao> listarTransacoesNoMes(int mes, int ano){
        List<ITransacao> transacaosNoMes = new ArrayList<>();

        for(ITransacao temp : transacoes){
            if(temp.getData().getMonthValue() == mes && temp.getData().getYear() == ano){
                transacaosNoMes.add(temp);
            }
        }

        return transacaosNoMes;

    }

    public boolean estaNoPeriodo(LocalDate inicio, LocalDate fim, LocalDate data) {
        return data.isAfter(inicio) && data.isBefore(fim);
    }


}
