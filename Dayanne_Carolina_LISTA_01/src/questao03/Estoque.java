package questao03;

public class Estoque {
    private Produto produto;
    private int qtdAtual;
    private int qtdMinima;

    public Estoque(){
        produto = new Produto();
        qtdAtual = 0;
        qtdMinima = 0;
    };

    public Estoque(Produto produto, int qtdAtual, int qtdMinima){
        this.produto = produto;
        this.qtdAtual = qtdAtual;
        this.qtdMinima = qtdMinima;
    }

    public void mudarQtdMinima(int qtdMinima){
        this.qtdMinima = qtdMinima;
    }

    public void reporEstoque(int qtd){
        this.qtdAtual += qtd;
    }

    public void darBaixa(int qtd){
        this.qtdAtual -= qtd;
    }

    public void relatorio(){
        System.out.println(String.format("O produto %s tem uma quantidade mínima de %d e sua quantidade atual de %d", produto.getNome(), qtdMinima, qtdAtual));
    }

}
