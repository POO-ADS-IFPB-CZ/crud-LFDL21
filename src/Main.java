import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ImageIcon icon = new ImageIcon("imgs/suco.png");
        String opcoes[] = {"Salvar", "Buscar", "Listar",
                "Atualizar", "Remover"};
        JOptionPane.showOptionDialog(
                null,
                "O que deseja fazer?",
                "CRUD Alunos",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,
                opcoes,
                opcoes[0]);

//        int retorno = JOptionPane.showConfirmDialog(null,
//                "Opções",
//                "Escolha uma opção",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.QUESTION_MESSAGE,
//                icon);
//        switch (retorno){
//            case JOptionPane.OK_OPTION ->System.out.println("Escolheu ok");
//            case JOptionPane.CANCEL_OPTION -> System.out.println("Escolheu cancel");
//            case JOptionPane.CLOSED_OPTION -> System.out.println("Fechou");
//        }

//        String valores[] = {"Opção 1", "Opção 2"};
//        String selecao = (String) JOptionPane.showInputDialog(
//                null,
//                "Escolha a opção",
//                "Entrada de dados",
//                JOptionPane.QUESTION_MESSAGE,
//                icon,
//                valores,
//                valores[0]);
//        System.out.println(selecao);

//        JOptionPane.showMessageDialog(null,
//                "Hello World",
//                "Mensagem do sistema",
//                JOptionPane.ERROR_MESSAGE,
//                icon
//                );
    }
}