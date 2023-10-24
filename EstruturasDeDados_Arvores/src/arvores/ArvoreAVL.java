package arvores;

import java.util.LinkedList;
import java.util.Queue;


public class ArvoreAVL {
	
	
	
	private class Nodo{
		
		private int dado, altd, alte, ocorrencias;  
		private Nodo dir, esq;
		
		public Nodo(int dado) {
			this.dado = dado;
			dir = esq = null;
			altd = alte = 0;
			ocorrencias = 1;  
		}    
		    
	}
	
	Nodo raiz;
		
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public ArvoreAVL() {
		raiz = null;
	}
	
	void inserirVetor(int vetor[]){
	    long inicio = System.currentTimeMillis();
	    for(int i=0; i<vetor.length; i++){
	        this.raiz = inserirDado(this.raiz, vetor[i]);
	    }
	    long fim = System.currentTimeMillis();
	    double tempo_gasto = (double)(fim - inicio) / 1000;
	    System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
	}

	public void excluirVetor(int[] vetor) {
	    long inicio = System.currentTimeMillis();
	    for (int i = 0; i < vetor.length; i++) {
	        this.raiz = removerNo(this.raiz, vetor[i]);
	    }
	    long fim = System.currentTimeMillis();
	    double tempo_gasto = (double)(fim - inicio) / 1000;
	    System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
	}

	
	public void inserir(int dado) {
		raiz = inserirDado(raiz, dado);
	}
	
