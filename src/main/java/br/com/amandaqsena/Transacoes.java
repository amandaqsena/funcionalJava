package funcionalJava.src.main.java.br.com.amandaqsena;

public class Transacoes {
    private String descricao;
    private double valor;
    private String categoria;


    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Transacoes(String descricao, double valor, String categoria){
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String toString(){
        return "Descrição = " + this.descricao + ", valor = " + this.valor + ", categoria = " + this.categoria;
    }
}
