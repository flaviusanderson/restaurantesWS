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
import javax.ws.rs.Produces;
import br.com.informati.restaurantes.http.CategoriaHttp;
import br.com.informati.restaurantes.modelo.CategoriaEntity;
import br.com.informati.restaurantes.modelo.RestauranteEntity;
import br.com.informati.restaurantes.repositorio.CategoriaDAO;
import br.com.informati.restaurantes.repositorio.RestauranteDAO;

/**
 * @author Flavius
 *
 */
@Path("/categoria")
public class CategoriaController implements IGenericoController<CategoriaHttp> {

	private final CategoriaDAO repositorio = new CategoriaDAO();
	private final RestauranteDAO repositorioRestaurante = new RestauranteDAO();
	
	@Override
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(CategoriaHttp categoriaHttp) {


		String msg = "Registro cadastrado com sucesso!";
		CategoriaEntity entidade = new CategoriaEntity();
		
		try{
			
			
			RestauranteEntity aux = this.repositorioRestaurante.consultarPorId(categoriaHttp.getRestaurante().getId());
			
			entidade.setRestaurante(aux);
			
			entidade.setNome(categoriaHttp.getNome());	
			entidade.setIdUsuario(categoriaHttp.getIdUsuario());
			
			repositorio.salvar(entidade);
			
		}catch(Exception e){
			
			msg = "Erro ao cadastrar um registro " + e.getMessage();
		}
		
		return msg;
		
	}

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/atualizar")
	public String atualizar(CategoriaHttp categoriaHttp) {


		String msg = "Registro atualizado com sucesso!";
		CategoriaEntity entidade = new CategoriaEntity();
 
		try {
 
			RestauranteEntity aux = this.repositorioRestaurante.consultarPorId(categoriaHttp.getRestaurante().getId());
			
			entidade.setRestaurante(aux);
			
			entidade.setId(categoriaHttp.getId());
			entidade.setNome(categoriaHttp.getNome());
			entidade.setIdUsuario(categoriaHttp.getIdUsuario());
			entidade.setUltimaAtualizacao( new Timestamp(categoriaHttp.getUltimaAtualizacao().getTime()));
			
			repositorio.atualizar(entidade);
 
		} catch (Exception e) {
 
			msg = "Erro ao alterar o registro " + e.getMessage();
 
		}
		
		return msg;
		
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodos")
	public List<CategoriaHttp> consultarTodos() {
		
		List<CategoriaHttp> listaCategorias =  new ArrayList<CategoriaHttp>();
		 
		List<CategoriaEntity> listaEntidades= repositorio.consultarTodos();
 
		for (CategoriaEntity entidade : listaEntidades) {
 
			CategoriaHttp categoria = CategoriaHttp.converterEntity(entidade);
			
			listaCategorias.add(categoria);
		}
 
		return listaCategorias;
		
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public CategoriaHttp consultarPorId(int id) {

		CategoriaHttp aux = new CategoriaHttp();
		
		CategoriaEntity entidade = repositorio.consultarPorId(id);
 
		if(entidade != null){
			aux = CategoriaHttp.converterEntity(entidade);
		}
		
		return aux;
		
	}

	@Override
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")	
	public String excluir(int id) {

		String msg = "Registro excluído com sucesso!";
		try {
 
			repositorio.excluir(id);
 
		} catch (Exception e) {
 
			msg = "Erro ao excluir o registro! " + e.getMessage();
		}
		
		return msg;
		
	}

	
}
