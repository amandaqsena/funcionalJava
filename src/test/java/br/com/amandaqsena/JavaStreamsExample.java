package funcionalJava.src.test.java.br.com.amandaqsena;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import funcionalJava.src.main.java.br.com.amandaqsena.Pessoa;
import funcionalJava.src.main.java.br.com.amandaqsena.Predicate;

public class JavaStreamsExample {
    /**
     * Continuação Programação Funcional - Streams e Lambda
     * 
     * - classe Function
     * - classe Supplier
     * 
     * - Introdução  a Streams
     * - .map()
     * - são mecanismos de processamentos de dados baseados em fluxos.
     * Permitem manipular dados de forma eficiente e sequencial sem
     * armazená-los em memória.
     * - operações
     * -- intermediárias
     * -- finais
     */

     public static void main(String[] args){
      // retomando predicate
      Predicate<String> stringPredicate = (s) -> s.length() > 0;
      System.out.println(stringPredicate.test("amanda"));

      // especificar o que ele recebe e o tipo de retorno
      Function<String,String> pMaiuscula = (str) -> str.toUpperCase();
      Function<String, String> addPrefixo = (str) -> "prefixo-".concat(str);
        
      // uso do compose (aplica primeiro o de dentro)
      Function<String, String> resultado = addPrefixo.compose(pMaiuscula);
        
      System.out.println(pMaiuscula.apply("amanda"));
      System.out.println(addPrefixo.apply("amanda"));
      System.out.println(resultado.apply("amanda"));

      System.out.println(pMaiuscula.andThen(addPrefixo).apply("amanda"));
        
      // converter para Euro
      // 1 euro = 5.55 BRL
      List<BigDecimal> precos = Arrays.asList(
         new BigDecimal("10"),
         new BigDecimal("20"),
         new BigDecimal("22"),
         new BigDecimal("14")
        );
        
      Function<BigDecimal,BigDecimal> realParaEuro =
         real -> real.divide(new BigDecimal("5.55"), 
                        2, RoundingMode.HALF_UP);
        
      for(BigDecimal real:precos) {
         System.out.println("Preço em Euro = " + realParaEuro.apply(real));
      }

      // outra opção
      precos.stream()
         .map(realParaEuro)
         .forEach(System.out::println);

      Stream<BigDecimal> stream = precos.stream();

      stream.filter(preco -> !preco.equals(BigDecimal.ZERO)).forEach(System.out::println);

      System.out.println("-----");

      precos.forEach(System.out::println);

      List<Pessoa> listPessoa = Arrays.asList(
         new Pessoa("Amanda",25),
         new Pessoa("Bruno",22),
         new Pessoa("Italo", 18),
         new Pessoa("Lucas",17),
         new Pessoa("Natan",26)
      );

      List<String> nomes = listPessoa.stream()
                     .filter(pessoa -> pessoa.getIdade() >20)
                     .map(Pessoa::getNome)
                     .collect(Collectors.toList());

      nomes.forEach(System.out::println);

      // Boa prática no desenvolvimento de aplicações: evitar
      // que objetos da camada de entidade se comuniquem com o controller
      // - controller (PessoaDto)
      // - service (Pessoa)
      // - repository (Entity)



      // Supplier e a geração de conteúdos infinitos

     }
}
