package questao03;

import java.time.LocalDateTime;

public class LicensaPlus extends Receita{
    int totalContas;

    public LicensaPlus(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        this.totalContas = totalContas;
    }


    @Override
    public double calcularTotal() {
        return totalContas * 35;
    }

    @Override
    public String toString() {
        return "LicencaPlus{" +
                "totalContas=" + totalContas +
                ", data=" + getData() + '\''+
                ", descricao=" + getDescricao() + '\''+
                ", total=" + calcularTotal() +
                '}';
    }
}
