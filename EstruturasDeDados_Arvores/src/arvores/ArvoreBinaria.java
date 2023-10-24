package arvores;

	
	public class ArvoreBinaria {
		
		private class Nodo{
			private int chave;
			private Nodo dir, esq;
			
			public Nodo(int item) {
				this.chave = item;
				dir = esq = null;
			}
		}
		
		Nodo raiz = null;
		
		
		public void inserirVetor(int[] vetor) {
		    long inicio = System.currentTimeMillis();
		    for(int i = 0; i < vetor.length; i++) {
		        inserir(vetor[i]);
		    }
		    long fim = System.currentTimeMillis();
		    double tempo_gasto = (double)(fim - inicio) / 1000;
		    System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
		}

		
		public void inserir(int chave) {
			raiz = inserirDado(raiz, chave);
		}

		
  /*		private Nodo inserirDado(Nodo raiz, int chave) {           // Recursiva
		    if (raiz == null) {
		        return new Nodo(chave);
		    }
		    
		    if(chave < raiz.chave) {
		        if (raiz.esq == null) {
		            raiz.esq = new Nodo(chave);
		        } else {
		            raiz.esq = inserirDado(raiz.esq, chave);
		        }
		    } else if(chave > raiz.chave) {
		        if (raiz.dir == null) {
		            raiz.dir = new Nodo(chave);
		        } else {
		            raiz.dir = inserirDado(raiz.dir, chave);
		        }
		    }
		    
		    return raiz;
		}                                         */
		

		private Nodo inserirDado(Nodo raiz, int chave) {       // Iterativa
		    Nodo novoNodo = new Nodo(chave);
		    
		    if (raiz == null) {
		        return novoNodo;
		    }
		    
		    Nodo atual = raiz;
		    Nodo anterior = null;
		    
		    while (atual != null) {
		        anterior = atual;
		        if (chave < atual.chave) {
		            atual = atual.esq;
		        } else if (chave > atual.chave) {
		            atual = atual.dir;
		        } else {
		            // Chave já existe, retornar a raiz
		            return raiz;
		        }
		    }
		    
		    if (chave < anterior.chave) {
		        anterior.esq = novoNodo;
		    } else {
		        anterior.dir = novoNodo;
		    }
		    
		    return raiz;
		}                                    
		

		public void excluirVetor(int[] vetor) {
		    long inicio = System.currentTimeMillis();
		    for (int i = 0; i < vetor.length; i++) {
		        remover(vetor[i]);
		    }
		    long fim = System.currentTimeMillis();
		    double tempo_gasto = (double)(fim - inicio) / 1000;
		    System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
		}



		public boolean buscar(int chave) {
		    long inicio = System.currentTimeMillis();
		    Nodo resultado = buscarIterativamente(chave);
		    long fim = System.currentTimeMillis();
		    double tempo_gasto = (double)(fim - inicio) / 1000;

		    if(resultado == null) {
		        System.out.println("A chave " + chave + " não foi encontrada na árvore. Tempo de operacao: " + tempo_gasto + " segundos");
		        return false;
		    } else {
		        System.out.println("A chave " + chave + " foi encontrada na árvore. Tempo de operacao: " + tempo_gasto + " segundos");
		        return true;
		    }
		}

		private Nodo buscarIterativamente(int chave) {
		    Nodo atual = raiz;
		    
		    while (atual != null) {
		        if (chave < atual.chave) {
		            atual = atual.esq;
		        } else if (chave > atual.chave) {
		            atual = atual.dir;
		        } else {
		            return atual; // chave encontrada
		        }
		    }
		    
		    return null; // chave não encontrada
		}


		
		public void mostrarEmOrdem() {
			mostrarCrescente(raiz);
		}
		
		private void mostrarCrescente(Nodo raiz) {
			if(raiz != null) {
				mostrarCrescente(raiz.esq);
				System.out.println(raiz.chave);
				mostrarCrescente(raiz.dir);
			}
		}
		
		
		
		public void remover(int chave) {
			raiz = removerItem(raiz, chave);
		}
		
		private Nodo removerItem(Nodo raiz, int chave) {
			if(raiz == null) {       // Nó não encontrado, não faz nada
				return null;
			}
			if(chave < raiz.chave) {
				raiz.esq = removerItem(raiz.esq, chave);    // chave a ser removida está à esquerda
			} else if(chave > raiz.chave) {
				raiz.dir = removerItem(raiz.dir, chave);    // chave a ser removida está à direita
			} else {             // encontramos o nó a ser removido
				if(raiz.esq == null) {       // Caso em que o nó não possui filho a esquerda
					return raiz.dir;
				} else if(raiz.dir == null){    // Caso em que o nó não possui filho a direita
					return raiz.esq;
				} else {          // Caso em que o nó possui ambos os filhos, sucessor será o menor da subarvore a direita
					Nodo sucessor = encontrarSucessor(raiz.dir);
					raiz.chave = sucessor.chave;     // substituimos o valor do nó a ser removido pelo valor do sucessor
					raiz.dir = removerItem(raiz.dir, sucessor.chave);
				}
			}
			return raiz;
		}
		
		private Nodo encontrarSucessor(Nodo nodo) {
			while(nodo.esq != null) {
				nodo = nodo.esq;
			}
			return nodo;
		}
			
	}