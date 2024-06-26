package model;

import view.Estatisticas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private int totalPessoas;
    private int totalMagra = 0;
    private int totalSaudavel = 0;
    private int totalObesidade1 = 0;
    private int totalObesidade2 = 0;
    private int totalObesidade3 = 0;
    private double mediaIdade = 0;
    private double mediaAltura = 0;
    private double mediaPeso = 0;

    public int getTotalObesidade3() {
        return totalObesidade3;
    }

    private int maiorIdade = 0;
    private double maiorAltura = 0;
    private double maiorPeso = 0;
    private int menorIdade;
    private double menorAltura;
    private double menorPeso;

    private static List<Pessoa> pessoalist = new ArrayList<Pessoa>();
    ;

    public Relatorio() {


    }

    public static void adicionarAmostra(Pessoa x) {

        pessoalist.add(x);
    }

    public static void removerAmostra(Pessoa x) {

        pessoalist.remove(x);
    }



    public static void criarArquivo() {
        String url = "C:\\Users\\guink\\Desktop\\calculo-imc\\src\\arquivo\\db-pessoa.txt";
        File arquivo = new File(url);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Pessoa aux : pessoalist) {
                bw.write(aux.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }

    public static void lerArquivo() {
        String caminhoArquivo = "C:\\Users\\guink\\Desktop\\calculo-imc\\src\\arquivo\\db-pessoa.txt";
        try {
            FileReader fr = new FileReader(caminhoArquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] atributos = linha.split(";");
                if (atributos.length == 7) {
                    String nome = atributos[0];
                    String cpf = atributos[1];
                    int idade = Integer.parseInt(atributos[2]);
                    double peso = Double.parseDouble(atributos[3]);
                    double altura = Double.parseDouble(atributos[4]);
                    double imc = Double.parseDouble(atributos[5]);
                    String estadoSaude = atributos[6];

                    Pessoa pessoa = new Pessoa(nome, cpf, idade, peso, altura, imc, estadoSaude);
                    adicionarAmostra(pessoa);
                } else {
                    System.err.println("Formato de linha inválido: " + linha);
                }
                System.out.println(linha);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }

    public void calcularEstatística() {
        totalPessoas = pessoalist.size();
        for (Pessoa x : pessoalist) {


            if (x.getEstadoSaude() == "Magro") {
                totalMagra++;
            } else if (x.getEstadoSaude() == "Saudavel") {
                totalSaudavel++;
            } else if (x.getEstadoSaude() == "Obesidade 1") {
                totalObesidade1++;
            } else if (x.getEstadoSaude() == "Obesidade 2") {
                totalObesidade2++;
            } else {
                totalObesidade3++;
            }
            mediaAltura = mediaAltura + x.getAltura();
            mediaPeso = mediaPeso + x.getPeso();
            mediaIdade = mediaIdade + x.getIdade();
            if (maiorIdade < x.getIdade())
                maiorIdade = x.getIdade();
            if (maiorAltura < x.getAltura())
                maiorAltura = x.getAltura();
            if (maiorPeso < x.getPeso())
                maiorPeso = x.getPeso();


        }
        mediaAltura = mediaAltura / totalPessoas;
        mediaPeso = mediaPeso / totalPessoas;
        mediaIdade = mediaIdade / totalPessoas;
        menorAltura = pessoalist.get(0).getAltura();
        menorIdade = pessoalist.get(0).getIdade();
        menorPeso = pessoalist.get(0).getPeso();


        for (int i = 0; i < pessoalist.size(); i++) {

            if (pessoalist.get(i).getIdade() < menorIdade)
                menorIdade = pessoalist.get(i).getIdade();
            if (pessoalist.get(i).getPeso() < menorPeso)
                menorPeso = pessoalist.get(i).getPeso();
            if (pessoalist.get(i).getAltura() < menorAltura)
                menorAltura = pessoalist.get(i).getAltura();

        }


    }

    public void mostrarDados() {
        System.out.println("Total de pessoas: " + totalPessoas);
        System.out.println("Total de magras: " + totalMagra);
        System.out.println("Total de saudaveis: " + totalSaudavel);
        System.out.println("Total de obesas1: " + totalObesidade1);
        System.out.println("Total de obesas2: " + totalObesidade2);
        System.out.println("Total de obesas3: " + totalObesidade3);
        System.out.println("Media idades: " + mediaIdade);
        System.out.println("Media pesos: " + mediaPeso);
        System.out.println("Media alturas: " + mediaAltura);
        System.out.println("Maior idade: " + maiorIdade);
        System.out.println("Maior peso: " + maiorPeso);
        System.out.println("Maior altura: " + maiorAltura);
        System.out.println("Menor altura: " + menorAltura);
        System.out.println("Menor peso: " + menorPeso);
        System.out.println("Menor idade: " + menorIdade);


    }
    public int getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(int totalPessoas) {
        this.totalPessoas = totalPessoas;
    }

    public int getTotalMagra() {
        return totalMagra;
    }

    public void setTotalMagra(int totalMagra) {
        this.totalMagra = totalMagra;
    }

    public int getTotalSaudavel() {
        return totalSaudavel;
    }

    public void setTotalSaudavel(int totalSaudavel) {
        this.totalSaudavel = totalSaudavel;
    }

    public int getTotalObesidade1() {
        return totalObesidade1;
    }

    public void setTotalObesidade1(int totalObesidade1) {
        this.totalObesidade1 = totalObesidade1;
    }

    public int getTotalObesidade2() {
        return totalObesidade2;
    }

    public void setTotalObesidade2(int totalObesidade2) {
        this.totalObesidade2 = totalObesidade2;
    }

    public double getMediaIdade() {
        return mediaIdade;
    }

    public void setMediaIdade(double mediaIdade) {
        this.mediaIdade = mediaIdade;
    }

    public double getMediaAltura() {
        return mediaAltura;
    }

    public void setMediaAltura(double mediaAltura) {
        this.mediaAltura = mediaAltura;
    }

    public double getMediaPeso() {
        return mediaPeso;
    }

    public void setMediaPeso(double mediaPeso) {
        this.mediaPeso = mediaPeso;
    }

    public double getMaiorIdade() {
        return maiorIdade;
    }

    public void setMaiorIdade(int maiorIdade) {
        this.maiorIdade = maiorIdade;
    }

    public double getMaiorAltura() {
        return maiorAltura;
    }

    public void setMaiorAltura(double maiorAltura) {
        this.maiorAltura = maiorAltura;
    }

    public double getMaiorPeso() {
        return maiorPeso;
    }

    public void setMaiorPeso(double maiorPeso) {
        this.maiorPeso = maiorPeso;
    }

    public double getMenorIdade() {
        return menorIdade;
    }

    public void setMenorIdade(int menorIdade) {
        this.menorIdade = menorIdade;
    }

    public double getMenorAltura() {
        return menorAltura;
    }

    public void setMenorAltura(double menorAltura) {
        this.menorAltura = menorAltura;
    }

    public double getMenorPeso() {
        return menorPeso;
    }

    public void setMenorPeso(double menorPeso) {
        this.menorPeso = menorPeso;
    }


    public static List<Pessoa> getPessoalist() {
        return pessoalist;
    }

    public static void setPessoalist(List<Pessoa> pessoalist) {
        pessoalist = pessoalist;
    }
}