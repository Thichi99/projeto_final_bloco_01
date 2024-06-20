package application.model;

public class CadastroProfissional extends Cadastro{
    private String crp;

    public CadastroProfissional(String nome, String telefone, String endereco, int numero, int tipo) {
        super(nome, telefone, endereco, numero, tipo);
        this.crp = crp;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Cadastro Regional de Psicologia (CRP): " + this.crp);
    }
}
