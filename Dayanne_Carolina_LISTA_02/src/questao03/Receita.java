package questao03;

import java.time.LocalDateTime;

public abstract class Receita implements ITransacao {

    private LocalDateTime data;
    private String descricao;

    public Receita(LocalDateTime data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String getTipo() {
        return "Receita";
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public abstract double calcularTotal();
}
