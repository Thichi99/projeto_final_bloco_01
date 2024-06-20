package application.model;

public class Cadastro {
    private String nome, telefone, endereco;
    private int numero, tipo;

    public Cadastro(String nome, String telefone, String endereco, int numero, int tipo) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void visualizar() {
        String tipo = " ";

        switch (this.tipo) {
            case 1:
                tipo = "Cliente";
                break;
            case 2:
                tipo = "Profissional";
                break;
        }

        System.out.println("\n=========================================================");
        System.out.println("Dados do Cadastro: ");
        System.out.println("\n=========================================================");
        System.out.println("Número do Cadastro: " + this.numero);
        System.out.println("Tipo do Cadastro: " + tipo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Telefone: " + this.telefone);

    }
}
