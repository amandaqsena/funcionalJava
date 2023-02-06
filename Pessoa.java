package funcionalJava;

public class Pessoa {
    public String nome;
    public int  idade;


    public int getIdade(){
        return this.idade;
    }

    public String getNome(){
        return this.nome;
    }
    Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return String.format("Nome = %s, Idade = %s", this.nome, this.getIdade());
    }
}
