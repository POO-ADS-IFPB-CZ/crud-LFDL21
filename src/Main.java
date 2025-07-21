import dao.AlunoDao;
import model.Aluno;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //TODO: Tratar exceções, finalizar as operações, desacoplar o código

        AlunoDao alunoDao;
        try {
            alunoDao = new AlunoDao();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ImageIcon icon = new ImageIcon("imgs/aluno.png");
        String opcoes[] = {"Salvar", "Buscar", "Listar",
                "Atualizar", "Remover", "Sair"};
        while(true){
            String escolha = (String) JOptionPane.showInputDialog(null,
                    "Escolha a opção",
                    "CRUD Alunos",
                    JOptionPane.QUESTION_MESSAGE,
                    icon,
                    opcoes,
                    opcoes[0]
            );
            if(escolha == null) System.exit(0);
            switch (escolha){
                case "Salvar" ->{
                    int matricula = Integer.parseInt(
                      JOptionPane.showInputDialog(null,
                          "Informe a matrícula")
                    );
                    String nome = JOptionPane.showInputDialog(null,
                        "Informe o nome");
                    String curso = JOptionPane.showInputDialog(null,
                            "Informe a matrícula");
                    Aluno aluno = new Aluno(matricula,nome,curso);
                    try {
                        if(alunoDao.salvar(aluno)){
                            JOptionPane.showMessageDialog(null,
                                    "Aluno salvo com sucesso");
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "Já existe aluno com essa matrícula",
                                    "Mensagem de erro",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Buscar" ->{
                    try{
                        int matricula = Integer.parseInt(
                                JOptionPane.showInputDialog(
                                    null,
                                    "Informe a matrícula"
                                ));
                        Aluno aluno = alunoDao.getAluno(matricula);
                        JOptionPane.showMessageDialog(null,
                                aluno);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Listar" -> {
                    try {
                        JOptionPane.showMessageDialog(null,
                                alunoDao.getAlunos(),
                                "Listagem de alunos",
                                JOptionPane.PLAIN_MESSAGE,
                                icon);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "Sair" -> System.exit(0);
            }
        }

    }
}