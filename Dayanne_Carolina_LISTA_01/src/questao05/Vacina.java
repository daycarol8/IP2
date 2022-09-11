package questao05;

public class Vacina {
    private int codigo;
    private String nome;
    private String lote;

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        if(nome.equals("CORONAVAC") || nome.equals("OXFORD")){
            this.nome = nome;
        }

    }

    public String getLote(){
        return lote;
    }

    public void setLote(String lote){
        this.lote = lote;
    }


}
