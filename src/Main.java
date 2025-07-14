import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("teste.txt");

        System.out.println("Tamanho: "+arquivo.length());
        System.out.println("Diretório: "+arquivo.getAbsolutePath());
        System.out.println("Pai: " +arquivo.getAbsoluteFile().getParent());
        System.out.println("Leitura: "+arquivo.canRead());
        System.out.println("Escrita: "+arquivo.canWrite());
        System.out.println("Execução: "+arquivo.canExecute());
        System.out.println("Modificação: "+ arquivo.lastModified());

    }
}