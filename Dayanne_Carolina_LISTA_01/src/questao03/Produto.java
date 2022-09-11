package questao03;

public class Produto {
    private int codigo;
    private String nome;

    public Produto(){
        codigo = 0;
        nome = "";
    }

    public Produto(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public void mudarNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
