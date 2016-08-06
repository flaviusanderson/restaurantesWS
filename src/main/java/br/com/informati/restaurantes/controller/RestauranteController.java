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

import br.com.informati.restaurantes.http.MesaHttp;
import br.com.informati.restaurantes.http.RestauranteHttp;
import br.com.informati.restaurantes.modelo.MesaEntity;
import br.com.informati.restaurantes.modelo.RestauranteEntity;
import br.com.informati.restaurantes.repositorio.RestauranteDAO;

/**
 * @author Flavius
 *
 */
public class RestauranteController implements IGenericoController<RestauranteHttp> {
	
	public final RestauranteDAO repositorio = new RestauranteDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/cadastrar")
	public String cadastrar(RestauranteHttp restauranteHttp) {

		String msg = "Registro atualizado com sucesso!";
		RestauranteEntity entidade = new RestauranteEntity();

		try {

			//entidade.setId(restauranteHttp.getId());
			
			entidade.setNome(restauranteHttp.getNome());
			entidade.setNomeFantasia(restauranteHttp.getNomeFantasia());
			entidade.setRazaoSocial(restauranteHttp.getRazaoSocial());
			entidade.setCnpj(restauranteHttp.getCnpj());
			entidade.setEndereco(restauranteHttp.getEndereco());
			entidade.setTelefone(restauranteHttp.getTelefone());

			
			
			//entidade.setPracaAlimentacao(pracaAlimentacao);
			
			
			entidade.setIdUsuario(restauranteHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(restauranteHttp.getUltimaAtualizacao().getTime()));

			repositorio.atualizar(entidade);

		} catch (Exception e) {

			msg = "Erro ao alterar o registro " + e.getMessage();

		}

		return msg;

	}

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/atualizar")
	public String atualizar(RestauranteHttp restauranteHttp) {
		
		String msg = "Registro atualizado com sucesso!";
		RestauranteEntity entidade = new RestauranteEntity();

		try {

			entidade.setId(restauranteHttp.getId());
			entidade.setNome(restauranteHttp.getNome());
			entidade.setNomeFantasia(restauranteHttp.getNomeFantasia());
			entidade.setRazaoSocial(restauranteHttp.getRazaoSocial());
			entidade.setCnpj(restauranteHttp.getCnpj());
			entidade.setEndereco(restauranteHttp.getEndereco());
			entidade.setTelefone(restauranteHttp.getTelefone());

			
			
			//entidade.setPracaAlimentacao(pracaAlimentacao);
			
			
			entidade.setIdUsuario(restauranteHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(restauranteHttp.getUltimaAtualizacao().getTime()));

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
	public List<RestauranteHttp> consultarTodos() {
		
		List<RestauranteHttp> listaRestaurantes = new ArrayList<RestauranteHttp>();

		List<RestauranteEntity> listaEntidades = repositorio.consultarTodos();

		for (RestauranteEntity entidade : listaEntidades) {

			RestauranteHttp restaurante = RestauranteHttp.converterEntity(entidade);

			listaRestaurantes.add(restaurante);
		}

		return listaRestaurantes;
		
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public RestauranteHttp consultarPorId(int id) {
		RestauranteHttp mesa = new RestauranteHttp();

		RestauranteEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			mesa = RestauranteHttp.converterEntity(entidade);
		}

		return mesa;
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
