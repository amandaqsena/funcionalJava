package funcionalJava.src.main.java.br.com.amandaqsena;

public class Pessoa {
    private String nome;
    private int  idade;
    private String setor;

    public int getIdade(){
        return this.idade;
    }

    public String getNome(){
        return this.nome;
    }
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return String.format("Nome = %s, Idade = %s", this.nome, this.getIdade());
    }
}
