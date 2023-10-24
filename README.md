# TrabalhoArvores
Estruturas de Dados II - Ciência da Computação

O objetivo deste trabalho é comparar o desempenho de árvores B, AVL e binária de busca na
execução de 100 mil e 1 milhão de inserções e exclusões. O trabalho também deve conter um
comparativo entre as árvores na busca de uma chave que não está na árvore, mas que seja maior
que a maior chave da árvore.

Tarefa 1: Implementação da árvore B
A primeira tarefa do trabalho é implementar a árvore B com, no mínimo os métodos de inserção,
remoção e busca.

Tarefa 2: Comparativo de desempenho para inserção e remoção
A segunda tarefa do trabalho é realizar um comparativo de desempenho entre as três árvores.
Para isso, devem ser gerados conjuntos de dados de 100 mil e 1 milhão de elementos. Os
conjuntos de dados devem ser inseridos e excluídos das árvores B, AVL e binária de busca. O
tempo de execução de cada operação deve ser medido e registrado. Deverá ser analisado o
desempenho com os dados sendo inseridos de forma ordenada e aleatória.

Tarefa 3: Comparativo de busca
A terceira tarefa do trabalho é realizar um comparativo de desempenho entre as três árvores na
busca de uma chave que não está na árvore, mas que seja maior que a maior chave da árvore.
Para isso, deve ser gerado um conjunto de dados aleatórios de 1 milhão de elementos. O
conjunto de dados deve ser inserido na árvore B, AVL e binária de busca. Em seguida, deve ser
feita uma busca por uma chave que seja maior que a maior chave da árvore. O tempo de
execução da busca deve ser medido e registrado. Deverá ser analisado o desempenho com os
dados sendo inseridos de forma ordenada e aleatória.

Comentários adicionais:
a) Chaves repetidas não são permitidas. A metodologia deve garantir que o número de
chaves inseridas seja igual ao solicitado, sem repetições.
b) A árvore B deve ser testada com diferentes ordens. O objetivo é verificar se o número
máximo/mínimo de chaves em um nó afeta o desempenho da árvore nas operações
solicitadas.
c) A recursividade pode falhar em testes com grandes conjuntos de dados. Neste caso, o
método deve ser adaptado para não recursivo.
