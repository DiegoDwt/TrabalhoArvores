package arvores;

	class Nodo {
		
	    int[] chaves;
	    int t;
	    Nodo[] filhos;
	    int n;
	    boolean folha;
	
	    Nodo(int t, boolean folha) {
	        this.t = t;
	        this.folha = folha;
	        chaves = new int[2*t-1];
	        filhos = new Nodo[2*t];
	        n = 0;
	    }
	}

	class ArvoreB {
	    Nodo raiz;
	    int t;
	
	    ArvoreB(int t) {
	        this.t = t;
	    }
	        
	    
	    Nodo inserirNodo(Nodo nodo, int chave) {
	        int i = 0;
	        if (nodo == null) {
	            nodo = new Nodo(t, true);
	            nodo.chaves[0] = chave;
	            nodo.n = 1;
	        } else {
	            for (i = nodo.n-1; i >= 0; i--) {
	                if (chave < nodo.chaves[i])
	                    break;
	            }
	            if (nodo.folha) 
	                if (i + 2 < nodo.chaves.length && nodo.n - i - 1 <= nodo.chaves.length - (i + 2)) {
	                    System.arraycopy(nodo.chaves, i+1, nodo.chaves, i+2, nodo.n - i - 1);
	                } else if (i + 1 < nodo.chaves.length) {
	                    nodo.chaves[i+1] = chave;
	                    nodo.n = nodo.n + 1;
	                } else {
		                int pos = i + 1;
		                if (nodo.filhos[pos] == null) {
		                    nodo.filhos[pos] = new Nodo(t, true);
		                }
		                nodo = inserirNodo(nodo.filhos[pos], chave);
		                if (nodo.n == 2*t) {
		                    return dividirNodo(nodo, i);
		                }
	                }
	        }
	        return nodo;
	    }

	    public void excluirVetor(int[] vetor) {
	        long inicio = System.currentTimeMillis();
	        for (int i = 0; i < vetor.length; i++) {
	            excluir(vetor[i]);
	        }
	        long fim = System.currentTimeMillis();
	        double tempo_gasto = (double)(fim - inicio) / 1000;
	        System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
	    }

	    private void excluir(int chave) {
	        if (raiz == null) {
	            return;
	        }
	        excluirChave(raiz, chave);
	    }

	    private void excluirChave(Nodo nodo, int chave) {
	        int i = 0;
	        while (i < nodo.n) {
	            if (chave == nodo.chaves[i]) {
	                // Mova todas as chaves e filhos para a esquerda
	                for (int j = i; j < nodo.n - 1; j++) {
	                    nodo.chaves[j] = nodo.chaves[j + 1];
	                    if (!nodo.folha) {
	                        nodo.filhos[j + 1] = nodo.filhos[j + 2];
	                    }
	                }
	                // Ajuste o número de chaves
	                nodo.n = nodo.n - 1;
	                return;
	            }
	            i++;
	        }
	        if (nodo.folha) {
	            return;
	        }
	        for (i = 0; i < nodo.n; i++) {
	            if (chave < nodo.chaves[i]) {
	                excluirChave(nodo.filhos[i], chave);
	                return;
	            }
	        }
	        excluirChave(nodo.filhos[nodo.n], chave);
	    }


	    
	    public void inserirVetor(int[] vetor) {
	        long inicio = System.currentTimeMillis();
	        for (int i = 0; i < vetor.length; i++) {
	            if (raiz == null) {
	                raiz = new Nodo(t, true);
	                raiz.chaves[0] = vetor[i];
	                raiz.n = 1;
	            } else {
	                raiz = inserirNodo(raiz, vetor[i]);
	            }
	        }
	        long fim = System.currentTimeMillis();
	        double tempo_gasto = (double)(fim - inicio) / 1000;
	        System.out.println("Tempo de operacao: " + tempo_gasto + " segundos");
	    }

	    Nodo dividirNodo(Nodo nodo, int i) {
	        Nodo novoNodo = new Nodo(t, nodo.folha);
	        novoNodo.n = t - 1;
	        System.arraycopy(nodo.chaves, i+1, novoNodo.chaves, 0, novoNodo.chaves.length);
	        if (!nodo.folha) {
	            System.arraycopy(nodo.filhos, i+1, novoNodo.filhos, 0, novoNodo.filhos.length);
	        }
	        nodo.n = i + 1;
	        for (int j = nodo.n; j < 2*t-1; j++) {
	            nodo.filhos[j] = null;
	        }
	        for (int j = nodo.n-1; j >= i+1; j--) {
	            nodo.chaves[j] = 0;
	            if (!nodo.folha) {
	                nodo.filhos[j+1] = null;
	            }
	        }
	        return novoNodo;
	    }
	
	    public void buscar(int chave) {
	        long inicio = System.currentTimeMillis();
	        int resultado = buscar(raiz, chave);
	        long fim = System.currentTimeMillis();
	        double tempo_gasto = (double)(fim - inicio) / 1000;
	        if (resultado == -1) {
	            System.out.println("Chave não encontrada na árvoreB.");
	        } else {
	            System.out.println("Chave encontrada na árvoreB.");
	        }
	        System.out.println("Tempo de operação: " + tempo_gasto + " segundos");
	    }

	    private int buscar(Nodo nodo, int chave) {
	        int i = 0;
	        while (i < nodo.n) {
	            if (chave == nodo.chaves[i]) {
	                return chave;
	            }
	            i++;
	        }
	        if (nodo.folha) {
	            return -1;
	        }
	        for (i = 0; i < nodo.n; i++) {
	            if (chave < nodo.chaves[i]) {
	                return buscar(nodo.filhos[i], chave);
	            }
	        }
	        return buscar(nodo.filhos[nodo.n], chave);
	    }

	    
	}
