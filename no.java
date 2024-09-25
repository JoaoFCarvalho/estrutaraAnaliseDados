// Classe representando o nó da árvore binária
class NoArvoreBinaria {
    int valor;
    NoArvoreBinaria esquerdo;
    NoArvoreBinaria direito;

    // Construtor para criar um nó
    public NoArvoreBinaria(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }
}

// Classe representando a árvore binária
class ArvoreBinaria {
    private NoArvoreBinaria raiz;

    // Método para inserir um novo nó na árvore
    public void inserirNo(int valor) {
        raiz = inserirNoRecursivo(raiz, valor);
    }

    private NoArvoreBinaria inserirNoRecursivo(NoArvoreBinaria atual, int valor) {
        if (atual == null) {
            return new NoArvoreBinaria(valor);
        }

        if (valor < atual.valor) {
            atual.esquerdo = inserirNoRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserirNoRecursivo(atual.direito, valor);
        }

        return atual;
    }

    // Método para remover um nó da árvore
    public void removerNo(int valor) {
        raiz = removerNoRecursivo(raiz, valor);
    }

    private NoArvoreBinaria removerNoRecursivo(NoArvoreBinaria atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor < atual.valor) {
            atual.esquerdo = removerNoRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = removerNoRecursivo(atual.direito, valor);
        } else {
            // Caso onde o nó a ser removido tem no máximo um filho
            if (atual.esquerdo == null) {
                return atual.direito;
            } else if (atual.direito == null) {
                return atual.esquerdo;
            }

            // Caso onde o nó tem dois filhos
            atual.valor = encontrarMenorValor(atual.direito);
            atual.direito = removerNoRecursivo(atual.direito, atual.valor);
        }

        return atual;
    }

    // Método auxiliar para encontrar o menor valor da subárvore
    private int encontrarMenorValor(NoArvoreBinaria raiz) {
        int menorValor = raiz.valor;
        while (raiz.esquerdo != null) {
            menorValor = raiz.esquerdo.valor;
            raiz = raiz.esquerdo;
        }
        return menorValor;
    }

    // Método para imprimir a árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(NoArvoreBinaria atual) {
        if (atual != null) {
            imprimirEmOrdemRecursivo(atual.esquerdo);
            System.out.print(atual.valor + " ");
            imprimirEmOrdemRecursivo(atual.direito);
        }
    }
}

// Classe principal para testar a árvore binária
public class TestaArvoreBinaria {
    public static void main(String[] args) {
        ArvoreBinaria minhaArvore = new ArvoreBinaria();
        
        // Inserindo nós na árvore
        minhaArvore.inserirNo(50);
        minhaArvore.inserirNo(30);
        minhaArvore.inserirNo(20);
        minhaArvore.inserirNo(40);
        minhaArvore.inserirNo(70);
        minhaArvore.inserirNo(60);
        minhaArvore.inserirNo(80);

        // Imprimindo a árvore em ordem
        System.out.print("Árvore em ordem: ");
        minhaArvore.imprimirEmOrdem();

        // Removendo um nó
        minhaArvore.removerNo(40);
        System.out.print("\nÁrvore após remover 40: ");
        minhaArvore.imprimirEmOrdem();
    }
}
