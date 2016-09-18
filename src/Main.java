/**
 * Created by luan on 17/09/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ListaEncadeadaSimples lista = new ListaEncadeadaSimples(5);

        lista.inserirNoFinal(1);
        lista.inserirNoFinal(2);
        lista.inserirNoInicio(3);
        lista.removerPrimeiro();
        lista.removerUltimo();

        for (int elemento : lista.getDados()) {
            System.out.println(elemento);
        }
    }
}
