/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.solucao_inicial;
import java.util.ArrayList;
import java.util.Random;

public class SolucaoInicial {

    public void solucaoInicial(int num_itens) {
        //instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();

        //imprime sequência de 10 números inteiros aleatórios
        for (int i = 0; i < num_itens; i++) {
            BuscaTabuMochila01.solucao_inicial.add(gerador.nextInt(2));
            // System.out.println(gerador.nextInt(2));
        }

    }

    public int Funcao_soma_lucro(ArrayList<Integer> solucao) {
        int soma = 0;
        for (int i = 0; i < solucao.size(); i++) {
            //System.out.println("Funçao Lucro - "+BuscaTabuMochila01.lucro.size());
            if (solucao.get(i) == 1) {
                soma = BuscaTabuMochila01.lucro.get(i) + soma;
            }

        }

        return (int) soma;
    }

    public int Funcao_soma_peso(ArrayList<Integer> solucao) {
        float soma = 0;
        for (int i = 0; i < solucao.size(); i++) {
            if (solucao.get(i) == 1) {
                soma = BuscaTabuMochila01.peso.get(i) + soma;
            }

        }

        return (int) soma;
    }
    
    public void solver(){
        
    }
}
