package funcionalJava.src.main.java.br.com.amandaqsena;

public class VerificaSeSaltador implements Verificador{

    @Override
    public boolean verificar(Animal a) {
        return a.podeSaltar();
    }
}
