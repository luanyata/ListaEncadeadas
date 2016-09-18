import Exceptions.ListaCheiaException;
import Exceptions.ListaVaziaException;

/**
 * Created by 14201105 on 31/08/16.
 */
public class ListaEncadeadaSimples {

    private int dados[];
    private int proximo[];
    private int posicaoPrimeiro;
    private int posicaoUltimo;
    private int posicaoPrimeiroLivre;
    private int numeroElementos;
    private int tamanhoVetor;

    public ListaEncadeadaSimples(int tamanhoVetor) {
        this.tamanhoVetor = tamanhoVetor;
        dados = new int[tamanhoVetor];
        proximo = new int[tamanhoVetor];

        popularArrayProximo();

        posicaoPrimeiro = -1;
        posicaoUltimo = -1;
        posicaoPrimeiroLivre = 0;
        numeroElementos = 0;

    }

    //region Utils
    private void popularArrayProximo() {
        for (int i = 0; i < tamanhoVetor; i++)
            proximo[i] = i + 1;

        proximo[tamanhoVetor - 1] = -1;
    }

    public int[] getDados() {
        return dados;
    }

//endregion

    //region Inserção
    public void inserirNoInicio(int elemento) throws ListaCheiaException {

        if (listaCheia())
            throw new ListaCheiaException("Lista Cheia");

        int tempPrimeiroOcupado = posicaoPrimeiro;
        posicaoPrimeiro = proximo[posicaoUltimo];
        proximo[posicaoUltimo] = proximo[posicaoPrimeiroLivre];
        proximo[posicaoPrimeiroLivre] = tempPrimeiroOcupado;

        dados[posicaoPrimeiroLivre] = elemento;
        posicaoPrimeiroLivre = proximo[posicaoPrimeiroLivre];

        numeroElementos++;
    }

    public void inserirNoFinal(int elemento) throws ListaCheiaException {

        if (listaCheia())
            throw new ListaCheiaException("Lista Cheia");

        if (listaVazia())
            posicaoPrimeiro = posicaoPrimeiroLivre;

        posicaoUltimo = posicaoPrimeiroLivre;
        dados[posicaoPrimeiroLivre] = elemento;
        posicaoPrimeiroLivre = proximo[posicaoPrimeiroLivre];
        numeroElementos++;
    }

    public void inserirNaPosicao(int posicao, int elemento) throws Exception {

        if (listaCheia())
            throw new ListaCheiaException("Lista Cheia");

        if (posicao - 1 < 0 || posicao >= tamanhoVetor)
            throw new Exception("Posição fora dos parâmetros da lista");


        int posicaoProximo = posicaoPrimeiro;

        if (posicao == 0) {
            inserirNoInicio(elemento);

        } else if (posicao == tamanhoVetor - 1 || posicao >= numeroElementos) {
            inserirNoFinal(elemento);

        } else {
            for (int i = 1; i <= tamanhoVetor; i++) {

                if (i == posicao) {
                    int tempPosicaoAnterior = proximo[posicaoProximo];

                    proximo[posicaoProximo] = posicaoPrimeiroLivre;
                    proximo[posicaoUltimo] = proximo[posicaoPrimeiroLivre];
                    proximo[posicaoPrimeiroLivre] = tempPosicaoAnterior;

                    dados[posicaoPrimeiroLivre] = elemento;

                    posicaoPrimeiroLivre = proximo[posicaoPrimeiroLivre];

                    numeroElementos++;

                } else {
                    posicaoProximo = proximo[posicaoProximo];
                }
            }
        }

    }

