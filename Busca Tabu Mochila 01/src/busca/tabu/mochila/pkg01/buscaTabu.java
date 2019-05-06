
package busca.tabu.mochila.pkg01;
import busca.tabu.mochila.pkg01.BuscaTabuMochila01;
import static busca.tabu.mochila.pkg01.BuscaTabuMochila01.solucao_corrente;
import java.util.List;
public class buscaTabu {
    public buscaTabu(){
        
    }
    /*Função para pegar a linha que atende o criterio de pegar o maior lucro
    sem ultrapassar a capacidade da mochila
     */
    public int linhaEscolhia(int matriz[][], int itens) {
        int maior =0;
        int linha = 0;
        int temp[][];
        
        //Trata se alguem já for tabu
        matriz = isTabu(matriz,itens);
        
       
        
        //Percorre a matriz procurando o maior valor da função objetivo
        for (int i = 0; i < itens; i++) {
            for (int j = 0; j < (itens + 2); j++) {

                if (j == itens) {
                    if (matriz[i][itens] > maior) {
                        System.out.println(""+ matriz[i][itens+1] +"<="+BuscaTabuMochila01.cap_max_mochila);
                        if (matriz[i][itens + 1] <= BuscaTabuMochila01.cap_max_mochila) {
                            maior = matriz[i][itens];
                            linha = i;
                        }
                    }
                    
                }
            }
            }
            System.out.println("maior-> " + maior);
            //verifica_limite(BuscaTabuMochila01);
            verifica_limite();
            BuscaTabuMochila01.funcao_objetivo.add(maior);
            BuscaTabuMochila01.melhor_solucao=maior;
            BuscaTabuMochila01.listaTabu.add(linha);//Adiciona como Tabu o movimento
            return linha;
        
    }
    
    public List <Integer> solucao_corrente(int matriz[][],int linha) {
        System.out.println("Da solucao corrente:"+linha);
        for (int i = linha; i <=linha; i++) {
            for (int j = 0; j < BuscaTabuMochila01.solucao_inicial.size(); j++) {
                int teste = matriz[i][j];
                solucao_corrente.set(i, teste);
                
            }
        }
        return solucao_corrente;
    }
    /*public int[][] trataValorTabu(int matriz[][]){
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
    }*/
    
    public void verifica_limite (){
        if(BuscaTabuMochila01.listaTabu.size()<BuscaTabuMochila01.qtd_elementos_tabu){
            //return true;
        }else{
            BuscaTabuMochila01.listaTabu.remove(0);
        }
    }
    public int[][] isTabu(int m[][],int itens){
        int i;
        //System.out.println("olhaso->"+maior);
        /*if(BuscaTabuMochila01.listaTabu.size()== 1){
            System.out.println("Lista de->"+BuscaTabuMochila01.listaTabu.get(0));
            if( BuscaTabuMochila01.listaTabu.get(0)==maior){
                return true; 
            }
            return false;
        }else{*/
           /* for(i=0; i<BuscaTabuMochila01.listaTabu.size() ;i++){
            //System.out.println("Lista->"+BuscaTabuMochila01.listaTabu.get(i));
            if( BuscaTabuMochila01.listaTabu.get(i)==maior){
                //System.out.println("TAbu");
                return true;   
            }
        }
            return false;
        //}*/
           
           
           //Coloca zero na função objetivo por ela ser Tabu
           int coluna=itens;
           for (int j = 0; j < BuscaTabuMochila01.listaTabu.size(); j++) {
               Integer linha = BuscaTabuMochila01.listaTabu.get(j);
                    
                   if(m[linha][linha]!=BuscaTabuMochila01.solucao_corrente.get(linha)){
                        //É um movimento tabu
                       m[linha][coluna]=0;
                       System.out.println("linha->"+linha+"coluna->"+coluna);
                       System.out.println("Valor funcao objetivo tabu->"+m[linha][coluna]);
                   }
                   
               }
        
        
      return m;
    }
    public void exibeTabu(){
        System.out.print("Lista Tabu:->");
            for (int i = 0; i <BuscaTabuMochila01.listaTabu.size() ; i++) {
                System.out.print(BuscaTabuMochila01.listaTabu.get(i));
            }
            System.out.println("");
    }
    
}
