
/**
 * Created by 14201105 on 31/08/16.
 */
public class Lista {

    int[] dados;
    int[] proximo;
    int[] espacoLivre;
    int posicaoPrimeiro;
    int posicaoUltimo;
    int posicaoPrimeiroLivre;
    int tamanhoVetor;
    int apontador;

    int numeroElementos;

    public Lista(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        dados = new int[tamanhoVetor];
        proximo = new int[tamanhoVetor];
        espacoLivre = new int[tamanhoVetor];

        numeroElementos = 0;
        posicaoPrimeiro = -1;
        posicaoUltimo = 0;
        posicaoPrimeiroLivre = 0;
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

    private void excluirElemento(int elemento) {
        for (int item : dados) {
            if (item == elemento) {

            }
        }
    }

    private boolean buscarElemento(int elementos) {
        for (int dado : dados)
            if (dado == elementos) {
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

