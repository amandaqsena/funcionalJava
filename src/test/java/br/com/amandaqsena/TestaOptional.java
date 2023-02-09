package funcionalJava.src.test.java.br.com.amandaqsena;

import java.util.Arrays;
import java.util.List;
import funcionalJava.src.main.java.br.com.amandaqsena.Pessoa;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

public class TestaOptional {

    public static void main(String[] args){
        List<Pessoa> listaPessoa = Arrays.asList(
        new Pessoa("Amanda", "TI", 20),
        new Pessoa("Ítalo",  "TI", 20),
        new Pessoa("Bruno",  "TI", 20),
        new Pessoa("Natan",  "RH", 20)
    );

    Map<String, String> pessoaPorSetor = listaPessoa.stream()
        .collect(Collectors.groupingBy(Pessoa::getSetor,
        Collectors.mapping(Pessoa::getNome, Collectors.joining(", "))));
    
    System.out.println(pessoaPorSetor);

    List<Pessoa> listaPessoaNula = null;

    System.out.println(buscarNomepessoa(listaPessoa,"Amanda"));
    
    String nome = null;
    Optional<String> nome1 = Optional.of(nome);

    // findFirst()
    // pode ter orElse
    }

    private static Optional<Pessoa> buscarNomepessoa(List<Pessoa> lista, String nome){
        if(null == lista){
            return Optional.empty();
        }
        for(Pessoa pessoa: lista){
            if(null != pessoa){
                if(pessoa.getNome().equals(nome)){
                    return Optional.of(pessoa);
                }
                return Optional.empty();
            }
            return Optional.empty();
        }
        return Optional.empty();
    }
    
}
