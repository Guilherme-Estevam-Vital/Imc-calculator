package view;

import javax.swing.*;

public class Consulta {
    private JPanel jpPrincipal3;
    private JLabel lbNome;
    private JLabel lbIdade;
    private JLabel lbPeso;
    private JLabel lbAltura;
    private JLabel lbImc;
    private JLabel lbEstadodeSaude;
    public Consulta(String nome, String idade, String peso, String altura,String imc,String estadodesaude){
        JFrame frame4 = new JFrame("Calculo IMC");
        frame4.setContentPane(this.jpPrincipal3);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.pack();
        frame4.setSize(250,250);
        frame4.setVisible(true);
        frame4.setLocationRelativeTo(null);
        frame4.setResizable(false);
        lbNome.setText(nome);
        lbIdade.setText(idade);
        lbPeso.setText(peso);
        lbAltura.setText(altura);
        lbImc.setText(imc);
        lbEstadodeSaude.setText(estadodesaude);
    }
}
