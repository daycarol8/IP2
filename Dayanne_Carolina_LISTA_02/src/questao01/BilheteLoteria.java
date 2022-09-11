package questao01;
import java.util.Arrays;
import java.util.Random;


public class BilheteLoteria {
    int[] numeros;


    public BilheteLoteria(int tamanho) {
        if(tamanho >= 6 && tamanho <= 15){
            Random gerador = new Random();
            this.numeros =  new int[tamanho];

            for(int i = 0; i < tamanho;){
                boolean diferente = true;
                int randomNumber = gerador.nextInt(60) + 1;
                for(int j = 0; j < i; j++){
                    if(randomNumber == numeros[j]){
                        diferente = false;
                    }
                }
                if(diferente){
                    numeros[i] = randomNumber;
                    i++;
                }
            }
            Arrays.sort(numeros);
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(numeros);
    }

    public int qtdNumerosContidos(BilheteLoteria outro){
        int contador = 0;
        for(int i = 0; i < outro.numeros.length; i++){
            for(int j = 0; j< this.numeros.length; j++){
                if(outro.numeros[i] == this.numeros[j]){
                    contador++;
                }
            }
        }

        return contador;
    }

}
