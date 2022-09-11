package questao02;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente extends Pessoa {
    private long codigo;

    public Cliente(String nome, LocalDate dataNascimento, long codigo) {
        super(nome, dataNascimento);
        this.codigo = codigo;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return codigo == cliente.codigo;
    }

}
