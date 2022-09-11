package questao02;

public class q2 {
    static double tabelaProbabilidade[][][] = new double[8][8][100];
    static int base[][][] =new int[8][8][100];


    static double probCavalo(int x, int y, int k){
        if(x < 0 || y < 0 || x >= 8 || y >= 8) return 0;
        if(k == 0) return 1;

        if(base[x][y][k] != 0)
            return tabelaProbabilidade[x][y][k];

        base[x][y][k] = 1;

        int movimentoX[] = {2, 2, -2, -2, 1, 1, -1, -1};
        int movimentoY[] = {1, -1, 1, -1, 2, -2, 2, -2};

        double prob = 0;

        for(int i = 0;i < 8; ++i){
            prob = prob + ((double)1 / (double)8) * probCavalo(x + movimentoX[i], y + movimentoY[i],  k-1);
        }
        tabelaProbabilidade[x][y][k] = prob;

        return prob;
    }

    public static void main(String[] args){
        System.out.println(probCavalo(0,0,1));
    }
}
