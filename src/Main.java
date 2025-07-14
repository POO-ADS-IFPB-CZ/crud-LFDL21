import java.io.*;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("teste.txt");

        //Lendo o arquivo
        try(BufferedReader br = new BufferedReader(
                new FileReader(arquivo)
        )){
            br.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Escrevendo no arquivo
//        Aluno aluno = new Aluno(456, "Maria", "ADS");
//        try(BufferedWriter bw = new BufferedWriter(
//                new FileWriter(arquivo, true)
//        )) {
//            bw.write(aluno.getMatricula()+","+aluno.getNome()+","
//                    +aluno.getCurso());
//            bw.newLine();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}