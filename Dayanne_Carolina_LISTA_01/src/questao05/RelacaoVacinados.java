package questao05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RelacaoVacinados {
    private RegistroVacina[] vacinados = new RegistroVacina[1000];

    static int contador = 0;
    private int vacinado1dose = 0;
    private int vacinado2dose = 0;

    public RegistroVacina[] getVacinados() {
        return vacinados;
    }

    public void setVacinados(RegistroVacina[] vacinados) {
        this.vacinados = vacinados;
    }

    public int getVacinado1dose() {
        return vacinado1dose;
    }

    public int getVacinado2dose() {
        return vacinado2dose;
    }

    public void adicionar(RegistroVacina registro){
        vacinados[contador] = registro;
        contador++;
    }

    public double calcularTotalVacinadosAcimaDe(int idade){
        double vacinadosAcimaDe = 0;
        for(int i = 0; i < contador; i++){
            if(vacinados[i].getDose() != 2 && vacinados[i].getVacinado().calcularIdade() > idade){
                vacinadosAcimaDe++;
            }
        }
        return vacinadosAcimaDe;
    }

    public void listarPessoasQueNãoTomaram2aDose(){
        for (int j = 0; j < vacinados.length; j++) {
            if(vacinados[j] != null){
                if(vacinados[j].getDose() != 2) {
                    LocalDate data = vacinados[j].getData_vacinacao().plusDays(21);
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                    String dataParaProximaDose = formatador.format(data);

                    System.out.printf("%-10s| %-20s| %5d |%15s%n", vacinados[j].getVacinado().getCpf(),
                            vacinados[j].getVacinado().getNome(), vacinados[j].getVacinado().calcularIdade(),
                            dataParaProximaDose);

                    vacinado1dose++;
                } else{
                    vacinado1dose--;
                    vacinado2dose++;
                }
            }

        }
    }

    public void totalDeIdososQueTomaram2aDose(){

    }
}
