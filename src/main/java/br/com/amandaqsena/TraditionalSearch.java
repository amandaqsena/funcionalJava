package funcionalJava.src.main.java.br.com.amandaqsena;

import java.util.ArrayList;
import java.util.List;

public class TraditionalSearch {
    public static void main(String[] args) {

        // lista de animais
        List<Animal> animais = new ArrayList<Animal>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));
        animais.add(new Animal("tartaruga", false, true));

        // imprime os animais verificados
        imprimir(animais, new VerificaSeSaltador());

        // ALTERNATIVA
        // podemos usar a sintaxe completa ou reduzida, nesse caso, estamos usando a reduzida
        imprimir(animais, animal -> animal.podeSaltar());

        // imprime os animais que podem nadar  
        imprimir(animais, animal -> animal.podeNadar());

    }
    private static void imprimir(List<Animal> animais, Verificador verificador) {
        for (Animal animal : animais) {
            // verificando
            if (verificador.verificar(animal)) {
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }
}
