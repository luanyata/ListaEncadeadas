/**
 * Created by luan on 17/09/16.
 */
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista(4);

        lista.inserirNaFente(9);
        lista.inserirNaFente(8);
        lista.inserirNaFente(7);
        lista.inserirNaFente(6);


        for (int elemento : lista.dados) {
            System.out.println("Numero:" + elemento);
        }

        for (int i : lista.proximo) {
            System.out.println("Indice:" + i);
        }
    }
}
