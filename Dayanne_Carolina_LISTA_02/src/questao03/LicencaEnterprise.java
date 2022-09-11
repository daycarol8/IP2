package questao03;

import java.time.LocalDateTime;

public class LicencaEnterprise extends Receita{
    int totalContas;

    public LicencaEnterprise(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        this.totalContas = totalContas;
    }


    @Override
    public double calcularTotal() {
        return totalContas * 150;
    }

    @Override
    public String toString() {
        return "LicencaEnterprise{" +
                "totalContas=" + totalContas +
                ", data=" + getData() + '\''+
                ", descricao=" + getDescricao() + '\''+
                ", total=" + calcularTotal() +
                '}';
    }
}
