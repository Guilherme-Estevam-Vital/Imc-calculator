package view;

import model.Pessoa;
import model.Relatorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static model.Relatorio.adicionarAmostra;

public class View {
    private JPanel TelaPrincipal;
    private JPanel pnTitulo;
    private JLabel jlTitulo;
    private JPanel pnBottom;
    private JButton bntCalcularIMC;
    private JButton btnNovo;
    private JButton btDados;
    private JButton btFechar;
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
    private JPanel jpPrincipal;


    private static JFrame frame1;


    public View() {
        frame1 = new JFrame("Calculo IMC");
        frame1.setContentPane(this.jpPrincipal);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
        Relatorio relatorio = new Relatorio();
        bntCalcularIMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(txtNome.getText());
                pessoa.setIdade(Integer.parseInt(txtIdade.getText()));
                pessoa.setPeso(Double.parseDouble(txtPeso.getText()));
                pessoa.setAltura(Double.parseDouble(txtAltura.getText()));
                pessoa.setCpf(txtCpf.getText());
                pessoa.classificaSaude();
                lbImc.setText(String.format("%.2f", pessoa.getImc()));
                lbCondicaoFisica.setText(pessoa.getEstadoSaude());
                adicionarAmostra(pessoa);
                btnNovo.setEnabled(true);


            }
        });
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAltura.setText("");
                txtPeso.setText("");
                txtNome.setText("");
                txtIdade.setText("");
                txtCpf.setText("");
                lbCondicaoFisica.setText("Estado de saúde");
                lbImc.setText("0.0");
                btnNovo.setEnabled(false);
            }
        });
        btDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorio.calcularEstatística();
                relatorio.mostrarDados();
                frame1.setVisible(false);
                Dados dados = new Dados();


            }
        });
        btFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
