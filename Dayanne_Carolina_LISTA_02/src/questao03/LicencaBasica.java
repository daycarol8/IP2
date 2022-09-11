package questao03;

import java.time.LocalDateTime;

public class LicencaBasica extends Receita{
    int totalContas;

    public LicencaBasica(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        this.totalContas = totalContas;
    }


    @Override
    public double calcularTotal() {
        return totalContas * 20;
    }


    @Override
    public String toString() {
        return "LicencaBasica{" +
                "totalContas=" + totalContas +
                ", data=" + getData() + '\''+
                ", descricao=" + getDescricao() + '\''+
                ", total=" + calcularTotal() +
                '}';
    }

}
