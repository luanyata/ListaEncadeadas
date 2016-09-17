
/**
 * Created by 14201105 on 31/08/16.
 */
public class Lista {

    int[] dados;
    int[] proximo;
    int posicaoPrimeiro;
    int posicaoUltimo;
    int posicaoPrimeiroLivre;
    int tamanhoVetor;
    int cursor;

    int numeroElementos;

    public Lista(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        dados = new int[tamanhoVetor];
        proximo = new int[tamanhoVetor];

        numeroElementos = 0;
        posicaoPrimeiro = -1;
        posicaoUltimo = 0;
        posicaoPrimeiroLivre = 0;
        cursor = 0;
    }

    private void inserirNaFente(int elemento) {
        if (!listaCheia()) {
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoPrimeiroLivre] = posicaoPrimeiro;
            posicaoPrimeiro = posicaoPrimeiroLivre;
            numeroElementos++;
            posicaoPrimeiroLivre++;
        } else {
            System.out.println("Error");
        }
    }

    private void inserirNoFim(int elemento) {
        if (!listaCheia()) {
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoUltimo] = posicaoPrimeiroLivre;
            proximo[posicaoPrimeiroLivre] = -1;
            posicaoUltimo = posicaoPrimeiroLivre;
            numeroElementos++;
            posicaoPrimeiroLivre++;
        } else {
            System.out.println("Error");
        }
    }

    private void inserirDespoisDe(int elemento, int ref) {
        if (!listaCheia() && !listaVazia()) {
            int posicaoAtual = posicaoPrimeiro;
            while (dados[posicaoAtual] != ref) {
                if (posicaoAtual == -1) {
                    System.out.println("Error");
                }
                posicaoAtual = proximo[posicaoAtual];
            }
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoPrimeiroLivre] = proximo[posicaoAtual];
            proximo[posicaoAtual] = posicaoPrimeiroLivre;
            if (posicaoAtual == posicaoUltimo) {
                posicaoUltimo = posicaoPrimeiro;
            }
            numeroElementos++;
            posicaoPrimeiroLivre++;
        } else {
            System.out.println("Error");
        }
    }

    private void inserirAntesDe(int elemento, int ref){
        if (!listaCheia() && !listaVazia()) {
            int posicaoAtual = posicaoPrimeiro;
            while (dados[posicaoAtual] != ref) {
                if (posicaoAtual == -1) {
                    System.out.println("Error");
                }
                posicaoAtual = proximo[posicaoAtual];
            }
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoPrimeiroLivre] = proximo[posicaoAtual-1];

            proximo[posicaoAtual - 1] = posicaoPrimeiroLivre;

            if (posicaoAtual == posicaoUltimo) {
                posicaoUltimo = posicaoPrimeiro;
            }
            numeroElementos++;
            posicaoPrimeiroLivre++;
        } else {
            System.out.println("Error");
        }
    }


    private void excluirElemento(int elemento) {
        if (!listaVazia() && buscarElemento(elemento)) {
            dados[cursor] = -1;
        }
    }

    private void excluirPrimeiroElemento(int elemento) {
        if (!listaVazia() && buscarElemento(elemento)) {
            dados[posicaoPrimeiro] = -1;
            posicaoPrimeiro = proximo[posicaoPrimeiro];
        }
    }

    private void excluirUltimoElemento(int elemento) {
        if (!listaVazia() && buscarElemento(elemento)) {
            dados[posicaoUltimo] = -1;
            posicaoUltimo = proximo[posicaoUltimo - 1];
        }
    }

    private boolean buscarElemento(int elementos) {

        for (int dado : dados)
            if (dado == elementos) {
                cursor = elementos;
                return true;
            }

        return false;
    }

    private boolean listaVazia() {
        return (numeroElementos == tamanhoVetor);
    }


    private boolean listaCheia() {
        return (numeroElementos == 0);
    }
}

