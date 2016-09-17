
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

    public void inserirNaFente(int elemento) {
        if (listaVazia()) {
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoPrimeiroLivre] = -1;
            posicaoUltimo = proximo[posicaoPrimeiroLivre];

        } else if (!listaCheia()) {
            dados[posicaoPrimeiroLivre] = elemento;

            proximo[posicaoPrimeiroLivre] = posicaoPrimeiro;

        } else {
            System.out.println("Error");
        }
        posicaoPrimeiroLivre++;
        posicaoPrimeiro++;
        numeroElementos++;
    }

    public void inserirNoFim(int elemento) {
        if (listaVazia()) {
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoPrimeiroLivre] = -1;
        } else if (!listaCheia()) {
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

    public void inserirNaPosicao(int posicao, int elemento) {
        if (!listaCheia() && !listaVazia()) {
            int posicaoAtual = posicaoPrimeiro;

            while (proximo[posicaoAtual] != posicao) {
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

    public void inserirDespoisDe(int elemento, int ref) {
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

    public void inserirAntesDe(int elemento, int ref) {
        if (!listaCheia() && !listaVazia()) {
            int posicaoAtual = posicaoPrimeiro;
            while (dados[posicaoAtual] != ref) {
                if (posicaoAtual == -1) {
                    System.out.println("Error");
                }
                posicaoAtual = proximo[posicaoAtual];
            }
            dados[posicaoPrimeiroLivre] = elemento;
            proximo[posicaoPrimeiroLivre] = proximo[posicaoAtual - 1];
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


    public void excluirElemento(int elemento) {
        if (!listaVazia() && buscarElemento(elemento)) {
            dados[cursor] = -1;
        }
    }

    public void excluirPrimeiroElemento(int elemento) {
        if (!listaVazia() && buscarElemento(elemento)) {
            dados[posicaoPrimeiro] = -1;
            posicaoPrimeiro = proximo[posicaoPrimeiro];
        }
    }

    public void excluirUltimoElemento(int elemento) {
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

    private boolean listaCheia() {
        return (numeroElementos == tamanhoVetor);
    }


    private boolean listaVazia() {
        return (numeroElementos == 0);
    }
}

