class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivamente(raiz, valor);
    }

    private No inserirRecursivamente(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivamente(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivamente(atual.direita, valor);
        }

        return atual;
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivamente(raiz);
    }

    private void percorrerEmOrdemRecursivamente(No no) {
        if (no != null) {
            percorrerEmOrdemRecursivamente(no.esquerda);
            System.out.print(no.valor + " ");
            percorrerEmOrdemRecursivamente(no.direita);
        }
    }
}

public class Arvore {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserindo valores na árvore
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(1);
        arvore.inserir(4);
        arvore.inserir(6);
        arvore.inserir(9);

        // Listando a árvore em ordem
        System.out.println("árvore em ordem:");
        arvore.percorrerEmOrdem();
    }
}
