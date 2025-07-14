import dao.AlunoDao;
import model.Aluno;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            AlunoDao dao = new AlunoDao();
//            dao.salvar(new Aluno(456,"Maria","ADS"));
            System.out.println(dao.getAlunos());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}