package funcionalJava.src.test.java.br.com.amandaqsena;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.function.Function;

import funcionalJava.src.main.java.br.com.amandaqsena.Transacoes;

public class TestaTransacoes {
/**
 * Desafio do dia
 * Vamos tentar usar:
 * - fiter()
 * - map()
 * - collect()
 * - Collectors.groupingBy()
 * 
 * Agrupar lista de transacoes por categoria e filtrar valores acima de 100
 * 
 * Bonus: valores acima de 100, categorizar como importante
 */
    public static void main(String[] args){
        List<Transacoes> transacoes = Arrays.asList(
        new Transacoes("Compras no mercado", 50.0, "Alimentacao"),
        new Transacoes("Compras em  restaurante", 150.0, "Alimentacao"),
        new Transacoes("Roupas", 75.0, "Vestuario"),
        new Transacoes("Combustivel", 25.0, "Transporte"),
        new Transacoes("Entretenimento", 140.0, "Lazer")
    );

    // pegar apenas os acima de 100

    System.out.println("Mostra acima de 100");
    Predicate<Transacoes> acima100 = (tr) -> tr.getValor() > 100;
    transacoes.stream().filter(transacao -> acima100.test(transacao)).forEach(System.out::println);
    
    System.out.println("-----");
    System.out.println("Mostra agrupados por categoria:");
    System.out.println();
    Map<String, List<Transacoes>> transacoesPorCategoria = transacoes.stream().collect(Collectors.groupingBy(Transacoes::getCategoria));
    transacoesPorCategoria.entrySet().forEach(entry -> {
        System.out.println(entry.getKey() + " " + entry.getValue());
    });

    System.out.println("-----");
    System.out.println("Mostra agrupados por categoria (agrupando maior q 100 como importante):");
    System.out.println();

    Function<Transacoes,Transacoes> reagrupa = (tr) -> {
        if(acima100.test(tr)){
            tr.setCategoria("Importante");
        }
        return tr;
    };

    Map<String, List<Transacoes>> transacoesPorCategoriaImportante =
            transacoes.stream().map(reagrupa)
            .collect(Collectors.groupingBy(Transacoes::getCategoria));

    transacoesPorCategoriaImportante.entrySet().forEach(entry -> {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    });
    
    // Colocando dois argumentos no groupingBy

    Map<String, List<String>> stringDeAgrupamento =
            transacoes.stream().map(reagrupa)
            .collect(Collectors.groupingBy(Transacoes::getCategoria,
            Collectors.mapping(Transacoes::getDescricao, Collectors.toList())));

    stringDeAgrupamento.entrySet().forEach(entry -> {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    });

    List<Integer> lista = Arrays.asList(1,2,3,4,5,6);

    lista.stream()
        .collect(Collectors.groupingBy( n-> n%2==0?"pares":"ímpares"))
        .entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

    lista.stream()
        .collect(Collectors.groupingBy( n-> n%2==0?"pares":"ímpares", 
        Collectors.summingInt(i->i)))
        .entrySet().forEach(entry -> {
            System.out.println("Soma de " + entry.getKey() + " : " 
            + entry.getValue());
        });

    }    
}
