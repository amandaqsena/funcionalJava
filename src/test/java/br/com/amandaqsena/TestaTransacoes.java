package funcionalJava.src.test.java.br.com.amandaqsena;

import java.util.Arrays;
import java.util.List;

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
 * Agrupar lista de transacoes
 * por categoria e filtrar valores acima de 100
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
    transacoes.stream().filter(transacao -> transacao.getValor() > 100).forEach(System.out::println);
    }
    
    
}
