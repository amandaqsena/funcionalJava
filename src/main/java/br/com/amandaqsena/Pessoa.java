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

    public String getSetor(){
        return this.setor;
    }
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome, String setor, int idade){
        this.nome = nome;
        this.setor = setor;
        this.idade = idade;
    }

    public String toString(){
        return String.format("Nome = %s, Idade = %s", this.nome, this.getIdade());
    }
}
