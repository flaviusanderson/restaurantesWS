/**
 * 
 */
package br.com.informati.restaurantes.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.informati.restaurantes.http.PerfilHttp;
import br.com.informati.restaurantes.http.UsuarioHttp;
import br.com.informati.restaurantes.modelo.PerfilEntity;
import br.com.informati.restaurantes.modelo.UsuarioEntity;
import br.com.informati.restaurantes.repositorio.PerfilDAO;
import br.com.informati.restaurantes.repositorio.UsuarioDAO;

/**
 * @author Flavius
 *
 */
@Path("/usuario")
public class UsuarioController implements IGenericoController<UsuarioHttp> {

	private final UsuarioDAO repositorio = new UsuarioDAO();
	private final PerfilDAO	repositorioPerfil = new PerfilDAO();
	
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(UsuarioHttp usuarioHttp){
		
		String msg = "Registro cadastrado com sucesso!";
		UsuarioEntity entidade = new UsuarioEntity();
		
		try{
			
			PerfilEntity aux = this.repositorioPerfil.consultarPorId(usuarioHttp.getPerfil().getId());
			
			entidade.setPerfil(aux);
			entidade.setNome(usuarioHttp.getNome());
			entidade.setEmail(usuarioHttp.getEmail());
			entidade.setSenha(usuarioHttp.getSenha());
			
			entidade.setIdUsuario(usuarioHttp.getIdUsuario());
			
			repositorio.salvar(entidade);
			
		}catch(Exception e){
			
			msg = "Erro ao cadastrar um registro " + e.getMessage();
		}
		
		return msg;
	}
	
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/atualizar")
	public String atualizar(UsuarioHttp usuarioHttp){
 
		String msg = "Registro atualizado com sucesso!";
		
		UsuarioEntity entidade = new UsuarioEntity();
 
		try {
 
			PerfilEntity aux = this.repositorioPerfil.consultarPorId(usuarioHttp.getPerfil().getId());
			
			entidade.setPerfil(aux);
			
			entidade.setId(usuarioHttp.getId());
			entidade.setNome(usuarioHttp.getNome());
			entidade.setEmail(usuarioHttp.getEmail());
			entidade.setSenha(usuarioHttp.getSenha());
			
			entidade.setIdUsuario(usuarioHttp.getIdUsuario());
			
			entidade.setUltimaAtualizacao( new Timestamp(usuarioHttp.getUltimaAtualizacao().getTime()));
			
			repositorio.atualizar(entidade);
 
		} catch (Exception e) {
 
			msg = "Erro ao alterar o registro " + e.getMessage();
 
		}
		
		return msg;
 
	}
	
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodos")
	public List<UsuarioHttp> consultarTodos(){
 
		List<UsuarioHttp> listaUsuarios =  new ArrayList<UsuarioHttp>();
 
		List<UsuarioEntity> listaEntidades= repositorio.consultarTodos();
 
		for (UsuarioEntity entidade : listaEntidades) {
 
			UsuarioHttp aux = new UsuarioHttp();
			aux.setId(entidade.getId());
			aux.setNome(entidade.getNome());
			aux.setEmail(entidade.getEmail());
			aux.setSenha(entidade.getSenha());
			aux.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
			aux.setIdUsuario(entidade.getIdUsuario());
			
			aux.setPerfil( PerfilHttp.converterEntity(entidade.getPerfil()) );
			
			listaUsuarios.add(aux);
		}
 
		return listaUsuarios;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public UsuarioHttp consultarPorId(@PathParam("id") int id){
 
		UsuarioHttp aux = new UsuarioHttp();
		UsuarioEntity entidade = repositorio.consultarPorId(id);
 
		if(entidade != null){
			
			aux.setId(entidade.getId());
			aux.setNome(entidade.getNome());
			aux.setEmail(entidade.getEmail());
			aux.setSenha(entidade.getSenha());
			aux.setUltimaAtualizacao(entidade.getUltimaAtualizacao());
			aux.setIdUsuario(entidade.getIdUsuario());
			aux.setPerfil( PerfilHttp.converterEntity(entidade.getPerfil()) );
		}
		
		return aux;
	}
	
	

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")	
	public String excluir(@PathParam("id") int id){
 
		String msg = "Registro excluído com sucesso!";
		try {
 
			repositorio.excluir(id);
 
		} catch (Exception e) {
 
			msg = "Erro ao excluir o registro! " + e.getMessage();
		}
		
		return msg;
 
	}
}
