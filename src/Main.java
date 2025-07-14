import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File arquivo = new File("teste.txt");
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
