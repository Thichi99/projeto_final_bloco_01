package application.controller;

import application.model.Cadastro;
import application.repository.CadastroRepository;

import java.util.ArrayList;
import java.util.List;

public class CadastroController implements CadastroRepository {

    private ArrayList<Cadastro> listaCadastros = new ArrayList<>();
    int numero = 0;

    @Override
    public void cadastrar(Cadastro cadastro) {
        listaCadastros.add(cadastro);
        System.out.println("O Cadastro número: " + cadastro.getNumero() + " foi criado com sucesso!");
    }

    @Override
    public void atualizar(Cadastro cadastro) {
        var buscarCadastro = buscarNaLista(cadastro.getNumero());

        if (buscarCadastro != null) {
            listaCadastros.set(listaCadastros.indexOf(buscarCadastro), cadastro);
            System.out.println("\nO Cadastro número: " + cadastro.getNumero() + " foi atualizado com sucesso!");
        } else {
            System.out.println("\nO Cadastro número: " + cadastro.getNumero() + " não foi encontrado.");
        }
    }

    @Override
    public void listarProfissionais() {
        for (var cadastro : listaCadastros) {
            if (cadastro.getTipo() == 2){
                cadastro.visualizar();
                }
        }
    }

    @Override
    public void procurarPorCod(int numero) {
        var cadastro = buscarNaLista(numero);

        if (cadastro != null) {
            cadastro.visualizar();
        } else {
            System.out.println("\nO Cadastro número: " + numero + " não foi encontrado.");
        }
    }

    @Override
    public void apagar(int numero) {
        var cadastro = buscarNaLista(numero);

        if (cadastro != null) {
            if (listaCadastros.remove(cadastro)) {
                System.out.println("\nO Cadastro número: " + numero + " foi excluído com sucesso!");
            }
        } else {
            System.out.println("\nO Cadastro número: " + numero + " não foi encontrado.");
        }
    }

    public Cadastro buscarNaLista(int numero) {
        for (var cadastro : listaCadastros) {
            if (cadastro.getNumero() == numero) {
                return cadastro;
            }
        }
        return null;
    }

    public int gerarNumero() {
        return ++numero;
    }
}
