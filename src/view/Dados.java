package view;

import model.Pessoa;
import model.Relatorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static model.Relatorio.*;

public class Dados {
    private JPanel jpPrincipal;
    private JPanel jpDoTitulo;
    private JLabel lbTitulo;
    private JPanel jpDosBotoes;
    private JButton btCarregarDados;
    private JButton btRemover;
    private JButton btAtualizar;
    private JButton btAdicionar;
    private JButton btSalvarDados;
    private JButton btConsultar;
    private JPanel jpDaTable;
    private JTable table;
    private JPanel jpRodape;
    private JLabel lbRodape;
    private JButton btMostrarEstatisiticas;
    private   List<Pessoa> litsDados;

    private void mostraTabela(){
        List<String[]> dataList = new ArrayList<>();
        String filePath = "C:\\Users\\guink\\Desktop\\calculo-imc\\src\\arquivo\\db-pessoa.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(";");
                dataList.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converter os dados em um array bidimensional de objetos
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        // Definir o modelo da tabela com os dados lidos do arquivo
        table.setModel(new DefaultTableModel(data, new String[]{"Nome", "Cpf", "Idade", "Peso", "Altura", "Imc", "Estado de saúde"}));
    }




    public Dados() {

        JFrame frame2 = new JFrame("Calculo IMC");
        frame2.setContentPane(this.jpPrincipal);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.pack();
        frame2.setVisible(true);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setSize(700,500);
        mostraTabela();
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame2.setVisible(false);
                View view = new View();


            }
        });
        btConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameConsultar = new JFrame("Consulta ");
                String userInput = JOptionPane.showInputDialog(frameConsultar, "Digite o cpf da consulta:");
                for(Pessoa x: getPessoalist()){
                    if (userInput.equals(x.getCpf())) {

                        System.out.println("Usario de cpf : " + userInput+" encontrado");
                        Consulta consulta = new Consulta(x.getNome(),Integer.toString(x.getIdade()),Double.toString(x.getPeso()),Double.toString(x.getAltura()),Double.toString(x.getImc()),x.getEstadoSaude());

                    }
                    else System.out.println("Cpf não encontrado!");
                }

            }

        });
        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aux =137;//jeito para não precisar tratar exceção, dava para usar try catch tbm.
                JFrame frameApagar = new JFrame("Remoção ");
                String  userInput = JOptionPane.showInputDialog(frameApagar, "Digite o cpf do usuario a ser apagado:");
                for(int i =0; i<getPessoalist().size();i++){
                    if (userInput.equals(getPessoalist().get(i).getCpf())) {
                        System.out.println("Usario de cpf : " + userInput+" apagado");
                        aux = i;

                    }
                    else System.out.println("Cpf não encontrado!");
                }
                if(aux!=137)
                removerAmostra(getPessoalist().get(aux));
            }
        });
        btSalvarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarArquivo();
                JOptionPane.showMessageDialog(null, "Arquivo criado.","Sucesso na criação do arquivo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btCarregarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerArquivo();
            }
        });
        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAtualizar = new JFrame("Atualização ");
                String  userInput = JOptionPane.showInputDialog(frameAtualizar, "Digite o cpf do usuario a ser atualizado:");
                for(int i =0; i<getPessoalist().size();i++){
                    if (userInput.equals(getPessoalist().get(i).getCpf())) {
                        System.out.println("Usario de cpf : " + userInput+" encontrado");
                        frame2.setVisible(false);
                        Atualizar atualizar = new Atualizar(i);


                    }
                    else System.out.println("Cpf não encontrado!");
                }

            }
        });
        btMostrarEstatisiticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Estatisticas estatisticas = new Estatisticas();

            }
        });
    }
}
