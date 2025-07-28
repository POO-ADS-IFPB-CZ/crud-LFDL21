package view;

import javax.swing.*;

public class TelaVisualizarAluno extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaVisualizarAluno() {
        setContentPane(contentPane);
        setModal(true);
        pack();
        getRootPane().setDefaultButton(buttonOK);
    }
}
