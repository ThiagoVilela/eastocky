package controllers;

import models.Usuario;
import play.Logger;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiago on 26/03/2017.
 */
public class UsuarioController extends Controller {

    public void cadastroUsuario(String nome, String email, String senha){
        Logger.info("Tentando criar um novo usuario");
        Usuario usuario = Usuario.find("byEmail", email).first();
        if(usuario == null){
            usuario = new Usuario();
            usuario.nome = nome;
            usuario.email = email;
            usuario.senha = senha;
            usuario.save();
            renderJSON(usuario);
        }else{
            renderJSON(new String("E-mail já cadastrado no sistema!"));
        }
    }

    public void loginNovoUsuario(String email, String senha){
	Logger.info("Realizando login");
	Logger.info(email);
	Logger.info(senha);
        Usuario usuario;
        usuario = Usuario.find("byEmailAndSenha", email, senha).first();
	Logger.info(usuario.nome);
        if(usuario == null){
            renderJSON(new String("Usuário não encontrado, verifique seu e-mail e senha!"));
        }else{
            renderJSON(usuario);
        }
    }

    public void listaUsuario(){
	   Logger.info("Buscando lista de usuários");
	   List<Usuario> fornecedorList = new ArrayList<Usuario>();
	   fornecedorList = Usuario.findAll();

	   if(fornecedorList.size() >= 0)
	       renderJSON(fornecedorList);
	   else
	       renderJSON(new String("Nenhum usuário cadastrado"));
	}


}
