package dao;

import model.Aluno;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AlunoDao {

    private File arquivo;

    public AlunoDao() throws IOException {
        arquivo = new File("alunos.txt");
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }

    public Set<Aluno> getAlunos() throws IOException,
            ClassNotFoundException {
        if(arquivo.length() != 0){
            try(ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo)
            )){
                return (Set<Aluno>) in.readObject();
            }
        }
        return new HashSet<>();
    }


}
