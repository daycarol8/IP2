package questao03;

import java.time.LocalDateTime;

public class DespesaComAgua extends Despesa{
    double totalM3;

    public DespesaComAgua(LocalDateTime data, String descricao, double totalM3) {
        super(data, descricao);
        this.totalM3 = totalM3;
    }

    @Override
    public double calcularTotal() {
        double total = 0;

        if(totalM3 <= 10){
            total+= 45;
        } else if (totalM3 > 10 && totalM3 <=20) {
            total = 45 + (totalM3 - 10) * 5;
        } else{
            total = 45 + (10 * 5) + (totalM3 - 20)*6;
        }

        return total;
    }

    @Override
    public String toString() {
        return "DespesaComAgua{" +
                "totalM3=" + totalM3 + '\''+
                ", data=" + getData() + '\''+
                ", descricao=" + getDescricao() +'\''+
                ", total=" + calcularTotal() +
                '}';
    }
}
