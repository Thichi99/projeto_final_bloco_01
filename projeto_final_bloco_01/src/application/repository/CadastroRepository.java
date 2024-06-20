package application.repository;

import application.model.Cadastro;

//Crud do Cadastro
public interface CadastroRepository {
    void cadastrar (Cadastro cadastro);

    void atualizar (Cadastro cadastro);

    void listarCadastros();

    void procurarPorCod(int numero);

    void apagar(int numero);

}
