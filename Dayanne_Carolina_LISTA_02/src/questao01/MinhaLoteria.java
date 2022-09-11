package questao01;

import java.util.ArrayList;

public class MinhaLoteria {
    public static void main(String[] args) {
        BilheteLoteria bilhetePremiado = new BilheteLoteria(6);

        for(int i =6; i <= 15; i++){
            int count = 0;
            int quadras = 0;
            int quinas = 0;
            ArrayList<BilheteLoteria> bilhetes = new ArrayList<>();
            boolean megaSena = false;
            while (megaSena != true){
                BilheteLoteria bilheteSorteado = new BilheteLoteria(i);
                //Evitando o uso de arraylist pois da erro de sobrecarga
                //bilhetes.add(bilheteSorteado);
                count++;
                int contador = bilhetePremiado.qtdNumerosContidos(bilheteSorteado);
                switch (contador){
                    case 4:
                        quadras++;
                        break;
                    case 5:
                        quinas++;
                        break;
                    case 6:
                        megaSena = true;
                        break;
                }
            }
            System.out.println("Jogo de " + i + " números: você apostou " +
                    count + " vezes para ganhar na mega-sena. Dentre esses jogos, você acertou "+
                    quadras + "quadras e " + quinas + " quinas."
                    );

        }
    }
}
