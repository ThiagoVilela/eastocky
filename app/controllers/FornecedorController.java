package controllers;

import models.Fornecedor;
import play.Logger;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 26/03/2017.
 */
public class FornecedorController extends Controller {

    public void cadastroFornecedor(String nome, String email, int telefone){
        Logger.info("Tentando criar um novo cidadao");
        Fornecedor fornecedor = Fornecedor.find("byEmail", email).first();
        if(fornecedor == null){
            fornecedor = new Fornecedor();
            fornecedor.nome = nome;
            fornecedor.email = email;
            fornecedor.telefone = telefone;
            fornecedor.save();
            renderJSON(fornecedor);
        }else{
            renderJSON(new String("E-mail já cadastrado no sistema!"));
        }
    }

    public void listaFornecedores(){
        Logger.info("Buscando lista de fornecedores");
        List<Fornecedor> fornecedorList = new ArrayList<Fornecedor>();
        fornecedorList = Fornecedor.findAll();

        if(fornecedorList.size() >= 0)
            renderJSON(fornecedorList);
        else
            renderJSON(new String("Nenhum fornecedor cadastrado"));

    }
}