	private Nodo inserirDado(Nodo raiz, int dado) {
		if(raiz == null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		if(dado < raiz.dado) {
			raiz.esq = inserirDado(raiz.esq, dado);
			if(raiz.esq.altd > raiz.esq.alte) {
				raiz.alte = raiz.esq.altd + 1;
			} else {
				raiz.alte = raiz.esq.alte + 1;
			}
			raiz = balanceamento(raiz);
		} else if (dado > raiz.dado) {
			raiz.dir = inserirDado(raiz.dir, dado);
			if(raiz.dir.altd > raiz.dir.alte) {
				raiz.altd = raiz.dir.altd + 1;
			} else {
				raiz.altd = raiz.dir.alte + 1;
			}
			raiz = balanceamento(raiz);
		} else {
			raiz.ocorrencias++;   
		}
		return raiz;
	}
	
	public void buscar(int chave) {
	    long inicio = System.currentTimeMillis();
	    if (!buscar(this.raiz, chave)) {
	        System.out.println("A chave " + chave + " nao foi encontrada.");
	    } else {
	        System.out.println("A chave " + chave + " foi encontrada.");
	    }
	    long fim = System.currentTimeMillis();
	    double tempo_gasto = (double)(fim - inicio) / 1000;
	    System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
	}

	private boolean buscar(Nodo raiz, int chave) {
	    if (raiz == null) {
	        return false;
	    } else if (chave < raiz.dado) {
	        return buscar(raiz.esq, chave);
	    } else if (chave > raiz.dado) {
	        return buscar(raiz.dir, chave);
	    } else { // chave == raiz.dado
	        return true;
	    }
	}
	
	private Nodo balanceamento(Nodo raiz) {
	    int fb = (raiz.dir != null ? raiz.dir.altd : 0) - (raiz.esq != null ? raiz.esq.alte : 0);
	    int fbSubArv;
	    if(fb == 2 ) {
	        fbSubArv = (raiz.dir.dir != null ? raiz.dir.dir.altd : 0) - (raiz.dir.esq != null ? raiz.dir.esq.alte : 0);
	        if(fbSubArv >= 0 ) {
	            raiz = rotacao_esquerda(raiz);
	        } else {
	            raiz.dir = rotacao_direita(raiz.dir);
	            raiz = rotacao_esquerda(raiz);
	        }
	    } else if(fb == -2) {
	        fbSubArv = (raiz.esq.dir != null ? raiz.esq.dir.altd : 0) - (raiz.esq.esq != null ? raiz.esq.esq.alte : 0);
	        if(fbSubArv <= 0) {
	            raiz = rotacao_direita(raiz);
	        } else {
	            raiz.esq = rotacao_esquerda(raiz.esq);
	            raiz = rotacao_direita(raiz);
	        }
	    }
	    return raiz;
	}

	
	
	private Nodo rotacao_esquerda(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.dir;
		aux2 = aux1.esq;
		raiz.dir = aux2;
		aux1.esq = raiz;
		if(raiz.dir == null) {
			raiz.altd = 0;
		} else if(raiz.dir.alte > raiz.dir.altd) {
			raiz.altd = raiz.dir.alte + 1;
		} else {
			raiz.altd = raiz.dir.altd + 1;	
		} 
		if(aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte + 1;
		} else {
			aux1.alte = aux1.esq.altd + 1;
		}
		return aux1;
	}
	
	
	private Nodo rotacao_direita(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.esq;
		aux2 = aux1.dir;
		raiz.esq = aux2;
		aux1.dir = raiz;
		if(raiz.esq == null) {
			raiz.alte = 0;
		} else if (raiz.esq.alte > raiz.esq.altd) {
			raiz.alte = raiz.alte + 1;
		} else {
			raiz.alte = raiz.esq.altd + 1;
		}
		if(aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte + 1;
		} else {
			aux1.altd = aux1.dir.altd + 1;
		}
		return aux1;
	}
	

	public void mostrarEmOrdem() {
		mostrandoOrdenado(raiz);
	}
	
	public void mostrandoOrdenado(Nodo raiz) {
		if(raiz != null) {
			mostrandoOrdenado(raiz.esq);
			System.out.println(raiz.dado + " (Ocorrências:" + raiz.ocorrencias + ")");  
			mostrandoOrdenado(raiz.dir);
		}
	}

	public void mostrarPorNivel() {
	    if(raiz == null) {
	        System.out.println("Árvore vazia!");
	        return;
	    }
	    Queue<Nodo> fila = new LinkedList<>();
	    fila.add(raiz);
	    
	    while(!fila.isEmpty()) {
	        int tamanhoNivel = fila.size();
	        for(int i = 0; i < tamanhoNivel; i++) {
	            Nodo nodoAtual = fila.poll();
	            if(nodoAtual != null) {
	                System.out.print(nodoAtual.dado + " ");
	                if(nodoAtual.esq != null) {
	                    fila.add(nodoAtual.esq);
	                } else {
	                    fila.add(null);
	                }
	                if(nodoAtual.dir != null) {
	                    fila.add(nodoAtual.dir);
	                } else {
	                    fila.add(null);
	                }
	            } else {
	                System.out.print("- ");
	            }
	        }
	        System.out.println();
	    }
	}
	
	public void remover(int valor) {               
	    raiz = removerNo(raiz, valor);
	}

	private Nodo removerNo(Nodo raiz, int valor) {
	    if (raiz == null) {
	        return raiz;
	    }

	    if (valor < raiz.dado) {
	        raiz.esq = removerNo(raiz.esq, valor);
	    } else if (valor > raiz.dado) {
	        raiz.dir = removerNo(raiz.dir, valor);
	    } else {
	        // Nó a ser deletado foi encontrado

	        // Caso 1: Nó não tem filhos ou tem apenas um filho
	        if (raiz.esq == null || raiz.dir == null) {
	            Nodo filho = (raiz.esq != null) ? raiz.esq : raiz.dir;
	            if (filho == null) {
	                // Nó não tem filhos
	                raiz = null;
	            } else {
	                // Nó tem um filho
	                raiz = filho;
	            }
	        } else {
	            // Caso 2: Nó tem dois filhos
	            Nodo sucessor = getSuccessor(raiz.dir);
	            raiz.dado = sucessor.dado;
	            raiz.ocorrencias = sucessor.ocorrencias;       
	            raiz.dir = removerNo(raiz.dir, sucessor.dado);
	        }
	    }

	    // Atualiza as alturas e realiza rotações
	    if (raiz != null) {
	        raiz = balanceamento(raiz);
	    }
	    return raiz;
	}

	private Nodo getSuccessor(Nodo node) {
	    Nodo current = node;
	    while (current.esq != null) {
	        current = current.esq;
	    }
	    return current;
	}
	
  
	   
}
