/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.tabu.mochila.pkg01;


import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.solucao_inicial;

/**
 *
 * @author wandella
 */
public class Vizinhanca {
    
    public void exibe_matriz(float m[][]){
        for (int i = 0; i < solucao_inicial.size(); i++) {
            for (int j = 0; j < solucao_inicial.size(); j++) {
                System.out.print(m[i][j]+" ");
            }
            
            System.out.println("");
        }
                
    }
    
    public void preencheMatriz(float matriz[][]){
        
        for (int i = 0; i < solucao_inicial.size(); i++) {
            for (int j = 0; j < solucao_inicial.size(); j++) {
                matriz[i][j]=solucao_inicial.get(j);
            }
        }
       // return matriz;
    }
}