    public void inserirAntes(int ref, int elemento) throws ListaCheiaException {

        if (listaCheia())
            throw new ListaCheiaException("Lista Cheia");


        int posicaoLista = posicaoPrimeiro;
        int posicaoAnteriorLista = posicaoPrimeiro;


        for (int i = 0; i < numeroElementos; i++) {
            if (dados[posicaoLista] == ref) {

                if (i == 0) {
                    inserirNoInicio(elemento);
                    break;

                } else {
                    int tempPrimeiroLivre = proximo[posicaoPrimeiroLivre];

                    dados[posicaoPrimeiroLivre] = elemento;

                    proximo[posicaoPrimeiroLivre] = proximo[posicaoAnteriorLista];
                    proximo[posicaoAnteriorLista] = proximo[posicaoUltimo];
                    proximo[posicaoUltimo] = tempPrimeiroLivre;

                    posicaoPrimeiroLivre = proximo[posicaoPrimeiroLivre];
                    numeroElementos++;
                    break;

                }

            } else {

                posicaoAnteriorLista = posicaoLista;
                posicaoLista = proximo[posicaoLista];
            }
        }
    }


    public void inserirDepois(int ref, int elemento) throws Exception {

        if (listaCheia())
            throw new ListaCheiaException("Lista Cheia");


        int posicaoLista = posicaoPrimeiro;


        for (int i = 0; i < numeroElementos; i++) {
            if (dados[posicaoLista] == ref) {

                if (i == numeroElementos - 1) {
                    inserirNoFinal(elemento);
                    break;

                } else {
                    int tempPrimeiroLivre = proximo[posicaoPrimeiroLivre];

                    dados[posicaoPrimeiroLivre] = elemento;

                    proximo[posicaoPrimeiroLivre] = proximo[posicaoLista];
                    proximo[posicaoLista] = proximo[posicaoUltimo];
                    proximo[posicaoUltimo] = tempPrimeiroLivre;

                    posicaoPrimeiroLivre = proximo[posicaoPrimeiroLivre];
                    numeroElementos++;
                    break;

                }

            } else {

                posicaoLista = proximo[posicaoLista];
            }
        }

    }
    //endregion

    //region Remover
    public void removerPrimeiro() throws Exception {

        if (listaVazia())
            throw new ListaVaziaException("Lista Vazia");

        int tempPrimeiroLivre = posicaoPrimeiroLivre;
        posicaoPrimeiroLivre = posicaoPrimeiro;
        posicaoPrimeiro = proximo[posicaoPrimeiro];
        proximo[posicaoPrimeiroLivre] = tempPrimeiroLivre;
        proximo[posicaoUltimo] = posicaoPrimeiroLivre;
        numeroElementos--;
    }


    public void removerUltimo() throws Exception {

        if (listaVazia())
            throw new Exception("Lista Vazia");

        posicaoPrimeiroLivre = posicaoUltimo;

        for (int i = 0; i < tamanhoVetor; i++) {
            if (proximo[i] == posicaoUltimo) {

                posicaoUltimo = i;
                numeroElementos--;
            }
        }
    }

    public void removerItem(int elemento) throws Exception {

        if (listaVazia())
            throw new ListaVaziaException("Lista Vazia");

        int posicaoLista = posicaoPrimeiro;
        int posicaoListaAnterior = posicaoPrimeiro;


        for (int i = 0; i < numeroElementos; i++) {
            if (dados[posicaoLista] == elemento) {

                if (i == 0) {
                    removerPrimeiro();

                } else if (i == numeroElementos - 1) {
                    removerUltimo();

                } else {

                    proximo[posicaoUltimo] = proximo[posicaoListaAnterior];
                    proximo[posicaoListaAnterior] = proximo[posicaoLista];
                    proximo[posicaoLista] = posicaoPrimeiroLivre;
                    posicaoPrimeiroLivre = posicaoLista;
                    numeroElementos--;
                    break;

                }

            } else {

                posicaoListaAnterior = posicaoLista;
                posicaoLista = proximo[posicaoLista];
            }
        }

    }
    //endregion

    //region Buscar
    public boolean buscar(int elemento) {

        for (int dado : dados) {
            if (dado == elemento) {
                return true;
            }
        }
        return false;
    }
    //endregion

    //region Verificação estado da lista
    private boolean listaCheia() {
        return numeroElementos == tamanhoVetor;
    }

    private boolean listaVazia() {
        return numeroElementos == 0;
    }
    //endregion
}

