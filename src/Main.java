import dao.GenericDao;
import model.Aluno;
import model.Professor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        GenericDao<Professor> professorDao;
        try {
            professorDao = new GenericDao<Professor>("professores.txt");
            professorDao.salvar(new Professor("222.222.222-02",
                "Maria", "ADS"));
            System.out.println(professorDao.getAll());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}