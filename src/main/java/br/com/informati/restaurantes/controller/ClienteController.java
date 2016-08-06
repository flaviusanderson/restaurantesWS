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

import br.com.informati.restaurantes.http.ClienteHttp;
import br.com.informati.restaurantes.http.MesaHttp;
import br.com.informati.restaurantes.modelo.ClienteEntity;
import br.com.informati.restaurantes.modelo.MesaEntity;
import br.com.informati.restaurantes.repositorio.ClienteDAO;

/**
 * @author Flavius
 *
 */
public class ClienteController implements IGenericoController<ClienteHttp> {
	
	public final ClienteDAO repositorio = new ClienteDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(ClienteHttp cliente) {
		String msg = "Registro atualizado com sucesso!";
		ClienteEntity entidade = new ClienteEntity();

		try {

			entidade.setId(cliente.getId());
			entidade.setNome(cliente.getNome());
			entidade.setCpf(cliente.getCpf());
			
			//TODO 
			//entidade.setPedidos(pedidos);
			
			entidade.setIdUsuario(cliente.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(cliente.getUltimaAtualizacao().getTime()));

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
	public String atualizar(ClienteHttp cliente) {
		String msg = "Registro atualizado com sucesso!";
		ClienteEntity entidade = new ClienteEntity();

		try {

			entidade.setId(cliente.getId());
			entidade.setNome(cliente.getNome());
			entidade.setCpf(cliente.getCpf());
			
			//TODO 
			//entidade.setPedidos(pedidos);
			
			entidade.setIdUsuario(cliente.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(cliente.getUltimaAtualizacao().getTime()));

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
	public List<ClienteHttp> consultarTodos() {
		List<ClienteHttp> listaClientes = new ArrayList<ClienteHttp>();

		List<ClienteEntity> listaEntidades = repositorio.consultarTodos();

		for (ClienteEntity entidade : listaEntidades) {

			ClienteHttp cliente = ClienteHttp.converterEntity(entidade);

			listaClientes.add(cliente);
		}

		return listaClientes;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public ClienteHttp consultarPorId(int id) {
		ClienteHttp cliente = new ClienteHttp();

		ClienteEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			cliente = ClienteHttp.converterEntity(entidade);
		}

		return cliente;
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
