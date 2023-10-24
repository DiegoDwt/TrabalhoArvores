package arvores;

import java.util.HashSet;
import java.util.Random;

public class Main {
	
    private static final int MILHAO = 1000000;
    private static final int CEM_MIL = 100000;

    public static void main(String[] args) {
    	
        Random random = new Random();
        int[] dadosOrdenados = new int[CEM_MIL];
        int[] dadosAleatorios = new int[CEM_MIL];
        int[] dadosOrdenados2 = new int[MILHAO];
        int[] dadosAleatorios2 = new int[MILHAO];

        // Gera um array de dados ordenados
        for (int i = 0; i < CEM_MIL; i++) {
            dadosOrdenados[i] = i;
        }

        // Gera um array de dados aleatórios
        HashSet<Integer> conjunto = new HashSet<Integer>();

        for (int i = 0; i < CEM_MIL; ) {
            int numero = random.nextInt(CEM_MIL);
            if (!conjunto.contains(numero)) {
                conjunto.add(numero);
                dadosAleatorios[i] = numero;
                i++;
            }
        }


        
        // Gera um array de dados ordenados
        for (int i = 0; i < MILHAO; i++) {
            dadosOrdenados2[i] = i;
        }
        

        // Gera um array de dados aleatórios
        HashSet<Integer> conjunto2 = new HashSet<Integer>();

        for (int i = 0; i < MILHAO; ) {
            int numero = random.nextInt(MILHAO);
            if (!conjunto2.contains(numero)) {
                conjunto2.add(numero);
                dadosAleatorios2[i] = numero;
                i++;
            }
        }
        
        // Cria as árvores
     
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        ArvoreBinaria arvoreBinaria2 = new ArvoreBinaria();
        ArvoreBinaria arvoreBinaria3 = new ArvoreBinaria();
        ArvoreBinaria arvoreBinaria4 = new ArvoreBinaria();
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        ArvoreAVL arvoreAVL2 = new ArvoreAVL();
        ArvoreAVL arvoreAVL3 = new ArvoreAVL();
        ArvoreAVL arvoreAVL4 = new ArvoreAVL();
        ArvoreB arvoreB = new ArvoreB(3);
        ArvoreB arvoreB2 = new ArvoreB(3);
        ArvoreB arvoreB3 = new ArvoreB(3);
        ArvoreB arvoreB4 = new ArvoreB(3);
        ArvoreB arvoreB5 = new ArvoreB(4);
        ArvoreB arvoreB6 = new ArvoreB(4);
        ArvoreB arvoreB7 = new ArvoreB(4);
        ArvoreB arvoreB8 = new ArvoreB(4);
        

      
       // Inserções na ArvoreBinaria
        
        System.out.println("Inserções na Arvore Binária: ");
        System.out.println();
        
        System.out.println("Inserção de vetor Ordenado com 100 mil elementos na Arvore Binária: ");
        arvoreBinaria.inserirVetor(dadosOrdenados);
        System.out.println();                           
        
        System.out.println("Inserção de vetor Aleatório com 100 mil elementos na Arvore Binária: ");
        arvoreBinaria2.inserirVetor(dadosAleatorios);
        System.out.println();                              
        
        System.out.println("Inserção de vetor Ordenado com 1 milhão elementos na Arvore Binária: ");
        arvoreBinaria3.inserirVetor(dadosOrdenados2);
        System.out.println();                                    
        
        System.out.println("Inserção de vetor Aleatório com 1 milhão elementos na Arvore Binária: ");
        arvoreBinaria4.inserirVetor(dadosAleatorios2);
        System.out.println();                                                  
           
        // Inserções na ArvoreAVL
        
        System.out.println("Inserções na Arvore AVL: ");
        System.out.println();
        
        System.out.println("Inserção de vetor Ordenado com 100 mil elementos na ArvoreAVL: ");
        arvoreAVL.inserirVetor(dadosOrdenados);
        System.out.println();                           
        
        System.out.println("Inserção de vetor Aleatório com 100 mil elementos na ArvoreAVL: ");
        arvoreAVL2.inserirVetor(dadosAleatorios);
        System.out.println();                              
        
        System.out.println("Inserção de vetor Ordenado com 1 milhão elementos na ArvoreAVL: ");
        arvoreAVL3.inserirVetor(dadosOrdenados2);
        System.out.println();                            
        
        System.out.println("Inserção de vetor Aleatório com 1 milhão elementos na ArvoreAVL: ");
        arvoreAVL4.inserirVetor(dadosAleatorios2);
        System.out.println();                             
        
                                                                         
        // Inserções na ArvoreB
        
       System.out.println("Inserções na Arvore B (Ordem 3): ");
       System.out.println();                               
        
       System.out.println("Inserção de vetor Ordenado com 100 mil elementos na Arvore B: ");
       arvoreB.inserirVetor(dadosAleatorios);
       System.out.println();                           
              
       System.out.println("Inserção de vetor Aleatório com 100 mil elementos na Arvore B: ");
       arvoreB2.inserirVetor(dadosAleatorios);
       System.out.println();                           
              
       System.out.println("Inserção de vetor Ordenado com 1 milhão elementos na Arvore B: ");
       arvoreB3.inserirVetor(dadosOrdenados2);
       System.out.println();                                  
              
       System.out.println("Inserção de vetor Aleatório com 1 milhão elementos na Arvore B: ");
       arvoreB4.inserirVetor(dadosAleatorios2);
       System.out.println();                                    
        
       System.out.println("Inserções na Arvore B (Ordem 4): ");
       System.out.println();                               
        
       System.out.println("Inserção de vetor Ordenado com 100 mil elementos na Arvore B: ");
       arvoreB5.inserirVetor(dadosAleatorios);
       System.out.println();                           
              
       System.out.println("Inserção de vetor Aleatório com 100 mil elementos na Arvore B: ");
       arvoreB6.inserirVetor(dadosAleatorios);
       System.out.println();                           
              
       System.out.println("Inserção de vetor Ordenado com 1 milhão elementos na Arvore B: ");
       arvoreB7.inserirVetor(dadosOrdenados2);
       System.out.println();                                  
              
       System.out.println("Inserção de vetor Aleatório com 1 milhão elementos na Arvore B: ");
       arvoreB8.inserirVetor(dadosAleatorios2);
       System.out.println();                           
       
        // Busca na ArvoreBinaria
        System.out.println("Busca de chave que não está na Arvore Binária: ");
        System.out.println();       
        
        System.out.println("Busca de chave em Arvore Binária com vetor com 1 milhão de elementos ordenados inserido: ");
        arvoreBinaria3.buscar(1000001);
        System.out.println();             
        
        
        System.out.println("Busca de chave em Arvore Binária com vetor com 1 milhão de elementos aleatórios inserido: ");
        arvoreBinaria4.buscar(1000001);
        System.out.println();               
        
        
        // Busca na ArvoreAVL
        System.out.println("Busca de chave que não está na Arvore AVL: ");
        System.out.println();       
              
        System.out.println("Busca de chave em Arvore AVL com vetor com 1 milhão de elementos ordenados inserido: ");
        arvoreAVL3.buscar(100000001);
        System.out.println();             
              
        System.out.println("Busca de chave em Arvore AVL com vetor com 1 milhão de elementos aleatórios inserido: ");
        arvoreAVL4.buscar(100000001);
        System.out.println();                   
                                                                
        
        // Busca na ArvoreB
        System.out.println("Busca de chave que não está na Arvore B (Ordem 3): ");
        System.out.println();       
                   
        System.out.println("Busca de chave em ArvoreB com vetor com 1 milhão de elementos ordenados inserido: ");
        arvoreB3.buscar(100000001);
        System.out.println();             
                   
        System.out.println("Busca de chave em ArvoreB com vetor com 1 milhão de elementos aleatórios inserido: ");
        arvoreB4.buscar(100000001);
        System.out.println();              
        
        
        System.out.println("Busca de chave que não está na Arvore B (Ordem 4): ");
        System.out.println();       
                   
        System.out.println("Busca de chave em ArvoreB com vetor com 1 milhão de elementos ordenados inserido: ");
        arvoreB7.buscar(100000001);
        System.out.println();             
                   
        System.out.println("Busca de chave em ArvoreB com vetor com 1 milhão de elementos aleatórios inserido: ");
        arvoreB8.buscar(100000001);
        System.out.println();             
      
    
       // Exclusões na ArvoreBinaria
       
        System.out.println("Exclusões na Arvore Binária: ");
        System.out.println();                                      
        
        System.out.println("Exclusão de vetor Ordenado com 100 mil elementos na Arvore Binária: ");
        arvoreBinaria.excluirVetor(dadosOrdenados);
        System.out.println();                           
        
        System.out.println("Exclusão de vetor Aleatório com 100 mil elementos na Arvore Binária: ");
        arvoreBinaria2.excluirVetor(dadosAleatorios);
        System.out.println();                               
        
        System.out.println("Exclusão de vetor Ordenado com 1 milhão elementos na Arvore Binária: ");
        arvoreBinaria3.excluirVetor(dadosOrdenados2);
        System.out.println();                                
        
        System.out.println("Exclusão de vetor Aleatório com 1 milhão elementos na Arvore Binária: ");
        arvoreBinaria4.excluirVetor(dadosAleatorios2);
        System.out.println();                                             
        
        
        // Exclusões na ArvoreAVL
        
        System.out.println("Exclusões na Arvore AVL: ");
        System.out.println();
        
        System.out.println("Exclusão de vetor Ordenado com 100 mil elementos na Arvore AVL: ");
        arvoreAVL.excluirVetor(dadosOrdenados);
        System.out.println();                         
        
        System.out.println("Exclusão de vetor Aleatório com 100 mil elementos na Arvore AVL: ");
        arvoreAVL2.excluirVetor(dadosAleatorios);
        System.out.println();                              
        
        System.out.println("Exclusão de vetor Ordenado com 1 milhão elementos na Arvore AVL: ");
        arvoreAVL3.excluirVetor(dadosOrdenados2);
        System.out.println();                                    
        
        System.out.println("Exclusão de vetor Aleatório com 1 milhão elementos na Arvore AVL: ");
        arvoreAVL4.excluirVetor(dadosAleatorios2);
        System.out.println();                                
                                                                
        
        // Exclusões na ArvoreB
        
        System.out.println("Exclusões na Arvore B (Ordem 3): ");
        System.out.println();                                  
        
        System.out.println("Exclusão de vetor Ordenado com 100 mil elementos na Arvore B: ");
        arvoreB.excluirVetor(dadosOrdenados);
        System.out.println();                            
        
        System.out.println("Exclusão de vetor Aleatório com 100 mil elementos na Arvore B: ");
        arvoreB2.excluirVetor(dadosAleatorios);
        System.out.println();                           
        
        System.out.println("Exclusão de vetor Ordenado com 1 milhão elementos na Arvore B: ");
        arvoreB3.excluirVetor(dadosOrdenados2);
        System.out.println();                                  
        
        System.out.println("Exclusão de vetor Aleatório com 1 milhão elementos na Arvore B: ");
        arvoreB4.excluirVetor(dadosAleatorios2);
        System.out.println();        
        
        System.out.println("Exclusões na Arvore B (Ordem 4): ");
        System.out.println();                                  
        
        System.out.println("Exclusão de vetor Ordenado com 100 mil elementos na Arvore B: ");
        arvoreB5.excluirVetor(dadosOrdenados);
        System.out.println();                            
        
        System.out.println("Exclusão de vetor Aleatório com 100 mil elementos na Arvore B: ");
        arvoreB6.excluirVetor(dadosAleatorios);
        System.out.println();                           
        
        System.out.println("Exclusão de vetor Ordenado com 1 milhão elementos na Arvore B: ");
        arvoreB7.excluirVetor(dadosOrdenados2);
        System.out.println();                                  
        
        System.out.println("Exclusão de vetor Aleatório com 1 milhão elementos na Arvore B: ");
        arvoreB8.excluirVetor(dadosAleatorios2);
        System.out.println();        
                                                                  
      

    }

  
}
