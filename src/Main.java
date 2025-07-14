import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("teste.txt");

        try(BufferedWriter bw = new BufferedWriter(
                new FileWriter(arquivo, false)
        )) {
            bw.write("Hello World");
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}