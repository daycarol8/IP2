package questao03;

import java.time.LocalDateTime;

public class DespesaComEnergia extends Despesa{
    double kWh;

    public DespesaComEnergia(LocalDateTime data, String descricao, double kWh) {
        super(data, descricao);
        this.kWh = kWh;
    }

    @Override
    public double calcularTotal() {
        double total = 0.5 * kWh + (Math.ceil(kWh/100)*1.2);
        if(kWh <= 50){
            total+= 2;
        } else if (kWh> 50 && kWh <=200) {
            total+= 15;
        } else{
            total+=35;
        }
        return total;

    }

    @Override
    public String toString() {
        return "DespesaComEnergia{" +
                "kWh=" + kWh + '\''+
                ", data=" + getData() + '\''+
                ", descricao=" + getDescricao() + '\''+
                ", total=" + calcularTotal() +
                '}';
    }
}
