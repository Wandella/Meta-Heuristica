/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.cap_max_mochila;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.lucro_inicial;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.peso_inicial;
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
        BuscaTabuMochila01.solucao_corrente=BuscaTabuMochila01.solucao_inicial;
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
    //Verificar se o peso da mochila está menor ou igual a sua capacidade maxima
    public String Verifica_Solucao() {
        int peso = 0;
        solucaoInicial(BuscaTabuMochila01.itens);
        peso = Funcao_soma_peso(solucao_inicial);
        //System.out.println("1->"+peso);
        
            while(peso > BuscaTabuMochila01.cap_max_mochila){
                solucao_inicial.clear();
                solucaoInicial(BuscaTabuMochila01.itens);
                peso = Funcao_soma_peso(solucao_inicial);
                //System.out.println(peso);
            }
        BuscaTabuMochila01.lucro_inicial = Funcao_soma_lucro(solucao_inicial);
        BuscaTabuMochila01.lucro_corrente = BuscaTabuMochila01.lucro_inicial;
        BuscaTabuMochila01.peso_inicial = Funcao_soma_peso(solucao_inicial);
        BuscaTabuMochila01.peso_corrente = BuscaTabuMochila01.peso_inicial;
        BuscaTabuMochila01.melhor_solucao = BuscaTabuMochila01.lucro_inicial;
        //BuscaTabuMochila01.listaTabu.add(BuscaTabuMochila01.lucro_inicial);
        BuscaTabuMochila01.funcao_objetivo.add(BuscaTabuMochila01.lucro_inicial);
        System.out.println("capacidade mochila="+cap_max_mochila);
        System.out.println("Lucro Inicial ="+lucro_inicial);
        System.out.println("Peso inicial="+peso_inicial);
            return "Solucao Valida";
        }
}

