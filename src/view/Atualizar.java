package view;

import model.Pessoa;
import model.Relatorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.Relatorio.getPessoalist;

public class Atualizar {
    private JPanel jpPrincipal;
    private JButton bntAtualizar;
    private JButton btVoltar;
    private JPanel jpPrincipal5;
    private JPanel TelaPrincipal;
    private JPanel pnTitulo;
    private JLabel jlTitulo;
    private JPanel pnBottom;
    private JButton btAtualizar;
    private JPanel jpCenter;
    private JLabel lbNome;
    private JTextField txtNome;
    private JLabel lbIdade;
    private JTextField txtIdade;
    private JLabel lbAltura;
    private JTextField txtAltura;
    private JLabel lbPeso;
    private JTextField txtPeso;
    private JLabel lbCpf;
    private JTextField txtCpf;
    private JLabel lbImc;
    private JLabel lbCondicaoFisica;
    private Relatorio x;
    private static JFrame frame6;


    public Atualizar(int i) {
         frame6 = new JFrame("Atualizar");
        frame6.setContentPane(this.jpPrincipal5);
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.pack();
        frame6.setVisible(true);
        frame6.setLocationRelativeTo(null);
        frame6.setResizable(false);


        btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame6.dispose();
                Dados dados = new Dados();
            }
        });
        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPessoalist().get(i).setNome(txtNome.getText());
                getPessoalist().get(i).setIdade(Integer.parseInt(txtIdade.getText()));
                getPessoalist().get(i).setPeso(Double.parseDouble(txtPeso.getText()));
                getPessoalist().get(i).setAltura(Double.parseDouble(txtAltura.getText()));
                getPessoalist().get(i).setCpf(txtCpf.getText());
                getPessoalist().get(i).classificaSaude();
                lbImc.setText(String.format("%.2f", getPessoalist().get(i).getImc()));
                lbCondicaoFisica.setText(getPessoalist().get(i).getEstadoSaude());
                JOptionPane.showMessageDialog(null, "Atualizado!");
                frame6.dispose();
                Dados dados = new Dados();

            }
        });
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
