/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.solucao_inicial;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author wandella
 */
public class Vizinhanca extends SolucaoInicial {

    public void exibe_matriz(int m[][]) {
        for (int i = 0; i < BuscaTabuMochila01.solucao_corrente.size(); i++) {
            for (int j = 0; j < BuscaTabuMochila01.solucao_corrente.size() + 2; j++) {
                System.out.print(m[i][j] + " ");
            }

            System.out.println("");
        }

    }

    public int[][] preencheMatriz(int matriz[][]) {
        for (int i = 0; i < BuscaTabuMochila01.solucao_inicial.size(); i++) {
            for (int j = 0; j < BuscaTabuMochila01.solucao_inicial.size(); j++) {
                matriz[i][j] = BuscaTabuMochila01.solucao_corrente.get(j);
            }
        }
        return matriz;
    }

    @SuppressWarnings("empty-statement")
    public void vizinhanca_solucao_inicial(int matriz[][]) {
        Random gerador = new Random();
        int sorteio = 0;
        for (int i = 0; i < BuscaTabuMochila01.solucao_corrente.size(); i++) {
            for (int j = 0; j < BuscaTabuMochila01.solucao_corrente.size() + 2; j++) {
                if (i == j) {
                    //Se o valor matriz for 1 remove ele
                    //senao adiciona
                    if (matriz[i][j] == 1) {
                        matriz[i][j] = 0;
                    } else {
                        matriz[i][j] = 1;
                    }

                }
                //System.out.print(matriz[i][j]+" ");
            }
        }
    }

    public void calculo_custos(int matriz[][]) {
        ArrayList<Integer> auxiliar = new ArrayList();
        
        for (int i = 0; i < BuscaTabuMochila01.solucao_corrente.size(); i++) {
            for (int j = 0; j < BuscaTabuMochila01.solucao_corrente.size() + 2; j++) {
                //System.out.println("solucao inicial = "+solucao_inicial.size());
                if (j < BuscaTabuMochila01.solucao_corrente.size()) {
                    float aux = matriz[i][j];
                    auxiliar.add(matriz[i][j]);
                }
                //Nas duas verificações abaixo, elas chamam uma função para calcular a soma
                //do peso e do lucro
                if (j == BuscaTabuMochila01.solucao_corrente.size()) {
                    //System.out.println("i="+i+"j="+j);
                    matriz[i][j] = Funcao_soma_lucro(auxiliar);
                    //matriz[i][j+1] = Funcao_soma_peso(auxiliar);
                    //System.out.println("To aqui na soma Lucro-"+matriz[i][j]+"\tPeso-"+matriz[i][j]);
                }
                if (j == (BuscaTabuMochila01.solucao_corrente.size()+1)) {
                    //System.out.println("i="+i+"j="+j);
                    // matriz[i][j] = Funcao_soma_lucro(auxiliar);
                    matriz[i][j] = Funcao_soma_peso(auxiliar);
                    //System.out.println("To aqui na soma Lucro-"+matriz[i][j]+"\tPeso-"+matriz[i][j]);
                }

            }
            //Limpa a lista para inserir a nova sequencia.
            auxiliar.clear();
        }
    }
}
