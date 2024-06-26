package view;

import model.Relatorio;

import javax.swing.*;
public class Estatisticas {
    private JPanel jpPrincipal3;
    private JLabel lbTotalDepessoas;
    private JLabel lbMagras;
    private JLabel lbSaudaveis;
    private JLabel lbObesidade1;
    private JLabel lbObesidade2;
    private JLabel lbObesidade3;
    private JLabel lbMediaIDade;
    private JLabel lbMediaAltura;
    private JLabel lbMediapeso;
    private JLabel lbMaiorIdade;
    private JLabel lbMaiorAltura;
    private JLabel lbMaiorpeso;
    private JLabel lbMenorIDadde;
    private JLabel lbMenorAltura;
    private JLabel lbMenorPEso;
    private Relatorio x;

    public Estatisticas(){
        JFrame frame8 = new JFrame("Calculo IMC");
        frame8.setContentPane(this.jpPrincipal3);
        //frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame8.pack();
        frame8.setSize(350,500);
        frame8.setVisible(true);
        frame8.setLocationRelativeTo(null);
        frame8.setResizable(false);
        Relatorio x = new Relatorio();
        x.calcularEstatística();
        x.mostrarDados();
        lbTotalDepessoas.setText(Integer.toString(x.getTotalPessoas()));

        lbMagras.setText(Integer.toString(x.getTotalMagra()));
        lbSaudaveis.setText(Integer.toString(x.getTotalSaudavel()));
        lbObesidade1.setText(Integer.toString(x.getTotalObesidade1()));
        lbObesidade2.setText(Integer.toString(x.getTotalObesidade2()));
        lbObesidade3.setText(Integer.toString(x.getTotalObesidade3()));
        lbMediaIDade.setText(Double.toString(x.getMediaIdade()));
        lbMediaAltura.setText(Double.toString(x.getMediaAltura()));
        lbMediapeso.setText(Double.toString(x.getMediaPeso()));
        lbMaiorIdade.setText(Double.toString(x.getMaiorIdade()));
        lbMaiorAltura.setText(Double.toString(x.getMaiorAltura()));
        lbMaiorpeso.setText(Double.toString(x.getMaiorPeso()));
        lbMenorIDadde.setText(Double.toString(x.getMenorIdade()));
        lbMenorAltura.setText(Double.toString(x.getMenorAltura()));
        lbMenorPEso.setText(Double.toString(x.getMenorPeso()));



    }

   }
