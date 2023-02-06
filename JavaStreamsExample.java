package funcionalJava;

import java.util.function.Function;

public class JavaStreamsExample {
    /**
     * Continuação Programação Funcional - Streams e Lambda
     * 
     * - classe Function
     * - classe Supplier
     * 
     * - Introdução  a Streams
     * - .map()
     */

     public static void main(String[] args){
        // retomando predicate
        Predicate<String> stringPredicate = (s) -> s.length() > 0;

        // especificar o que ele recebe e o tipo de retorno
        Function<String,String> teste = (str) -> str.toUpperCase();

        System.out.println(teste.apply("amanda"));
     }
}
