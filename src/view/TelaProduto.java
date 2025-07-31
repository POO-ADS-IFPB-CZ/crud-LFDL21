package view;

import dao.GenericDao;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Set;

public class TelaProduto extends JFrame {

    private JTextField tfCodigo;
    private JTextField tfDescricao;
    private JTextField tfPreco;
    private JTable tabelaProdutos;
    private DefaultTableModel tableModel;

    private GenericDao<Produto> dao;

    public TelaProduto() {
        setTitle("Cadastro de Produto");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        try {
            dao = new GenericDao<>("produtos.dat");
            initComponents();
            carregarProdutos();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar banco de dados: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void initComponents() {
        // Campos não são visíveis na imagem, mas ainda são necessários para ações
        tfCodigo = new JTextField();
        tfDescricao = new JTextField();
        tfPreco = new JTextField();

        // Tabela
        tableModel = new DefaultTableModel(new Object[]{"Código", "Descrição", "Preço"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // células não editáveis diretamente
            }
        };

        tabelaProdutos = new JTable(tableModel);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);

        add(scrollPane, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnRemover = new JButton("Remover");

        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnRemover);

        add(painelBotoes, BorderLayout.SOUTH);

        // Ações
        btnAdicionar.addActionListener(e -> {
            try {
                inserirProdutoViaDialog();
            } catch (Exception ex) {
                mostrarErro(ex);
            }
        });

        btnRemover.addActionListener(e -> {
            try {
                excluirProduto();
            } catch (Exception ex) {
                mostrarErro(ex);
            }
        });

        btnAtualizar.addActionListener(e -> {
            try {
                atualizarProdutoViaDialog();
            } catch (Exception ex) {
                mostrarErro(ex);
            }
        });

        tabelaProdutos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabelaProdutos.getSelectedRow() != -1) {
                int row = tabelaProdutos.getSelectedRow();
                tfCodigo.setText(tableModel.getValueAt(row, 0).toString());
                tfDescricao.setText(tableModel.getValueAt(row, 1).toString());
                tfPreco.setText(tableModel.getValueAt(row, 2).toString());
            }
        });
    }

    private void carregarProdutos() throws IOException, ClassNotFoundException {
        Set<Produto> produtos = dao.getAll();
        tableModel.setRowCount(0);
        for (Produto p : produtos) {
            tableModel.addRow(new Object[]{p.getCodigo(), p.getDescricao(), p.getPreco()});
        }
    }

    private void inserirProdutoViaDialog() throws IOException, ClassNotFoundException {
        JTextField codField = new JTextField();
        JTextField descField = new JTextField();
        JTextField precoField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Código:"));
        panel.add(codField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descField);
        panel.add(new JLabel("Preço:"));
        panel.add(precoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Adicionar Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            long codigo = Long.parseLong(codField.getText());
            String descricao = descField.getText();
            float preco = Float.parseFloat(precoField.getText());

            Produto novo = new Produto(codigo, descricao, preco);

            if (dao.salvar(novo)) {
                tableModel.addRow(new Object[]{codigo, descricao, preco});
            } else {
                JOptionPane.showMessageDialog(this, "Produto com esse código já existe. Use atualizar.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void excluirProduto() throws IOException, ClassNotFoundException {
        int row = tabelaProdutos.getSelectedRow();
        if (row != -1) {
            long codigo = Long.parseLong(tableModel.getValueAt(row, 0).toString());
            Produto p = new Produto(codigo, "", 0);

            if (dao.remover(p)) {
                tableModel.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao remover produto.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para remover.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void atualizarProdutoViaDialog() throws IOException, ClassNotFoundException {
        int row = tabelaProdutos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para atualizar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JTextField codField = new JTextField(tableModel.getValueAt(row, 0).toString());
        JTextField descField = new JTextField(tableModel.getValueAt(row, 1).toString());
        JTextField precoField = new JTextField(tableModel.getValueAt(row, 2).toString());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Código:"));
        panel.add(codField);
        panel.add(new JLabel("Descrição:"));
        panel.add(descField);
        panel.add(new JLabel("Preço:"));
        panel.add(precoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Atualizar Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            long codigo = Long.parseLong(codField.getText());
            String descricao = descField.getText();
            float preco = Float.parseFloat(precoField.getText());

            Produto atualizado = new Produto(codigo, descricao, preco);

            if (dao.atualizar(atualizado)) {
                tableModel.setValueAt(codigo, row, 0);
                tableModel.setValueAt(descricao, row, 1);
                tableModel.setValueAt(preco, row, 2);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar produto.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarErro(Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaProduto().setVisible(true));
    }
}

