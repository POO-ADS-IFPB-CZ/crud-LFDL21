import dao.AlunoDao;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

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