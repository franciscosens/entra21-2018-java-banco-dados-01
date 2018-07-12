package view;

import bean.ClienteBean;
import interfaces.BaseGUInterface;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 * @author Henrique Silva / Rafael Alipio Harada
 */
public class ClienteListaCadastro implements BaseGUInterface {

    private int linhaSelecionada = -1;
    private JFrame jFrame;
    private JLabel jLabelID, jLabelNome, jLabelData, jLabelCPF;
    private JTextField jTextFieldID, jTextFieldNome;
    private JButton jButtonSalvar, jButtonExcluir, jButtonEditar;
    private JRadioButton jRadioButtonAtivo, jRadioButtonInativo;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private DefaultTableModel dtm;
    private JFormattedTextField jFormattedTextFieldCPF, jFormattedTextFieldData;
    private ButtonGroup buttonGroup;
    private ArrayList<ClienteBean> dados = new ArrayList<>();

    public ClienteListaCadastro() {
        instanciarComponentes();
        gerarTela();
        adicionarComponentes();
        gerarLocalizacoes();
        gerarDimensoes();
        configurarJFormattedTextField();
        definirjRadioButton();
        acaoBotaoSalvar();
        acaoBotaoEditar();
        acaoBotaoExcluir();
        acaoBotaoTeclas();
        jFrame.setVisible(true);
    }

    public void instanciarComponentes() {
        //JLabel´s
        jLabelID = new JLabel("ID");
        jLabelNome = new JLabel("Nome");
        jLabelData = new JLabel("Data Nascimento");
        jLabelCPF = new JLabel("CPF");

        //JTextField´s
        jTextFieldID = new JTextField();
        jTextFieldNome = new JTextField();
        jFormattedTextFieldData = new JFormattedTextField();
        jFormattedTextFieldCPF = new JFormattedTextField();

        //JButton´s
        jButtonSalvar = new JButton("Salvar");
        jButtonExcluir = new JButton("Excluir");
        jButtonEditar = new JButton("Editar");

        //JRadioButton´s
        jRadioButtonAtivo = new JRadioButton("Ativo");
        jRadioButtonInativo = new JRadioButton("Inativo");

        //JTable
        jTable = new JTable();
        configurarJTable();

        //JScrollPane
        jScrollPane = new JScrollPane(jTable);

        //ButtonGroup
        buttonGroup = new ButtonGroup();
    }

