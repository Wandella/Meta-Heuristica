/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wandella
 */
public class BuscaTabuMochila01 {
    //Variaveis para leituras vindas do arquivo
     public static ArrayList<Float> lucro = new ArrayList();
     public static ArrayList<Float> peso = new ArrayList();
     public static float cap_max_mochila;
     public static int itens;
     //Variavel para a solucao do problema
     public static ArrayList<Integer> solucao_inicial = new ArrayList();
     
    public static void main(String[] args) {
     //abrindo e lendo arquivo
     LeArquivo novo = new LeArquivo();
     System.out.println(novo.LendoArquivo());
     //Gerando o vetor com a solução inicial
     SolucaoInicial inicio = new SolucaoInicial();
     inicio.solucaoInicial(itens);
     
        
        
        for (int i = 0; i < itens; i++) {
            System.out.print(solucao_inicial.get(i));
           // System.out.println(gerador.nextInt(2));
        }
        System.out.println("");
        
        //Tabela
        //Matriz de vizinhaça
     float ma[][];
         ma = new float[itens][itens+2];
     Vizinhanca vizinhos = new Vizinhanca();
     vizinhos.preencheMatriz(ma);
     vizinhos.exibe_matriz(ma);
     
     //System.out.println("\nLucro Total\t=\t"+inicio.funcao_soma_lucro(solucao_inicial));
        //System.out.println(" "+lucro.size()+" "+peso.size()+" "+cap_max_mochila);
     //System.out.println("\nPeso Total\t=\t"+inicio.funcao_soma_peso(solucao_inicial));
   }
}
