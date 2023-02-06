package funcionalJava.src.test.java.br.com.amandaqsena;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import funcionalJava.src.main.java.br.com.amandaqsena.Pessoa;
/**
 * Dado uma lista de pessoas, 
 * filtre todas as pessoas que são adultas
 * e ordene por seu nome em ordem crescente.
 * Se o nome for igual, organize por idade em ordem crescente
 */
public class TestaPessoa {
    public static void main(String[] args){
        List<Pessoa> pessoal = List.of(
                new Pessoa("Zé", 95),
                new Pessoa("Amanda", 25),
                new Pessoa("Enzo", 5),
                new Pessoa("Valentina", 10),
                new Pessoa("Calebe", 19),
                new Pessoa("Calebe", 22),
                new Pessoa("Calebe", 18)
        );
        List<Pessoa> adultosOrdenados = pessoal.stream().filter(it -> it.getIdade() >= 18).
            sorted(Comparator.comparing(Pessoa::getNome).
            thenComparing(Comparator.comparingInt(Pessoa::getIdade))).
            collect(Collectors.toList());
        
        adultosOrdenados.forEach(System.out::println);
    }
}
