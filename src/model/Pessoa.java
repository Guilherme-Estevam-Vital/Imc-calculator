package model;

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private double altura;
    private double peso;
    private double imc;
    private String estadoSaude;

    public Pessoa( String nome, String cpf, int idade, double altura, double peso, double imc, String estadoSaude) {

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.estadoSaude = estadoSaude;
    }
    public  Pessoa(){

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }



    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(String estadoSaude) {
        this.estadoSaude = estadoSaude;
    }


    public double calcularIMC(){

        return (this.peso/(this.altura*this.altura));
    }
    public String toString(){
        return nome + ";" +
                cpf + ";" +
                idade + ";" +
                peso + ";" +
                altura + ";" +
                imc + ";" +
                estadoSaude + ";";
    }

    public void classificaSaude(){
        this.imc = calcularIMC();
        if(this.imc<=18.5)
            this.estadoSaude = "Magro";
        else
        if (this.imc>18.5 && this.imc<= 24.9){
            this.estadoSaude = "Saudavel";
        }
        else
        if (this.imc>24.9 && this.imc<= 29.9){
            this.estadoSaude = "Obesidade 1";
        }
        else
        if (this.imc>29.9 && this.imc<= 39.9){
            this.estadoSaude = "Obesidade 2";
        }
        else
            this.estadoSaude = "Obesidade 3";
    }
}
