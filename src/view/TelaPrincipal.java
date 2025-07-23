package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JFormattedTextField formattedTextField1;

    public TelaPrincipal() {
        setContentPane(contentPane);
        setTitle("IFPB - Cajazeiras");
        setAlwaysOnTop(true);
        ImageIcon icon = new ImageIcon("src/imgs/chapeu.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        buttonCancel.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        TelaPrincipal dialog = new TelaPrincipal();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        try {
            MaskFormatter formatter = new MaskFormatter("############");
            formattedTextField1 = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
