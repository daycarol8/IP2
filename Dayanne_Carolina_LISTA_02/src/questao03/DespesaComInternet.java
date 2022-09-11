package questao03;

import java.time.LocalDateTime;

public class DespesaComInternet extends Despesa{

    double dadosTrafegados;

    public DespesaComInternet(LocalDateTime data, String descricao, double dadosTrafegados) {
        super(data, descricao);
        this.dadosTrafegados = dadosTrafegados;
    }

    @Override
    public double calcularTotal() {
        double total = 0;

        if(dadosTrafegados<=20){
            total += 90.9;
        } else if (dadosTrafegados > 20 && dadosTrafegados < 100) {
            total = 90.9 + (dadosTrafegados - 20) * 3.9;
        } else if (dadosTrafegados>=100 && dadosTrafegados < 500) {
            total = 240.9 + (dadosTrafegados - 100) * 4.4;
        } else {
            total = 590.9 + (dadosTrafegados - 500) * 5.1;
        }

        return total;
    }


    @Override
    public String toString() {
        return "DespesaComInternet{" +
                "dadosTrafegados=" + dadosTrafegados + '\''+
                ", data=" + getData() + '\''+
                ", descricao=" + getDescricao() + '\''+
                ", total=" + calcularTotal() +
                '}';
    }
}
