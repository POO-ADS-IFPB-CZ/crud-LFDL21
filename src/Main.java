import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("teste.txt");
        Aluno aluno = new Aluno(456, "Maria", "ADS");

        try(BufferedWriter bw = new BufferedWriter(
                new FileWriter(arquivo, true)
        )) {
            bw.write(aluno.getMatricula()+","+aluno.getNome()+","
                    +aluno.getCurso());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}