import java.io.*;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("teste.txt");
        Aluno aluno = new Aluno(123, "João", "ADS");

        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(arquivo)
        )){
            out.writeObject(aluno);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}