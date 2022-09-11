package questao03;

import java.time.LocalDateTime;

public abstract class Despesa implements ITransacao {

    private LocalDateTime data;
    private String descricao;

    public Despesa(LocalDateTime data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String getTipo() {
        return "Despesa";
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public abstract double calcularTotal();
}

