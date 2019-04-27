
package busca.tabu.mochila.pkg01;

import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.itens;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.solucao_inicial;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class buscaTabu {
    public buscaTabu(){
        
    }
    /*Função para pegar a linha que atende o criterio de pegar o maior lucro
    sem ultrapassar a capacidade da mochila
     */
    public int linhaEscolhia(int matriz[][], int itens) {
        int maior = BuscaTabuMochila01.lucro_corrente;
        int linha = 0;
        int temp[][];
        //Trata se alguem já for tabu
        matriz = trataValorTabu(matriz);
        for (int i = 0; i < itens; i++) {
            for (int j = 0; j < (itens + 2); j++) {

                if (j == itens) {
                    //System.out.println(""+matriz[i][itens]+">"+maior);
                    if (matriz[i][itens] > maior) {
                        //System.out.println(""+ matriz[i][itens+1] +"<="+BuscaTabuMochila01.cap_max_mochila);
                       if (matriz[i][itens + 1] <= BuscaTabuMochila01.cap_max_mochila) {
                                maior = matriz[i][itens];
                                linha = i;
                            }
                        }
                    }

                }
            }

        //verifica_limite(BuscaTabuMochila01);
        verifica_limite();
        BuscaTabuMochila01.listaTabu.add(maior);
        return linha;
    }
    
    public void solucao_corrente(int matriz[][],int linha) {
        System.out.println(linha);
        for (int i = linha; i <=linha; i++) {
            for (int j = 0; j < BuscaTabuMochila01.solucao_inicial.size(); j++) {
                BuscaTabuMochila01.solucao_corrente.set(i, matriz[i][j]);
            }
        }
        
    }
    public int[][] trataValorTabu(int matriz[][]){
        for (int i = 0; i <itens; i++) {
            for (int j = 0; j < itens+2; j++) {
                if(j==itens){
                    if(isTabu(matriz[i][j])){
                        System.out.println("Tabuuuuuu");
                        matriz[i][j]=0;
                    }
            }
                
            }
        }
        return matriz;
    }
    
    public void verifica_limite (){
        if(BuscaTabuMochila01.listaTabu.size()<=BuscaTabuMochila01.maximo_elementos){
            //return true;
        }else{
            BuscaTabuMochila01.listaTabu.remove(0);
        }
    }
    public boolean isTabu(int maior){
        int i;
        System.out.println("olhaso->"+maior);
        if(BuscaTabuMochila01.listaTabu.size()== 1){
            System.out.println("Lista de->"+BuscaTabuMochila01.listaTabu.get(0));
            if( BuscaTabuMochila01.listaTabu.get(0)==maior){
                return true; 
            }
            return false;
        }else{
            for(i=0; i<BuscaTabuMochila01.maximo_elementos ;i++){
            System.out.println("Lista->"+BuscaTabuMochila01.listaTabu.get(i));
            if( BuscaTabuMochila01.listaTabu.get(i)==maior){
                //System.out.println("TAbu");
                return true;   
            }
        }
            return false;
        }
        
      
    }
    public void exibeTabu(){
        System.out.print("Lista Tabu:->");
            for (int i = 0; i <BuscaTabuMochila01.listaTabu.size() ; i++) {
                System.out.print(BuscaTabuMochila01.listaTabu.get(i));
            }
            System.out.println("");
    }
    
}