    @Override
    public void gerarTela() {
        jFrame = new JFrame("Cadastro Cliente");
        jFrame.setSize(530, 340);
        jFrame.setLayout(null);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void adicionarComponentes() {
        jFrame.add(jLabelID);
        jFrame.add(jLabelNome);
        jFrame.add(jLabelData);
        jFrame.add(jLabelCPF);
        jFrame.add(jTextFieldID);
        jFrame.add(jTextFieldNome);
        jFrame.add(jFormattedTextFieldData);
        jFrame.add(jFormattedTextFieldCPF);
        jFrame.add(jButtonSalvar);
        jFrame.add(jButtonExcluir);
        jFrame.add(jButtonEditar);
        jFrame.add(jRadioButtonAtivo);
        jFrame.add(jRadioButtonInativo);
        jFrame.add(jScrollPane);
    }

    @Override
    public void gerarLocalizacoes() {
        jLabelID.setLocation(10, 10);
        jLabelNome.setLocation(10, 35);
        jLabelData.setLocation(10, 60);
        jLabelCPF.setLocation(10, 85);
        jRadioButtonAtivo.setLocation(10, 110);
        jRadioButtonInativo.setLocation(90, 110);
        jTextFieldID.setLocation(115, 10);
        jTextFieldNome.setLocation(115, 35);
        jFormattedTextFieldData.setLocation(115, 60);
        jFormattedTextFieldCPF.setLocation(115, 85);
        jButtonSalvar.setLocation(10, 175);
        jButtonEditar.setLocation(10, 245);
        jButtonExcluir.setLocation(135, 245);
        jScrollPane.setLocation(245, 10);
    }

    @Override
    public void gerarDimensoes() {
        jLabelID.setSize(20, 20);
        jLabelNome.setSize(40, 20);
        jLabelData.setSize(100, 20);
        jLabelCPF.setSize(30, 20);
        jRadioButtonAtivo.setSize(70, 20);
        jRadioButtonInativo.setSize(70, 20);
        jTextFieldID.setSize(120, 20);
        jTextFieldNome.setSize(120, 20);
        jFormattedTextFieldData.setSize(120, 20);
        jFormattedTextFieldCPF.setSize(120, 20);
        jButtonSalvar.setSize(225, 50);
        jButtonEditar.setSize(100, 50);
        jButtonExcluir.setSize(100, 50);
        jScrollPane.setSize(270, 290);
    }

    private void configurarJTable() {
        dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Nome");
        dtm.addColumn("CPF");
        jTable.setModel(dtm);
    }

    private void definirjRadioButton() {
        buttonGroup.add(jRadioButtonAtivo);
        buttonGroup.add(jRadioButtonInativo);
    }

    private void configurarJFormattedTextField() {
        try {
            MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
            maskFormatter.install(jFormattedTextFieldCPF);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Chame o Pastor");
        }
        try {
            MaskFormatter maskFormatterData = new MaskFormatter("##/##/####");
            maskFormatterData.install(jFormattedTextFieldData);
        } catch (Exception x) {
            x.printStackTrace();
            JOptionPane.showMessageDialog(null, "Chame o Pastor");
        }
    }

    private void acaoBotaoSalvar() {
        jButtonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //id
                //nome
                //data
                //cpf
                //ativo/inativo
                if (jTextFieldID.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID deve ser informado");
                    jTextFieldID.requestFocus();
                }
                if (jTextFieldNome.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome deve ser preenchido");
                    jTextFieldNome.requestFocus();
                    return;
                }
                if (jFormattedTextFieldData.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data deve ser informada");
                    jFormattedTextFieldData.requestFocus();
                    return;
                }
                String cpf = jFormattedTextFieldCPF.getText()
                        .replace(".", "").replace("/", "").replace("-", "");
                if (cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "CPF deve ser preenchido");
                    jFormattedTextFieldCPF.requestFocus();
                    return;
                }
                if (!jRadioButtonAtivo.isSelected() && !jRadioButtonInativo.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Deve ser selecionado se é ativo ou passivo");
                    return;
                }

                limparCampos();
            }
        });
    }

    private void limparCampos() {
        jTextFieldID.setText("");
        jFormattedTextFieldCPF.setText("");
        jTextFieldNome.setText("");
        jFormattedTextFieldData.setText("");
        linhaSelecionada = -1;
        jTextFieldID.requestFocus();
    }

    private void acaoBotaoEditar() {
        jButtonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Seleciona um registro");
                    return;
                }
                linhaSelecionada = jTable.getSelectedRow();

            }
        });
    }

    private void preencherCampos(ClienteBean dados) {
        jTextFieldNome.setText(dados.getNome());
        jTextFieldID.setText(
                String.valueOf(dados.getId())
        );
        jFormattedTextFieldData.setText(
                String.valueOf(dados.getData())
        );
        jFormattedTextFieldCPF.setText(dados.getCpf());
        jRadioButtonAtivo.setSelected(dados.isAtivo());
        jRadioButtonInativo.setSelected(dados.isInativo());
    }

    private void acaoBotaoExcluir() {
        jButtonExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void acaoBotaoTeclas() {
        jTextFieldID.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        jTextFieldNome.requestFocus();
                        break;
                    case KeyEvent.VK_TAB:
                        jTextFieldNome.requestFocus();
                        break;
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        jTextFieldNome.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        jFormattedTextFieldData.requestFocus();
                        break;
                    case KeyEvent.VK_TAB:
                        jFormattedTextFieldData.requestFocus();
                        break;
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        jFormattedTextFieldData.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        jFormattedTextFieldCPF.requestFocus();
                        break;
                    case KeyEvent.VK_TAB:
                        jFormattedTextFieldCPF.requestFocus();
                        break;
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        jFormattedTextFieldCPF.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        jFormattedTextFieldCPF.requestFocus();
                        break;
                    case KeyEvent.VK_TAB:
                        jFormattedTextFieldCPF.requestFocus();
                        break;
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

    }

}
