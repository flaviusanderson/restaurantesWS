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
import br.com.informati.restaurantes.http.MesaHttp;
import br.com.informati.restaurantes.modelo.CategoriaEntity;
import br.com.informati.restaurantes.modelo.MesaEntity;
import br.com.informati.restaurantes.modelo.RestauranteEntity;
import br.com.informati.restaurantes.repositorio.MesaDAO;

/**
 * @author Flavius
 *
 */
public class MesaController implements IGenericoController<MesaHttp> {

	public final MesaDAO repositorio = new MesaDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(MesaHttp mesaHttp) {

		String msg = "Registro cadastrado com sucesso!";
		MesaEntity entidade = new MesaEntity();

		try {

			entidade.setNumero(mesaHttp.getNumero());
			entidade.setDescricao(mesaHttp.getDescricao());

			entidade.setIdUsuario(mesaHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(mesaHttp.getUltimaAtualizacao().getTime()));

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
	public String atualizar(MesaHttp mesaHttp) {

		String msg = "Registro atualizado com sucesso!";
		MesaEntity entidade = new MesaEntity();

		try {

			entidade.setId(mesaHttp.getId());
			entidade.setNumero(mesaHttp.getNumero());
			entidade.setDescricao(mesaHttp.getDescricao());

			entidade.setIdUsuario(mesaHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(mesaHttp.getUltimaAtualizacao().getTime()));

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
	public List<MesaHttp> consultarTodos() {

		List<MesaHttp> listaMesas = new ArrayList<MesaHttp>();

		List<MesaEntity> listaEntidades = repositorio.consultarTodos();

		for (MesaEntity entidade : listaEntidades) {

			MesaHttp mesa = MesaHttp.converterEntity(entidade);

			listaMesas.add(mesa);
		}

		return listaMesas;

	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public MesaHttp consultarPorId(int id) {

		MesaHttp mesa = new MesaHttp();

		MesaEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			mesa = MesaHttp.converterEntity(entidade);
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
