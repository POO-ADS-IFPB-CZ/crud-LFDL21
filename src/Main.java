import java.io.*;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("teste.txt");

        //Lendo do arquivo binário
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(arquivo)
        )){
            Aluno aluno = (Aluno) in.readObject();
            System.out.println(aluno);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Escrevendo no arquivo binário
//        Aluno aluno = new Aluno(123, "João", "ADS");
//        try(ObjectOutputStream out = new ObjectOutputStream(
//                new FileOutputStream(arquivo)
//        )){
//            out.writeObject(aluno);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }
}